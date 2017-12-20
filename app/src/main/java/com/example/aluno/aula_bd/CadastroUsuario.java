package com.example.aluno.aula_bd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroUsuario extends AppCompatActivity {
    Button CD;
    EditText US, Email, SN, REPSenha;
    Bd_Usuario usuario;


    private final String TAG = "usuario";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "carregando GUI do cadastroUsuario");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        Log.i(TAG, "carregando componentes da GUI");

        CD = (Button) findViewById(R.id.btcada);
        US = (EditText) findViewById(R.id.edUsuario);
        Email = (EditText) findViewById(R.id.edEmail);
        SN = (EditText) findViewById(R.id.edSenha);
        REPSenha = (EditText) findViewById(R.id.edRSenha);

        usuario = new Bd_Usuario(this);

        CD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "chamando evento do btcadastro");

                Log.i(TAG, "colentando dados informados pelo usuario");
                String usuario2 = US.getText().toString();
                String email = Email.getText().toString();
                String senha = SN.getText().toString();
                String senha2 = REPSenha.getText().toString();

                Log.i(TAG, "Confirmando Senha");
                if (senha.equals(senha2)){


                   boolean resultado_gravacao =  usuario.salvarUsuario(usuario2, email, senha,usuario);
                    if (resultado_gravacao == true){
                        mensagem("Cadastro Realizado com Sucesso!");
                    }else {
                        mensagem("Cadastro não realizado, ocorreu um erro em um dos dados verifiquios!");
                    }


                }else {
                    mensagem("Senhas incompativeis!");
                }

            }
        });
    }
    public void mensagem(String msg){
        Toast.makeText(CadastroUsuario.this, msg, Toast.LENGTH_LONG).show();
    }
}
