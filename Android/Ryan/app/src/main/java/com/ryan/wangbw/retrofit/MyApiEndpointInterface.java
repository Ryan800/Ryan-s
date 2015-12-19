package com.ryan.wangbw.retrofit;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * author: wangbw
 * Date: 2015-11-30
 * Time: 15:21
 * Desc: EndPoints
 */
public interface MyApiEndpointInterface {
    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);

    @GET("/group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId, @Query("sort") String sort);

    @POST("/users/new")
    Call<User> createUser(@Body User user);

    @POST("/snsapi_v1/?service=User.login")
    Call<BaseResponse<WxResponse<LoginResponse>>> login(@Body LoginRequest request);
}
