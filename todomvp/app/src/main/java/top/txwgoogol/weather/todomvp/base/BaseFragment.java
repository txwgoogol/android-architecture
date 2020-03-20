package top.txwgoogol.weather.todomvp.base;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import top.txwgoogol.weather.todomvp.util.HandleBack;

/**
 * Fragment基类 处理一些公共的操作
 *
 * @author txw
 * @// TODO: 04/12/18
 */
public class BaseFragment extends Fragment implements HandleBackInterface {

    /**
     * 返回事件处理
     *
     * @return
     */
    @Override
    public boolean onBackPressed() {
        return HandleBack.handleBackPress(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Objects.requireNonNull(getActivity()).finish();
        }
        return true;
    }

}