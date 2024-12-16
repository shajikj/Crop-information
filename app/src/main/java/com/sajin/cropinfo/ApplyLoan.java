package com.sajin.cropinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ApplyLoan extends AppCompatActivity {
    Button fullSideView, takePhoto;
    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private static final int SELECT_PICTURE = 200;
    ImageView imagephoto,proView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_loan);
        getSupportActionBar().setTitle("Apply Loan");

        fullSideView = findViewById(R.id.camera);
        takePhoto = findViewById(R.id.landimagecamerafull);
        imagephoto= findViewById(R.id.imagephoto);
        proView= findViewById(R.id.imagephotolandfull);
        final Context context = this;
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                takeNormalPhotopro();
            }
        });

        fullSideView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeNormalPhoto();
            }
        });


    }
    public void FullView() {


    }

    private void takeNormalPhoto() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            }
            else
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        }
    }

    private void takeNormalPhotopro() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
            }
            else
            {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,SELECT_PICTURE);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE)
        {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
            else
            {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_REQUEST) {
                try {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    File outputdir = getApplicationContext().getCacheDir();
                    if (!outputdir.exists()) {
                        outputdir.mkdirs();
                    }
                    OutputStream outStream = null;
                    //  File file = new File(Environment.getExternalStorageDirectory() + "/inpaint/"+"seconds"+".png");
                    File outputfile = File.createTempFile("temp", ".jpg", outputdir);
                    outStream = new FileOutputStream(outputfile);
                    photo.compress(Bitmap.CompressFormat.PNG, 85, outStream);
                    outStream.close();
                    // Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                    imagephoto.setImageURI(Uri.fromFile(outputfile));


                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                try {
                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap photo = (Bitmap) data.getExtras().get("data");
                        File outputdir = getApplicationContext().getCacheDir();
                        if (!outputdir.exists()) {
                            outputdir.mkdirs();
                        }
                        OutputStream outStream = null;
                        //  File file = new File(Environment.getExternalStorageDirectory() + "/inpaint/"+"seconds"+".png");
                        File outputfile = File.createTempFile("temp", ".jpg", outputdir);
                        outStream = new FileOutputStream(outputfile);
                        photo.compress(Bitmap.CompressFormat.PNG, 85, outStream);
                        outStream.close();
                        // Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                        proView.setImageURI(Uri.fromFile(outputfile));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{

        }
    }
}