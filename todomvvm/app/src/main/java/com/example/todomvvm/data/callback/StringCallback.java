package com.example.todomvvm.data.callback;

import com.example.todomvvm.data.convert.StringConvert;
import retrofit2.Call;
import retrofit2.Response;

public abstract class StringCallback extends AbsCallback<String> {

    private StringConvert convert;

    public StringCallback() {
        convert = new StringConvert();
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        super.onResponse(call, response);
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        super.onFailure(call, t);
    }

    @Override
    public String convertResponse(Response response) {
        return super.convertResponse(response);
    }

}