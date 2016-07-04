package com.salazar.raul.registrodeusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmar_datos extends AppCompatActivity {
    private TextView tvMnombre_completo;
    private TextView tvMfecha_naciemiento;
    private TextView tvMtelefono;
    private TextView tvMemail;
    private TextView tvMdescripcion;
    private Button btnEditar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        /*Castear variables*/
        btnEditar               = (Button)   findViewById(R.id.btnEditar);
        tvMnombre_completo      = (TextView) findViewById(R.id.tvMnombre_completo);
        tvMtelefono             = (TextView) findViewById(R.id.tvMtelefono);
        tvMemail                = (TextView) findViewById(R.id.tvMemail);
        tvMdescripcion          = (TextView) findViewById(R.id.tvMdescripcion);
        tvMfecha_naciemiento    = (TextView) findViewById(R.id.tvMfecha_naciemiento);

        Bundle parametros   = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.envnombre));
        String telefono     = parametros.getString(getResources().getString(R.string.envtelefono));
        String email        = parametros.getString(getResources().getString(R.string.envemail));
        String descripcion  = parametros.getString(getResources().getString(R.string.envdescripcion));
        String fecha        = parametros.getString(getResources().getString(R.string.envfechanacimiento));




        tvMnombre_completo.setText(nombre);
        tvMtelefono.setText(telefono);
        tvMemail.setText(email);
        tvMdescripcion.setText(descripcion);
        tvMfecha_naciemiento.setText(fecha);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditarCampos();
            }
        });


    }

    public void EditarCampos(){
        Intent intent  = new Intent(confirmar_datos.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.envnombre),tvMnombre_completo.getText().toString());
        intent.putExtra(getResources().getString(R.string.envtelefono),tvMtelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.envemail),tvMemail.getText().toString());
        intent.putExtra(getResources().getString(R.string.envdescripcion),tvMdescripcion.getText().toString());
        intent.putExtra(getResources().getString(R.string.envfechanacimiento),tvMfecha_naciemiento.getText().toString());
        startActivity(intent);
    }


    public boolean onKeyDown(int keyCode, KeyEvent event){

        if(keyCode == KeyEvent.KEYCODE_BACK ){
            Intent intent = new Intent(confirmar_datos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode,event);
    }

}
