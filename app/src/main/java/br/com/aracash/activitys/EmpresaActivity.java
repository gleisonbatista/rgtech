package br.com.aracash.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.aracash.R;

public class EmpresaActivity extends AppCompatActivity {
    private ListView listaEmpresa;
    private String[] lista = {"Supermercado", "Farmacia", "Supermercado 2","Supermercado 3", "Farmacia 2", "Farmacia3", "Padaria", "Convêniencia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa);
        ListView listaEmpresas = (ListView) findViewById(R.id.listaEmpresas);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lista
        );
        listaEmpresas.setAdapter(adapter);
    }
}