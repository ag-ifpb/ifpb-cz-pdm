package ifpb.receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;

public class EventBus {
    private static EventBus eventBus = null;
    private LocalBroadcastManager manager;
    private ArrayList<Intent> pendentsMessages = new ArrayList<>();

    private EventBus(Context ctx) {
        this.manager = LocalBroadcastManager.getInstance(ctx);
    }

    public void sendBroadcast(Intent msg){
        if (manager.sendBroadcast(msg)){
            Log.d("AGDebug", "Mensagem enviada imediatamente");
            pendentsMessages.remove(msg);
        } else {
            Log.d("AGDebug", "Mensagem não enviada imediatamente");
            if (!pendentsMessages.contains(msg)){
                Log.d("AGDebug", "Mensagem não armazenada para envio posteriormente");
                pendentsMessages.add(msg);
            }
        }
    }

    public void registerReceiver(BroadcastReceiver receiver, IntentFilter filter){
        manager.registerReceiver(receiver, filter);
        for (Intent m: pendentsMessages) {
            sendBroadcast(m);
        }
    }

    public void unregisterReceiver(BroadcastReceiver receiver){
        manager.unregisterReceiver(receiver);
    }

    public synchronized static EventBus getInstance(Context ctx){
        if (eventBus == null){
            eventBus = new EventBus(ctx);
        }
        return eventBus;
    }

}
