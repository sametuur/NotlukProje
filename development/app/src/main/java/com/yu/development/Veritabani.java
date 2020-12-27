package com.yu.development;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.sql.SQLException;

public class Veritabani {
    //VeriTabanı Tablo ve isim adlarını yaz
    private static final String DATABASE_ISIM = "Kisiler";
    private static final String DATABASE_TABLO = "Rehber";
    private static final int DATABASE_VERSION = 1;

    //Veritabanını kullanacak sınıfları tutan Context nesnesi
    private final Context contextim;
    //Oluşturduğumuz veritabanıyardımcı sınıfının nesnesi
    private VeritabaniHelper veritabanihelper;
    //Veritabanımızın nesnesi
    private SQLiteDatabase veritabanim;

    // Oluşturulacak insanlar tablosunun sütunları
    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_ISIM = "isim";
    public static final String KEY_TELEFON = "telefon";
    //Constructor kısmı
    public Veritabani(Context c) {
        this.contextim = c;
    }

    //Veritabanı bağlantıyı açıp içine veri girebildiğimiz kısım.
    public Veritabani baglantiyiAc() throws SQLException {

        veritabanihelper = new VeritabaniHelper(contextim);
        veritabanim = veritabanihelper.getWritableDatabase();

        return this;

    }
    //Veritabanını kapattığımız kısım
    public void baglantiyiKapat() {

        veritabanihelper.close();

    }
    //Bu kısımda ise Veritabanı oluşturacağız. SQLiteOperHelper'dan kalıtım alıyoruz. 2 Metodu var. Oncreate ve OnUpgrade
    //Bu kısımda yapılan işlemler OnCreate'te Veritabanını SQL komut olarak oluşturduk. OnUpgrade'de tabloyu silip tekrar oluşt    //urduk
    private static class VeritabaniHelper extends SQLiteOpenHelper {

        public VeritabaniHelper(Context contextim) {
            super(contextim, DATABASE_ISIM, null, DATABASE_VERSION);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL("CREATE TABLE " + DATABASE_TABLO + " (" + KEY_ROW_ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT , " + KEY_ISIM
                    + " TEXT NOT NULL, " + KEY_TELEFON + " TEXT NOT NULL);");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLO);
            onCreate(db);

        }

    }

}