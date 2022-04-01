package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class rass extends AppCompatActivity implements View.OnClickListener , RadioGroup.OnCheckedChangeListener {
    private RadioButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10,b11;
    RadioGroup rg;
    TextView tv;
    int total=0;
    int rass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rass);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        tv = findViewById(R.id.tv);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);

        total = getIntent().getIntExtra("total", 0);
        Log.d("sum","total=" + total);
    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.previous:
                it = new Intent(this, test6.class);
                break;
            case R.id.next:
                it = new Intent(this, cpot.class);
                break;
            case R.id.rassexplan:
                it = new Intent(this, rass_explan.class);
                break;
        }
        it.putExtra("rass",rass);
        it.putExtra("total1",total);
        startActivity(it);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.b1:
                rass=1;
                tv.setText("建議增加鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffb7dd"));
                break;
            case R.id.b2:
                rass=2;
                tv.setText("建議增加鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffb7dd"));
                break;
            case R.id.b3:
                rass=3;
                tv.setText("建議增加鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffb7dd"));
                break;
            case R.id.b4:
                rass=4;
                tv.setText("建議增加鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffb7dd"));
                break;
            case R.id.b5:
                rass=5;
                tv.setText("建議維持鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffddaa"));
                break;
            case R.id.b6:
                rass=6;
                tv.setText("建議維持鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffddaa"));
                break;
            case R.id.b7:
                rass=7;
                tv.setText("建議維持鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#ffddaa"));
                break;
            case R.id.b8:
                rass=8;
                tv.setText("建議減少鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#99ff99"));
                break;
            case R.id.b9:
                rass=9;
                tv.setText("建議減少鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#99ff99"));
                break;
            case R.id.b10:
                rass=10;
                tv.setText("建議減少鎮靜藥物劑量");
                tv.setBackgroundColor(Color.parseColor("#99ff99"));
                break;
            case R.id.b11:
                rass=11;
                tv.setText("未使用");
                tv.setTextColor(Color.parseColor("#000000"));
                tv.setBackgroundColor(Color.parseColor("#FF6347"));
                break;
        }
    }
}