package com.apps.tdt.thejan.salesdemoapp.services.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thejan on 9/19/2017.
 */

public class MonthlySalesResponce {

    @SerializedName("January")
    @Expose
    private String January;

    @SerializedName("February")
    @Expose
    private String February;


    @SerializedName("March")
    @Expose
    private String March;

    @SerializedName("April")
    @Expose
    private String April;


    public String getJanuary() {
        return January;
    }

    public void setJanuary(String january) {
        January = january;
    }

    public String getFebruary() {
        return February;
    }

    public void setFebruary(String february) {
        February = february;
    }

    public String getMarch() {
        return March;
    }

    public void setMarch(String march) {
        March = march;
    }

    public String getApril() {
        return April;
    }

    public void setApril(String april) {
        April = april;
    }
}
