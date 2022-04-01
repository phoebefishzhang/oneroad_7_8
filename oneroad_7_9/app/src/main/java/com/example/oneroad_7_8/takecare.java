package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

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
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class takecare extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences ref;
    String dangerlev;
    Button allfinish;
    FirebaseFirestore db;
    SharedPreferences ref1,ref2,ref3,ref4,ref5,ref6,ref7,ref8,ref9;
    CheckBox CB1,CB2,CB3,CB4,CB5,CB6,CB7,CB8,CB9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takecare);
        allfinish=(Button) findViewById(R.id.allfinish);
        dangerlev = getIntent().getStringExtra("totalsum");
        Log.d("totalsum","total="+dangerlev);
        db= FirebaseFirestore.getInstance();
        CB1=findViewById(R.id.CB1);
        CB2=findViewById(R.id.CB2);
        CB3=findViewById(R.id.CB3);
        CB4=findViewById(R.id.CB4);
        CB5=findViewById(R.id.CB5);
        CB6=findViewById(R.id.CB6);
        CB7=findViewById(R.id.CB7);
        CB8=findViewById(R.id.CB8);
        CB9=findViewById(R.id.CB9);


        ref1=getSharedPreferences("nurselogin",MODE_PRIVATE);
        ref2=getSharedPreferences("patientlogin",MODE_PRIVATE);
        ref3=getSharedPreferences("roadused",MODE_PRIVATE);
        ref4=getSharedPreferences("reasonwhy",MODE_PRIVATE);
        ref5=getSharedPreferences("othertools",MODE_PRIVATE);
        ref6=getSharedPreferences("medicine",MODE_PRIVATE);
        ref7=getSharedPreferences("tools",MODE_PRIVATE);
        ref8=getSharedPreferences("test1",MODE_PRIVATE);
        ref9=getSharedPreferences("get_score",MODE_PRIVATE);
        allfinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(CB1.isChecked() && CB2.isChecked() && CB3.isChecked() && CB4.isChecked() && CB5.isChecked() && CB6.isChecked() && CB7.isChecked() && CB8.isChecked() && CB9.isChecked()){
                    ProgressDialog dialog = new ProgressDialog(takecare.this);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setTitle("處理中");
                    dialog.show();
                    new Thread(()->{

                        /**設置要告訴用戶的話*/
                        dialog.setMessage("上傳中： ");
                        SystemClock.sleep(100);
                        String nursename=ref1.getString("nursename","");
                        String patientname=ref2.getString("patientname","");
                        String patientnum=ref2.getString("patientnum","");
                        String road_CB_1=ref3.getString("CB_1","");
                        String road_CB_2=ref3.getString("CB_2","");
                        String road_CB_3=ref3.getString("CB_3","");
                        String road_CB_4=ref3.getString("CB_4","");
                        String road_CB_5=ref3.getString("CB_5","");
                        String road_CB_6=ref3.getString("CB_6","");
                        String road_CB_7=ref3.getString("CB_7","");
                        String road_CB_8=ref3.getString("CB_8","");
                        String road_CB_9=ref3.getString("CB_9","");
                        String road_other1=ref3.getString("other_road1Name","");
                        String road_other2=ref3.getString("other_road2Name","");
                        String reason1=ref4.getString("reason1","");
                        String reason2=ref4.getString("reason2","");
                        String reason3=ref4.getString("reason3","");
                        String reason4=ref4.getString("reason4","");
                        String reason5=ref4.getString("reason5","");
                        String reason6=ref4.getString("reason6","");
                        String reason7=ref4.getString("reason7","");
                        String reason8=ref4.getString("reason8","");
                        String othertool1=ref5.getString("othertool1","");
                        String othertool2=ref5.getString("othertool2","");
                        String othertool3=ref5.getString("othertool3","");
                        String Cisatracurium=ref6.getString("cisatracurium","");
                        String cml=ref6.getString("cml","");
                        String Dexmedetomidine=ref6.getString("Dexmedetomidine","");
                        String dml=ref6.getString("dml","");
                        String Fentany=ref6.getString("Fentany","");
                        String fml=ref6.getString("fml","");
                        String Fentany_dilution=ref6.getString("Fentany_dilution","");
                        String fml_dilution=ref6.getString("fml_dilution","");
                        String Midazolam=ref6.getString("Midazolam","");
                        String mml=ref6.getString("mml","");
                        String Midazolam_dilution=ref6.getString("Midazolam_dilution","");
                        String mml_dilution=ref6.getString("mml_dilution","");
                        String Proplfol=ref6.getString("Propofol","");
                        String pml=ref6.getString("pml","");
                        String othermed1Name=ref6.getString("othermed1Name","");
                        String othermed2Name=ref6.getString("othermed2Name","");
                        String othermed1ml=ref6.getString("othermed1ml","");
                        String othermed2ml= ref6.getString("othermed2ml","");
                        String tool1=ref7.getString("tool1","");
                        String tool2=ref7.getString("tool2","");
                        String eyes=ref8.getString("eyes","");
                        String move=ref8.getString("move","");
                        String talk=ref8.getString("talk","");
                        int test1_1= ref9.getInt("score1",0);
                        int road=ref9.getInt("score2",0);
                        int test2= ref9.getInt("score3",0);
                        int test3= ref9.getInt("score4",0);
                        int test4= ref9.getInt("score5",0);
                        int test5= ref9.getInt("score6",0);
                        int test6= ref9.getInt("score7",0);
                        Calendar c=Calendar.getInstance();
                        int year=c.get(Calendar.YEAR);
                        int month=c.get(Calendar.MONTH)+1;
                        int day=c.get(Calendar.DAY_OF_MONTH);
                        SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
                        SimpleDateFormat df2=new SimpleDateFormat("HH:mm");
                        String str=df.format(c.getTime());
                        String str2=df2.format(c.getTime());

                        String date=year+"-"+month+"-"+day;
                        String fulldate=year+"-"+month+"-"+day+"("+str+")";


                        Map<String,Object> patient=new HashMap<>();
                        patient.put("name",patientname);
                        patient.put("dangerlev",dangerlev);
                        patient.put("nursename",nursename);
                        patient.put("病歷號",patientnum);
                        patient.put("nursename",nursename);
                        patient.put("road_CB_1",road_CB_1);
                        patient.put("road_CB_2",road_CB_2);
                        patient.put("road_other1",road_other1);
                        patient.put("road_other2",road_other2);
                        patient.put("road_CB_3",road_CB_3);
                        patient.put("road_CB_4",road_CB_4);
                        patient.put("road_CB_5",road_CB_5);
                        patient.put("road_CB_6",road_CB_6);
                        patient.put("road_CB_7",road_CB_7);
                        patient.put("road_CB_8",road_CB_8);
                        patient.put("road_CB_9",road_CB_9);
                        patient.put("體重","60");
                        patient.put("reason1",reason1);
                        patient.put("reason2",reason2);
                        patient.put("reason3",reason3);
                        patient.put("reason4",reason4);
                        patient.put("reason5",reason5);
                        patient.put("reason6",reason6);
                        patient.put("reason7",reason7);
                        patient.put("reason8",reason8);
                        patient.put("othertool1",othertool1);
                        patient.put("othertool2",othertool2);
                        patient.put("othertool3",othertool3);
                        patient.put("Cisatracurium",Cisatracurium);
                        patient.put("Dexmedetomidine",Dexmedetomidine);
                        patient.put("Fentany",Fentany);
                        patient.put("Fentany_dilution",Fentany_dilution);
                        patient.put("Midazolam",Midazolam);
                        patient.put("Midazolam_dilution",Midazolam_dilution);
                        patient.put("Propofol",Proplfol);
                        patient.put("othermed1Name",othermed1Name);
                        patient.put("othermed1ml",othermed1ml);
                        patient.put("othermed2Name",othermed2Name);
                        patient.put("othermed2ml",othermed2ml);
                        patient.put("test1_1",test1_1);
                        patient.put("road",road);
                        patient.put("test2",test2);
                        patient.put("test3",test3);
                        patient.put("test4",test4);
                        patient.put("test5",test5);
                        patient.put("test6",test6);
                        patient.put("cml",cml);
                        patient.put("dml",dml);
                        patient.put("fml",fml);
                        patient.put("fml_dilution",fml_dilution);
                        patient.put("mml",mml);
                        patient.put("mml_dilution",mml_dilution);
                        patient.put("pml",pml);
                        patient.put("eyes",eyes);
                        patient.put("move",move);
                        patient.put("talk",talk);
                        patient.put("tool1",tool1);
                        patient.put("tool2",tool2);
                        patient.put("date",date);
                        patient.put("time",str);
                        db.collection("patientlist").document(patientnum)
                                .set(patient)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d(TAG, "DocumentSnapshot successfully written for db1!");

                                        db.collection("patientlist/"+patientnum+"/history")
                                                .document(fulldate)
                                                .set(patient)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Log.d(TAG, "DocumentSnapshot successfully written!");


                                                        Intent it = new Intent();
                                                        it = new Intent(takecare.this,second_main.class);
                                                        startActivity(it);
                                                        dialog.dismiss();
                                                    }
                                                });

                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error writing document", e);
                                    }
                                });

                        dialog.dismiss();
                    }).start();



                }else{
                    Toast.makeText(takecare.this,"未確認完",Toast.LENGTH_LONG).show();

                }




            }

        });
    }

    @Override
    public void onClick(View v) {


    }
}