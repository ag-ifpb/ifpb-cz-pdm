package ag.ifpb.temp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends Activity {
    private TextView tvHello;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setText(R.string.hm1);
        //
        btn = (Button) findViewById(R.id.btn);
        btn.setText(R.string.btn_name);
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                toquei(view);
                tvHello.setText(R.string.hm2);
            }
        });

    }

    public void toquei(View v){
        Toast.makeText(this, "Teste", Toast.LENGTH_LONG).show();
    }
}
