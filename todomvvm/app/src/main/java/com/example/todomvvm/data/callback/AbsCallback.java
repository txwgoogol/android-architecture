package com.example.todomvvm.data.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {

    }

    public String convertResponse(Response response){
        return response.body().toString();
    }

}
