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

public class test5 extends AppCompatActivity implements View.OnClickListener {
    private android.widget.RadioGroup RadioGroup;
    RadioButton b3,b2;
    int sum5 ,new_sum5= 0;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);
        b3=findViewById(R.id.b3);
        b2=findViewById(R.id.b2);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        sum5=getIntent().getIntExtra("test4",1);
        Log.d("sum5", "sum5=" + sum5);
    }

    @Override
    public void onClick(View v) {
        RadioGroup=findViewById(R.id.RadioGroup);
        Intent it = new Intent();
        switch (RadioGroup.getCheckedRadioButtonId()){
            case R.id.b3:
                new_sum5=sum5+3;
                break;
            case R.id.b2:
                new_sum5=sum5+2;
                break;
        }

        switch (v.getId()) {

            case R.id.next:
                if(new_sum5==0) {
                    Log.d(TAG, "be banned");
                    Toast.makeText(test5.this, "請選擇一項", Toast.LENGTH_LONG).show();
                }else{
                    int result_score=new_sum5-sum5;
                    it = new Intent(this, test6.class);
                    ref.edit().putInt("score6",result_score).apply();
                    Log.d("sum5","sum5=" + new_sum5);
                    it.putExtra("test5",new_sum5);
                    startActivity(it);
                    break;
                }

        }

    }
}