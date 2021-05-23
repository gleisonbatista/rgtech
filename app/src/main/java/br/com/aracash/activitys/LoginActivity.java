package br.com.aracash.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.aracash.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //MÉTODO DE LINK PARA ABRIR TELA INCIAL
    public void abrirLogar(View view){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
    //MÉTODO DE LINK PARA ABRIR TELA RECUPERAR SENHA
    public void abrirRecuperarSenha(View view){
        Intent i = new Intent(getApplicationContext(), RecuperarSenhaActivity.class);
        startActivity(i);
    }
    //MÉTODO DE LINK PARA ABRIR TELA DE CADASTRO
    public void abrirCadastro(View view){
        Intent i = new Intent(getApplicationContext(), CadastrarUsuarioActivity.class);
        startActivity(i);
    }
}