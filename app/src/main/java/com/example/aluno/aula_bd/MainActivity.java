package com.example.aluno.aula_bd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cadastrar;
    private final String TAG = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "carregando GUI da MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "Carregando componentes da GUI");
        cadastrar = (Button) findViewById(R.id.edCadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Chamando evento do botão cadastrar");

                Log.i(TAG, "carregando CasdratoUsuario");
                Intent intent = new Intent(MainActivity.this, CadastroUsuario.class);
                startActivity(intent);
            }
        });
    }
}
