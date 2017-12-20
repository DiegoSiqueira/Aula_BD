package com.example.aluno.aula_bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;


public class Bd_Usuario extends SQLiteOpenHelper {
    private static final String Banco_Dados = "usuario";
    private static final int Versao = 1;
    private static final String TAG = "usuario";

    public Bd_Usuario(Context context) {
        super(context, Banco_Dados, null, Versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "criando tabela do banco de dados");
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS usuario (_id integer primary key AutoIncrement, " +
                    "nome varchar(50), email varchar(30), senha varchar(30))");


            Log.i(TAG, "Tabelas criadas com sucesso");

        } catch (SQLException e) {
            Log.e(TAG, "falha durante a criação das tabelas: " + e);
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versao_antiga, int versao_nova) {

    }

    public boolean salvarUsuario(String nome, String email, String senha, Bd_Usuario usuario) {
        SQLiteDatabase banco = usuario.getWritableDatabase();

        ContentValues valore = new ContentValues();
        valore.put("nome", nome);
        valore.put("email", email);
        valore.put("senha", senha);
        try {
            long resultado = banco.insert("usuario", null, valore);

            if (resultado==-1) {
                Log.i(TAG, "Ocoreu um erro durante a inserção dos dados" );
                return false;
            } else {
                Log.i(TAG, "Dados inseridos com sucesso no banco de dados");
                return true;
            }
        } catch (SQLException e) {
            Log.e(TAG, e.toString());
            return false;

        }
    }
}
