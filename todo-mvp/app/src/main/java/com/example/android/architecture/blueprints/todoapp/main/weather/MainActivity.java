package com.example.android.architecture.blueprints.todoapp.main.weather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.architecture.blueprints.todoapp.data.Now;
import com.example.weather.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.util.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements WeatherContact.View {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.text)
    TextView text;

    private WeatherContact.Presenter mPresenter;
    private WeatherPresenter mWeatherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mWeatherPresenter = new WeatherPresenter(this);
    }

    @Override
    public void loadProgress() {
        showProgressDialog();
    }

    @Override
    public void hideProgress() {
        dismissProgressDialog();
    }

    @Override
    public void onSuccess(Now weather) {
        dataSuccess(weather);
    }

    @Override
    public void onFailure() {
        dismissProgressDialog();
    }

    @Override
    public void setPresenter(WeatherContact.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    private void dataSuccess(Now model) {
        if (!model.equals("") && model != null) {
            String showData = getResources().getString(R.string.city) + model.getResults().get(0).getLocation().getName()
                    + getResources().getString(R.string.text) + model.getResults().get(0).getNow().getText()
                    + getResources().getString(R.string.wind_direction) + model.getResults().get(0).getNow().getWind_direction()
                    + getResources().getString(R.string.temperature) + model.getResults().get(0).getNow().getTemperature();
            text.setText(showData);
        }
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        mPresenter.start();
    }

    //----------加载对话框 start -------------
    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("加载中");
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }
    //----------加载对话框 end -------------

}
