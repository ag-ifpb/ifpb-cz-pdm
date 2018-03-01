package br.edu.ifpb.application;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.TextView;
import android.widget.Toast;

public abstract class LocalReceiver extends BroadcastReceiver {
    public static final String ACTION_CRIME = "br.edu.ifpb.application.ACTION";
    public static final String PARAM_MSG = "br.edu.ifpb.application.MSG";

    public static void registry(Context ctx, final TextView tv){
        //filtro de registro
        IntentFilter crimeFilter = new IntentFilter(ACTION_CRIME);
        //gerenciador de envio e recebimento em broadcast
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(ctx);
        //recebedor
        LocalReceiver lr = new LocalReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                String msg = intent.getStringExtra(PARAM_MSG);
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                tv.setText(msg);//
            }
        };
        //registro do recebedor no filtro do crime
        lbm.registerReceiver(lr, crimeFilter);
    }
}
