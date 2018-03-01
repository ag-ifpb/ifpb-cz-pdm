package br.edu.ifpb.application;


import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class IntentService extends android.app.IntentService {

    public IntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //
        Log.d("AGDebug", "Bloqueando o IntentService");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //mensagem para ser enviada para broadcast
        Intent msg = new Intent(LocalReceiver.ACTION_CRIME);
        msg.putExtra(LocalReceiver.PARAM_MSG, "O serviço desbloqueou");
        //
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        lbm.sendBroadcast(msg);
        //
        Log.d("AGDebug", "Desbloqueando o IntentService");
        //
        stopSelf();
    }



}
