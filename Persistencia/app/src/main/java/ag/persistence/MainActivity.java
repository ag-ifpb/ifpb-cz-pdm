package ag.persistence;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private void saveCache(){
        String content = "Olá mundo" ;
        //Arquivo do arquivo;
        File file;
        FileOutputStream outputStream;
        try  {
            file = new File(getCacheDir(), "MyCache" );
            outputStream = new FileOutputStream (file);
            outputStream.write(content.getBytes());
            outputStream.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private void saveExternal(){
        //disponibilidade e possibilidade de escrita
        boolean mExternalStorageAvailable = false;
        boolean mExternalStorageWriteable = false;
        //checar o estado
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {//montado para escrita
            mExternalStorageAvailable = mExternalStorageWriteable = true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {//montado para leitura
            mExternalStorageAvailable = true;
            mExternalStorageWriteable = false;
        } else {
            mExternalStorageAvailable = mExternalStorageWriteable = false;
        }
    }

    private void saveInternal(Object objeto) throws IOException, ClassNotFoundException {
        //Para Gravar
        String FILENAME = "hello_file";
        File file =getFileStreamPath(FILENAME);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(objeto);
        oos.close();
        fos.close();

        //Para Ler
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object retorno = ois.readObject();
        fis.close();
        ois.close();

        //use retorno
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Log.d("AGDebug", String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)));
        Log.d("AGDebug", String.valueOf(Environment.getExternalStorageDirectory()));
        //contextualizar o armazenamento
//        SharedPreferences preferences = getSharedPreferences("Configurations", 0);
//        SharedPreferences.Editor e = preferences.edit();
//        e.putBoolean("debug_mode", true);
//        e.commit();
//        //
        MeuBancoDeDados m =  new MeuBancoDeDados(this);
        //recuperar o drive de manipulação de dados
        SQLiteDatabase db = m.getReadableDatabase();
//        //
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("name", "Ari Garcia");
//        db.insert("TB1", null, contentValues);// tente alterar
//        //
//        db.execSQL("insert into TB1 (name) values (\"ari agrcia\")");
//        //
//        Log.d("AGDebug", "database path: " + db.getPath());
        //
//        //O cursor no android é similar ao ResultSet do Java
//        Cursor cursor = banco.get().rawQuery("select * from tb1 limit ?", new String[]{"1"});
//        while (cursor.moveToNext()) {
//            Log.i(TAG_LOG, "f: " + cursor.getInt(cursor.getColumnIndex("name")));
//            Log.i(TAG_LOG, "-------");
//        }
//        //Nunca esqueça de feixar o cursor.
//        cursor.close();

        db.execSQL(null);//procedimento para insert, update, delete...
        Cursor cursor = db.query();
        //
         new ContentProvider(){

             @Override
             public boolean onCreate() {
                 //criar o banco de dados
                 return false;
             }

             @Nullable
             @Override
             public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
                 //Uri uri1 --> select * from table1
                 //selecionar dados do sqlite por exemplo
                 return null;
             }

             @Nullable
             @Override
             public String getType(@NonNull Uri uri) {
                 //table1 --> content://persistence.ag/table1
                 //table2 --> content://persistence.ag/table2
                 //table3 --> content://persistence.ag/table3
                 return null;
             }

             @Nullable
             @Override
             public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
                 String table = map.get("content://persistence.ag/table1");
                 // URI => content://persistence.ag/table1
                 // SQL => insert into table1 (f) values(?)
                 //checagem
                 db.insert(table, values);
                 return null;
             }

             @Override
             public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
                 // URI => content://persistence.ag/table1/4
                 return 0;
             }

             @Override
             public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {

                 return 0;
             }
         }
    }
}
