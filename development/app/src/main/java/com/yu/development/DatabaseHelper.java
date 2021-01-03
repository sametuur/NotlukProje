package com.yu.development;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;


    private static final String DATABASE_NAME = "users";

    private static final String TABLE_USER = "Kayit";
    private static final String TABLE_GUNLUK = "gunluk";


    private static final String KAYIT_ID = "id";
    private static final String KAYIT_NAME = "kayıtName";

    private static final String GUNLUK_ID = "id";
    private static final String GUNLUK_KAYIT= "gunlukayit";



    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" + KAYIT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KAYIT_NAME + " TEXT" +")";

    private static final String CREATE_TABLE_GUNLUK = "CREATE TABLE " + TABLE_GUNLUK + "(" + GUNLUK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +GUNLUK_KAYIT+" TEXT"+")";


    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_GUNLUK);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GUNLUK);
        onCreate(db);
    }
    /**
     * Yeni aktivite eklemeyi saglar
     *
     * @param user eklenecek aktivitine
     * @return eklenen kullanıcının id'si doner, hata durumunda -1 doner
     */
    public long createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KAYIT_ID, user.getID());
        values.put(KAYIT_NAME, user.getUserName());
        return db.insert(TABLE_USER, null, values);
    }
    public long creategunluk(gunlukara gunluk) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GUNLUK_ID,gunluk.getGunlukID());
        values.put(GUNLUK_KAYIT,gunluk.getGunlukkayit());
        return db.insert(TABLE_GUNLUK, null, values);

    }
    /**
     * Tum Başlıkları  getirir
     *
     * @return Kayitli başlıklar
     */
    public List<String> getAllUsers() {
        List<String> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] stunlar = {KAYIT_NAME};
        @SuppressLint("Recycle") Cursor cursor = db.query(TABLE_USER, stunlar, null, null, null, null, null);
        while (cursor.moveToNext()) {
            users.add(cursor.getString(0) );
        }
        return users;
    }
    public List<String> getAllgunluk() {
        List<String> deneme = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] stunlar = {GUNLUK_KAYIT};
        @SuppressLint("Recycle") Cursor cursor = db.query(TABLE_GUNLUK, stunlar, null, null, null, null, null);
        while (cursor.moveToNext()) {
            deneme.add( cursor.getString(0));
        }
        return deneme;
    }

    /**
     * aktivite adlarını siler **/
    public void deleteUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KAYIT_NAME+" = ?", new String[]{String.valueOf(username)});
        db.close();
    }

}
