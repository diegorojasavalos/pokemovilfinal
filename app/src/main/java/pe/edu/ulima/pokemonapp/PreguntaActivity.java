package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import pe.edu.ulima.pokemonapp.model.GestorPokemonApp;
import pe.edu.ulima.pokemonapp.model.Pregunta;

public class PreguntaActivity extends AppCompatActivity {

    TextView numpregunta;       //numero de la pregunta
    TextView detalle;           //detalle de la pregunta
    ImageButton nextbut;        //siguiente pregunta
    ImageButton checkbut;       //validar respuesta
    EditText respuesta;         //campo de respuesta
    ImageView imagen;           //para cambiar la imagen en caso de ser correcto
    private Pregunta mPregunta;
    List <Pregunta> preguntas  = GestorPokemonApp.getInstance().obtenerPreguntas();
    private int cadenapreguntas = 0;

    private int acumpuntu=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        nextbut=(ImageButton)findViewById(R.id.next);
        checkbut=(ImageButton)findViewById(R.id.check);
        numpregunta=(TextView)findViewById(R.id.preg);
        detalle=(TextView)findViewById(R.id.textpreg);
        imagen=(ImageView)findViewById(R.id.img);
        respuesta=(EditText)findViewById(R.id.rpta);
        numpregunta.setText("Pregunta" + preguntas.get(cadenapreguntas).getId());
        detalle.setText( preguntas.get(cadenapreguntas).getPregunta());


        Bundle bundlesito=getIntent().getExtras();

        String usuario= bundlesito.getString("nombre");


        checkbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rpta=respuesta.getText().toString();
                if(rpta.equalsIgnoreCase(preguntas.get(cadenapreguntas).getRespuesta())){
                    Toast.makeText(PreguntaActivity.this, R.string.correcto_toast, Toast.LENGTH_SHORT).show();
                    acumpuntu=acumpuntu+10;
                    imagen.setImageResource(preguntas.get(cadenapreguntas).getImagen());
                }else{
                    Toast.makeText(PreguntaActivity.this,
                            R.string.incorrecto_toast,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        nextbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadenapreguntas++;
                if(cadenapreguntas==preguntas.size()) {
                    Intent intent = new Intent(PreguntaActivity.this, PuntajeActivity.class);
                    intent.putExtra("puntaje",acumpuntu);
                    startActivity(intent);
                }else{
                    numpregunta.setText("Pregunta" + preguntas.get(cadenapreguntas).getId());
                    detalle.setText( preguntas.get(cadenapreguntas).getPregunta());
                    respuesta.setText("");
                    imagen.setImageResource(R.drawable.pokeball);
                }
            }
        });





    }
}