package ag.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MeuBancoDeDados extends SQLiteOpenHelper {
    private static final String DBNAME = "MeuBancoDeDados";
    private static final int VERSION = 6;

    public MeuBancoDeDados(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TB1 (name varchar(10));";
        db.execSQL(sql);//<- não altera mais o banco // executado apenas uma vez
        //Log.d("AGDebug", "Criando tabela TB1");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "alter table TB1 add flag varchar(1)";
        //String sql = "CREATE TABLE TB1 (name varchar(10));";
        db.execSQL(sql);//<- sempre que altera a versão
        Log.d("AGDebug", "Alterando a tabela TB1");
    }

}
