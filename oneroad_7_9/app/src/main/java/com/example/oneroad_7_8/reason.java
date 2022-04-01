package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class reason extends AppCompatActivity {
    CheckBox cb_res3,cb_res33,cb_res4,cb_res5,cb_res6,cb_res8;
    Button finish;
    EditText otherres;
    SharedPreferences ref;
    String totalsum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);

        cb_res3=findViewById(R.id.c3);
        cb_res33=findViewById(R.id.c33);
        cb_res4=findViewById(R.id.c4);
        cb_res5=findViewById(R.id.c5);
        cb_res6=findViewById(R.id.c6);
        cb_res8=findViewById(R.id.c8);
        finish=findViewById(R.id.next);
        otherres=findViewById(R.id.edit);
        ref=getSharedPreferences("reasonwhy",MODE_PRIVATE);
        totalsum =getIntent().getStringExtra("totalsum");

        cb_res8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    otherres.setVisibility(View.VISIBLE);
                }else{
                    otherres.setVisibility(View.INVISIBLE);
                }
            }
        });


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();


                    if (cb_res3.isChecked()) {
                        ref.edit().putString("reason1", cb_res3.getText().toString()).apply();
                    }else{
                        ref.edit().putString("reason1","").apply();
                    }
                if (cb_res33.isChecked()) {
                    ref.edit().putString("reason2", cb_res33.getText().toString()).apply();
                }else{
                    ref.edit().putString("reason2","").apply();
                }
                    if (cb_res4.isChecked()) {
                        ref.edit().putString("reason3", cb_res4.getText().toString()).apply();
                    }else{
                        ref.edit().putString("reason3","").apply();
                    }
                    if (cb_res5.isChecked()) {
                        ref.edit().putString("reason4", cb_res5.getText().toString()).apply();
                    }else{
                        ref.edit().putString("reason4","").apply();
                    }
                    if (cb_res6.isChecked()) {
                        ref.edit().putString("reason5", cb_res6.getText().toString()).apply();
                    }else{
                        ref.edit().putString("reason5","").apply();
                    }
                    if (cb_res8.isChecked()) {
                        ref.edit().putString("reason6", otherres.getText().toString()).apply();
                    }
                    if(!cb_res8.isChecked()){
                        ref.edit().putString("reason6", "").apply();
                    }


                    intent = new Intent(reason.this, tools.class);
                    intent.putExtra("totalsum", totalsum);
                    startActivity(intent);


            }






        });
    }

}