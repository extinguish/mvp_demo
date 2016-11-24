package com.singuloid.rxjava.advanced.retrofit;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author: guoshicaho
 * Date: 11/23/16
 * Email: shichao.guo@singuloid.com
 * LastUpdateTime: 11/23/16
 * LastUpdateBy: guoshicaho
 */
public interface GithubApi {

    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> contributors(@Path("owner") String owner,
                                               @Path("repo") String repo);





}
