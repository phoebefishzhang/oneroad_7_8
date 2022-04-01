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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import static android.content.ContentValues.TAG;

public class patientlogin extends AppCompatActivity {

    private EditText patientnum;
    private Button loginbtn;
    private FirebaseFirestore db;
    SharedPreferences ref,ref2,ref3,ref4;
    private String share_patient_name,share_patient_num,getlastdanger;
    private  String share_patient_wight;
    private ImageButton scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        patientnum=(EditText) findViewById(R.id.patientnumber);
        loginbtn=(Button) findViewById(R.id.login);
        scan = findViewById(R.id.scan);
        db=FirebaseFirestore.getInstance();
        ref=getSharedPreferences("patientlogin",MODE_PRIVATE);
        ref2=getSharedPreferences("reasonwhy",MODE_PRIVATE);
        ref3=getSharedPreferences("tools",MODE_PRIVATE);
        ref4=getSharedPreferences("get_score",MODE_PRIVATE);
        Intent intent=this.getIntent();
        String nurse_num=intent.getStringExtra("scan_patient_num");

        patientnum.setText(nurse_num);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(patientlogin.this);
                /**設置UI形式為轉圈圈*/
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setTitle("處理中");
                dialog.show();
                new Thread(()->{
                        /**設置要告訴用戶的話*/
                        dialog.setMessage("載入中 ");
                        SystemClock.sleep(100);
                    ref2.edit().clear().commit();
                    ref3.edit().clear().commit();
                    ref4.edit().clear().commit();
                    db.collection("patientlist").document(patientnum.getText().toString())
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if(task.isSuccessful()){
                                        DocumentSnapshot doc=task.getResult();
                                        if(doc.exists()){
                                            Log.d(TAG, "Document data:"+doc.getString("病歷號"));
                                            share_patient_name=doc.getString("name");
                                            share_patient_num=doc.getString("病歷號");
                                            share_patient_wight=doc.getString("體重");
                                            getlastdanger= doc.getString("dangerlev");
                                            ref.edit().putString("patientname",share_patient_name).apply();
                                            ref.edit().putString("patientnum",share_patient_num).apply();
                                            ref.edit().putString("patientweight",share_patient_wight).apply();
                                            ref.edit().putString("dangerlev",getlastdanger).apply();
                                            dialog.dismiss();
                                            Intent it=new Intent(patientlogin.this,third_main.class);
                                            startActivity(it);

                                        }
                                        else{
                                            dialog.dismiss();
                                            Toast.makeText(patientlogin.this, "帳號錯誤", Toast.LENGTH_SHORT).show();
                                            Log.d(TAG,"NO RESULT");
                                        }
                                    }
                                    else{
                                        Log.d(TAG,"GET FAILED WITH",task.getException());
                                    }
                                }
                            });


                    dialog.dismiss();
                }).start();

            }
        });


        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(patientlogin.this,scan2.class);
                startActivity(it);
            }
        });
    }
}