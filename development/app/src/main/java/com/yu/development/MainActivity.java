package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button button, listele;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        list = findViewById(R.id.veriler);
        listele = findViewById(R.id.listele);


        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseHelper db = new DatabaseHelper(MainActivity.this);
                List<String> veriler = db.getAllUsers();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, veriler);
                list.setAdapter(adapter);


            }
        });


        /*list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), list.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });*/
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), list.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "VAZ GEÇTİM KNKS",Toast.LENGTH_SHORT).show();

            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getApplicationContext(), list.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();*/
                Intent rTent = new Intent(getApplicationContext(), Araci.class);
                rTent.putExtra("tag",  list.getItemAtPosition(position).toString());
                startActivity(rTent);

            }
        });



        button.setOnClickListener(v -> {
            Intent Tent = new Intent(getApplicationContext(),gunluk.class);
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


