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

public class test4 extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup RadioGroup;
    RadioButton b1,b2,b4;
    TextView textView6;
    int sum4 ,new_sum4=0;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        b4=findViewById(R.id.b4);
        b2=findViewById(R.id.b2);
        b1=findViewById(R.id.b1);
        textView6=findViewById(R.id.textView6);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        sum4=getIntent().getIntExtra("test3",0);
        Log.d("sum4", "sum4=" + sum4);
    }

    @Override
    public void onClick(View v) {
        RadioGroup=findViewById(R.id.RadioGroup);
        Intent it = new Intent();

        switch (RadioGroup.getCheckedRadioButtonId()){
            case R.id.b4:
                new_sum4=sum4+4;
                break;
            case R.id.b2:
                new_sum4=sum4+2;
                break;
            case R.id.b1:
                new_sum4=sum4+1;
                break;
        }


        switch (v.getId()) {



            case R.id.next:
                if(new_sum4==0) {
                    Log.d(TAG,"be banned");
                    Toast.makeText(test4.this,"請選擇一項",Toast.LENGTH_LONG).show();

                }else{
                    it = new Intent(this, test5.class);
                    int result_score=new_sum4-sum4;
                    ref.edit().putInt("score5",result_score).apply();
                    Log.d("sum4","newsum4=" + new_sum4);
                    it.putExtra("test4",new_sum4);
                    startActivity(it);
                    break;

                }
        }

    }
}