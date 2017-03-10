package br.com.ifpb.serviceandbroadcastreceiverapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import android.widget.Toast;

public class StartedService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        Log.d("[AGDebug]", "Starting o serviço.");
        //
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    //Toast.makeText(StartedService.this, "Serviço finalizado", Toast.LENGTH_LONG).show();
                    //
                    Handler handler = HandlerSingleton.getHandlerInstance();
                    handler.sendMessage(Message.obtain());
                    //
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        //
        Log.d("[AGDebug]", "Finishing o serviço.");
        //
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        //enviar comunicação para a activity
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
