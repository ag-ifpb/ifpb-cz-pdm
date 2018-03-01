package ifpb.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class MainReceiver extends BroadcastReceiver {
    public static final String ACTION = "ifpb.pdm.UPDATED_VIEW";

    @Override
    public void onReceive(Context context, Intent intent) {
        //update view
        String text = intent.getStringExtra("txt");
        MainSingleton.getInstance().getHandler().setText(text);
    }

}
