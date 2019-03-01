package fyp.com.kwuizy.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class OnlineDBHelper extends SQLiteAssetHelper {

    private static final String DB_NAME = "";
    private static final int DB_VER = 1;



    public OnlineDBHelper(Context context, String name, String storageDirectory, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, storageDirectory, factory, version);
    }
}
