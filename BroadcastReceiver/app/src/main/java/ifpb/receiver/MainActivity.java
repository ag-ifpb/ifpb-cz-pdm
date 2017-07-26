package ifpb.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "AGDebug-Tela-1";
    private MainReceiver receiver;

    public static class MyHandler extends Handler {
        private final MainActivity activity;

        public MyHandler(MainActivity activity) {
            super(activity.getApplicationContext().getMainLooper());
            this.activity = activity;
        }

        public void setText(final String text) {
            //colocando na fila da thread principal
            post(new Runnable() {
                @Override
                public void run() {
                    activity.setNewText(text);
                }
            });
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        //
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainService.class);
                MainActivity.this.startService(intent);
            }
        });
        //
        MainSingleton.getInstance().setHandler(new MyHandler(this));
        //
        receiver = new MainReceiver();
        //
        LocalBroadcastManager lm = LocalBroadcastManager.getInstance(this);
        lm.registerReceiver(receiver, new IntentFilter(MainReceiver.ACTION));
        //
        Log.d(TAG, "onCreate()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("txt", "Opa");
        super.onSaveInstanceState(outState);
        Log.d("AGDebug", "saving");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("AGDebug", "restoring: " + savedInstanceState.getString("txt"));
    }

    public void setNewText(String text) {
        ((TextView) findViewById(R.id.tv1)).setText(text);
        ((TextView) findViewById(R.id.tv1)).invalidate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }
}
