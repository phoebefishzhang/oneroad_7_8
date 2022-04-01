package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

public class nrs extends AppCompatActivity implements View.OnClickListener {
    Spinner ten;
    int nrs;
    int total;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nrs);
        ten = findViewById(R.id.ten);
        ref=getSharedPreferences("patientlogin",MODE_PRIVATE);
        total = getIntent().getIntExtra("total2",0);
        Log.d("sum", "total2=" + total);
    }

    @Override
    public void onClick(View v) {
        Intent it=new Intent();
        switch (ten.getSelectedItemPosition()) {
            case 0:
                nrs = 100;
                break;
            case 1:
                nrs = 0;
                break;
            case 2:
                nrs = 1;
                break;
            case 3:
                nrs = 2;
                break;
            case 4:
                nrs = 3;
                break;
            case 5:
                nrs = 4;
                break;
            case 6:
                nrs = 5;
                break;
            case 7:
                nrs = 6;
                break;
            case 8:
                nrs = 7;
                break;
            case 9:
                nrs = 8;
                break;
            case 10:
                nrs = 9;
                break;
            case 11:
                nrs = 10;
                break;
        }
        switch(v.getId()){
            case R.id.next:
                if(nrs==100){
                    Toast.makeText(nrs.this, "未填完", Toast.LENGTH_LONG).show();
                }else {
                    ref.edit().putString("patientnrs",String.valueOf(nrs)).apply();
                    it = new Intent(this, EatMedicine.class);
                    Log.d("nrs", String.valueOf(nrs));
                    it.putExtra("total3", total);
                    startActivity(it);
                    break;
                }
        }

    }
}