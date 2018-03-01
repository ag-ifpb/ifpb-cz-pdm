package ifpb.receiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainService extends Service {

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        //
        Log.d("AGDebug", "Iniciando o serviço");
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("AGDebug", "Iniciando o timer");
                    Thread.sleep(5000);
                    //
                    Intent intentBroadcast = new Intent(MainReceiver.ACTION);
                    intentBroadcast.putExtra("txt", "Texto alterado pelo broadcast");
                    //intentBroadcast.setFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                    //
                    EventBus eventBus = EventBus.getInstance(MainService.this);
                    eventBus.sendBroadcast(intentBroadcast);
                    //
                    Log.d("AGDebug", "Finalizando e escrevendo na visão");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Log.d("AGDebug", "Finalizando o serviço");
        //

        //
        return Service.START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
