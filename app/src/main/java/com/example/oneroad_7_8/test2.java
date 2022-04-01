package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class test2 extends AppCompatActivity implements View.OnClickListener {
    Spinner righthand, lefthand, rightleg, leftleg;
    int rhand, lhand, rleg, lleg, hand, leg;
    int sum2 = 0;
    int sum21;
    SharedPreferences ref;
    int newsum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        righthand = findViewById(R.id.righthand);
        lefthand = findViewById(R.id.lefthand);
        rightleg = findViewById(R.id.rightleg);
        leftleg = findViewById(R.id.leftleg);
        sum2 = getIntent().getIntExtra("road", 0);

        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        Log.d("sum2", "sum2=" + sum2);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (righthand.getSelectedItemPosition()) {
            case 0:
                rhand = 100;
                break;
            case 1:
                rhand = 5;
                break;
            case 2:
                rhand = 4;
                break;
            case 3:
                rhand = 3;
                break;
            case 4:
                rhand = 2;
                break;
            case 5:
                rhand = 1;
                break;
            case 6:
                rhand = 0;
                break;
        }
        switch (lefthand.getSelectedItemPosition()) {
            case 0:
                lhand = 100;
                break;
            case 1:
                lhand = 5;
                break;
            case 2:
                lhand = 4;
                break;
            case 3:
                lhand = 3;
                break;
            case 4:
                lhand = 2;
                break;
            case 5:
                lhand = 1;
                break;
            case 6:
                lhand = 0;
                break;
        }
        switch (rightleg.getSelectedItemPosition()) {
            case 0:
                rleg = 100;
                break;
            case 1:
                rleg = 5;
                break;
            case 2:
                rleg = 4;
                break;
            case 3:
                rleg = 3;
                break;
            case 4:
                rleg = 2;
                break;
            case 5:
                rleg = 1;
                break;
            case 6:
                rleg = 0;
                break;
        }
        switch (leftleg.getSelectedItemPosition()) {
            case 0:
                lleg = 100;
                break;
            case 1:
                lleg = 5;
                break;
            case 2:
                lleg = 4;
                break;
            case 3:
                lleg = 3;
                break;
            case 4:
                lleg = 2;
                break;
            case 5:
                lleg = 1;
                break;
            case 6:
                lleg = 0;
                break;
        }
        if (rhand >= lhand) {
            hand = rhand;
        } else {
            hand = lhand;
        }//左右手比

        if (rleg >= lleg) {
            leg = rleg;
        } else {
            leg = lleg;
        }//左右腳比

        if (hand >= leg) {
            sum21 = hand;
        } else {
            sum21 = leg;
        }//手跟腳比

        if (sum21 >= 3 && sum21 < 100) { //代公式
            sum21 = 3;
        } else if (sum21 == 0) {
            sum21 = 1;
        }
        newsum2 = sum2 + sum21;

        switch (v.getId()) {
            case R.id.explan4:
                it = new Intent(this, explan4.class);
                startActivity(it);
                break;
        }

        switch (v.getId()) {
            case R.id.next:
                if(rhand==100 || lhand==100 || rleg==100 || lleg==100){
                    Toast.makeText(test2.this, "仍有未填", Toast.LENGTH_SHORT).show();
                    sum2=getIntent().getIntExtra("road", 0);
                    break;
                }else{
                    it = new Intent(this, test3.class);
                    ref.edit().putInt("score3",sum21).apply();
                    Log.d("sum2", "sum2=" + newsum2);
                    Log.d("sumh", hand + "");
                    Log.d("suml", leg + "");
                    it.putExtra("handleg", newsum2);
                    startActivity(it);
                }

                break;

        }

    }
}