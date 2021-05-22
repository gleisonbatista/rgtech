package br.com.aravisa20.classes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

import br.com.aravisa20.R;

public class Util {
    public static String getUrl(){
        return "http://gleisonbatista.com.br:8091/scriptcase/app/Hackaton/";
    }
    public static boolean isCPF(String CPF) {
        CPF = CPF.replace(".","").replace("-","").trim();
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") || CPF.equals("33333333333") ||
                CPF.equals("44444444444") || CPF.equals("55555555555") ||
                CPF.equals("66666666666") || CPF.equals("77777777777") ||
                CPF.equals("88888888888") || CPF.equals("99999999999") ||
                (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = (int)(CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }
    //Imprimir CPF
    public static String imprimeCPF(String CPF) {
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
                CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    //Validar Data
    public static boolean validaData(String data) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(data);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    public static void mascaraCPF(EditText campoCpf){
        //ADICIONAR MASCARA DE CPF AO CAMPO CPF
        SimpleMaskFormatter maskCpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwCpf = new MaskTextWatcher(campoCpf, maskCpf);
        campoCpf.addTextChangedListener(mtwCpf);
    }

    public static void mascaraFone(EditText campoFone){
        SimpleMaskFormatter maskTelefone = new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtwTelefone = new MaskTextWatcher(campoFone, maskTelefone);
        campoFone.addTextChangedListener(mtwTelefone);
    }

    public static void mascaraData(EditText campoData){
        SimpleMaskFormatter maskData = new SimpleMaskFormatter("NN/NN/NNNN");
        MaskTextWatcher mtwData = new MaskTextWatcher(campoData, maskData);
        campoData.addTextChangedListener(mtwData);
    }
    public static void alertaCampos(String mensagem){
        //AlertDialog.Builder msg = new AlertDialog.Builder(this);
        AlertDialog.Builder msg = new AlertDialog.Builder(null);
        msg.setTitle("Atenção!");
        msg.setIcon(R.drawable.ic_menu_manage);
        msg.setMessage(mensagem);
        msg.setCancelable(false);
        msg.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        msg.show();
    }
}
