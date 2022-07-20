package com.krodriguez.kennethrodriguez_nycschools.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class ScoresItem {
    @SerializedName("dbn")
    @Nullable
    String dbn;
    @SerializedName("num_of_sat_test_takers")
    @Nullable
    String numOfSatTestTakers;
    @SerializedName("sat_critical_reading_avg_score")
    @Nullable
    String satCriticalReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    @Nullable
    String satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    @Nullable
    String satWritingAvgScore;
    @SerializedName("school_name")
    @Nullable
    String schoolName;

    public ScoresItem(@Nullable String dbn,
                      @Nullable String numOfSatTestTakers,
                      @Nullable String satCriticalReadingAvgScore,
                      @Nullable String satMathAvgScore,
                      @Nullable String satWritingAvgScore,
                      @Nullable String schoolName) {
        this.dbn = dbn;
        this.numOfSatTestTakers = numOfSatTestTakers;
        this.satCriticalReadingAvgScore = satCriticalReadingAvgScore;
        this.satMathAvgScore = satMathAvgScore;
        this.satWritingAvgScore = satWritingAvgScore;
        this.schoolName = schoolName;
    }

    @Nullable
    public String getDbn() {
        return dbn;
    }

    @Nullable
    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    @Nullable
    public String getSatCriticalReadingAvgScore() {
        return satCriticalReadingAvgScore;
    }

    @Nullable
    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    @Nullable
    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    @Nullable
    public String getSchoolName() {
        return schoolName;
    }
}
