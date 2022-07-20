package com.krodriguez.kennethrodriguez_nycschools.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class SchoolsResp {
    @SerializedName("city")
    @Nullable
    String city;
    @SerializedName("dbn")
    @Nullable
    String dbn;
    @SerializedName("latitude")
    @Nullable
    String latitude;
    @SerializedName("location")
    @Nullable
    String location;
    @SerializedName("longitude")
    @Nullable
    String longitude;
    @SerializedName("overview_paragraph")
    @Nullable
    String overview_paragraph;
    @SerializedName("phone_number")
    @Nullable
    String phone_number;
    @SerializedName("school_email")
    @Nullable
    String schoolEmail;
    @SerializedName("school_name")
    @Nullable
    String schoolName;
    @SerializedName("website")
    @Nullable
    String website;
    @SerializedName("zip")
    @Nullable
    String zip;

    public SchoolsResp(@Nullable String city,
                       @Nullable String dbn,
                       @Nullable String latitude,
                       @Nullable String location,
                       @Nullable String longitude,
                       @Nullable String overview_paragraph,
                       @Nullable String phone_number,
                       @Nullable String school_email,
                       @Nullable String school_name,
                       @Nullable String website,
                       @Nullable String zip) {
        this.city = city;
        this.dbn = dbn;
        this.latitude = latitude;
        this.location = location;
        this.longitude = longitude;
        this.overview_paragraph = overview_paragraph;
        this.phone_number = phone_number;
        this.schoolEmail = school_email;
        this.schoolName = school_name;
        this.website = website;
        this.zip = zip;
    }

    @Nullable
    public String getCity() {
        return city;
    }

    public void setCity(@Nullable String city) {
        this.city = city;
    }

    @Nullable
    public String getDbn() {
        return dbn;
    }

    public void setDbn(@Nullable String dbn) {
        this.dbn = dbn;
    }

    @Nullable
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(@Nullable String latitude) {
        this.latitude = latitude;
    }

    @Nullable
    public String getLocation() {
        return location;
    }

    public void setLocation(@Nullable String location) {
        this.location = location;
    }

    @Nullable
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(@Nullable String longitude) {
        this.longitude = longitude;
    }

    @Nullable
    public String getOverview_paragraph() {
        return overview_paragraph;
    }

    public void setOverview_paragraph(@Nullable String overview_paragraph) {
        this.overview_paragraph = overview_paragraph;
    }

    @Nullable
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@Nullable String phone_number) {
        this.phone_number = phone_number;
    }

    @Nullable
    public String getSchool_email() {
        return schoolEmail;
    }

    public void setSchool_email(@Nullable String school_email) {
        this.schoolEmail = school_email;
    }

    @Nullable
    public String getSchool_name() {
        return schoolName;
    }

    public void setSchool_name(@Nullable String school_name) {
        this.schoolName = school_name;
    }

    @Nullable
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@Nullable String website) {
        this.website = website;
    }

    @Nullable
    public String getZip() {
        return zip;
    }

    public void setZip(@Nullable String zip) {
        this.zip = zip;
    }
}

