package com.smalljellybean.listingworks.service;

import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class HttpService {

    private static final String TAG = HttpService.class.getName();
    private static HttpInterface httpInterface;

    public HttpInterface build() {
        return getInterface();
    }

    private HttpInterface getInterface() {
        if (httpInterface == null) {
            httpInterface = buildRestAdapter().create(HttpInterface.class);
        }
        return httpInterface;
    }

    private RestAdapter buildRestAdapter() {
        RestAdapter.Builder builder = new RestAdapter.Builder();
        builder.setEndpoint("https://api.parse.com");
        OkHttpClient httpClient = new OkHttpClient();
        httpClient.setConnectTimeout(2000, TimeUnit.MILLISECONDS);


        builder.setClient(new OkClient(httpClient))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog(TAG));

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZZZZZ");
        builder.setConverter(new GsonConverter(gsonBuilder.create()));
        builder.setLogLevel(RestAdapter.LogLevel.FULL);
        return builder.build();
    }
}
