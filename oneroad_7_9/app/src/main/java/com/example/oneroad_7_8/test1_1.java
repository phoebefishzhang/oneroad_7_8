package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class test1_1 extends AppCompatActivity {
    RadioGroup RG;
    RadioButton b4, b3, b2, b1;
    int sum = 0;
    Button next;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test11);
        next = findViewById(R.id.next);
        b4 = findViewById(R.id.b4);
        b3 = findViewById(R.id.b3);
        b2 = findViewById(R.id.b2);
        b1 = findViewById(R.id.b1);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RG = findViewById(R.id.RG);
                switch (RG.getCheckedRadioButtonId()) {
                    case R.id.b4:
                        sum = 4;
                        break;
                    case R.id.b3:
                        sum = 3;
                        break;
                    case R.id.b2:
                        sum = 2;
                        break;
                    case R.id.b1:
                        sum = 1;
                        break;
                }
                if (sum == 0) {
                    Log.d(TAG, "be banned");
                    Toast.makeText(test1_1.this, "請選擇一項", Toast.LENGTH_LONG).show();
                } else {
                    Intent it = new Intent(test1_1.this, test1_2.class);
                    ref.edit().putInt("score1",sum).apply();
                    it.putExtra("sense", sum);
                    Log.d("sum", sum + "");
                    startActivity(it);
                }
            }
        });


    }
}