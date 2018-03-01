package br.edu.ifpb.application;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartedService extends Service {

    public StartedService() {
    }

    @Override
    //@IntDef(value = {Service.START_FLAG_REDELIVERY, Service.START_FLAG_RETRY}, flag = true)
    public int onStartCommand(Intent intent, int flags, int startId) {
        //
        Log.d("AGDebug", "Iniciando o serviço como comando");
        //está trabalhando sobre a UIThread
//        try {
//            Thread.sleep(1000);//dormir por 1s
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //
        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d("AGDebug", "Vinculando o serviço");
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Log.d("AGDebug", "Criando o serviço");
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.d("AGDebug", "Iniciando o serviço");
        super.onStart(intent, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d("AGDebug", "Vincular novamente o serviço");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("AGDebug", "Destruindo o serviço");
        super.onDestroy();
    }
}
