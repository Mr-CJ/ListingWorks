package com.smalljellybean.listingworks.service;

import de.greenrobot.event.EventBus;
import retrofit.RetrofitError;
import retrofit.Callback;
import retrofit.client.Response;

public class HttpCallback<ResponseModel> implements Callback<ResponseModel> {
    @Override
    public void success(ResponseModel model, Response response) {
        EventBus.getDefault().post(model);
    }

    @Override
    public void failure(RetrofitError error) {

    }
}
