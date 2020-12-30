package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Araci extends AppCompatActivity {
    Button button;
    TextView textView1 , textView2;
    EditText editTextTextMultiLine2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_araci);
        button = findViewById(R.id.button4);
        textView2 = findViewById(R.id.textView2);



        Bundle gelen = getIntent().getExtras();
        String alinmis = gelen.getString("tag");
        textView2.setText(alinmis);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent bTent = new Intent(getApplicationContext(),gunlukgecmisi.class);
                startActivity(bTent);
                String userName = ((TextView) findViewById(R.id.textView2)).getText().toString();
                String kayit =((EditText) findViewById(R.id.editTextTextMultiLine2)).getText().toString();
                gunlukara gunluk = new gunlukara();
                gunluk.setGunlukkayit(kayit+"\n"+userName);
                long result;
                try (DatabaseHelper helper = new DatabaseHelper(getApplicationContext())) {
                    result = helper.creategunluk(gunluk);
                }
                if ( result > 0 ) {
                    Toast.makeText(Araci.this, "Yeni  gunluk eklendi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Araci.this, "gunluk  eklenirken hata oluştu", Toast.LENGTH_SHORT).show();
                }


        }
        });
    }
}