package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class medicine extends AppCompatActivity implements View.OnClickListener {
    private EditText CE, DE, FE, FE_dilution, ME, ME_dilution, PE, eW, othermed1E, othermed2E, othermed1Name, othermed2Name;//填寫
    private CheckBox C, D, F, F_dilution, M,M_dilution , P,othermed1, othermed2;
    private TextView t1, t2, t3,t3_dilution, t4, t4_dilution, t5,t6,t7, cfast1, cfast2, cfast3, cfast4, dfast, ffast,ffast2, mfast,mfast2, pfast;//文字顯示
    private TextView r1, c1, c2;
    int total2 = 0;
    int rass, cpot;
    SharedPreferences ref,ref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        C = findViewById(R.id.C);
        D = findViewById(R.id.D);
        F = findViewById(R.id.F);
        F_dilution=findViewById(R.id.F_dilution);
        M = findViewById(R.id.M);
        M_dilution=findViewById(R.id.M_dilution);
        P = findViewById(R.id.P);
        othermed1=findViewById(R.id.othermed1);
        othermed2=findViewById(R.id.othermed2);
        othermed1E=findViewById(R.id.othermed1E);
        othermed2E=findViewById(R.id.othermed2E);
        othermed1Name=findViewById(R.id.othermed1Name);
        othermed2Name=findViewById(R.id.othermed2Name);
        ref = getSharedPreferences("patientlogin", MODE_PRIVATE);
        ref2=getSharedPreferences("medicine",MODE_PRIVATE);
        String patientweight = ref.getString("patientweight", "");

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t3_dilution=findViewById(R.id.t3_dilution);
        t4 = findViewById(R.id.t4);
        t4_dilution=findViewById(R.id.t4_dilution);
        t5 = findViewById(R.id.t5);
        t6= findViewById(R.id.t6);
        t7=findViewById(R.id.t7);
        cfast1 = findViewById(R.id.cfast1);
        cfast2 = findViewById(R.id.cfast2);
        cfast3 = findViewById(R.id.cfast3);
        cfast4 = findViewById(R.id.cfast4);
        dfast = findViewById(R.id.dfast);
        ffast = findViewById(R.id.ffast);
        ffast2 = findViewById(R.id.ffast2);
        mfast = findViewById(R.id.mfast);
        mfast2 = findViewById(R.id.mfast2);
        pfast = findViewById(R.id.pfast);

        CE = findViewById(R.id.CE);
        DE = findViewById(R.id.DE);
        FE = findViewById(R.id.FE);
        FE_dilution=findViewById(R.id.FE_dilution);
        ME = findViewById(R.id.ME);
        ME_dilution=findViewById(R.id.ME_dilution);
        PE = findViewById(R.id.PE);
        eW = findViewById(R.id.eW);

        r1 = findViewById(R.id.r1);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);

        total2 = getIntent().getIntExtra("total2", 0);
        rass = getIntent().getIntExtra("rass", 0);
        cpot = getIntent().getIntExtra("cpot", 0);
        Log.d("sum", "total2=" + total2);
        Log.d(TAG, "get RESULT" + patientweight);
        eW.setText(patientweight);
        eW.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    double val, speed1, speed12, speed2, speed3, speed32, speed4, speed5, speed52, speed6, speed62, speed7, speed72, speed8, speed82,speed9,speed92,speed10,speed102;

                    try {
                        val = Double.parseDouble(eW.getText().toString());
                    } catch (NumberFormatException e) {
                        val = 0;
                    }
                    speed1 = 0.5 * val * 60 / 1000 / 0.4;
                    speed12 = (0.5 * val * 60 / 1000 / 0.4) * 20;
                    speed2 = 3 * val * 60 / 1000 / 0.4;
                    speed3 = 0.5 * val * 60 / 1000 / 2;
                    speed32 = (0.5 * val * 60 / 1000 / 2) * 20;
                    speed4 = 3 * val * 60 / 1000 / 2;
                    speed5 = 0.2 * val / 4;
                    speed52 = 0.7 * val / 4;
                    speed6 = 1;
                    speed62 = 2;
                    speed7 = 0.04 * val / 5;
                    speed72 = 0.2 * val / 5;
                    speed8 = 5 * val * 60 / 1000 / 10;
                    speed82 = (5 * val * 60 / 1000 / 10) * 16;
                    speed9 = 5;
                    speed92 =10;
                    speed10 =0.04 * val ;
                    speed102 =0.2 * val;

                    cfast1.setText(String.format("%.2f~%.2f ml/hr", speed1, speed12));
                    cfast2.setText(String.format("%.2f ml/hr", speed2));
                    cfast3.setText(String.format("%.2f~%.2f ml/hr", speed3, speed32));
                    cfast4.setText(String.format("%.2f ml/hr", speed4));
                    dfast.setText(String.format("%.2f~%.2f ml/hr", speed5, speed52));
                    ffast.setText(String.format("%.1f~%.1f ml/hr", speed6, speed62));
                    ffast2.setText(String.format("%.1f~%.1f ml/hr", speed9, speed92));
                    mfast.setText(String.format("%.2f~%.2f ml/hr", speed7, speed72));
                    mfast2.setText(String.format("%.2f~%.2f ml/hr", speed10, speed102));
                    pfast.setText(String.format("%.2f~%.2f ml/hr", speed8, speed82));

                    return true;
                }
                return false;
            }
        });

        C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t1.setText("ml/hr");
                    CE.setVisibility(View.VISIBLE);
                } else {
                    t1.setText("");
                    CE.setVisibility(View.INVISIBLE);
                }
            }
        });

        D.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t2.setText("ml/hr");
                    DE.setVisibility(View.VISIBLE);
                } else {
                    t2.setText("");
                    DE.setVisibility(View.INVISIBLE);
                }
            }
        });

        F.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t3.setText("ml/hr");
                    FE.setVisibility(View.VISIBLE);
                } else {
                    t3.setText("");
                    FE.setVisibility(View.INVISIBLE);
                }
            }
        });

        F_dilution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t3_dilution.setText("ml/hr");
                    FE_dilution.setVisibility(View.VISIBLE);
                } else {
                    t3_dilution.setText("");
                    FE_dilution.setVisibility(View.INVISIBLE);
                }
            }
        });

        M.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t4.setText("ml/hr");
                    ME.setVisibility(View.VISIBLE);
                } else {
                    t4.setText("");
                    ME.setVisibility(View.INVISIBLE);
                }
            }
        });

        M_dilution.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t4_dilution.setText("ml/hr");
                    ME_dilution.setVisibility(View.VISIBLE);
                } else {
                    t4_dilution.setText("");
                    ME_dilution.setVisibility(View.INVISIBLE);
                }
            }
        });

        P.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t5.setText("ml/hr");
                    PE.setVisibility(View.VISIBLE);
                } else {
                    t5.setText("");
                    PE.setVisibility(View.INVISIBLE);
                }
            }
        });
        othermed1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t6.setText("ml/hr");
                    othermed1E.setVisibility(View.VISIBLE);
                    othermed1Name.setVisibility(View.VISIBLE);
                } else {
                    t6.setText("");
                    othermed1E.setVisibility(View.INVISIBLE);
                }
            }
        });
        othermed2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    t7.setText("ml/hr");
                    othermed2E.setVisibility(View.VISIBLE);
                    othermed2Name.setVisibility(View.VISIBLE);
                } else {
                    t7.setText("");
                    othermed2E.setVisibility(View.INVISIBLE);
                }
            }
        });
        if (rass == 11) {
            r1.setText("RASS : 未使用");
            r1.setBackgroundColor(Color.parseColor("#FF6347"));
        } else if (rass > 7 && rass < 11) {
            r1.setText("RASS : 建議減低鎮靜藥物劑量");
            r1.setBackgroundColor(Color.parseColor("#99ff99"));
        } else if (rass > 4) {
            r1.setText("RASS : 建議維持鎮靜藥物劑量");
            r1.setBackgroundColor(Color.parseColor("#ffddaa"));
        } else {
            r1.setText("RASS : 建議增加鎮靜藥物劑量");
            r1.setBackgroundColor(Color.parseColor("#ffb7dd"));
        }

        if (cpot >= 3) {
            c1.setText("CPOT : 建議增加止痛藥物劑量:");
            c1.setBackgroundColor(Color.parseColor("#ffb7dd"));
            c2.setBackgroundColor(Color.parseColor("#ffb7dd"));
            c2.setText("Fentanyl,Morphine,NSAIDs");
        } else {
            c1.setText("CPOT : 建議可維持止痛藥物劑量:");
            c1.setBackgroundColor(Color.parseColor("#ffddaa"));
            c2.setBackgroundColor(Color.parseColor("#ffddaa"));
            c2.setText("Fentanyl");
        }

    }


    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.previous:
                it = new Intent(this, cpot.class);
                break;
            case R.id.next:
                if(C.isChecked()){
                    ref2.edit().putString("cisatracurium",C.getText().toString()).apply();
                    ref2.edit().putString("cml",CE.getText().toString()).apply();
                }else{
                    ref2.edit().putString("cisatracurium","").apply();
                    ref2.edit().putString("cml","").apply();
                }
                if(D.isChecked()){
                    ref2.edit().putString("Dexmedetomidine",D.getText().toString()).apply();
                    ref2.edit().putString("dml",DE.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Dexmedetomidine","").apply();
                    ref2.edit().putString("dml","").apply();
                }
                if(F.isChecked()){
                    ref2.edit().putString("Fentany",F.getText().toString()).apply();
                    ref2.edit().putString("fml",FE.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Fentany","").apply();
                    ref2.edit().putString("fml","").apply();
                }
                if(F_dilution.isChecked()){
                    ref2.edit().putString("Fentany_dilution",F_dilution.getText().toString()).apply();
                    ref2.edit().putString("fml_dilution",FE_dilution.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Fentany_dilution","").apply();
                    ref2.edit().putString("fml_dilution","").apply();
                }

                if(M.isChecked()){
                    ref2.edit().putString("Midazolam",M.getText().toString()).apply();
                    ref2.edit().putString("mml",ME.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Midazolam","").apply();
                    ref2.edit().putString("mml","").apply();
                }
                if(M_dilution.isChecked()){
                    ref2.edit().putString("Midazolam_dilution",M_dilution.getText().toString()).apply();
                    ref2.edit().putString("mml_dilution",ME_dilution.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Midazolam_dilution","").apply();
                    ref2.edit().putString("mml_dilution","").apply();
                }
                if(P.isChecked()){
                    ref2.edit().putString("Propofol",P.getText().toString()).apply();
                    ref2.edit().putString("pml",PE.getText().toString()).apply();
                }else{
                    ref2.edit().putString("Propofol","").apply();
                    ref2.edit().putString("pml","").apply();
                }
                if(othermed1.isChecked()){

                    ref2.edit().putString("othermed1ml",othermed1E.getText().toString()).apply();
                    ref2.edit().putString("othermed1Name",othermed1Name.getText().toString()).apply();
                }else{
                    ref2.edit().putString("othermed1Name","").apply();
                    ref2.edit().putString("othermed1ml","").apply();
                }
                if(othermed2.isChecked()){

                    ref2.edit().putString("othermed2ml",othermed2E.getText().toString()).apply();
                    ref2.edit().putString("othermed2Name",othermed2Name.getText().toString()).apply();
                }else{
                    ref2.edit().putString("othermed2Name","").apply();
                    ref2.edit().putString("othermed2ml","").apply();
                }
                it = new Intent(this, finish.class);
                break;
        }

        it.putExtra("total4", total2);
        startActivity(it);
    }
}