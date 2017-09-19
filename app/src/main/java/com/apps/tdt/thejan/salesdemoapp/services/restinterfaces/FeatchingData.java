package com.apps.tdt.thejan.salesdemoapp.services.restinterfaces;

import com.apps.tdt.thejan.salesdemoapp.services.apimodels.CommonResponce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Thejan on 9/19/2017.
 */

public class FeatchingData {


    public interface FeatchMonthlySalesInterface {
        @FormUrlEncoded
        @POST("/android-exam")
        Call<CommonResponce> FeatchMonthlySales(@Field("data_type") String data_type,
                                                @Field("year") String year);
    }

    public interface FeatchHourlyActivityCountInterface {
        @FormUrlEncoded
        @POST("/android-exam")
        Call<CommonResponce> FeatchHourlyActivityCount(@Field("data_type") String data_type,
                                                       @Field("date") String date);
    }


}
