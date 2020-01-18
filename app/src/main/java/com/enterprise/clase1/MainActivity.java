package com.enterprise.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Spinner seccion, areas;
    private EditText tema;
    private Button registrar;

    private DatabaseReference basededatosclase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basededatosclase = FirebaseDatabase.getInstance().getReference("Clase");

        seccion = (Spinner)findViewById(R.id.spinsecciones);
        areas = (Spinner)findViewById(R.id.spinareas);
        tema = (EditText)findViewById(R.id.txttema);
        registrar = (Button)findViewById(R.id.btnregistrar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarClase();
            }
        });

    }


    private void guardarClase(){

        String sec = seccion.getSelectedItem().toString();
        String area = areas.getSelectedItem().toString();
        String tem = tema.getText().toString();

        if(!TextUtils.isEmpty(tem)){
            String id = basededatosclase.push().getKey();

            Clase clase = new Clase(id, sec, area, tem);

            basededatosclase.child("Lecciones").child(id).setValue(clase);

            Toast.makeText(this, "Registro guardado", Toast.LENGTH_LONG).show();

            tema.setText("");

        }else{
            Toast.makeText(this, "Debes de indicar un tema", Toast.LENGTH_LONG).show();

        }

    }




}
