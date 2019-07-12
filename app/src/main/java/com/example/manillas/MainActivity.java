package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner comboMateriales, comboDijes, comboTipos, comboMonedas;

        String monedas[];
        monedas = getResources().getStringArray(R.array.moneda);
        ArrayAdapter<String> adapterMoneda = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,monedas);
        comboMonedas = findViewById(R.id.spinnerMonedas);
        comboMonedas.setAdapter(adapterMoneda);


        ArrayList<Object> listaMaterial = new ArrayList<>();
        ArrayList<Object> listaDijes = new ArrayList<>();
        ArrayList<Object> listaTipos = new ArrayList<>();

        Tipo tipoOro = new Tipo();
        tipoOro.nombre = getString(R.string.oro);
        tipoOro.valor = 100;

        Tipo tipoPlata = new Tipo();
        tipoOro.nombre = getString(R.string.plata);
        tipoOro.valor = 50;

        listaTipos.add(tipoOro);
        listaTipos.add(tipoPlata);

        Clase dijeAncla = new Clase();
        dijeAncla.nombre = getString(R.string.ancla);
        dijeAncla.listado =  listaTipos;

        listaDijes.add(dijeAncla);

        Clase materialCuero = new Clase();
        materialCuero.nombre = getString(R.string.cuero);
        materialCuero.listado = listaDijes;
        listaMaterial.add(materialCuero);


        listaDijes.clear();
        listaTipos.clear();

        tipoOro.nombre = getString(R.string.oro);
        tipoOro.valor = 100;


        tipoOro.nombre = getString(R.string.plata);
        tipoOro.valor = 50;

        listaTipos.add(tipoOro);
        listaTipos.add(tipoPlata);


        dijeAncla.nombre = getString(R.string.ancla);
        dijeAncla.listado =  listaTipos;

        listaDijes.add(dijeAncla);


        materialCuero.nombre = getString(R.string.cuerda);
        materialCuero.listado = listaDijes;
        listaMaterial.add(materialCuero);

        ArrayAdapter<Object> adapterMateriales = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item,listaMaterial);
        comboMateriales = findViewById(R.id.spinnerMaterialManilla);
        comboMateriales.setAdapter(adapterMateriales);

        ArrayAdapter<Object> adapterDijes = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item,listaDijes);
        comboDijes = findViewById(R.id.spinnerDijes);
        comboDijes.setAdapter(adapterDijes);

        ArrayAdapter<Object> adapterTipos = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item,listaTipos);
        comboTipos = findViewById(R.id.spinnerTipos);
        comboTipos.setAdapter(adapterTipos);

    }
}
class Clase{
   String nombre;
    ArrayList<Object> listado;

    @Override
    public String toString() {
        return nombre;
    }
}
class Dije{
    String nombre;
    Tipo tipo;
    public String toString() {
        return nombre;
    }
}
class Material{
    String nombre;
    Dije dije;
    public String toString() {
        return nombre;
    }
}
class Tipo{
    String nombre;
    int valor;
    public String toString() {
        return nombre;
    }
}
