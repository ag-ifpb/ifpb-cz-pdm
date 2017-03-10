package br.com.utacteam.thirdapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private Button btnStart;
    private Button btnStop;

    private int count = 0;
    private Thread mThread;

    private void startCount(){
        //
//        final Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                //
//                text.setText("Count: " + count);
//                Log.d("[AGDebug]", "Count: " + count);
//                //
//                Intent intent = new Intent(MainActivity.this, MyService.class);
//                MainActivity.this.startService(intent);
//            }
//        };
//        //
//        final Looper looper = getApplicationContext().getMainLooper();
//        //
//        mThread = new Thread(){
//            @Override
//            public void run() {
//                //
//                Handler handler = new Handler(looper);
//                while(true) {
//                    //
//                    count++;
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        break;
//                    }
//                    handler.post(runnable);
//                }
//            }
//        };
//        mThread.start();
        Looper looper = getApplicationContext().getMainLooper();
        Log.d("[AGDebug]", "Looper in activity: " + looper.hashCode());
        MyHandler.init(looper, new Handler.Callback(){
            @Override
            public boolean handleMessage(Message message) {
                Log.d("[AGDebug]", "Mensagem recebida: " + message.what);
                text.setText("Count: " + 0);
                return true;
            }
        });
        //
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    private void stopCount(){
        //mThread.interrupt();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperar os elementos da visão
        text = (TextView) findViewById(R.id.txt);
        btnStart = (Button) findViewById(R.id.btn1);
        btnStop = (Button) findViewById(R.id.btn2);
        //
        btnStart.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                startCount();
            }
        });
        btnStop.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                stopCount();
            }
        });
        //

    }


}
