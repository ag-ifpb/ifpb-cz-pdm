package ifpb.receiver;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ContentProvider extends android.content.ContentProvider {

    //combinador de uri
    private static UriMatcher uriMatcher;


    //constants de acesso e autorização
    private static final String PROTOCOL = "content";
    private static final String AUTHORITY = "ag.ifpb";
    private static final String MIMETYPE_DB1 = "table1";
    private static final String MIMETYPE_DB2 = "table2";
    private static final String MIMETYPE_DB3 = "table3";
    private static final String MIMETYPE_DB4 = "table4";

    //tipos de acessos
    private static final int ITEMS = 0;//selecionar todos os itens
    private static final int ITEM = 1;//selecionar um item pelo
    private static final int FILTER = 2;//selecionar com filtro simples
    private static final int DELETE = 3;

    //
    static {
        uriMatcher.addURI(AUTHORITY, "/tables", ITEMS);
        uriMatcher.addURI(AUTHORITY, "/tables/#", ITEM);
        uriMatcher.addURI(AUTHORITY, "/tables/filter/#",FILTER);
        uriMatcher.addURI(AUTHORITY, "/tables/#", DELETE);
    }

    private SQLiteDatabase database;

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        if (uriMatcher.match(uri) == DELETE) {
            //db = myDatabase.getWritableDatabase()
            String _id = uri.getPathSegments().get(0);
            String sql = "delete from table id = ?";// + _id;//<-- usar mascaramento
            database.execSQL(sql, new String[]{_id});
        }
    }

    @Override
    public String getType(Uri uri) {
        if (uriMatcher.match(uri) == DELETE) return MIMETYPE_DB1;
        else return MIMETYPE_DB2;

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        //db = myDatabase.getWritableDatabase()
        // ---->  content://ag.ifpb/table1/0
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        //checar se um arquivo existe e criá-lo se for o caso
        //recuperar uma instância do banco de dados
        MyDatabase myDatabase = new MyDatabase(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        //db = myDatabase.getReadableDatabase()
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs) {
        //db = myDatabase.getWritableDatabase()
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
