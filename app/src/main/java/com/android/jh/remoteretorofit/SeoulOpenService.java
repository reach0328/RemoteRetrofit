package com.android.jh.remoteretorofit;

import com.android.jh.remoteretorofit.Domain.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JH on 2017-03-07.
 */

public interface SeoulOpenService {
    // full address = http://openapi.seoul.go.kr:8088/774e574b4b72656133344272687368/json/SearchParkingInfo/1/1000"
    @GET("774e574b4b72656133344272687368/json/SearchParkingInfo/1/1000/{gu}") //레스풀 방식
    Call<Data> getData(@Path("gu") String value);
}
