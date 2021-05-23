package br.com.aracash.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.aracash.R;

public class RecuperarSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);
    }
    public void alertaPagamento(View view){
        alertaCampos("As informações de recuperação de senha foram enviadas para seu e-mail de cadastro");

    }
    public void alertaCampos(String mensagem) {
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Atenção!");
        msg.setIcon(R.drawable.logo_menor);
        msg.setMessage(mensagem);
        msg.setCancelable(false);
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        msg.show();
    }
}