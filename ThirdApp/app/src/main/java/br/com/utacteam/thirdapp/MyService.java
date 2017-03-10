package br.com.utacteam.thirdapp;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        Log.d("[AGDebug]", "Service in running 1 ---.");
        //
        //Bundle bundle = intent.getExtras();
        Log.d("[AGDebug]", "Service in running 2.");
        //Messenger messenger = (Messenger) bundle.get("MESSENGER");
        Log.d("[AGDebug]", "Messenger is recovered.");
        //
        Looper looper = getApplicationContext().getMainLooper();
        Log.d("[AGDebug]", "Looper in service: " + looper.hashCode());
        //
        Handler handler = MyHandler.getInstance();
        Message message = Message.obtain();
        message.setTarget(handler);
        //try {
            //handler.sendMessage(message);
        message.sendToTarget();

        //} catch (RemoteException e) {
        //    e.printStackTrace();
        //}
        //
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        Log.d("[AGDebug]", "Service in stopping.");
        return START_NOT_STICKY;
    }

}
