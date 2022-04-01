package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class explan4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explan4);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this,test2.class);
        startActivity(it);
    }
}