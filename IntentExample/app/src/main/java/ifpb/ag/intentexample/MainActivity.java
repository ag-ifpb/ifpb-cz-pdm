package ifpb.ag.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);
        //
        Button btn = (Button) findViewById(R.id.btnopen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                //Uri uri = Uri.parse("http://uol.com.br");
                //Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //MainActivity.this.startActivity(intent);
                //
                Intent intent = new Intent(MainActivity.this, View2Activity.class);
                //
                Bundle bundle = new Bundle();
                bundle.putInt("umNumero", 12);
                intent.putExtras(bundle);
                ///
                MainActivity.this.startActivity(intent);
            }
        });
    }
}
