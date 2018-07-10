package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.android.architecture.blueprints.searchview.MaterialSearchView;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.base.BaseFragment;
import com.example.android.architecture.blueprints.todoapp.common.Constant;
import com.example.android.architecture.blueprints.todoapp.data.city.City;
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBHelper;
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBManger;
import com.example.android.architecture.blueprints.todoapp.data.location.Search;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.view.ProgressDialogEx;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.bumptech.glide.util.Preconditions.checkNotNull;

public class CityListFragment extends BaseFragment implements CityListContact.View {

    private static final String TAG = "CityListFragment";

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;
    Unbinder unbinder;

    private SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;

    private CityListPresenter mCityPresenter;
    private CityListContact.Presenter mPresenter;

    private CityListAdapter mCityAdapter;

    private String[] strings; //搜索结果
    private List<City> cityList = new ArrayList<>();

    public static CityListFragment newInstance(String str) {
        CityListFragment cityListFragment = new CityListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("str", str);
        cityListFragment.setArguments(bundle);
        return cityListFragment;
    }

    @Override
    public void setPresenter(CityListContact.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCityPresenter = new CityListPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_city, container, false);
        unbinder = ButterKnife.bind(this, viewRoot);

        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setTitle("城市列表");
        }

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Logger.d(TAG, "onQueryTextSubmit: ");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Logger.d(TAG, "onQueryTextChange: ");
                //执行搜索
                mCityPresenter.setSearchKey(newText);

                return false;
            }
        });

        //初始化数据库
        dbHelper = DBManger.getInstance(getActivity());

        //从数据查询已经存在的城市数据
        sqLiteDatabase = dbHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(Constant.TABLE_CITY, null, null, null, null, null, null);
        //将cursor转换为list集合
        List<City> list = DBManger.cursorToList(cursor);
        for (City city : list) {
            Logger.d(TAG, "查询数据: " + city.toString());
            cityList.add(city);

            if (cityList != null) {
                initAdapter(cityList);
            }
        }

        sqLiteDatabase.close();

        return viewRoot;
    }

    @Override
    public void onSearchResult(List<Search.ResultsBean> resultsBeanList) {
        //数组与list的转换 https://www.cnblogs.com/jingnumber/p/7814092.html
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < resultsBeanList.size(); i++) {
            list.add(resultsBeanList.get(i).getName());
        }
        strings = new String[list.size()];
        list.toArray(strings);

        searchView.setCursorDrawable(R.drawable.color_cursor_white);
        searchView.setSuggestions(strings);
        searchView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            //向城市列表添加数据 返回数据城市id查询天气数据
            mCityPresenter.setSearchWeather(resultsBeanList.get(position).getId());

            //关闭搜索框 回到城市列表页面
            searchView.closeSearch();
        });
    }

    @Override
    public void onWeatherResult(City city) {
        //向数集合中添加城市数据
        cityList.add(city);
        initAdapter(cityList);

        Logger.d(TAG, "onWeatherResult: " + city.getId() + " " + city.getName() + " " + city.getTime() + " " + city.getTemperature());

        sqLiteDatabase = dbHelper.getWritableDatabase();
        /* 哪里错了？ 为什么不成功 泪溃 :(
        String insertSQL = "insert into " + Constant.TABLE_CITY + " values("
                + city.getId() + ","
                + city.getTime() + ","
                + city.getName() + ","
                + city.getTemperature() + ")";
        DBManger.execSQL(sqLiteDatabase, insertSQL);
        */
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.CITY_ID, city.getId());
        contentValues.put(Constant.CITY_TIME, city.getTime());
        contentValues.put(Constant.CITY_NAME, city.getName());
        contentValues.put(Constant.CITY_TEMPERATURE, city.getTemperature());
        contentValues.put(Constant.CITY_CODE, city.getCode());
        long result = sqLiteDatabase.insert(Constant.TABLE_CITY, null, contentValues);
        if (result > 0) {
            Logger.d(TAG, "添加数据成功");
        } else {
            Logger.d(TAG, "添加数据失败");
        }

        sqLiteDatabase.close();
    }

    /**
     * 回调
     *
     * @param resultCode The result code to propagate back to the originating activity, often RESULT_CANCELED or RESULT_OK
     * @param position
     */
    private void setResult(int resultCode, int position) {
        if (position >= 0) {
            Intent intent = new Intent();
            intent.putExtra("id", cityList.get(position).getId());
            getActivity().setResult(resultCode, intent);
        } else {
            getActivity().setResult(resultCode);
        }
        getActivity().finish();
    }

    @Override
    public void onResume() {
        super.onResume();
        mCityPresenter.onAttach();
    }

    @Override
    public void onPause() {
        super.onPause();
        mCityPresenter.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadProgress() {
        ProgressDialogEx.showProgressDialog(getActivity());
    }

    @Override
    public void hideProgress() {
        ProgressDialogEx.dismissProgressDialog();
    }

    @Override
    public void onSuccess(Now now) {
        Logger.d(TAG, "onSuccess: ");
    }

    @Override
    public void onFailure() {
        ProgressDialogEx.dismissProgressDialog();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_search, menu);
        searchView.setMenuItem(menu.findItem(R.id.action_search));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                setResult(RESULT_CANCELED, -1);
                break;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initAdapter(List list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCityAdapter = new CityListAdapter(getActivity(), list);
        mCityAdapter.notifyDataSetChanged(); //刷新adapter
        mCityAdapter.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> setResult(RESULT_OK, position));
        recyclerView.setAdapter(mCityAdapter);
    }

}