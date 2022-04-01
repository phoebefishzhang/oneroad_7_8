package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;

public class tools extends AppCompatActivity implements View.OnClickListener {
    private CheckBox c4,c5,c44;
    private Spinner sp4,sp5,sp44;
    String totalsum;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        c4 = findViewById(R.id.c4);
        c44 = findViewById(R.id.c44);
        c5 = findViewById(R.id.c5);
        sp4 = findViewById(R.id.sp4);
        sp44 = findViewById(R.id.sp44

        );
        sp5 = findViewById(R.id.sp5);
        totalsum = getIntent().getStringExtra("totalsum");
        ref=getSharedPreferences("tools",MODE_PRIVATE);

        c4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    sp4.setVisibility(View.VISIBLE);
                } else {
                    sp4.setVisibility(View.INVISIBLE);
                }
            }
        });
        c5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    sp5.setVisibility(View.VISIBLE);
                } else {
                    sp5.setVisibility(View.INVISIBLE);
                }
            }
        });

        c44.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    sp44.setVisibility(View.VISIBLE);
                } else {
                    sp44.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.next:
                String [] location=getResources().getStringArray(R.array.all);
                int idlocation=sp4.getSelectedItemPosition();
                int idlocation2=sp5.getSelectedItemPosition();
                int idlocation3=sp44.getSelectedItemPosition();
                if(c4.isChecked()){
                    String update=location[idlocation];
                    ref.edit().putString("tool1",c4.getText().toString()+"/"+update).apply();
                    Log.d(TAG, "SUCCEWSS"+update);
                }
                if(c5.isChecked()){
                    String update=location[idlocation2];
                    ref.edit().putString("tool2",c5.getText().toString()+"/"+update).apply();
                    Log.d(TAG, "SUCCEWSS"+update);
                }
                if(c44.isChecked()){
                    String update=location[idlocation3];
                    ref.edit().putString("tool3",c44.getText().toString()+"/"+update).apply();
                    Log.d(TAG, "SUCCEWSS"+update);
                }
                it = new Intent(this, takecare.class);
                break;

        }
        it.putExtra("totalsum",totalsum);
        startActivity(it);
    }
}