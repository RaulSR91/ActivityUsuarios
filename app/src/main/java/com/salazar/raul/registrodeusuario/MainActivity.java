package com.salazar.raul.registrodeusuario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView tvNombreCompleto;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFecha_nacimiento;

    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

        tvNombreCompleto    =   (TextView) findViewById(R.id.tvNombreCompleto) ;
        tvTelefono          =   (TextView) findViewById(R.id.tvTelefono) ;
        tvEmail             =   (TextView) findViewById(R.id.tvEmail) ;
        tvDescripcion       =   (TextView) findViewById(R.id.tvDescripcion) ;
        tvFecha_nacimiento  =   (TextView) findViewById(R.id.tvFecha_nacimiento) ;
        btnSiguiente        =   (Button)   findViewById(R.id.btnSiguiente);

        try {
            Bundle parametros   = getIntent().getExtras();
            String nombre       = parametros.getString(getResources().getString(R.string.envnombre));
            String telefono     = parametros.getString(getResources().getString(R.string.envtelefono));
            String email        = parametros.getString(getResources().getString(R.string.envemail));
            String descripcion  = parametros.getString(getResources().getString(R.string.envdescripcion));
            String Fecha_nacimiento  = parametros.getString(getResources().getString(R.string.envfechanacimiento));

            /*En caso de modificacion*/
            tvNombreCompleto.setText(nombre);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
            tvFecha_nacimiento.setText(Fecha_nacimiento);
        }
        catch (NullPointerException e){
            tvNombreCompleto.setText("");
            tvTelefono.setText("");
            tvEmail.setText("");
            tvDescripcion.setText("");
            tvFecha_nacimiento.setText("");
        }


        /*Evento click*/
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Enviardatos();
            }
        });
    }

    public void Enviardatos(){
        Intent intent  = new Intent(MainActivity.this,confirmar_datos.class);

        intent.putExtra(getResources().getString(R.string.envnombre),tvNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.envtelefono),tvTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.envemail),tvEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.envdescripcion),tvDescripcion.getText().toString());
        intent.putExtra(getResources().getString(R.string.envfechanacimiento),tvFecha_nacimiento.getText().toString());
        startActivity(intent);
        finish();

    }





}
