package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class reason extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,reason;
    RadioGroup rg;
    Button finish;
    EditText otherres;
    SharedPreferences ref;
    String totalsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        r5=findViewById(R.id.r5);
        r6=findViewById(R.id.r6);
        r7=findViewById(R.id.r7);
        r8=findViewById(R.id.r8);
        r9=findViewById(R.id.r9);
        r10=findViewById(R.id.r10);
        rg=findViewById(R.id.rg);

        finish=findViewById(R.id.next);
        otherres=findViewById(R.id.otherreason);
        ref=getSharedPreferences("reasonwhy",MODE_PRIVATE);
        totalsum =getIntent().getStringExtra("totalsum");

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.r10:
                        otherres.setVisibility(View.VISIBLE);
                        ref.edit().putString("reason",r10.getText().toString()).apply();
                        break;
                    case R.id.r9:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r9.getText().toString()).apply();
                        break;
                    case R.id.r8:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r8.getText().toString()).apply();
                        break;
                    case R.id.r7:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r7.getText().toString()).apply();
                        break;
                    case R.id.r6:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r6.getText().toString()).apply();
                        break;
                    case R.id.r5:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r5.getText().toString()).apply();
                        break;
                    case R.id.r4:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r4.getText().toString()).apply();
                        break;
                    case R.id.r3:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r3.getText().toString()).apply();
                        break;
                    case R.id.r2:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r2.getText().toString()).apply();
                        break;
                    case R.id.r1:
                        otherres.setVisibility(View.INVISIBLE);
                        ref.edit().putString("reason",r1.getText().toString()).apply();
                        break;

                }

            }
        });






        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    ref.edit().putString("reason1",otherres.getText().toString()).apply();


                Intent intent = new Intent();
                int selectid= rg.getCheckedRadioButtonId();

                reason=(RadioButton)findViewById(selectid);
                Log.d("otherres", String.valueOf(otherres));






                intent = new Intent(reason.this, tools.class);
                intent.putExtra("totalsum", totalsum);
                startActivity(intent);


            }







        });

    }

}

