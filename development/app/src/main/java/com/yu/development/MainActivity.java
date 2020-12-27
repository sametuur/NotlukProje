package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.yu.development.R.*;


public class MainActivity extends AppCompatActivity {
    Button button;
    ArrayList<String>arrayList1;
    ArrayAdapter<String>adapter1;
    TextView degisken2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        degisken2= findViewById(id.degisken2);
        button = findViewById(id.button);
        ListView list = findViewById(id.list_itemci);


        String[] items={""};
        arrayList1=new ArrayList<>(Arrays.asList(items));
        adapter1= new ArrayAdapter<>(this, layout.list_item3, id.txtitems, arrayList1);
        list.setAdapter(adapter1);
        Intent s = getIntent();
        String newItem=s.getStringExtra("Key");
        arrayList1.add(newItem);
        adapter1.notifyDataSetChanged();




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

