package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class gunlukgecmisi extends AppCompatActivity {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunlukgecmisi);
        list = findViewById(R.id.list);



        DatabaseHelper db = new DatabaseHelper(gunlukgecmisi.this);
        List<String> gelenler = db.getAllgunluk();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(gunlukgecmisi.this, android.R.layout.simple_list_item_1, android.R.id.text1, gelenler);
        list.setAdapter(adapter);
    }
}