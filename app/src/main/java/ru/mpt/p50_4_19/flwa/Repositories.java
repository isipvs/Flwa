package ru.mpt.p50_4_19.flwa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ru.mpt.p50_4_19.flwa.db.DBHelper;
import ru.mpt.p50_4_19.flwa.db.SQLiteProductRepository;

/** */
public class Repositories {

    private Context context;
    private ProductRepository productRepository;
    private SQLiteDatabase db;

    private Repositories( Context context ) {
        this.context = context;
    }

    /** */
    public SQLiteDatabase dataBase() {
        if( db == null )
            db = new DBHelper( context ).getWritableDatabase();
        return db;
    }

    /** */
    public ProductRepository productRepository() {
        if( productRepository ==  null )
            productRepository = new SQLiteProductRepository( dataBase() );
        return productRepository;
    }
}
