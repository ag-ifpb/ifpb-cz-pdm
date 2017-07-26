package ifpb.broadcastreceiver_by_system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MainReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Bateria está com pouca carga",
                Toast.LENGTH_LONG).show();
    }
}

