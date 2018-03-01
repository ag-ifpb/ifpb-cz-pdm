package br.edu.ifpb.application;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.transition.Scene;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "AGDebug";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        ViewGroup mvg = (ViewGroup) findViewById(R.id.mvg);
        //
        Scene mscene = Scene.getSceneForLayout(mvg, R.layout.activity_main, this);
        final Scene dscene = Scene.getSceneForLayout(mvg, R.layout.activity_detail, this);
        //
        final Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //TransitionManager.go(dscene);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MainActivity.this,
                        R.anim.myanim, android.R.anim.slide_out_right);
                ((AppCompatActivity)(MainActivity.this)).startActivity(intent, options.toBundle());
            }
        });
        //
        final Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, StartedService.class);
                Intent intent = new Intent(MainActivity.this, IntentService.class);
                MainActivity.this.startService(intent);//solicita que inicie o serviço
            }
        });
        //
        final Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentService.class);
                MainActivity.this.stopService(intent);//solicita que mate o serviço
            }
        });
        //
        TextView tv = (TextView) findViewById(R.id.txt);
        LocalReceiver.registry(this, tv);
        //
        Log.d(TAG, "Atividade criada");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Atividade iniciada");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Atividade resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Atividade pausada");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Atividade parada");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Atividade reiniciada");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Atividade destruída");
    }

}
