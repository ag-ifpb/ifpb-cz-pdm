package br.edu.ifpb.app_isconnected;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private void markAsConnected(){
        //recuperar os elementos da visão
        ImageView img = (ImageView) findViewById(R.id.img);
        TextView txt = (TextView) findViewById(R.id.text);
        //
        img.setImageResource(R.drawable.icon_green);
        txt.setText(R.string.with_connection);
        txt.setTextColor(getResources().getColor(R.color.colorIconTextGreen));
    }

    private void markAsDisconnected(){
        //recuperar os elementos da visão
        ImageView img = (ImageView) findViewById(R.id.img);
        TextView txt = (TextView) findViewById(R.id.text);
        //
        img.setImageResource(R.drawable.icon_red);
        txt.setText(R.string.without_connection);
        txt.setTextColor(getResources().getColor(R.color.colorIconTextRed));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
        //with connection
        lbm.registerReceiver(new WithConnectionReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("AGDebug", "conectado");
                markAsConnected();
            }
        }, new IntentFilter(WithConnectionReceiver.ACTION));
        //without connection
        lbm.registerReceiver(new WithoutConnectionReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("AGDebug", "desconectado");
                markAsDisconnected();
            }
        }, new IntentFilter(WithoutConnectionReceiver.ACTION));
        //
        Button btStartService = (Button) findViewById(R.id.btStartService);
        Button btStopService = (Button) findViewById(R.id.btStopService);
        //
        btStartService.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                startService(new Intent(MainActivity.this, CheckingInternetService.class));
            }
        });
        //
        btStopService.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, CheckingInternetService.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
