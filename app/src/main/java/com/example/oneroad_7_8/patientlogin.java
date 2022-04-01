package com.example.oneroad_7_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.SQLTransactionRollbackException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class patientlogin extends AppCompatActivity {

    private EditText patientnum;
    private Button loginbtn;
    private FirebaseFirestore db;
    SharedPreferences ref, ref2, ref3, ref4,ref5;
    private String share_patient_name, share_patient_num, getlastdanger, patientgender;
    private String share_patient_wight;
    private ImageButton scan;
    RadioGroup rg;
    RadioButton b1, b2, b3, b4;
    Spinner spmicu, spsicu, spnricu, sprcc;
    String SelectUpdate,SelectClass;
    TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        patientnum = (EditText) findViewById(R.id.patientnumber);
        loginbtn = (Button) findViewById(R.id.login);
        scan = findViewById(R.id.scan);
        db = FirebaseFirestore.getInstance();
        ref = getSharedPreferences("patientlogin", MODE_PRIVATE);
        ref2 = getSharedPreferences("reasonwhy", MODE_PRIVATE);
        ref3 = getSharedPreferences("tools", MODE_PRIVATE);
        ref4 = getSharedPreferences("get_score", MODE_PRIVATE);
        ref5=getSharedPreferences("medicine",MODE_PRIVATE);
        Intent intent = this.getIntent();
        String nurse_num = intent.getStringExtra("scan_patient_num");
        spmicu = findViewById(R.id.spmicu);
        spsicu = findViewById(R.id.spsicu);
        spnricu = findViewById(R.id.spnrcu);
        sprcc = findViewById(R.id.sprcc);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        rg=findViewById(R.id.rg);
        patientnum.setText(nurse_num);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.b1:
                        ref.edit().putString("patientclass",b1.getText().toString()).apply();
                        spmicu.setVisibility(View.VISIBLE);
                        spsicu.setVisibility(View.INVISIBLE);
                        spnricu.setVisibility(View.INVISIBLE);
                        sprcc.setVisibility(View.INVISIBLE);
                        t1.setVisibility(View.VISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                        t3.setVisibility(View.INVISIBLE);
                        t4.setVisibility(View.INVISIBLE);

                        Log.d(TAG,"get1");

                        break;
                    case R.id.b2:
                        ref.edit().putString("patientclass",b2.getText().toString()).apply();
                        spmicu.setVisibility(View.INVISIBLE);
                        spsicu.setVisibility(View.VISIBLE);
                        spnricu.setVisibility(View.INVISIBLE);
                        sprcc.setVisibility(View.INVISIBLE);
                        t1.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.VISIBLE);
                        t3.setVisibility(View.INVISIBLE);
                        t4.setVisibility(View.INVISIBLE);

                        Log.d(TAG,"get2");

                        break;
                    case R.id.b3:
                        ref.edit().putString("patientclass",b3.getText().toString()).apply();
                        spmicu.setVisibility(View.INVISIBLE);
                        spsicu.setVisibility(View.INVISIBLE);
                        spnricu.setVisibility(View.VISIBLE);
                        sprcc.setVisibility(View.INVISIBLE);
                        t1.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                        t4.setVisibility(View.INVISIBLE);
                        t3.setVisibility(View.VISIBLE);

                        Log.d(TAG,"get3");

                        break;
                    case R.id.b4:
                        ref.edit().putString("patientclass",b4.getText().toString()).apply();
                        spmicu.setVisibility(View.INVISIBLE);
                        spsicu.setVisibility(View.INVISIBLE);
                        spnricu.setVisibility(View.INVISIBLE);
                        sprcc.setVisibility(View.VISIBLE);
                        t1.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                        t3.setVisibility(View.INVISIBLE);

                        Log.d(TAG,"get4");

                        t4.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] location=getResources().getStringArray(R.array.micu);
                String [] location2=getResources().getStringArray(R.array.sicu);
                String [] location3=getResources().getStringArray(R.array.nricu);
                String [] location4=getResources().getStringArray(R.array.rcc);
                int idlocation=spmicu.getSelectedItemPosition();
                int idlocation2=spsicu.getSelectedItemPosition();
                int idlocation3=spnricu.getSelectedItemPosition();
                int idlocation4=sprcc.getSelectedItemPosition();
                String update=location[idlocation];
                String update2=location2[idlocation2];
                String update3=location3[idlocation3];
                String update4=location4[idlocation4];

                if(patientnum.getText().toString().equals("")){
                    Toast.makeText(patientlogin.this, "請輸入編號", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "NO enter code");

                }else{
                    ProgressDialog dialog = new ProgressDialog(patientlogin.this);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setTitle("處理中");
                    dialog.show();
                    new Thread(() -> {
                        dialog.setMessage("載入中 ");
                        SystemClock.sleep(100);
                        ref.edit().clear().commit();
                        ref2.edit().clear().commit();
                        ref3.edit().clear().commit();
                        ref4.edit().clear().commit();
                        ref5.edit().clear().commit();
                        db.collection("patientlist").document(patientnum.getText().toString())
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if (task.isSuccessful()) {
                                            DocumentSnapshot doc = task.getResult();
                                            if (doc.exists()) {
                                                if(b1.isChecked() || b2.isChecked() || b3.isChecked() || b4.isChecked()){
                                                    if(!update.equals("-未填-") || !update2.equals("-未填-") || !update3.equals("-未填-") || !update4.equals("-未填-")){
                                                        if(b1.isChecked()){
                                                            SelectUpdate=update;
                                                            SelectClass=b1.getText().toString();
                                                        }
                                                        if(b2.isChecked()){
                                                            SelectUpdate=update2;
                                                            SelectClass=b2.getText().toString();
                                                        }
                                                        if(b3.isChecked()){
                                                            SelectUpdate=update3;
                                                            SelectClass=b3.getText().toString();
                                                        }
                                                        if(b4.isChecked()){
                                                            SelectUpdate=update4;
                                                            SelectClass=b4.getText().toString();
                                                        }
                                                        Log.d(TAG, "Document data:" + doc.getString("病歷號"));
                                                        share_patient_name = doc.getString("name");
                                                        share_patient_num = doc.getString("病歷號");
                                                        share_patient_wight = doc.getString("體重");
                                                        getlastdanger = doc.getString("dangerlev");
                                                        patientgender = doc.getString("gender");
                                                        ref.edit().putString("patientname", share_patient_name).apply();
                                                        ref.edit().putString("patientnum", share_patient_num).apply();
                                                        ref.edit().putString("patientweight", share_patient_wight).apply();
                                                        ref.edit().putString("dangerlev", getlastdanger).apply();
                                                        ref.edit().putString("patientroom",SelectUpdate).apply();
                                                        ref.edit().putString("patientclass",SelectClass).apply();
                                                        ref.edit().putString("gender",patientgender).apply();
                                                        dialog.dismiss();
                                                        Intent it = new Intent(patientlogin.this, third_main.class);

                                                        Log.d(TAG,SelectUpdate);

                                                        startActivity(it);
                                                    }else{
                                                        dialog.dismiss();
                                                        Toast.makeText(patientlogin.this, "填寫病房", Toast.LENGTH_SHORT).show();
                                                        Log.d(TAG, "NO SELECT ROOM"+update);
                                                    }


                                                }else{
                                                    dialog.dismiss();
                                                    Toast.makeText(patientlogin.this, "請填寫單位別", Toast.LENGTH_SHORT).show();
                                                    Log.d(TAG, "NO SELECT CLASS");
                                                }

                                            } else {
                                                dialog.dismiss();
                                                Toast.makeText(patientlogin.this, "帳號錯誤", Toast.LENGTH_SHORT).show();
                                                Log.d(TAG, "NO RESULT");
                                            }
                                        } else {
                                            Log.d(TAG, "GET FAILED WITH", task.getException());
                                        }
                                    }
                                });


                        dialog.dismiss();
                    }).start();

                }



            }
        });



        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(patientlogin.this, scan2.class);
                startActivity(it);

            }
        });


    }


}