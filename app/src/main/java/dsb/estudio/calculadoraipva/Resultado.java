package dsb.estudio.calculadoraipva;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Resultado extends AppCompatActivity {

    Calculadora calculadora;
    float porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        calculadora = new Calculadora();
        Automovel automovel = getIntent().getExtras().getParcelable("key");

        if(automovel.getEstado().equals("São Paulo") || automovel.getEstado().equals("Rio de Janeiro") || automovel.getEstado().equals("Minas Gerais"))
        {
            porcentagem = (float) 4.0;
        }
        else if(automovel.getEstado().equals("Goiás"))
        {
            porcentagem = (float) 3.75;
        }
        else if(automovel.getEstado().equals("Distrito Federal") || automovel.getEstado().equals("Mato Grosso do Sul") || automovel.getEstado().equals("Paraná"))
        {
            porcentagem = (float) 3.5;
        }
        else if(automovel.getEstado().equals("Alagoas") || automovel.getEstado().equals("Amazonas") || automovel.getEstado().equals("Amapá") || automovel.getEstado().equals("Pernambuco") || automovel.getEstado().equals("Rio Grande do Norte") || automovel.getEstado().equals("Rio Grande do Sul") || automovel.getEstado().equals("Roraima"))
        {
            porcentagem = (float) 3;
        }
        else if(automovel.getEstado().equals("Bahia") || automovel.getEstado().equals("Ceará") || automovel.getEstado().equals("Maranhão") || automovel.getEstado().equals("Pará") || automovel.getEstado().equals("Paraíba") || automovel.getEstado().equals("Piauí") || automovel.getEstado().equals("Sergipe"))
        {
            porcentagem = (float) 2.5;
        }
        else
        {
            porcentagem = (float) 2.0;
        }

        float x = calculadora.CalculaPorcentagem(40000,porcentagem);

        final TextView resultado = (TextView)findViewById(R.id.resultado);
        String result = "";

        if(automovel.getValor().isEmpty())
        {
            result = "0";
        }
        else
        {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
            format.setCurrency(Currency.getInstance("BRL"));
            result = format.format(Float.parseFloat(automovel.getValor()));
        }
        String  st =  "  Modelo do carro: " + automovel.getModelo();
        st = st + "\n  Valor do carro: "+ result;
        st = st + "\n  Estado: "+ automovel.getEstado();
        st = st + "\n  Alíquota média: "+ porcentagem + "%";

        String res = "";

        if(x != 0)
        {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault());
            format.setCurrency(Currency.getInstance("BRL"));
            res = format.format(x);
        }

        st = st + "\n  Valor IPVA: " + res;
        resultado.setText(st.toUpperCase());

    }
}