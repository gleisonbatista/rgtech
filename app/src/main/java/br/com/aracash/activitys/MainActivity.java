package br.com.aracash.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.aracash.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //MÉTODO DE LINK PARA ABRIR TELA DE CADASTRO
    public void abrirEmpresa(View view){
        Intent i = new Intent(getApplicationContext(), EmpresaActivity.class);
        startActivity(i);
    }
    //MÉTODO DE LINK PARA ABRIR TELA DE CADASTRO
    public void abrirPagamento(View view){
        Intent i = new Intent(getApplicationContext(), PagamentoActivity.class);
        startActivity(i);
    }
}