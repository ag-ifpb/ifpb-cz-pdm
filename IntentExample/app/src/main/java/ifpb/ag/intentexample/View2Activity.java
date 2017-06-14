package ifpb.ag.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class View2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_view2);
        //
        int number = getIntent().getExtras().getInt("umNumero", -1);
        //
        Button btn = (Button) findViewById(R.id.btnback);
        btn.setText( btn.getText() + " " + number );
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        View2Activity.this, MainActivity.class
                );
                View2Activity.this.startActivity(intent);
            }
        });
    }
}
