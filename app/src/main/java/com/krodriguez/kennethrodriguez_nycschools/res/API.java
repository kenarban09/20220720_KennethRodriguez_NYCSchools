package com.krodriguez.kennethrodriguez_nycschools.res;

import com.krodriguez.kennethrodriguez_nycschools.model.SchoolsResp;
import com.krodriguez.kennethrodriguez_nycschools.model.ScoresItem;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://data.cityofnewyork.us/resource/";

    @GET("s3k6-pzi2")
    Single<List<SchoolsResp>> getSchools();

    @GET("f9bf-2cp4")
    Single<List<ScoresItem>> getScores();
}
