package com.example.oneroad_7_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

import static android.content.ContentValues.TAG;

public class table extends AppCompatActivity {
    ImageView a4,a3,a2,a1,b4,b3,b2,b1,c4,c3,c2,c1,d4,d3,d2,d1,e4,e3,e2,e1,f4,f3,f2,f1,g4,g3,g2,g1;
    SharedPreferences ref,ref2;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ref=getSharedPreferences("get_score",MODE_PRIVATE);
        ref2=getSharedPreferences("patientlogin",MODE_PRIVATE);
        db=FirebaseFirestore.getInstance();

        int test1_1= ref.getInt("score1",0);
        int road=ref.getInt("score2",0);
        int test2= ref.getInt("score3",0);
        int test3= ref.getInt("score4",0);
        int test4= ref.getInt("score5",0);
        int test5= ref.getInt("score6",0);
        int test6= ref.getInt("score7",0);
        String patientnum=ref2.getString("patientnum","");

        setContentView(R.layout.activity_table);

        a4=findViewById(R.id.a4);
        a3=findViewById(R.id.a3);
        a2=findViewById(R.id.a2);
        a1=findViewById(R.id.a1);

        b4=findViewById(R.id.b4);
        b3=findViewById(R.id.b3);
        b2=findViewById(R.id.b2);
        b1=findViewById(R.id.b1);

        c4=findViewById(R.id.c4);
        c3=findViewById(R.id.c3);
        c2=findViewById(R.id.c2);
        c1=findViewById(R.id.c1);

        d4=findViewById(R.id.d4);
        d3=findViewById(R.id.d3);
        d2=findViewById(R.id.d2);
        d1=findViewById(R.id.d1);

        e4=findViewById(R.id.e4);
        e3=findViewById(R.id.e3);
        e2=findViewById(R.id.e2);
        e1=findViewById(R.id.e1);

        f4=findViewById(R.id.f4);
        f3=findViewById(R.id.f3);
        f2=findViewById(R.id.f2);
        f1=findViewById(R.id.f1);

        g4=findViewById(R.id.g4);
        g3=findViewById(R.id.g3);
        g2=findViewById(R.id.g2);
        g1=findViewById(R.id.g1);

        if(test1_1==0 && road==0 && test2==0 && test3==0 && test4==0 && test5==0 && test6 ==0){
            db.collection("patientlist").document(patientnum).get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            DocumentSnapshot doc=task.getResult();
                             Long test1_1=doc.getLong("test1_1");
                            Long  road=doc.getLong("road");
                            Long  test2=doc.getLong("test2");
                            Long  test3=doc.getLong("test3");
                            Long  test4=doc.getLong("test4");
                            Long  test5=doc.getLong("test5");
                            Long  test6=doc.getLong("test6");

                            Log.d(TAG, "Cached document data: " +test1_1);
                            Log.d(TAG, "Cached document data1: " +road);
                            Log.d(TAG, "Cached document data2: " +test2);
                            Log.d(TAG, "Cached document data3: " +test3);
                            Log.d(TAG, "Cached document data4: " +test4);
                            Log.d(TAG, "Cached document data5: " +test5);
                            Log.d(TAG, "Cached document data6: " +test6);
                            if(test1_1==1){
                                a1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test1_1==2){
                                a2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test1_1==3){
                                a3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test1_1==4){
                                a4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if (road == 1) {
                                b1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if (road == 2) {
                                b2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if (road == 3) {
                                b3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test2 == 1){
                                c1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test2 == 2){
                                c2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test2 == 3){
                                c3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test3 ==1){
                                d1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test3 ==2){
                                d2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test3 ==3){
                                d3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test4==1){
                                e1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test4==2){
                                e2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test4==4){
                                e4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test5==2){
                                f2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test5==3){
                                f3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test6==1){
                                g1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test6==2){
                                g2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test6==3){
                                g3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }
                            if(test6==4){
                                g4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
                            }

                        }
                    });
        }

        if(test1_1==1){
            a1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test1_1==2){
            a2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test1_1==3){
            a3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test1_1==4){
            a4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if (road == 1) {
            b1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if (road == 2) {
            b2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if (road == 3) {
            b3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test2 == 1){
            c1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test2 == 2){
            c2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test2 == 3){
            c3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test3 ==1){
            d1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test3 ==2){
            d2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test3 ==3){
            d3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test4==1){
            e1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test4==2){
            e2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test4==4){
            e4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test5==2){
            f2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test5==3){
            f3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test6==1){
            g1.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test6==2){
            g2.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test6==3){
            g3.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }
        if(test6==4){
            g4.setImageDrawable(getResources().getDrawable(R.drawable.circle));
        }






    }
}