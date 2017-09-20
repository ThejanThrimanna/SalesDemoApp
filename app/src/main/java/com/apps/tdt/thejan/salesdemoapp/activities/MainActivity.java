package com.apps.tdt.thejan.salesdemoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.apps.tdt.thejan.salesdemoapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btn_monthly_sale)
    Button mMonthlySale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_monthly_sale)
    public void OnClickMonthlySale(View view){


        Intent intent = new Intent(this, MonthlySalesActivity.class);
        startActivity(intent);
    }
}
