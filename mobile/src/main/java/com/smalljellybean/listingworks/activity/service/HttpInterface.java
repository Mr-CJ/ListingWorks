package com.smalljellybean.listingworks.activity.service;


import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;

public interface HttpInterface {
    @GET("/1/classes/ListItem")
    @Headers({
            "Content-Type: application/json",
            "X-Parse-Application-Id: z487UaKHYRPsy2TDrLmeMRdymIDwfCQ9ESE6n2Wt",
            "X-Parse-REST-API-Key: ZxzwQnCfCphwmICv9iNIECXnOjPIElFLC4d2rwj1"
    })
    public void listItems(Callback<ListItemResponse> callback);

}
