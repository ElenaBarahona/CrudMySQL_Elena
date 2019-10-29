package com.eg.crudmysql_elen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Main2Activity extends AppCompatActivity {
    private Button btnGuardar, btnConsultar1, btnConsultar2, btnEliminar, btnActualizar;
    private EditText et_codigo, et_description, et_precio;
    boolean estadoCodigo = false;
    boolean estadoDescripcion = false;
    boolean estadoPrecio = false;
    int estadoInsert=0;


    MantenimientoMySQL manto = new MantenimientoMySQL();
   boolean estadoGuarda = false;
    boolean estadoEliminar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnConsultar1 = (Button) findViewById(R.id.btnConsultar1);
        btnConsultar2 = (Button) findViewById(R.id.btnConsultar2);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnActualizar = (Button) findViewById(R.id.btnEditar);

        et_codigo = (EditText) findViewById(R.id.et_codigo);
        et_description = (EditText) findViewById(R.id.et_descripcion);
        et_precio = (EditText) findViewById(R.id.et_precio);



        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_codigo.getText().toString().length() == 0) {
                    estadoCodigo = false;
                    et_codigo.setError("Campo obligatorio");
                } else {
                    estadoCodigo = true;
                }
                if (et_description.getText().toString().length() == 0) {
                    estadoDescripcion = false;
                    et_description.setError("Campo obligatorio");
                } else {
                    estadoDescripcion = true;
                }
                if (et_precio.getText().toString().length() == 0) {
                    estadoPrecio = false;
                    et_precio.setError("Campo obligatorio");
                } else {
                    estadoPrecio = true;
                }
                if (estadoCodigo && estadoDescripcion && estadoPrecio) {
                    //Toast.makeText(this, "Estamos bien", Toast.LENGTH_SHORT).show();


                }if (estadoCodigo && estadoDescripcion && estadoPrecio){
                    String codigo = et_codigo.getText().toString();
                    String descripcion = et_description.getText().toString();
                    String precio = et_precio.getText().toString();
                    estadoGuarda = manto.guardar1(Main2Activity.this, codigo, descripcion, precio);
                    if(estadoGuarda){
                        Toast.makeText(Main2Activity.this, "Registro Almacenado Correctamente.", Toast.LENGTH_SHORT).show();
                        limpiarDatos();
                    }
                }

            }





    public void limpiarDatos(){
        et_codigo.setText(null);
        et_description.setText(null);
        et_precio.setText(null);
        et_codigo.requestFocus();
    }






}
