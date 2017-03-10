package br.com.utacteam.secapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private void openBrowser(){
        Uri _uri = new Uri.Builder().scheme("http")
                .authority("www.android.com")
                .path("nada").build();
        Log.d("[AGDebug] ",  _uri.toString());
        Uri uri = Uri.parse("http://www.android.com");
        Log.d("[AGDebug] ",  uri.toString());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void openMaps(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                //openBrowser();
                openMaps();
            }
        });
    }
}
