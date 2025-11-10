package github.devatomicfull.agenda_contatos.data.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;

import github.devatomicfull.agenda_contatos.data.model.Contato;

public class ContatoDao extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String AGENDA_DB = "agenda_db";

    public ContatoDao(@Nullable Context context) {
     super(context, AGENDA_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        StringBuilder sb_sql = new StringBuilder();
        sb_sql.append("CREATE TABLE contato (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT, " +
                "email TEXT, " +
                "telefone TEXT, " +
                "imagem TEXT, " +
                "excluido INT DEFAULT 0);");
        bd.execSQL(sb_sql.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Contato> contatoBuscaArrayList() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Contato> contatoArrayList = new ArrayList<>();

        String sql = "SELECT * FROM contato WHERE excluido = 0"; // opcional: só contatos ativos
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Contato c = new Contato();
                c.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                c.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
                c.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                c.setTelefone(cursor.getString(cursor.getColumnIndexOrThrow("telefone")));
                c.setImagem(cursor.getString(cursor.getColumnIndexOrThrow("imagem")));
                c.setExcluido(cursor.getInt(cursor.getColumnIndexOrThrow("excluido")));

                contatoArrayList.add(c);
            } while (cursor.moveToNext());
        }

        if (cursor != null) cursor.close();
        db.close();

        return contatoArrayList;
    }

}
