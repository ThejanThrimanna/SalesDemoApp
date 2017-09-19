package com.apps.tdt.thejan.salesdemoapp.services.apimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Thejan on 9/19/2017.
 */

public class CommonResponce {

    @SerializedName("Data")
    @Expose
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
