package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class cpot extends AppCompatActivity implements View.OnClickListener {
    Spinner sp1, sp2, sp3, sp4, sp5;
    int total = 0;
    TextView tv1, tv2;
    int sum1, sum2, sum3, sum4, sum5,cpot;
    int rass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpot);
        //total1 = getIntent().getIntExtra("total1", 0);
        total = getIntent().getIntExtra("total2",0);
        Log.d("sum", "total2=" + total);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        sp3 = findViewById(R.id.sp3);
        sp4 = findViewById(R.id.sp4);
        sp5 = findViewById(R.id.sp5);


    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (sp1.getSelectedItemPosition()) {
            case 0:
                sum1 = 11;//未填
                break;
            case 1:
                sum1 = 0;
                break;
            case 2:
                sum1 = 1;
                break;
            case 3:
                sum1 = 2;
                break;
        }
        switch (sp2.getSelectedItemPosition()) {
            case 0:
                sum2 = 11;//未填
                break;
            case 1:
                sum2 = 0;
                break;
            case 2:
                sum2 = 1;
                break;
            case 3:
                sum2 = 2;
                break;
        }
        switch (sp3.getSelectedItemPosition()) {
            case 0:
                sum3 = 11;//未填
                break;
            case 1:
                sum3 = 0;
                break;
            case 2:
                sum3 = 1;
                break;
            case 3:
                sum3 = 2;
                break;
        }
        switch (sp4.getSelectedItemPosition()) {
            case 0:
                sum4 = 11;//未填
                break;
            case 1:
                sum4 = 0;
                break;
            case 2:
                sum4 = 1;
                break;
            case 3:
                sum4 = 2;
                break;
        }
        switch (sp5.getSelectedItemPosition()) {
            case 0:
                sum5 = 11;//未填
                break;
            case 1:
                sum5 = 0;
                break;
            case 2:
                sum5 = 1;
                break;
            case 3:
                sum5 = 2;
                break;
        }
        cpot=sum1+sum2+sum3+sum4+sum5;
        switch (v.getId()) {

            case R.id.explan5:
                it = new Intent(this, explan5.class);
                startActivity(it);
                break;
        }
        switch (v.getId()) {
            case R.id.next:
                if (cpot > 10) {
                    Toast.makeText(cpot.this, "未填完", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "be banned");
                } else {
                    it = new Intent(this, rass.class);
                    Log.d("cpot","cpot="+cpot);

                    it.putExtra("cpot",cpot);
                    it.putExtra("total3", total);
                    startActivity(it);
                    break;
                }
        }


    }
}
