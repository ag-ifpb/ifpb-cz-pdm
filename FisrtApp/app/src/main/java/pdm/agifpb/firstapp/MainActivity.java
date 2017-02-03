package pdm.agifpb.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button tabChat = (Button) findViewById(R.id.tab_chat);
        Button tabMissions = (Button) findViewById(R.id.tab_missions);
        //
        final LinearLayout tabFrameChat = (LinearLayout) findViewById(R.id.tab_frame_chat);
        final LinearLayout tabFrameMissions = (LinearLayout) findViewById(R.id.tab_frame_missions);
        //
        tabChat.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("[AGDebug]", "Abrindo o tab do chat.");
                tabFrameChat.setVisibility(View.VISIBLE);
                tabFrameMissions.setVisibility(View.GONE);
            }
        });
        //
        tabMissions.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("[AGDebug]", "Abrindo o tab do missiões.");
                tabFrameChat.setVisibility(View.GONE);
                tabFrameMissions.setVisibility(View.VISIBLE);
            }
        });

    }
}
