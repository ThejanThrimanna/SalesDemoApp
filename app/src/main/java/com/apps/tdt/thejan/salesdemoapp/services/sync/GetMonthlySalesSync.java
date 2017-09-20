package com.apps.tdt.thejan.salesdemoapp.services.sync;

import com.activeandroid.util.Log;
import com.apps.tdt.thejan.salesdemoapp.helper.Constants;
import com.apps.tdt.thejan.salesdemoapp.services.ServiceGenerator;
import com.apps.tdt.thejan.salesdemoapp.services.apimodels.CommonResponce;
import com.apps.tdt.thejan.salesdemoapp.services.restinterfaces.FeatchingData;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Thejan on 9/19/2017.
 */

public class GetMonthlySalesSync {


    private GetMonthlySalesEvents delegate;

    public GetMonthlySalesSync(GetMonthlySalesEvents delegate) {
        this.delegate = delegate;
    }

    public void getTsrDetails(String data_type, String year) {

        ServiceGenerator.CreateServiceForDomain(FeatchingData.FeatchMonthlySalesInterface.class, Constants.BaseUrl)
                .FeatchMonthlySales(data_type, year)
                .enqueue(new retrofit2.Callback<CommonResponce>() {
                    @Override
                    public void onResponse(Call<CommonResponce> call, Response<CommonResponce> response) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                try {

                                    if (response.body().getData() != null) {

                                        delegate.getMonthlySalesSuccess(response.body().getData());

                                    } else {
                                        delegate.getMonthlySalesFaile("");
                                    }

                                } catch (Throwable t) {
                                    delegate.getMonthlySalesFaile("");
                                    Log.e("My App", "Could not parse malformed JSON: \"" + response.body().getData() + "\"");
                                }
                            } else {
                                delegate.getMonthlySalesFaile("");
                            }
                        } else {
                            try {
                                String message = response.errorBody().string();
                                delegate.getMonthlySalesFaile(message);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }


                    @Override
                    public void onFailure(Call<CommonResponce> call, Throwable t) {
                        System.out.println(t);
                        delegate.getMonthlySalesFaile("Service error");
                    }
                });

    }


    public interface GetMonthlySalesEvents {
        void getMonthlySalesSuccess(String update);

        void getMonthlySalesFaile(String message);


    }
}
