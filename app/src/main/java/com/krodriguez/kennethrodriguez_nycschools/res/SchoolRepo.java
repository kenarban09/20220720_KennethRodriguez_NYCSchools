package com.krodriguez.kennethrodriguez_nycschools.res;

import com.krodriguez.kennethrodriguez_nycschools.model.SchoolsResp;
import com.krodriguez.kennethrodriguez_nycschools.model.ScoresItem;

import java.util.List;

import io.reactivex.Single;

public interface SchoolRepo {
    Single<List<SchoolsResp>> getSchools();
    Single<List<ScoresItem>> getScores(String schoolDbn);
}
