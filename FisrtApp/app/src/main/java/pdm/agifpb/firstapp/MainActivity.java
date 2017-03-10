package pdm.agifpb.firstapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        final Button tabChat = (Button) findViewById(R.id.tab_chat);
        final Button tabMissions = (Button) findViewById(R.id.tab_missions);
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
                tabChat.setBackgroundColor(Color.parseColor("#55888888"));
                tabMissions.setBackgroundColor(Color.parseColor("#00000000"));
            }

        });
        //
        tabMissions.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("[AGDebug]", "Abrindo o tab do missiões.");
                tabFrameChat.setVisibility(View.GONE);
                tabFrameMissions.setVisibility(View.VISIBLE);
                tabChat.setBackgroundColor(Color.parseColor("#00000000"));
                tabMissions.setBackgroundColor(Color.parseColor("#55888888"));
            }
        });
        //
        LinearLayout frameChat = (LinearLayout) findViewById(R.id.frame_chat);
        ListView listView = (ListView) findViewById(R.id.listViewChatItems);
        listView.addView(frameChat);
    }
}
