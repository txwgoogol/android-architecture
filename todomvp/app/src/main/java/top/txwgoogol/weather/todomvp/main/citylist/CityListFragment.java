package top.txwgoogol.weather.todomvp.main.citylist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import top.txwgoogol.weather.todomvp.util.TimeConvert;
import top.txwgoogol.weather.widget.searchview.MaterialSearchView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import top.txwgoogol.weather.todomvp.R;
import top.txwgoogol.weather.todomvp.base.BaseFragment;
import top.txwgoogol.weather.todomvp.common.Constant;
import top.txwgoogol.weather.todomvp.data.bean.city.City;
import top.txwgoogol.weather.todomvp.data.bean.search.Search;
import top.txwgoogol.weather.todomvp.data.source.local.sqlite.DBUtils;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static androidx.core.util.Preconditions.checkNotNull;

/**
 * 展示城市列表的类
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class CityListFragment extends BaseFragment implements CityListContact.View {

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

    //搜索结果
    private String[] strings;
    //存储新添加城市数据集合
    private List<City> newCityList = new ArrayList<>();
    //数据库获取的数据集合
    private List<City> dbCityList;
    private City mCity;

    //hashMap代替ArrayList去重操作
    //private Map<String,City> map = new HashMap<>();

    private boolean isRepeat = false;

    /**
     * 接收上个视图传过来的数据
     *
     * @param cityEvent
     * @return 返回CityListFragment类
     */
    public static CityListFragment newInstance(City cityEvent) {
        Logger.d(cityEvent.toString());
        CityListFragment cityListFragment = new CityListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("city", cityEvent);
        cityListFragment.setArguments(bundle);
        return cityListFragment;
    }

    /**
     * @return 返回CityListFragment类
     */
    public static CityListFragment newInstance() {
        return new CityListFragment();
    }

    @Override
    public void setPresenter(CityListContact.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCity = getArguments().getParcelable("city");
        View viewRoot = inflater.inflate(R.layout.fragment_city, container, false);
        unbinder = ButterKnife.bind(this, viewRoot);

        mCityPresenter = new CityListPresenter(this);

        setHasOptionsMenu(true);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.city_list);
        }

        initSearchView();

        initCityListAdapter(newCityList);

        return viewRoot;
    }

    /**
     * 数据适配工作
     *
     * @param list 数据列表
     */
    @Override
    public void initCityListAdapter(List<City> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        mCityAdapter = new CityListAdapter();
        recyclerView.setAdapter(mCityAdapter);
        mCityAdapter.setNewData(list);

        //添加头部
        mCityAdapter.setHeaderView(getHeaderView(1, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        }));

        mCityAdapter.setOnItemClickListener((BaseQuickAdapter adapter, View view, int position) -> setResult(RESULT_OK, position));

        mCityAdapter.setOnItemLongClickListener((BaseQuickAdapter adapter, View view, int position) -> {
            new AlertDialog.Builder(getActivity())
                    .setTitle("删除该城市")
                    .setMessage("确认删除该城市")
                    .setNegativeButton("取消", (DialogInterface dialog, int which) -> {
                    })
                    .setPositiveButton("确定", (DialogInterface dialog, int which) -> {
                        //DBUtils.getInstance(getActivity()).delete(newCityList.get(position).getId());
                        DBUtils.getInstance(getActivity()).deleteCityAndWeather(newCityList.get(position).getId());
                        newCityList.remove(position);
                        mCityAdapter.notifyDataSetChanged();
                    })
                    .create().show();
            return true;
        });

        /*
        mCityAdapter.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            setResult(RESULT_OK, position);
        });

        mCityAdapter.setOnItemLongClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            new AlertDialog.Builder(getActivity())
                    .setTitle("删除该城市")
                    .setMessage("确认删除该城市")
                    .setNegativeButton("取消", (DialogInterface dialog, int which) -> {
                    })
                    .setPositiveButton("确定", (DialogInterface dialog, int which) -> {
                        DBUtils.getInstance(getActivity()).delete(newCityList.get(position).getId());
                        newCityList.remove(position);
                        mCityAdapter.notifyDataSetChanged();
                    })
                    .create().show();
            return true;
        });
        */
    }

    /**
     * 添加头部
     *
     * @param type     类型
     * @param listener 监听器
     * @return 返回视图
     */
    private View getHeaderView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.item_city, (ViewGroup) recyclerView.getParent(), false);
        if (type == 1) {
            ImageView locationCity = view.findViewById(R.id.ic_weather_location_city);
            locationCity.setVisibility(View.VISIBLE);
            TextView cityName = view.findViewById(R.id.city_name);
            cityName.setText(mCity.getName());
            TextView cityTime = view.findViewById(R.id.city_time);
            cityTime.setText(TimeConvert.stampToTime(String.valueOf(System.currentTimeMillis())));
            TextView cityTemplate = view.findViewById(R.id.city_template);
            cityTemplate.setText(mCity.getTemperature() + "°");
        }
        view.setOnClickListener(listener);
        return view;
    }

    @Override
    public void initSearchResultAdapter(List<Search.ResultsBean> searchResultList) {
        //数组与list的转换 https://www.cnblogs.com/jingnumber/p/7814092.html
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < searchResultList.size(); i++) {
            list.add(searchResultList.get(i).getName());
        }
        strings = new String[list.size()];
        list.toArray(strings);

        searchView.setCursorDrawable(R.drawable.color_cursor_white);
        searchView.setSuggestions(strings);
        searchView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            //向城市列表添加数据 返回数据城市id查询天气数据
            mCityPresenter.searchWeather(searchResultList.get(position).getId());

            //关闭搜索框 回到城市列表页面
            searchView.closeSearch();
        });
    }

    @Override
    public void addToCityList(City city) {

        for (int i = 0; i < newCityList.size(); i++) {
            Logger.d(newCityList.get(i).getId().contains(city.getId()));
            //List 数据去重操作 可以用HashMap 替换 但是我不会用 贼尴尬  等完成了项目再来优化 :(
            if (newCityList.get(i).getId().contains(city.getId())) {
                isRepeat = true;
            } else {
                isRepeat = false;
            }
        }

        //去重操作
        if (isRepeat || DBUtils.getInstance(getActivity()).query(Constant.TABLE_CITY, city.getId())) {
            DBUtils.getInstance(getActivity()).update(city);//如果存在直接进行更新
            mCityAdapter.notifyDataSetChanged();//刷新列表
        } else {
            //向数集合中添加城市数据
            newCityList.add(city);
            mCityAdapter.notifyDataSetChanged();
            //添加数据到数据库
            DBUtils.getInstance(getActivity()).insert(city); //如果不再存在直接添加
        }

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

    /**
     * 获取菜单
     *
     * @param menu     菜单列表
     * @param inflater 获取布局文件
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
     * 回调
     *
     * @param resultCode The result code to propagate back to the originating activity, often RESULT_CANCELED or RESULT_OK
     * @param position
     */
    private void setResult(int resultCode, int position) {
        if (position >= 0) {
            Intent intent = new Intent();
            intent.putExtra("id", newCityList.get(position).getId());
            getActivity().setResult(resultCode, intent);
        } else {
            getActivity().setResult(resultCode);
        }
        getActivity().finish();
    }

    //初始化搜索
    private void initSearchView() {
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Logger.d("onQueryTextSubmit: ");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Logger.d("onQueryTextChange: ");
                //执行搜索
                mCityPresenter.searchCity(newText);

                return false;
            }
        });
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
     * 查询数据库是否有数据
     *
     * @return true:有数据 false:没有数据
     */
    @Override
    public boolean isDataMissing() {
        //获取城市列表
        dbCityList = DBUtils.getInstance(getActivity()).query(Constant.TABLE_CITY);
        if (dbCityList.size() > 0) {
            newCityList.addAll(dbCityList);
            Logger.d(newCityList.size());
            mCityAdapter.notifyDataSetChanged();
            return true;
        }
        return false;
    }

    /**
     * 判断该Fragment是否添加到Activity中
     *
     * @return true:成功 false:失败
     */
    @Override
    public boolean isActive() {
        return isAdded();
    }

}