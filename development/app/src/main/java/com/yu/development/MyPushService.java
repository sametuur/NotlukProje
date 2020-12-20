package com.yu.development;

import android.content.Intent;
import android.util.Log;

import com.huawei.hms.push.HmsMessageService;

public class MyPushService extends HmsMessageService {
    private static final String TAG = "MyPushService";
    @Override
    public void onNewToken(String token) {
        super.onNewToken(token);
        Log.i(TAG, "receive token:" + token);
        sendTokenToDisplay(token);
    }

    private void sendTokenToDisplay(String token) {
        Intent intent = new Intent("com.yu.development.onNewToken");
        intent.putExtra("token", token);
        sendBroadcast(intent);
    }
}