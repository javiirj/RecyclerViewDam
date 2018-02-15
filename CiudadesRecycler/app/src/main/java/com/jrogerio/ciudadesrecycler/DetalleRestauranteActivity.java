package com.jrogerio.ciudadesrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetalleRestauranteActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_restaurante);

        textView = findViewById(R.id.nombre_restaurante);

        // Obtenemos del Intent que ha lanzado este Activity
        // los parámetros que vienen a través del putExtra();
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");

        textView.setText(nombre);
    }
}
