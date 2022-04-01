package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class second_main extends AppCompatActivity {
    private Button patient_login_btn,logout,table;
    private TextView nursename,nursename2;
    SharedPreferences ref,ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);
        nursename=(TextView)findViewById(R.id.nursename);
        nursename2=(TextView)findViewById(R.id.nursename2);
        patient_login_btn=(Button) findViewById(R.id.patientloginbtn);
        ref=getSharedPreferences("nurselogin",MODE_PRIVATE);
        ref2=getSharedPreferences("patientlogin",MODE_PRIVATE);
        nursename.setText(ref.getString("nursename",""));
        nursename2.setText(ref.getString("nursename",""));
        logout=(Button) findViewById(R.id.logout);
        table = findViewById(R.id.table);
        String patientnum=ref2.getString("patientnum","");

        patient_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(second_main.this,patientlogin.class);
                startActivity(it);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second_main.this,"登出成功",Toast.LENGTH_LONG).show();
                Intent it=new Intent(second_main.this,MainActivity.class);
                startActivity(it);
            }
        });
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(patientnum.equals("")){
                    Toast.makeText(second_main.this, "尚未開始診斷", Toast.LENGTH_SHORT).show();

                }else{
                    Intent it=new Intent(second_main.this,table.class);
                    startActivity(it);
                }

            }
        });
    }

}