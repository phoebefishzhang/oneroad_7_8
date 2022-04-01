package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class road extends AppCompatActivity implements View.OnClickListener {
int total3=0,sum12,new_sum12=0;
CheckBox CB_ENDO,CB_CPV,CB_Doublelumen,CB_Asheath,CB_Vsheath,CB_NG,CB_IABP,CB_CVVH,CB_none,CB_other1,CB_other2;
EditText other_road1Name,other_road2Name;
SharedPreferences ref,ref2;
    private int CountCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
        CB_ENDO=findViewById(R.id.CB_ENDO);
        CB_CPV=findViewById(R.id.CB_CPV);
        CB_Doublelumen=findViewById(R.id.CB_Doublelumen);
        CB_Asheath=findViewById(R.id.CB_Asheath);
        CB_Vsheath=findViewById(R.id.CB_Vsheath);
        CB_NG=findViewById(R.id.CB_NG);
        CB_IABP=findViewById(R.id.CB_IABP);
        CB_CVVH=findViewById(R.id.CB_CVVH);
        CB_none=findViewById(R.id.CB_none);
        CB_other1=findViewById(R.id.CB_other1);
        CB_other2=findViewById(R.id.CB_other2);
        other_road1Name=findViewById(R.id.other_road1Name);
        other_road2Name=findViewById(R.id.other_road2Name);
        ref=getSharedPreferences("roadused",MODE_PRIVATE);
        ref2=getSharedPreferences("get_score",MODE_PRIVATE);
        sum12=getIntent().getIntExtra("sense",0);
        Log.d("sum12", "sum12=" + sum12);
        total3 = getIntent().getIntExtra("total3", 0);
        Log.d("sum","total3=" + total3);
        CB_none.setChecked(true);
        CB_other1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    other_road1Name.setVisibility(View.VISIBLE);
                }else{
                    other_road1Name.setVisibility(View.INVISIBLE);
                }
            }
        });

        CB_other2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    other_road2Name.setVisibility(View.VISIBLE);
                }else{
                    other_road2Name.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent();
        switch (v.getId()) {

            case R.id.next:
                CountCheckbox=0;
                String text="";
                if(CB_ENDO.isChecked()){
                    CountCheckbox+=1;
                    ref.edit().putString("ENDO",CB_ENDO.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("ENDO","none").apply();
                }
                if(CB_CPV.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CPV",CB_CPV.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CPV","none").apply();
                }
                if(CB_Doublelumen.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("Doublelumen",CB_Doublelumen.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("Doublelumen","none").apply();
                }
                if(CB_Asheath.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("Asheath",CB_Asheath.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("Asheath","none").apply();
                }
                if(CB_Vsheath.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("Vsheath",CB_Vsheath.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("Vsheath","none").apply();
                }
                if(CB_NG.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("NG",CB_NG.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("NG","none").apply();
                }
                if(CB_IABP.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("IABP",CB_IABP.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("IABP","none").apply();
                }
                if(CB_CVVH.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CVVH",CB_CVVH.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CVVH","none").apply();
                }
                if(CB_other1.isChecked()){
                    if(other_road1Name.getText().toString().matches("")){
                        Toast.makeText(road.this,"請輸入管路名稱",Toast.LENGTH_LONG).show();
                    }else{
                        CountCheckbox+=10;
                        ref.edit().putString("other_road1Name",other_road1Name.getText().toString()).apply();
                    }

                }else{
                    ref.edit().putString("other_road1Name","none").apply();
                }
                if(CB_other2.isChecked()){
                    if(other_road2Name.getText().toString().matches("")){
                        Toast.makeText(road.this,"請輸入管路名稱",Toast.LENGTH_LONG).show();
                    }else{
                        CountCheckbox+=10;
                        ref.edit().putString("other_road2Name",other_road2Name.getText().toString()).apply();
                    }

                }else{
                    ref.edit().putString("other_road2Name","none").apply();
                }
                if(CountCheckbox>20){
                     text="red";
                     new_sum12=sum12+3;
                }
                else if(CountCheckbox>=10 && CountCheckbox<=21){
                     text="yellow";
                     new_sum12=sum12+2;
                }
                else if(CountCheckbox<10){
                    text="green";
                    new_sum12=sum12+1;
                }
                Log.d(TAG,"count="+text);
                int result_score=new_sum12-sum12;
                ref2.edit().putInt("score2",result_score).apply();
                it = new Intent(this, test2.class);
                it.putExtra("road",new_sum12);

                startActivity(it);
                break;
        }


    }

    public void onCheckVoxClicked(View view) {
        boolean checked=((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.CB_ENDO:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_ENDO","unchecked");
                break;
            case R.id.CB_CPV:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_CPV","unchecked");
                break;
            case R.id.CB_Doublelumen:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_Doublelumen","unchecked");
                break;
            case R.id.CB_Asheath:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_Asheath","unchecked");
                break;
            case R.id.CB_Vsheath:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_Vsheath","unchecked");
                break;
            case R.id.CB_NG:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("NG","unchecked");
                break;
            case R.id.CB_IABP:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_IABP","unchecked");
                break;
            case R.id.CB_CVVH:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_CVVH","unchecked");
                break;

            case R.id.CB_other1:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("other1","unchecked");
                break;
            case R.id.CB_other2:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("other2","unchecked");
                break;


            case R.id.CB_none:
                if(checked)
                    CB_ENDO.setChecked(false);
                    CB_CPV.setChecked(false);
                    CB_Doublelumen.setChecked(false);
                    CB_Asheath.setChecked(false);
                    CB_Vsheath.setChecked(false);
                    CB_NG.setChecked(false);
                    CB_IABP.setChecked(false);
                    CB_CVVH.setChecked(false);
                    CB_other1.setChecked(false);
                    CB_other2.setChecked(false);
                break;


        }
    }
}