package com.example.oneroad_7_8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;

import static android.content.ContentValues.TAG;

public class scan extends AppCompatActivity {
    SurfaceView surfaceView;
    TextView textView;
    CameraSource cameraSource;
    String nurseid;
    BarcodeDetector barcodeDetector;
    FirebaseFirestore db;
    String share_nurse_name,y_n_banned;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        getPermissionsCamera();
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        textView = (TextView) findViewById(R.id.textView);
        ref=getSharedPreferences("nurselogin",MODE_PRIVATE);
        db=FirebaseFirestore.getInstance();
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS).build();
        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(300, 300).build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector).setAutoFocusEnabled(true).build();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA)
                        !=PackageManager.PERMISSION_GRANTED)
                    return;
                try{
                    cameraSource.start(surfaceHolder);
                }catch (IOException e){
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                cameraSource.stop();
            }
        });
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>(){

            @Override
            public void release() {

            }

            @Override
            public void receiveDetections( Detector.Detections<Barcode> detections) {

                final SparseArray<Barcode> qrCodes=detections.getDetectedItems();

                if(qrCodes.size()!=0){



                    textView.post(() -> textView.setText(qrCodes.valueAt(0).displayValue));
                    nurseid=qrCodes.valueAt(0).displayValue;
                        SystemClock.sleep(100);
                        db.collection("nurselist").document(nurseid)
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
                                                    Toast.makeText(scan.this,"帳號管制中請找管理員",Toast.LENGTH_LONG).show();

                                                }else{
                                                    Log.d(TAG, "Document data:"+doc.getString("name")+y_n_banned);
                                                    share_nurse_name=doc.getString("name");
                                                    ref.edit().putString("nursename",share_nurse_name).apply();
                                                    Intent it=new Intent(scan.this,second_main.class);
                                                    startActivity(it);

                                                }

                                            }
                                            else{
                                                Toast.makeText(scan.this, "帳號錯誤", Toast.LENGTH_SHORT).show();
                                                Log.d(TAG,"NO RESULT");

                                            }
                                        }
                                        else{
                                            Log.d(TAG,"GET FAILED WITH",task.getException());
                                        }
                                    }
                                });




                }
            }
        });

    }



    private void getPermissionsCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }

    }


}