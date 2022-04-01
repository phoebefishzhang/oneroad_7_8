package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class test6 extends AppCompatActivity implements View.OnClickListener {
    private android.widget.RadioGroup RadioGroup;
    RadioButton b1,b2,b3,b4;
    int sum6 ,new_sum6= 0;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test6);
        b4=findViewById(R.id.b4);
        b3=findViewById(R.id.b3);
        b2=findViewById(R.id.b2);
        b1=findViewById(R.id.b1);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        sum6=getIntent().getIntExtra("test5",0);
        Log.d("sum6", "sum6=" + sum6);

    }

    @Override
    public void onClick(View v) {
        RadioGroup=findViewById(R.id.RadioGroup);
        Intent it = new Intent();
        switch (RadioGroup.getCheckedRadioButtonId()){
            case R.id.b4:
                new_sum6=sum6+4;
                break;
            case R.id.b3:
                new_sum6=sum6+3;
                break;
            case R.id.b2:
                new_sum6=sum6+2;
                break;
            case R.id.b1:
                new_sum6=sum6+1;
                break;
        }

        switch (v.getId()) {
            case R.id.next:
                if(new_sum6==0){
                    Log.d(TAG, "be banned");
                    Toast.makeText(test6.this, "請選擇一項", Toast.LENGTH_LONG).show();
                }else{
                    it = new Intent(this, pain.class);
                    int result_score=new_sum6-sum6;
                    ref.edit().putInt("score7",result_score).apply();
                    Log.d("sum6","sum6=" + new_sum6);
                    it.putExtra("total",new_sum6);
                    startActivity(it);
                    break;
                }
        }
    }
}