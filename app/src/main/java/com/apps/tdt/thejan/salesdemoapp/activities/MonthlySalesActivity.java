package com.apps.tdt.thejan.salesdemoapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.apps.tdt.thejan.salesdemoapp.R;
import com.apps.tdt.thejan.salesdemoapp.services.sync.GetMonthlySalesSync;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MonthlySalesActivity extends AppCompatActivity implements GetMonthlySalesSync.GetMonthlySalesEvents{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_sales);

        ButterKnife.bind(this);

        init();

    }

    private void init() {

        GetMonthlySalesSync getMonthlySalesSync = new GetMonthlySalesSync(this);
        getMonthlySalesSync.getTsrDetails("monthly_sales","2017");

    }

    @Override
    public void getMonthlySalesSuccess(String update) {

    }

    @Override
    public void getMonthlySalesFaile(String message) {

    }
}
