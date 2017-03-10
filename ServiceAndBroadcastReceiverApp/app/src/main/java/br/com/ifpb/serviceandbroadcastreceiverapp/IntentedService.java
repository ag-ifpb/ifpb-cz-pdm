package br.com.ifpb.serviceandbroadcastreceiverapp;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;


public class IntentedService extends IntentService {

    public IntentedService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //
        Log.d("[AGDebug]", "Starting o serviço.");
        //
        try {
            //
            Thread.sleep(5000);
            //Toast.makeText(StartedService.this, "Serviço finalizado", Toast.LENGTH_LONG).show();
            //
            Handler handler = HandlerSingleton.getHandlerInstance();
            handler.sendMessage(Message.obtain());
            //
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        Log.d("[AGDebug]", "Finishing o serviço.");
    }


}
