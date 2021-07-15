package com.example.practica_almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button guardar, leer,externo,bases;
TextView contenido;
EditText captura;
String nombreArchivo;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        guardar = (Button)findViewById(R.id.guardar);
        bases = (Button)findViewById(R.id.bases);
        leer= (Button)findViewById(R.id.leer);
        externo = (Button)findViewById(R.id.externo);
        captura = (EditText) findViewById(R.id.captura);
        contenido = (TextView) findViewById(R.id.contenido);
        nombreArchivo ="archivo.txt";
        bases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
        externo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExernoStorage.class);
                startActivity(intent);
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String capturado = captura.getText().toString();
                if(!capturado.equals(""))
                {
                    GuardarCaptura();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error no haz capturado nada",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void GuardarCaptura() {
    }
}