package ifpb.receiver;

import android.os.Handler;

/**
 * Created by arigarcia on 7/25/17.
 */

public class MainSingleton {
    private static final MainSingleton ourInstance = new MainSingleton();

    private MainSingleton() {
    }

    public static MainSingleton getInstance() {
        return ourInstance;
    }

    private MainActivity.MyHandler handler;

    public void setHandler(MainActivity.MyHandler handler) {
        this.handler = handler;
    }

    public MainActivity.MyHandler getHandler() {
        return handler;
    }
}
