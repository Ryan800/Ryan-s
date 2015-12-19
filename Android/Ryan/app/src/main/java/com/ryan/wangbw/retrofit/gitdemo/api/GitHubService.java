package com.ryan.wangbw.retrofit.gitdemo.api;

import com.ryan.wangbw.retrofit.gitdemo.model.GitModel;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 10:31
 * Desc:
 */
public interface GitHubService {
    @GET("/users/{username}")
    Call<GitModel> getUser(@Path("username") String username);
}
