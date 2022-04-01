package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class finish extends AppCompatActivity implements View.OnClickListener {
    int totalsum;
    private CheckBox c1, c2, c3;
    private Spinner sp2, sp3;

    Button b1, b2;
    FirebaseFirestore db;
    SharedPreferences ref1,ref2,ref3,ref4,ref5,ref6,ref7,ref8,ref9;

    String dan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        totalsum = getIntent().getIntExtra("total4", 0);

        Log.d("totalsum", "total=" + totalsum);
        db = FirebaseFirestore.getInstance();
        show(totalsum);

        ref1=getSharedPreferences("nurselogin",MODE_PRIVATE);
        ref2=getSharedPreferences("patientlogin",MODE_PRIVATE);
        ref3=getSharedPreferences("roadused",MODE_PRIVATE);
        ref4=getSharedPreferences("reasonwhy",MODE_PRIVATE);
        ref5=getSharedPreferences("othertools",MODE_PRIVATE);
        ref6=getSharedPreferences("medicine",MODE_PRIVATE);
        ref7=getSharedPreferences("get_score",MODE_PRIVATE);
        ref8=getSharedPreferences("test1",MODE_PRIVATE);
        ref9=getSharedPreferences("get_score",MODE_PRIVATE);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        sp2 = findViewById(R.id.sp2);
        sp3 = findViewById(R.id.sp3);




        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    sp2.setVisibility(View.VISIBLE);
                } else {
                    sp2.setVisibility(View.INVISIBLE);
                }
            }
        });
        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    sp3.setVisibility(View.VISIBLE);
                } else {
                    sp3.setVisibility(View.INVISIBLE);
                }
            }
        });



    }

    private void show(int tot) {

        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        if (tot <= 12) {
            dan = "低危險";
            tv1.setText(dan);
            tv1.setTextColor(Color.parseColor("#FF000000"));
            tv1.setBackgroundColor(Color.parseColor("#00FF00"));
            tv2.setText("不建議約束");
            tv2.setTextColor(Color.parseColor("#FF000000"));
            tv2.setBackgroundColor(Color.parseColor("#99ff99"));
        }
        if (tot > 12 && tot <= 16) {
            dan = "中危險";
            tv1.setText(dan);
            tv1.setTextColor(Color.parseColor("#FF000000"));
            tv1.setBackgroundColor(Color.parseColor("#FF8800"));
            tv2.setText("不建議約束，但可使用替代式約束工具(乒乓球手套)");
            tv2.setTextColor(Color.parseColor("#FF000000"));
            tv2.setBackgroundColor(Color.parseColor("#ffddaa"));
        }
        if (tot >= 17) {
            dan = "高危險";
            tv1.setText(dan);
            tv1.setTextColor(Color.parseColor("#FF000000"));
            tv1.setBackgroundColor(Color.parseColor("#FF0000"));
            tv2.setText("建議預防性約束");
            tv2.setTextColor(Color.parseColor("#FF000000"));
            tv2.setBackgroundColor(Color.parseColor("#ffb7dd"));
        }


    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {
            case R.id.b1:
                ref2.edit().putInt("totalsum",totalsum).apply();
                if("低危險".equals(dan)){
                    AlertDialog.Builder alt=new AlertDialog.Builder(finish.this);
                    alt.setTitle("填寫約束原因");
                    alt.setMessage("高危身體約束評估量表評估分數低於16分，但護理人員仍進行病人約束，需填寫原因，是否前往填寫原因");
                    alt.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent i=new Intent(finish.this,reason.class);
                            i.putExtra("totalsum",dan);
                            startActivity(i);
                        }
                    });
                    alt.setNegativeButton("否", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alt.show();
                }
                if("中危險".equals(dan)){
                    AlertDialog.Builder alt=new AlertDialog.Builder(finish.this);
                    alt.setTitle("填寫約束原因");
                    alt.setMessage("高危身體約束評估量表評估分數低於16分，但護理人員仍進行病人約束，需填寫原因，是否前往填寫原因");
                    alt.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent i=new Intent(finish.this,reason.class);
                            i.putExtra("totalsum",dan);
                            startActivity(i);
                        }
                    });
                    alt.setNegativeButton("否", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    alt.show();
                }
                if("高危險".equals(dan)){
                    Intent i=new Intent(finish.this,tools.class);
                    i.putExtra("totalsum",dan);
                    startActivity(i);
                }
                String[] location=getResources().getStringArray(R.array.one);
                int idlocation=sp2.getSelectedItemPosition();
                int idlocation2=sp3.getSelectedItemPosition();
                if(c1.isChecked()){
                    ref5.edit().putString("othertool1",c1.getText().toString()).apply();
                }else{
                    ref5.edit().putString("othertool1","").apply();
                }
                if(c2.isChecked()){
                    String update=location[idlocation];
                    ref5.edit().putString("othertool2",c2.getText().toString()+"/"+update).apply();
                }
                else{
                    ref5.edit().putString("othertool2","").apply();
                }
                if(c3.isChecked()){
                    String  update=location[idlocation2];
                    ref5.edit().putString("othertool3",c3.getText().toString()+"/"+update).apply();
                }
                else{
                    ref5.edit().putString("othertool3","").apply();
                }

                break;
            case R.id.b2:

                AlertDialog.Builder alt=new AlertDialog.Builder(finish.this);
                alt.setTitle("確認都完成，即將結束評估");
                alt.setMessage("請確認評估都正確且不必約束，即將登出病人並上傳資料");
                alt.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ProgressDialog dialog2 = new ProgressDialog(finish.this);
                        dialog2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                        dialog2.setTitle("處理中");
                        dialog2.show();
                        new Thread(()->{

                                /**設置要告訴用戶的話*/
                                dialog2.setMessage("上傳中 ");
                                SystemClock.sleep(100);
                            String[]  location=getResources().getStringArray(R.array.one);

                            int idlocation=sp2.getSelectedItemPosition();
                            int idlocation2=sp3.getSelectedItemPosition();
                            String update=location[idlocation];
                            String  update2=location[idlocation2];
                            String othertool1;
                            String othertool2;
                            String othertool3;
                            if(c1.isChecked()){
                                othertool1=c1.getText().toString();

                            }else{
                                othertool1="";
                            }
                            if(c2.isChecked()){
                                othertool2=c2.getText().toString()+"/"+update;

                            }
                            else{
                                othertool2="";
                            }
                            if(c3.isChecked()){
                                othertool3=c3.getText().toString()+"/"+update2;

                            }
                            else{
                                othertool3="";
                            }
                            String nursename=ref1.getString("nursename","");
                            String patientname=ref2.getString("patientname","");
                            String patientnum=ref2.getString("patientnum","");
                            String patientgender=ref2.getString("gender","");
                            String frs= ref2.getString("patientfrs","");
                            String nrs=ref2.getString("patientnrs","");
                            String eatmed1=ref2.getString("eatmedC1","");
                            String eatmed2=ref2.getString("eatmedC2","");
                            String eatmed3=ref2.getString("eatmedC3","");
                            String eatmed4=ref2.getString("eatmedC4","");
                            String eatmed5=ref2.getString("eatmedC5","");
                            String eatmed6=ref2.getString("eatmedC6","");
                            String eatmed7=ref2.getString("eatmedC7","");
                            String eatmed8=ref2.getString("eatmedC8","");
                            String eatmed9=ref2.getString("eatmedC9","");
                            String eatmed10=ref2.getString("eatmedC10","");
                            String patientclass=ref2.getString("patientclass","");
                            String patientroom=ref2.getString("patientroom","");
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
                            int test1_1= ref7.getInt("score1",0);
                            int road=ref7.getInt("score2",0);
                            int test2= ref7.getInt("score3",0);
                            int test3= ref7.getInt("score4",0);
                            int test4= ref7.getInt("score5",0);
                            int test5= ref7.getInt("score6",0);
                            int test6= ref7.getInt("score7",0);
                            String eyes=ref8.getString("eyes","");
                            String move=ref8.getString("move","");
                            String talk=ref8.getString("talk","");
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
                            patient.put("dangerlev",dan);
                            patient.put("nursename",nursename);
                            patient.put("病歷號",patientnum);
                            patient.put("nursename",nursename);
                            patient.put("gender",patientgender);
                            patient.put("totalsum",totalsum);
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
                            patient.put("frs",frs);
                            patient.put("nrs",nrs);
                            patient.put("patientclass",patientclass);
                            patient.put("patientroom",patientroom);
                            patient.put("eatmed1",eatmed1);
                            patient.put("eatmed2",eatmed2);
                            patient.put("eatmed3",eatmed3);
                            patient.put("eatmed4",eatmed4);
                            patient.put("eatmed5",eatmed5);
                            patient.put("eatmed6",eatmed6);
                            patient.put("eatmed7",eatmed7);
                            patient.put("eatmed8",eatmed8);
                            patient.put("eatmed9",eatmed9);
                            patient.put("eatmed10",eatmed10);
                            patient.put("體重","60");
                            patient.put("reason1","");
                            patient.put("test1_1",test1_1);
                            patient.put("road",road);
                            patient.put("test2",test2);
                            patient.put("test3",test3);
                            patient.put("test4",test4);
                            patient.put("test5",test5);
                            patient.put("test6",test6);
                            patient.put("reason","");
                            patient.put("reason1","");
                            patient.put("reason2","");
                            patient.put("reason3","");
                            patient.put("reason4","");
                            patient.put("reason5","");
                            patient.put("reason6","");
                            patient.put("reason7","");
                            patient.put("reason8","");
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
                            patient.put("tool1","");
                            patient.put("tool2","");
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

                                                            db.collection("TotalHitstory").document(fulldate)
                                                                    .set(patient)
                                                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                        @Override
                                                                        public void onSuccess(Void unused) {
                                                                            dialog2.dismiss();

                                                                            Intent it = new Intent();
                                                                            it = new Intent(finish.this,second_main.class);
                                                                            startActivity(it);
                                                                        }
                                                                    });


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
                            dialog2.dismiss();
                        }).start();




                    }
                });
                alt.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alt.show();


                break;
            case R.id.explan6:
                it = new Intent(this, explan6.class);
                startActivity(it);
                break;
            case R.id.table:
                it = new Intent(this,table.class);
                startActivity(it);
                break;
        }

    }
}