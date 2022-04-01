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
import android.widget.Toast;

public class test3 extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rg;
    RadioButton b3,b2,b1;
    int sum3, new_sum3=0;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        b3=findViewById(R.id.b3);
        b2=findViewById(R.id.b2);
        b1=findViewById(R.id.b1);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        sum3=getIntent().getIntExtra("handleg",0);
        Log.d("sum3", "sum3=" + sum3);
    }

    @Override
    public void onClick(View v) {
        rg=findViewById(R.id.rg);
        Intent it = new Intent();

        switch (rg.getCheckedRadioButtonId()){
            case R.id.b3:
                new_sum3 = sum3 +3;
                break;
            case R.id.b2:
                new_sum3 = sum3 +2;
                break;
            case R.id.b1:
                new_sum3 = sum3 +1;
                break;
        }
        switch (v.getId()) {

            case R.id.next:
                if(new_sum3==0){
                    Log.d(TAG,"be banned");
                    Toast.makeText(test3.this,"請選擇一項",Toast.LENGTH_LONG).show();
                }else{
                    it = new Intent(this, test4.class);
                    int result_score=new_sum3-sum3;
                    ref.edit().putInt("score4",result_score).apply();
                    Log.d("sum3", "sum3=" + new_sum3);
                    it.putExtra("test3",new_sum3);
                    startActivity(it);
                    break;
                }

        }

    }
}