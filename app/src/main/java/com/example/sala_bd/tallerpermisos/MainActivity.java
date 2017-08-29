package com.example.sala_bd.tallerpermisos;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    ImageButton contactosB;
    ImageButton contactosCamara;
    final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    final int MY_PERMISSIONS_REQUEST_CAMARA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactosB = (ImageButton) findViewById(R.id.imageButton);
        contactosB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitudPermiso();
                Toast.makeText(getApplicationContext(),"loka loka entro", Toast.LENGTH_LONG).show();
            }
        });

        contactosCamara = (ImageButton) findViewById(R.id.imageButton2);
        contactosCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitudPermisoCamara();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(getApplicationContext(),PermisoActivity.class);
                    intent.putExtra("valor","aceptado Contactos");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), PermisoActivity.class);
                    intent.putExtra("valor", "denegados Contactos");
                    startActivity(intent);
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_CAMARA: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(getApplicationContext(),PermisoActivity.class);
                    intent.putExtra("valor","aceptado CAMARA");
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(),PermisoActivity.class);
                    intent.putExtra("valor","denegados CAMARA");
                    startActivity(intent);
                }
                return;
            }
        }
    }



    private void solicitudPermiso (){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

            }
             ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_CONTACTS},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);


        }
    }

    private void solicitudPermisoCamara (){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            if
                    (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
            }
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMARA);


        }
    }


}
