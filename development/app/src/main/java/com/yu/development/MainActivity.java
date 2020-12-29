package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.yu.development.R.*;


public class MainActivity extends AppCompatActivity {
    Button button,listele;
    TextView degisken2;
     ListView list ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        degisken2= findViewById(R.id.degisken2);
        button = findViewById(R.id.button);
        list = findViewById(R.id.veriler);
        listele=findViewById(R.id.listele);
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Veritabani veritabani = new Veritabani(MainActivity.this);
                List<Model> vVeriler = veritabani.Verigetir();
                ArrayAdapter<Model> adapter = new ArrayAdapter<Model>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1,vVeriler);
                list.setAdapter(adapter);

            }
        });









        button.setOnClickListener(v -> {
            Intent Tent = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(Tent);
        });


        //  tvToken = findViewById(R.id.tv_log);
        MyReceiver receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.yu.development.onNewToken");
        MainActivity.this.registerReceiver(receiver, filter);
    }
    public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.yu.development.onNewToken".equals(intent.getAction())) {
                String token = intent.getStringExtra("token");

            }

        }

    }

}

