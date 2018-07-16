package com.example.android.architecture.blueprints.todoapp.main.citylist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.android.architecture.blueprints.todoapp.data.db.sqlite.DBUtils;
import com.example.android.architecture.blueprints.todoapp.data.search.Search;
import com.example.android.architecture.blueprints.todoapp.data.weather.Now;
import com.example.android.architecture.blueprints.todoapp.util.ProgressDialogUtils;
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

    private CityListPresenter mCityPresenter;
    private CityListContact.Presenter mPresenter;

    private CityListAdapter mCityAdapter;

    private String[] strings; //搜索结果
    private List<City> cityList = new ArrayList<>();
    //hashMap代替ArrayList去重操作
    //private Map<String,City> map = new HashMap<>();

    private boolean isRepeat = false;

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
            actionBar.setTitle(R.string.city_list);
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

        //获取城市列表
        List<City> cities = DBUtils.getInstance(getActivity()).query(Constant.TABLE_CITY);

        for (City city : cities) {
            Logger.d("查询数据: " + city.toString());
            cityList.add(city);
            mCityPresenter.setSearchWeather(city.getId());  //更新列表数据
            initAdapter(cityList);
        }

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

        Logger.d(city.getId());
        for (int i = 0; i < cityList.size(); i++) {
            Logger.d(cityList.get(i).getId().contains(city.getId()));
            //List 数据去重操作 可以用HashMap 替换 但是我不会用 贼尴尬  等完成了项目再来优化 :(
            if (cityList.get(i).getId().contains(city.getId())) {
                isRepeat = true;
            } else {
                isRepeat = false;
            }
        }

        //去重操作
        if (isRepeat || DBUtils.getInstance(getActivity()).query(Constant.TABLE_CITY, city.getId())) {
            //Toast.makeText(getActivity(), "城市列表已经存在该城市天气数据,请勿重读添加!", Toast.LENGTH_SHORT).show();
            DBUtils.getInstance(getActivity()).update(city);//如果存在直接进行更新
            mCityAdapter.notifyDataSetChanged();//刷新列表
            //initAdapter(cityList);
        } else {
            //向数集合中添加城市数据
            cityList.add(city);
            initAdapter(cityList);
            Logger.d(TAG, city.toString());
            //添加数据到数据库
            DBUtils.getInstance(getActivity()).insert(city); //如果不再存在直接添加
        }
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
        ProgressDialogUtils.showProgressDialog(getActivity());
    }

    @Override
    public void hideProgress() {
        ProgressDialogUtils.dismissProgressDialog();
    }

    @Override
    public void onSuccess(Now now) {
        Logger.d(TAG, "onSuccess: ");
    }

    @Override
    public void onFailure() {
        ProgressDialogUtils.dismissProgressDialog();
    }

    /**
     * 获取菜单
     *
     * @param menu     菜单列表
     * @param inflater 实例话布局文件的
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_search, menu);
        searchView.setMenuItem(menu.findItem(R.id.action_search));
    }

    /**
     * 菜单操作 返回按钮操作
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //系统菜单
            case android.R.id.home:
                setResult(RESULT_CANCELED, -1);
                break;
        }
        return true;
    }

    /**
     * 数据回调工作
     *
     * @param requestCode 请求码
     * @param resultCode  返回码
     * @param data        返回携带的值
     */
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

    /**
     * 长按删除事件
     *
     * @param cityId
     */
    @Override
    public void removeCityById(String cityId) {
        DBUtils.getInstance(getActivity()).delete(cityId);
    }

    /**
     * 数据适配工作
     *
     * @param list 数据列表
     */
    private void initAdapter(List<City> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mCityAdapter = new CityListAdapter(list);
        mCityAdapter.notifyDataSetChanged(); //刷新adapter
        mCityAdapter.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Logger.d("ITEM单击事件");
            setResult(RESULT_OK, position);
        });

        mCityAdapter.setOnItemLongClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Logger.d("ITEM长按事件   "+position);
            new AlertDialog.Builder(getActivity())
                    .setTitle("删除该城市")
                    .setMessage("确认删除该城市")
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mCityPresenter.removeCityById(cityList.get(position).getId());//根据城市ID移除添加的城市
                            cityList.remove(position);
                            mCityAdapter.notifyDataSetChanged();
                        }
                    })
                    .create().show();
            return true;//返回true表示消耗该长按事件
        });
        recyclerView.setAdapter(mCityAdapter);
    }

}