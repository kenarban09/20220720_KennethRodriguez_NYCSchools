package com.krodriguez.kennethrodriguez_nycschools.res;


import com.krodriguez.kennethrodriguez_nycschools.model.SchoolsResp;
import com.krodriguez.kennethrodriguez_nycschools.model.ScoresItem;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;

public class SchoolRepoImp implements SchoolRepo {

    private final API serviceApi;

    @Inject
    public SchoolRepoImp(API apiService) {
        serviceApi = apiService;
    }

    @Override
    public Single<List<SchoolsResp>> getSchools() { return serviceApi.getSchools(); }

    @Override
    public Single<List<ScoresItem>> getScores(String school) {
        return serviceApi.getScores()
                .map((Function<List<ScoresItem>, List<ScoresItem>>) scores ->
                        scores.stream().filter(scores1 ->
                                Objects.equals(scores1.getDbn(), school)).collect(Collectors.toList()));
    }
}
