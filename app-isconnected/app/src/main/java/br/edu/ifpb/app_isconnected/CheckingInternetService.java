package br.edu.ifpb.app_isconnected;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class CheckingInternetService extends IntentService {

    public CheckingInternetService() {
        super("CheckingInternetService");
    }

    private boolean checkInternet() {
        try {
            URL url = new URL("http://uol.com.br");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            String contentType = conn.getContentType();
            if (contentType != null && !"".equals(contentType)) {
                return true;
            }
        } catch (IOException e) {
        }
        //
        return false;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(getApplicationContext());
        //
        while (true) {
            if (checkInternet()) {
                //markAsConnected();//atualiza a visão
                lbm.sendBroadcast(new Intent(WithConnectionReceiver.ACTION));
            } else {
                //markAsDisconnected();//atualiza a visão
                lbm.sendBroadcast(new Intent(WithoutConnectionReceiver.ACTION));
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
