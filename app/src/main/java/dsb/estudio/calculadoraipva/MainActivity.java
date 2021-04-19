package dsb.estudio.calculadoraipva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Automovel automovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        automovel = new Automovel();

        String[] lsPeso = getResources().getStringArray(R.array.lista_aliquota);

        final Spinner spin = (Spinner) findViewById(R.id.spinnerEstado);
        final EditText modelo = findViewById(R.id.editTextTextPersonName);
        final EditText valor = findViewById(R.id.editTextTextPersonName2);
        final Spinner estado = findViewById(R.id.spinnerEstado);
        Button button = findViewById(R.id.button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lsPeso);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                automovel.setModelo(modelo.getText().toString());
                automovel.setValor(valor.getText().toString());
                automovel.setEstado(estado.getSelectedItem().toString());

                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("key", automovel);
                startActivity(intent);
            }
        });
    }
}