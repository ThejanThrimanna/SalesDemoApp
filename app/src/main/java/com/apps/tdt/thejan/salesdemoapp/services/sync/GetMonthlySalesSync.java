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
                                //delegate.getCollectroSuccess(response.body());
                                try {

                                    if (response.body().getData() != null) {

//                                        JSONArray obj = new JSONArray(response.body().getData());
//                                        City city = new City();
//                                        city.clearTable();
//                                        saveDataToTheDatabase(obj);

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
//                                Log.d("SmartFm - ErrorLog", message);
//                                ErrorLog.saveErrorLog("Update Booking Time", message);
                                delegate.getMonthlySalesFaile(message);
                            } catch (Exception e) {
                                e.printStackTrace();
                                // delegate.onUpdateFailer(SmartConstants.TRY_AGAIN_EXCEPTION);
                            }
                        }
                    }

                    private void saveDataToTheDatabase(JSONArray data) {

//                        JSONArray names = data.names();
//                        JSONArray values = data.toJSONArray(names);


//                        for(int i = 0; i<data.length(); i++){
//
//                            try {
//                                JSONObject row = data.getJSONObject(i);
//
//                                City city = new City();
//
//                                city.setProvinceId(row.getString("ProvinceCode"));
//                                city.setDistrictId(row.getString("DiscrictCode"));
//                                city.setCityName(row.getString("Description"));
//
//                                city.save();
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//
//
//                        }

                        try {
                            // province.set

                        } catch (Exception e) {

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
