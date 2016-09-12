package pe.edu.ulima.pokemonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PuntajeActivity extends AppCompatActivity {

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        text = (TextView) findViewById(R.id.punt);
        Bundle bun = getIntent().getExtras();

        int puntaje = bun.getInt("puntaje"); //mostrar el puntaje en el ID puntaje
        text.setText(String.valueOf(puntaje));


    }
}
