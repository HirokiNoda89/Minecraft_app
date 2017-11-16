package to.msn.wings.minecraft_memo2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 4163104 on 2017/09/05.
 */

public class MemoOpenHelper extends SQLiteOpenHelper {

    static final private String DBName = "MEMO_DB";
    static final private int VERSION = 1;

    public MemoOpenHelper(Context context){
        super(context, DBName, null,VERSION);
    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE MEMO_TABLE(" +
        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
        "uuid TEXT," +
        "xyz TEXT," +
        "body TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS MEMO_TABLE");

        onCreate(db);
    }
}