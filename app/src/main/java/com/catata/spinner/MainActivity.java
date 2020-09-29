package com.catata.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPlanetas = (Spinner)findViewById(R.id.spinner);

        final ArrayList<String> planetas = new ArrayList<String>();

        planetas.add("Mercurio");
        planetas.add("Venus");
        planetas.add("Tierra");

        /*
        //Crear adaptador para coger array desde un recurso, en este caso planets_array del fichero planetas.xml

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);*/

        //Creando adaptador para vincularle los datos (ArrayList planetas)
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,planetas);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPlanetas.setAdapter(adapter);


        spinnerPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //adapterView.getItemAtPosition(i);
                Log.i("ADAPTADOR", planetas.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}