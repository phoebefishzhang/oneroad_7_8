package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class third_main extends AppCompatActivity {
    private Button startbtn,logout,table;
    private TextView nursename,patientname,patientnum,lastdanger,usedroad,othertool,medicineName,medicineML,reasonwhy,tools,lasttime;
    FirebaseFirestore db;
    String patient_num,get_road_CB_1,get_road_CB_2,get_road_CB_3,get_road_CB_4,get_road_CB_5,get_road_CB_6,get_road_CB_7,get_road_CB_8,get_road_CB_9,totalString,get_cis,get_dex,get_otherroad1,get_otherroad2;
    String  total_medicineName,get_fen,get_fen_dilution,get_mid,get_mid_dilution,get_pro,get_cisml,get_dexml,get_fenml,get_fenml_dilution,get_midml,get_midml_dilution,get_proml,total_medicineml;
    String get_reason1,total_reason,get_reason2,get_reason3,get_reason4,get_reason5,get_reason6,get_reason7,get_reason8;
    String get_othertool1,get_othertool2,get_othertool3,get_tool1,get_tool2,get_tool3,total_othertools,total_tools;
    SharedPreferences ref,ref2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_main);
        startbtn=(Button) findViewById(R.id.startbtn);
        nursename=(TextView) findViewById(R.id.nursename);
        patientname=(TextView) findViewById(R.id.patientname);
        patientnum=(TextView) findViewById(R.id.patientnum);
        lastdanger=(TextView)findViewById(R.id.lastdanger);
        db=FirebaseFirestore.getInstance();
        table=findViewById(R.id.table);
        usedroad=(TextView)findViewById(R.id.usedroad);
        othertool=(TextView)findViewById(R.id.othertool);
        medicineName=(TextView)findViewById(R.id.medicineName);
        medicineML=(TextView)findViewById(R.id.medicineML);
        reasonwhy=(TextView)findViewById(R.id.reasonwhy);
        tools=(TextView)findViewById(R.id.tools);
        lasttime=(TextView)findViewById(R.id.lasttime);
        ref=getSharedPreferences("nurselogin",MODE_PRIVATE);
        ref2=getSharedPreferences("patientlogin",MODE_PRIVATE);
        patient_num=ref2.getString("patientnum","");
        nursename.setText(ref.getString("nursename",""));
        patientname.setText(ref2.getString("patientname",""));
        patientnum.setText(ref2.getString("patientnum",""));
        lastdanger.setText(ref2.getString("dangerlev",""));
        logout=(Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(third_main.this,"登出成功",Toast.LENGTH_LONG).show();
                Intent it=new Intent(third_main.this,second_main.class);
                startActivity(it);
            }
        });
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(third_main.this,table.class);
                startActivity(it);
            }
        });

        db.collection("patientlist").document(patient_num).get()
                .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                       if(task.isSuccessful()){
                           DocumentSnapshot doc=task.getResult();
                           if (doc.exists()) {
                               get_road_CB_1=doc.getString("road_CB_1");
                               if("none".equals(get_road_CB_1)){
                                   get_road_CB_1="";
                               }else{
                                   get_road_CB_1=get_road_CB_1+"\n";
                               }
                               get_road_CB_2=doc.getString("road_CB_2");
                               if("none".equals(get_road_CB_2)){
                                   get_road_CB_2="";
                               }else{
                                   get_road_CB_2=get_road_CB_2+"\n";
                               }
                               get_road_CB_3=doc.getString("road_CB_3");
                               if("none".equals(get_road_CB_3)){
                                   get_road_CB_3="";
                               }else{
                                   get_road_CB_3=get_road_CB_3+"\n";
                               }
                               get_road_CB_4=doc.getString("road_CB_4");
                               if("none".equals(get_road_CB_4)){
                                   get_road_CB_4="";
                               }else{
                                   get_road_CB_4=get_road_CB_4+"\n";
                               }
                               get_road_CB_5=doc.getString("road_CB_5");
                               if("none".equals(get_road_CB_5)){
                                   get_road_CB_5="";
                               }else{
                                   get_road_CB_5=get_road_CB_5+"\n";
                               }
                               get_road_CB_6=doc.getString("road_CB_6");
                               if("none".equals(get_road_CB_6)){
                                   get_road_CB_6="";
                               }else{
                                   get_road_CB_6=get_road_CB_6+"\n";
                               }
                               get_road_CB_7=doc.getString("road_CB_7");
                               if("none".equals(get_road_CB_7)){
                                   get_road_CB_7="";
                               }else{
                                   get_road_CB_7=get_road_CB_7+"\n";
                               }
                               get_road_CB_8=doc.getString("road_CB_8");
                               if("none".equals( get_road_CB_8)){
                                   get_road_CB_8="";
                               }else{
                                   get_road_CB_8= get_road_CB_8+"\n";
                               }
                               get_road_CB_9=doc.getString("road_CB_9");
                               if("none".equals(get_road_CB_9)){
                                   get_road_CB_9="";
                               }else{
                                   get_road_CB_9=get_road_CB_9+"\n";
                               }
                               get_otherroad1=doc.getString("road_other1");
                               if("none".equals(get_otherroad1)){
                                   get_otherroad1="";
                               }else{
                                   get_otherroad1=get_otherroad1+"\n";
                               }
                               get_otherroad2=doc.getString("road_other2");
                               if("none".equals(get_otherroad2)){
                                   get_otherroad2="";
                               }else{
                                   get_otherroad2=get_otherroad2+"\n";
                               }

                               totalString=get_road_CB_1+get_road_CB_2+get_road_CB_3+get_road_CB_4+get_road_CB_5+get_road_CB_6+get_road_CB_7+get_road_CB_8+get_road_CB_9+get_otherroad1+get_otherroad2;

                               usedroad.setText(totalString);

                               get_cis=doc.getString("Cisatracurium");
                               if("Cisatracurium".equals(get_cis)){
                                   get_cis="Cisatracurium\n";
                                   get_cisml=doc.getString("cml")+"ml/hr\n";

                               }else{
                                   get_cis="";
                                   get_cisml="";
                               }
                               get_dex=doc.getString("Dexmedetomidine");
                               if("Dexmedetomidine".equals(get_dex)){
                                   get_dex="Dexmedetomidine\n";
                                   get_dexml=doc.getString("dml")+"ml/hr\n";
                               }else{
                                   get_dex="";
                                   get_dexml="";
                               }
                               get_fen=doc.getString("Fentany");
                               if("Fentanyl".equals(get_fen)){
                                   get_fen="Fentanyl\n";
                                   get_fenml=doc.getString("fml")+"ml/hr\n";
                               }else{
                                   get_fen="";
                                   get_fenml="";
                               }
                               get_fen_dilution=doc.getString("Fentany_dilution");
                               if("Fentanyl(稀釋)".equals(get_fen_dilution)){
                                   get_fen_dilution="Fentanyl(稀釋)\n";
                                   get_fenml_dilution=doc.getString("fml_dilution")+"ml/hr\n";
                               }else{
                                   get_fen_dilution="";
                                   get_fenml_dilution="";
                               }
                               get_mid=doc.getString("Midazolam");
                               if("Dormicum".equals(get_mid)){
                                   get_mid="Dormicum\n";
                                   get_midml=doc.getString("mml")+"ml/hr\n";

                               }else{
                                   get_mid="";
                                   get_midml="";
                               }
                               get_mid_dilution=doc.getString("Midazolam_dilution");
                               if("Dormicum(稀釋)".equals(get_mid_dilution)){
                                   get_mid_dilution="Dormicum(稀釋)\n";
                                   get_midml_dilution=doc.getString("mml_dilution")+"ml/hr\n";

                               }else{
                                   get_mid_dilution="";
                                   get_midml_dilution="";
                               }
                               get_pro=doc.getString("Propofol");
                               if("Propofol".equals(get_pro)){
                                   get_pro="Propofol\n";
                                   get_proml=doc.getString("pml")+"ml/hr\n";
                               }else{
                                   get_pro="";
                                   get_proml="";
                               }
                               total_medicineName=get_cis+get_dex+get_fen+get_fen_dilution+get_mid+get_mid_dilution+get_pro;
                               medicineName.setText(total_medicineName);

                               total_medicineml=get_cisml+get_dexml+get_fenml+get_fenml_dilution+get_midml+get_midml_dilution+get_proml;
                                medicineML.setText(total_medicineml);

                               get_reason1=doc.getString("reason");
                               if(!"".equals(get_reason1)){
                                   if("其他:".equals(get_reason1)){
                                       get_reason1=get_reason1+doc.getString("otherreason")+"\n";
                                   }else{
                                       get_reason1=get_reason1+"\n";
                                   }

                               }

                               total_reason=get_reason1;
                               reasonwhy.setText(total_reason);

                               get_othertool1=doc.getString("othertool1");
                               if(!"".equals(get_othertool1)){
                                   get_othertool1=get_othertool1+"\n";
                               }
                               get_othertool2=doc.getString("othertool2");
                               if(!"".equals(get_othertool2)){
                                   get_othertool2=get_othertool2+"\n";
                               }

                               get_othertool3=doc.getString("othertool3");
                               if(!"".equals(get_othertool3)){
                                   get_othertool3=get_othertool3+"\n";
                               }
                               total_othertools=get_othertool1+get_othertool2+get_othertool3;
                               othertool.setText(total_othertools);

                               get_tool1=doc.getString("tool1");
                               if(!"".equals(get_tool1)){
                                   get_tool1=get_tool1+"\n";
                               }
                               get_tool2=doc.getString("tool2");
                               if(!"".equals(get_tool2)){
                                   get_tool2=get_tool2+"\n";
                               }
                               get_tool3=doc.getString("tool3");
                               if(!"".equals(get_tool3)){
                                   get_tool3=get_tool3+"\n";
                               }
                               total_tools=get_tool1+get_tool2+get_tool3;
                               tools.setText(total_tools);
                               String get_lastdate=doc.getString("date");
                               String get_lasttime=doc.getString("time");
                               String total_lasttime=get_lastdate+"("+get_lasttime+ ')';
                               lasttime.setText(total_lasttime);

                           }
                           else{
                               Toast.makeText(third_main.this, "NO RESULT", Toast.LENGTH_SHORT).show();
                               Log.d(TAG,"NO RESULT");
                           }



                       }
                       else{
                           Log.d(TAG,"GET FAILED WITH",task.getException());
                       }
                    }
                });





        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(third_main.this,start.class);
                startActivity(it);
            }
        });
    }
}