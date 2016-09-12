package pe.edu.ulima.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText ete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ete = (EditText) findViewById(R.id.etehint);
        Button but = (Button) findViewById(R.id.but);
        but.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent =new Intent(LoginActivity.this, PreguntaActivity.class);
        intent.putExtra("usuario", ete.getText().toString());
        Toast.makeText(LoginActivity.this, R.string.INGRESAR, Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }




}
