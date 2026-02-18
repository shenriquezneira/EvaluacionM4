package com.example.cursopm_p1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // referencia de los Elementos visuales
    private EditText etNombre;
    private EditText etApellido;
    private Button btnSaludar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initViews();
        initListerners();

    }


    // MEtodo conecta vistas con Java

    private void initViews() {


        etNombre = findViewById(R.id.edit_nom);
        etApellido = findViewById(R.id.edit_ape);
        btnSaludar = findViewById(R.id.btn);

    }

    private void mostrarSaludo() {

        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        if (!nombre.isEmpty() && !apellido.isEmpty()) {
            String mensaje = "Hola " + nombre + " " + apellido + ",¡bienvenido al bootcamp !";
            Toast.makeText(MainActivity.this, mensaje,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Por favor, completa ambos campos", Toast.LENGTH_SHORT).show();
        }
    }

    ;


    private void initListerners() {
        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarSaludo();
            }
        });
    }

}