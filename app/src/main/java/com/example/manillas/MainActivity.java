package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String materiales[];
    String dijes[];
    String tipos[];
    String monedas[];

    TextView resultado;
    EditText cantidad;

    Spinner comboMateriales, comboDijes, comboTipos, comboMonedas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Captura de los objetos utilizados
        cantidad = findViewById(R.id.textCantidad);
        resultado = findViewById(R.id.textResultado);

        // Traemos información de los arrays
        materiales = getResources().getStringArray(R.array.materiales);
        dijes = getResources().getStringArray(R.array.dijes);
        tipos = getResources().getStringArray(R.array.tipos);
        monedas = getResources().getStringArray(R.array.monedas);

        //Creamos el adapter indicando donde se va a colocar
        // Como se va a visualizar y que se va a mostrar
        ArrayAdapter<String> adapterMateriales = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,materiales);
        ArrayAdapter<String> adapterDijes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,dijes);
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipos);
        ArrayAdapter<String> adapterMonedas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,monedas);

        //Pasamos el adapter al combo
        comboMateriales = findViewById(R.id.spinnerMateriales);
        comboMateriales.setAdapter(adapterMateriales);

        comboDijes = findViewById(R.id.spinnerDijes);
        comboDijes.setAdapter(adapterDijes);

        comboTipos = findViewById(R.id.spinnerTipos);
        comboTipos.setAdapter(adapterTipos);

        comboMonedas = findViewById(R.id.spinnerMonedas);
        comboMonedas.setAdapter(adapterMonedas);
    }

    public void calcular(View v){

        int DOLAR = 3200,valorManilla, valor=0, cant, opcMaterial, opcDije, opcTipo, opcMoneda;

        if(validar()){
            cant = Integer.parseInt(cantidad.getText().toString());
            opcMaterial = comboMateriales.getSelectedItemPosition();
            opcDije = comboDijes.getSelectedItemPosition();
            opcTipo = comboTipos.getSelectedItemPosition();
            opcMoneda = comboMonedas.getSelectedItemPosition();

            if((opcMaterial == 0 && opcDije == 0 && (opcTipo == 0 || opcTipo == 1))
                    || (opcMaterial == 0 && opcDije == 1 && opcTipo == 2)
            ){
                valor = 100;
            }else if((opcMaterial == 0 && opcDije == 0 && opcTipo == 2)
                    || (opcMaterial == 1 && opcDije == 1 && opcTipo == 3)
            ){
                valor = 80;
            }else if((opcMaterial == 0 && opcDije == 0 && opcTipo == 3)
                    || (opcMaterial == 1 && opcDije == 0 && opcTipo == 2)
            ){
                valor = 70;
            }else if(opcMaterial == 0 && opcDije == 1 && (opcTipo == 0 || opcTipo == 1)){
                valor = 120;
            }else if((opcMaterial == 0 && opcDije == 1 && opcTipo == 3)
                    || (opcMaterial == 1 && opcDije == 0 && (opcTipo == 0 || opcTipo == 1))
                    || (opcMaterial == 1 && opcDije == 1 && opcTipo == 2)
            ){
                valor = 90;
            }else if(opcMaterial == 1 && opcDije == 1 && (opcTipo == 0 || opcTipo == 1)){
                valor = 110;
            }else{
                valor = 50;
            }

            valorManilla = opcMoneda == 0 ? (valor*DOLAR*cant) : (valor*cant);
            //debug
            //Log.d("Prueba", "Valor del resultado" + res);
            resultado.setText(getResources().getString(R.string.resultado_manillas)+" "+valorManilla+" "+comboMonedas.getSelectedItem().toString());
        }


    }

    public boolean validar(){
        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(getResources().getString(R.string.error_vacio));
            cantidad.requestFocus();
            return false;
        }
        int cant = Integer.parseInt(cantidad.getText().toString());
        if(cant <= 0){
            cantidad.setError(getResources().getString(R.string.error_negativo));
            cantidad.requestFocus();
            return false;
        }

        return true;
    }

    public void borrar(View v){
        cantidad.setText("");
        cantidad.setError(null);
        comboMateriales.setSelection(0);
        comboDijes.setSelection(0);
        comboTipos.setSelection(0);
        comboMonedas.setSelection(0);
        cantidad.requestFocus();
        resultado.setText("");
    }


}
