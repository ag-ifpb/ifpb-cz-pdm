package br.com.utacteam.thirdapp;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by arigarcia on 3/1/17.
 */
public class MyHandler {
    //
    private static Handler HANDLER = null;

    public static void init(Looper looper, Handler.Callback callback){
        HANDLER = new Handler(looper, callback);
    }

    //
    public static Handler getInstance() {
        if (HANDLER == null){
            throw new RuntimeException("Handler must be not null.");
        }
        return HANDLER;
    }


}
