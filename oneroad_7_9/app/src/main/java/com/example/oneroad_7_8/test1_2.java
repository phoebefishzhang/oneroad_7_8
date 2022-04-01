package com.example.oneroad_7_8;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class test1_2 extends AppCompatActivity implements View.OnClickListener {

    int total3=0,sum12,new_sum12=0;
    CheckBox CB_1,CB_2,CB_3,CB_4,CB_5,CB_6,CB_7,CB_8,CB_9,CB_none,CB_other1,CB_other2;
    EditText other_road1Name,other_road2Name;
    SharedPreferences ref,ref2;
    private int CountCheckbox,specialCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_test12);
        super.onCreate(savedInstanceState);
        CB_1=findViewById(R.id.CB_1);
        CB_2=findViewById(R.id.CB_2);
        CB_3=findViewById(R.id.CB_3);
        CB_4=findViewById(R.id.CB_4);
        CB_5=findViewById(R.id.CB_5);
        CB_6=findViewById(R.id.CB_6);
        CB_7=findViewById(R.id.CB_7);
        CB_8=findViewById(R.id.CB_8);
        CB_9=findViewById(R.id.CB_9);
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
                specialCount=0;
                String text="";
                if(CB_1.isChecked()){
                    CountCheckbox+=10;
                    specialCount+=1;
                    ref.edit().putString("CB_1",CB_1.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_1","none").apply();
                }
                if(CB_2.isChecked()){
                    CountCheckbox+=10;
                    specialCount+=1;
                    ref.edit().putString("CB_2",CB_2.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_2","none").apply();
                }
                if(CB_3.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_3",CB_3.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_3","none").apply();
                }
                if(CB_4 .isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_4",CB_4.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_4","none").apply();
                }
                if(CB_5.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_5",CB_5.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_5","none").apply();
                }
                if(CB_6.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_6",CB_6.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_6","none").apply();
                }
                if(CB_7.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_7",CB_7.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_7","none").apply();
                }
                if(CB_8.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_8",CB_8.getText().toString()).apply();
                }
                else{

                    ref.edit().putString("CB_8","none").apply();
                }
                if(CB_9.isChecked()){
                    CountCheckbox+=10;
                    ref.edit().putString("CB_9",CB_9.getText().toString()).apply();
                }
                else{
                    ref.edit().putString("CB_9","none").apply();
                }
                if(CB_other1.isChecked()){
                    if(other_road1Name.getText().toString().matches("")){
                        Toast.makeText(test1_2.this,"請輸入管路名稱1",Toast.LENGTH_LONG).show();
                        break;
                    }else{
                        CountCheckbox+=10;
                        ref.edit().putString("other_road1Name",other_road1Name.getText().toString()).apply();
                    }

                }else{
                    ref.edit().putString("other_road1Name","none").apply();
                }
                if(CB_other2.isChecked()){
                    if(other_road2Name.getText().toString().matches("")){
                        Toast.makeText(test1_2.this,"請輸入管路名稱2",Toast.LENGTH_LONG).show();
                        break;
                    }else{
                        CountCheckbox+=10;
                        ref.edit().putString("other_road2Name",other_road2Name.getText().toString()).apply();
                    }

                }else{
                    ref.edit().putString("other_road2Name","none").apply();
                }
                if(CountCheckbox>=30){
                    text="red";
                    new_sum12=sum12+3;
                }
                else if(CountCheckbox<30 && specialCount>=1){
                    text="yellow";
                    new_sum12=sum12+2;
                }
                else if(CountCheckbox<30 && specialCount<1){
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
            case R.id.CB_1:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_1","unchecked");
                break;
            case R.id.CB_2:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_2","unchecked");
                break;
            case R.id.CB_3:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_3","unchecked");
                break;
            case R.id.CB_4:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_4","unchecked");
                break;
            case R.id.CB_5:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_5","unchecked");
                break;
            case R.id.CB_6:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_6","unchecked");
                break;
            case R.id.CB_7:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_7","unchecked");
                break;
            case R.id.CB_8:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_8","unchecked");
                break;
            case R.id.CB_9:
                if(checked)
                    CB_none.setChecked(false);
                else
                    Log.d("CB_9","unchecked");
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
                    CB_1.setChecked(false);
                CB_2.setChecked(false);
                CB_3.setChecked(false);
                CB_4.setChecked(false);
                CB_5.setChecked(false);
                CB_6.setChecked(false);
                CB_7.setChecked(false);
                CB_8.setChecked(false);
                CB_9.setChecked(false);
                CB_other1.setChecked(false);
                CB_other2.setChecked(false);
                break;


        }
    }
}