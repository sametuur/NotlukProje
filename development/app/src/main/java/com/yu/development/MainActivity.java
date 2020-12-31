package com.yu.development;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;
import com.huawei.hms.ads.banner.BannerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Button button, listele;
    ListView list;
    InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        list = findViewById(R.id.veriler);
        listele = findViewById(R.id.listele);

        HwAds.init(this);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId("teste9ih9j0rc3");
        interstitialAd.setAdListener(adListener);

        AdParam adParam = new AdParam.Builder().build();
        interstitialAd.loadAd(adParam);

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
            showInterstitial();
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
    public void loadBannerAd(){
        BannerView bannerView = new BannerView(this);
        bannerView.setAdId("testw6vs28auh3");
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);
        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);
    }
    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            //Toast.makeText(MainActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAdFailed(int errorCode) {
            Toast.makeText(MainActivity.this, "Ad load failed with error code: " + errorCode,
                    Toast.LENGTH_SHORT).show();
            Log.d("TAG", "Ad load failed with error code: " + errorCode);
        }

        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Log.d("TAG", "onAdClosed");
        }

        @Override
        public void onAdClicked() {
            Log.d("TAG", "onAdClicked");
            super.onAdClicked();
        }

        @Override
        public void onAdOpened() {
            Log.d("TAG", "onAdOpened");
            super.onAdOpened();
        }
    };

    private void showInterstitial() {
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }
 }


