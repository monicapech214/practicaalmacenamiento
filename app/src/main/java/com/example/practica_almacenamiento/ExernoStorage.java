package com.example.practica_almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExernoStorage extends AppCompatActivity {
Button guardare, leere;
TextView contenidoe;
String nombreArchivo = "",rutaSDcard="";
EditText capturae;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exerno_storage);
        guardare = (Button)findViewById(R.id.guardar);
        leere= (Button)findViewById(R.id.leere);
        capturae = (EditText) findViewById(R.id.captura);
        contenidoe = (TextView) findViewById(R.id.contenidoe);
        nombreArchivo ="archivo.txt";
        guardare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarExterno();
            }
        });
    }

    private void guardarExterno() {
        String texto = capturae.getText().toString();
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            rutaSDcard=getExternalFilesDir(null).getAbsolutePath();
        }
        else {
            Toast.makeText(getApplicationContext(),"No se puede acceder a la SD card",Toast.LENGTH_LONG).show();
        }
        File file = new File(rutaSDcard+"/"+nombreArchivo);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            if(fos!= null)
            {
                fos.write(texto.getBytes());
            }
            if(fos!= null)
            {
                fos.close();
            }
            Toast.makeText(getApplicationContext(),"TEXTO GUARDADO CON EXITO!!!",Toast.LENGTH_LONG).show();
        }catch (FileNotFoundException e)
        {
            Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }catch (IOException e)
        {
            Toast.makeText(getApplicationContext(),"Error"+e.getMessage(),Toast.LENGTH_LONG).show();
            e.printStackTrace();

        }
    }
}