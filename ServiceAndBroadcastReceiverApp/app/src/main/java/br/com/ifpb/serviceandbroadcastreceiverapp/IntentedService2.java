package br.com.ifpb.serviceandbroadcastreceiverapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


public class IntentedService2 extends IntentService {

    public IntentedService2(){
        super("MyIntentService2");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //
        Log.d("[AGDebug]", "Starting o serviço.");
        //
        try {
            //
            Thread.sleep(5000);
            //
            LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getApplicationContext());
            manager.sendBroadcast(new Intent("ag.my.first.broadcast"));
            //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        Log.d("[AGDebug]", "Finishing o serviço.");
    }


}
