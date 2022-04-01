package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class pain extends AppCompatActivity implements View.OnClickListener{
int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain);
        total = getIntent().getIntExtra("total",0);
        Log.d("sum", "total1=" + total);

    }

    @Override
    public void onClick(View v) {
        Intent it =new Intent();
        switch(v.getId()){
            case R.id.b1:
                it = new Intent(this,cpot.class);
                break;
            case R.id.b2:
                it = new Intent(this,nrs.class);
                break;
            case R.id.b3:
                it = new Intent(this,frs.class);
                break;
        }
        it.putExtra("total2",total);
        startActivity(it);
    }
}