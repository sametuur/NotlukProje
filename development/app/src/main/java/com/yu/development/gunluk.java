package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gunluk extends AppCompatActivity {
    Button alarm,gunluklistesi;
    EditText editText,multitext;
   // DatabaseHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunluk);
        alarm = findViewById(R.id.alarm);
        gunluklistesi=findViewById(R.id.gunluklistesi);
        editText=findViewById(R.id.editname);
        multitext=findViewById(R.id.editTextTextMultiLine);
      //  helper = new DatabaseHelper(getApplicationContext());
        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iTent = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(iTent);
            }
        });
        gunluklistesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = ((EditText) findViewById(R.id.editname)).getText().toString();
                String kayit =((EditText) findViewById(R.id.editTextTextMultiLine)).getText().toString();
                User user = new User();
                user.setUserName(userName);
               gunlukara gunluk = new gunlukara();
               gunluk.setGunlukkayit(kayit+"\n"+userName);
                long resut;
                long result;
                try (DatabaseHelper helper = new DatabaseHelper(getApplicationContext())) {
                    resut = helper.createUser(user);
                    result = helper.creategunluk(gunluk);
                }
                if ( result > 0 || resut >0 ) {
                    Toast.makeText(gunluk.this, "Yeni aktivite ve gunluk eklendi", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(gunluk.this, "aktivite ve gunluk  eklenirken hata oluştu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}