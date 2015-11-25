package com.smalljellybean.listingworks.service;


import com.smalljellybean.listingworks.domain.ListItemResponse;
import com.smalljellybean.listingworks.domain.User;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;

public interface HttpInterface {
    @GET("/1/classes/ListItem")
    @Headers({
            "Content-Type: application/json",
            "X-Parse-Application-Id: z487UaKHYRPsy2TDrLmeMRdymIDwfCQ9ESE6n2Wt",
            "X-Parse-REST-API-Key: ZxzwQnCfCphwmICv9iNIECXnOjPIElFLC4d2rwj1"
    })
    public void listItems(Callback<ListItemResponse> callback);

    @GET("/1/users")
    @Headers({
            "Content-Type: application/json",
            "X-Parse-Application-Id: z487UaKHYRPsy2TDrLmeMRdymIDwfCQ9ESE6n2Wt",
            "X-Parse-REST-API-Key: ZxzwQnCfCphwmICv9iNIECXnOjPIElFLC4d2rwj1"
    })
    public void login(@Query("username")String username, @Query("password")String password, Callback<User> callback);

    @POST("/1/users")
    @Headers({
            "Content-Type: application/json",
            "X-Parse-Application-Id: z487UaKHYRPsy2TDrLmeMRdymIDwfCQ9ESE6n2Wt",
            "X-Parse-REST-API-Key: ZxzwQnCfCphwmICv9iNIECXnOjPIElFLC4d2rwj1"
    })
    public void signUp(@Body User user, Callback<User> callback);

}
