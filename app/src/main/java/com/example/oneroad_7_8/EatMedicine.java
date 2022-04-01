package com.example.oneroad_7_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

public class EatMedicine extends AppCompatActivity implements View.OnClickListener {
    CheckBox c_no, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
    int total;
    SharedPreferences ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_medicine);
        c_no = findViewById(R.id.c_no);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        ref=getSharedPreferences("patientlogin",MODE_PRIVATE);
        c_no.setChecked(true);

        total = getIntent().getIntExtra("total3", 0);
        Log.d("sum", "total3=" + total);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.next:
                if(c1.isChecked()){
                    ref.edit().putString("eatmedC1",c1.getText().toString()).apply();
                }
                if(c2.isChecked()){
                    ref.edit().putString("eatmedC2",c2.getText().toString()).apply();
                }
                if(c3.isChecked()){
                    ref.edit().putString("eatmedC3",c3.getText().toString()).apply();
                }
                if(c4.isChecked()){
                    ref.edit().putString("eatmedC4",c4.getText().toString()).apply();
                }
                if(c5.isChecked()){
                    ref.edit().putString("eatmedC5",c5.getText().toString()).apply();
                }
                if(c6.isChecked()){
                    ref.edit().putString("eatmedC6",c6.getText().toString()).apply();
                }
                if(c7.isChecked()){
                    ref.edit().putString("eatmedC7",c7.getText().toString()).apply();
                }
                if(c8.isChecked()){
                    ref.edit().putString("eatmedC8",c8.getText().toString()).apply();
                }
                if(c9.isChecked()){
                    ref.edit().putString("eatmedC9",c9.getText().toString()).apply();
                }
                if(c10.isChecked()){
                    ref.edit().putString("eatmedC10",c10.getText().toString()).apply();
                }
                it = new Intent(this, finish.class);
                break;

        }
        it.putExtra("total4", total);
        startActivity(it);
    }

    public void onCheckVoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.c1:
                if (c1.isChecked()){
                    c_no.setChecked(false);
                }
                else{
                    Log.d("c1", "unchecked");
                }

                break;
            case R.id.c2:
                if (c2.isChecked()){
                    c_no.setChecked(false);
                }
                else{
                    Log.d("c2", "unchecked");
                }
                break;
            case R.id.c3:
                if (c3.isChecked()){
                    c_no.setChecked(false);
                }
                else
                    Log.d("c3", "unchecked");
                break;
            case R.id.c4:
                if (c4.isChecked()){
                    c_no.setChecked(false);
                }
                else
                    Log.d("c4", "unchecked");
                break;
            case R.id.c5:
                if (c5.isChecked()){
                    c_no.setChecked(false);

                }

                else
                    Log.d("c5", "unchecked");
                break;
            case R.id.c6:
                if (c6.isChecked()){
                    c_no.setChecked(false);
                }
                else
                    Log.d("c6", "unchecked");
                break;
            case R.id.c7:
                if (c7.isChecked()){
                    c_no.setChecked(false);
                }

                else
                    Log.d("c7", "unchecked");
                break;
            case R.id.c8:
                if (c8.isChecked()){
                    c_no.setChecked(false);
                }
                else
                    Log.d("c8", "unchecked");
                break;
            case R.id.c9:
                if (c9.isChecked()){
                    c_no.setChecked(false);
                }
                else
                    Log.d("c9", "unchecked");
                break;
            case R.id.c10:
                if (c10.isChecked()){
                    c_no.setChecked(false);

                }

                else
                    Log.d("c10", "unchecked");
                break;
            case R.id.c_no:
                if (checked)
                    c1.setChecked(false);
                c2.setChecked(false);
                c3.setChecked(false);
                c4.setChecked(false);
                c5.setChecked(false);
                c6.setChecked(false);
                c7.setChecked(false);
                c8.setChecked(false);
                c9.setChecked(false);
                c10.setChecked(false);
                break;

        }
    }
}