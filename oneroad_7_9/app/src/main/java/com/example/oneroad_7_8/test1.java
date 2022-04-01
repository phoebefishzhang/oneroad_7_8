package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class test1 extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rg;
    Spinner sp1, sp2, sp3;
    SharedPreferences ref;
    LinearLayout l1, l2, l3;
    int eyes, move, talk, total;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        sp3 = findViewById(R.id.sp3);

        rg = findViewById(R.id.rg);
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        next = findViewById(R.id.next);
        ref=getSharedPreferences("test1",MODE_PRIVATE);

    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent();


        switch (v.getId()) {
            case R.id.explan1:
                it = new Intent(this, explan1.class);
                startActivity(it);
                break;
            case R.id.explan2:
                it = new Intent(this, explan2.class);
                startActivity(it);
                break;
            case R.id.explan3:
                it = new Intent(this, explan3.class);
                startActivity(it);
                break;
        }

        switch (v.getId()) {
            case R.id.next:
                String[] location = getResources().getStringArray(R.array.eyes);
                String[] location2 = getResources().getStringArray(R.array.move);
                String[] location3 = getResources().getStringArray(R.array.talk);
                int idlocation = sp1.getSelectedItemPosition();
                int idlocation2 = sp2.getSelectedItemPosition();
                int idlocation3 = sp3.getSelectedItemPosition();
                if (idlocation == 0 || idlocation2 == 0 || idlocation3 == 0) {
                    Toast.makeText(test1.this, "未填完", Toast.LENGTH_LONG).show();
                    break;
                } else {
                    String update1 = location[idlocation];
                    String update2 = location2[idlocation2];
                    String update3 = location3[idlocation3];
                    ref.edit().putString("eyes", update1).apply();
                    ref.edit().putString("move", update2).apply();
                    ref.edit().putString("talk", update3).apply();

                    it = new Intent(this, test1_1.class);
                    startActivity(it);
                    break;

                }

        }
    }
}