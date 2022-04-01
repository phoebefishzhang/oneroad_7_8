package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class frs extends AppCompatActivity implements View.OnClickListener {
    Spinner ten;
    int frs;
    SharedPreferences ref;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frs);
        ten = findViewById(R.id.ten);
        total = getIntent().getIntExtra("total2", 0);
        ref=getSharedPreferences("patientlogin", MODE_PRIVATE);
        Log.d("sum", "total2=" + total);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (ten.getSelectedItemPosition()) {
            case 0:
                frs = 100;
                break;
            case 1:
                frs = 0;
                break;
            case 2:
                frs = 1;
                break;
            case 3:
                frs = 2;
                break;
            case 4:
                frs = 3;
                break;
            case 5:
                frs = 4;
                break;
            case 6:
                frs = 5;
                break;
            case 7:
                frs = 6;
                break;
            case 8:
                frs = 7;
                break;
            case 9:
                frs = 8;
                break;
            case 10:
                frs = 9;
                break;
            case 11:
                frs = 10;
                break;
        }
        switch (v.getId()) {
            case R.id.next:
                if (frs == 100) {
                    Toast.makeText(frs.this, "未填完", Toast.LENGTH_LONG).show();
                } else {
                    ref.edit().putString("patientfrs",String.valueOf(frs)).apply();
                    Log.d("nrs", String.valueOf(frs));
                    it = new Intent(this, EatMedicine.class);
                    it.putExtra("total3", total);
                    startActivity(it);
                    break;
                }
        }

    }

}