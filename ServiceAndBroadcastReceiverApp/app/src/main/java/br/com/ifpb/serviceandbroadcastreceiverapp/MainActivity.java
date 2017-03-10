package br.com.ifpb.serviceandbroadcastreceiverapp;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private void startService(){
        //Intent intent = new Intent(this, StartedService.class);
        Intent intent = new Intent(this, IntentedService2.class);
        startService(intent);
    }

    private void stopService(){
        Intent intent = new Intent(this, IntentedService2.class);
        stopService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        //
        btn1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity.this.startService();
            }
        });
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                MainActivity.this.stopService();
            }
        });
        //
        HandlerSingleton.init(getApplicationContext().getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                Log.d("[AGDebug]", "Recebi mensagem nº " + message.what);
                return true;
            }
        });
        //
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
        localBroadcastManager.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("[AGDebug]", "Minha mensagem recebida do broadcast. ");
                Toast.makeText(MainActivity.this, "Mensagem recebida via broadcast", Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter("ag.my.first.broadcast"));

    }




}
