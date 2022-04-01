package com.example.oneroad_7_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

public class nurselogin extends AppCompatActivity {
    private EditText nursenumber;
    private FirebaseFirestore db;
    private Button loginbtn;
    private String share_nurse_name,y_n_banned;
    private ImageButton scan;

    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurselogin);
        nursenumber=(EditText) findViewById(R.id.nursenumber);
        loginbtn=(Button) findViewById(R.id.login);
        scan = findViewById(R.id.scan);
        db=FirebaseFirestore.getInstance();
        ref=getSharedPreferences("nurselogin",MODE_PRIVATE);
        Intent intent=this.getIntent();
        String nurse_num=intent.getStringExtra("scan_nurse_num");


        nursenumber.setText(nurse_num);

        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(nursenumber.getText().toString().equals("")){
                    Toast.makeText(nurselogin.this, "請輸入編號", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "NO enter code");
                }else{
                    ProgressDialog dialog = new ProgressDialog(nurselogin.this);

                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setTitle("處理中");
                    dialog.show();
                    new Thread(()->{


                        dialog.setMessage("登入中 ");
                        SystemClock.sleep(100);
                        db.collection("nurselist").document(nursenumber.getText().toString())
                                .get()
                                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if(task.isSuccessful()){
                                            DocumentSnapshot doc=task.getResult();
                                            if(doc.exists()){
                                                y_n_banned=doc.getString("帳號狀態");
                                                if("封鎖".equals(y_n_banned)){
                                                    Log.d(TAG,"be banned");
                                                    Toast.makeText(nurselogin.this,"帳號管制中請找管理員",Toast.LENGTH_LONG).show();
                                                    dialog.dismiss();
                                                }else{
                                                    Log.d(TAG, "Document data:"+doc.getString("name")+y_n_banned);
                                                    share_nurse_name=doc.getString("name");
                                                    ref.edit().putString("nursename",share_nurse_name).apply();
                                                    Intent it=new Intent(nurselogin.this,second_main.class);
                                                    startActivity(it);
                                                    dialog.dismiss();
                                                }

                                            }
                                            else{
                                                Toast.makeText(nurselogin.this, "帳號錯誤", Toast.LENGTH_SHORT).show();
                                                Log.d(TAG,"NO RESULT");
                                                dialog.dismiss();
                                            }
                                        }
                                        else{
                                            Log.d(TAG,"GET FAILED WITH",task.getException());
                                        }
                                    }
                                });


                    }).start();

                }
                }

        });

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(nurselogin.this,scan.class);
                startActivity(it);
            }
        });
    }


}