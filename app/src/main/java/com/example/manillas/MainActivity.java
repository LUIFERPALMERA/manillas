package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String materiales[];
        String dijes[];
        String tipos[];
        String monedas[];

        Spinner comboMateriales, comboDijes, comboTipos, comboMonedas;

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
}
