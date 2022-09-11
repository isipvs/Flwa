package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DBHelper extends SQLiteOpenHelper {

    final private Context context;

    public DBHelper(@Nullable Context context ) {
        super(context, "flwa.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try (BufferedReader r = new BufferedReader( new InputStreamReader( context.getAssets().open("int_db.sql") ) ) )
        {
            String sqlInit = r.lines().map( (s)->s.trim() ).filter( (s)->!s.isEmpty() ).collect( Collectors.joining() );
            Arrays.asList( sqlInit.split(";")).forEach( (s)->db.execSQL(s) );
        } catch (Exception e) {
            Log.e("db","error on init flwa database", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
