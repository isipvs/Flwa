package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import entity.Product;
import ru.mpt.p50_4_19.flwa.ProductRepository;

/** */
public class SQLiteProductRepository implements ProductRepository {

    final private SQLiteDatabase db;

    public SQLiteProductRepository(SQLiteDatabase db) {
        this.db = db;
    }

    /** */
    private Product map( Cursor c ) {
        return
            new Product(
                c.getInt(1),
                c.getString(2),
                c.getString(3),
                c.getString(4),
                new BigDecimal(c.getString(5)),
                c.getString(6)
            );
    }

    @Override
    public List<Product> findAll() {

        try ( Cursor c = db.rawQuery("select id_prdct, name, short_name, note, price, image_id from prdct", null) ) {

            if( c.getCount() == 0 )
              return Collections.emptyList();

            List<Product> retList = new ArrayList<>();

            c.moveToFirst();

            do {
              retList.add ( map(c) );
            }
            while( c.moveToNext() );

            return retList;
        }
    }

    @Override
    public Optional<Product> findById(int id) {

        String[] args = new String[]{Integer.toString(id)};

        try ( Cursor c = db.rawQuery("select id_prdct, name, short_name, note, price, image_id from prdct where id_prdct=?", args) )
        {
            if( c.getCount() == 0 )
                return Optional.empty();

            c.moveToFirst();
            return Optional.of(map(c));
        }
    }
}
