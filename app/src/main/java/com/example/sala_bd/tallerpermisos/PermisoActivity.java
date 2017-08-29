package com.example.sala_bd.tallerpermisos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PermisoActivity extends AppCompatActivity {

    String valor;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permiso);

        valor = getIntent().getStringExtra("valor");
        text = (TextView) findViewById(R.id.respuesta);
        text.setText(valor);
    }
}
