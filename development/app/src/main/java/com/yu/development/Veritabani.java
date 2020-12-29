package com.yu.development;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class Veritabani extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="TABAN";
    private static final String TABAN_TABLE = "gg";
    private static final int DATABASE_VERSION = 1;



    public Veritabani(Context context){
        super (context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqltabloolustur = "CREATE TABLE "+ TABAN_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,MYTEXT TEXT)";
        db.execSQL(sqltabloolustur);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABAN_TABLE);
    }


    public void Ekle(Model text){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("MYTEXT",text.getText());
        db.insert(TABAN_TABLE,null,cv);
        db.close();

    }
    public List<Model> Verigetir () {
        List<Model> yazi = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM "+TABAN_TABLE;
        Cursor cursor = db.rawQuery(selectQuery,null);
        Model text = null ;
        if (cursor.moveToFirst()){
            do {
                text = new Model ();
                text.setID(Integer.parseInt(cursor.getString(0)));
                text.setText(cursor.getString(1));

            }while (cursor.moveToNext());
        }
        return yazi;
    }





















   /* private static final String DATABASE_NAME="TABAN";
    private static final int DATABASE_VERSION = 1;
    private static final String TABAN_TABLE = "gg";



    public static final String ROW_ID="id";
    public static final String ROW_NAME="ad";


    public Veritabani(Context context ) { super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABAN_TABLE + "("+ROW_ID+" INTEGER PRIMARY KEY ,"+ROW_NAME+"TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABAN_TABLE);
        onCreate(db);

    }
    public void VeriEKle(String tablom){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_NAME,tablom.trim());
        db.insert(TABAN_TABLE,null,cv);
        db.close();
    }
    public List<String> Verilistele(){
        ArrayList<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[] sutunlar = {ROW_ID,ROW_NAME};
        Cursor cursor = db.query(TABAN_TABLE,sutunlar,null,null,null,null,null);
        while(cursor.moveToNext())
            veriler.add(cursor.getInt(0) + "-" + cursor.getString(1));
        return veriler;
    }
       public List<Kisiler> TumKayitlariGetir() {
            SQLiteDatabase vt = this.getReadableDatabase();
            String[] sutunlar = new String[]{ROW_AD, ROW_SOYAD};
            Cursor c = vt.query(AJANDA_TABLE, sutunlar, null,null,null,null,null);
            int adsirano = c.getColumnIndex(ROW_AD);
            int soyadsirano = c.getColumnIndex(ROW_SOYAD);
            List<Kisiler> kisilerList = new ArrayList<Kisiler>();
            for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
                Kisiler kisiler = new Kisiler();
                kisiler.setAd(c.getString(adsirano));
                kisiler.setSoyAd(c.getString(soyadsirano));
                kisilerList.add(kisiler);
            }
            vt.close();
            return kisilerList;
        }
         public long KayitEkle(Kisiler kisiler) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ROW_AD, kisiler.getAd());
        cv.put(ROW_SOYAD, kisiler.getSoyAd());
        long id = db.insert(AJANDA_TABLE, null, cv);
        db.insert(AJANDA_TABLE, null, cv);
        db.close();
        return id;
    }

*/
}
