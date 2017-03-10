package pdm.agifpb.firstapp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arigarcia on 2/9/17.
 */
public class ChatListAdapter extends BaseAdapter {
    private final Context ctx;
    private final List<ChatItem> list = new ArrayList<ChatItem>();

    public ChatListAdapter(Context context){
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout ll =  viewGroup.findViewById(R.id.frame_chat);
        return null;
    }
}
