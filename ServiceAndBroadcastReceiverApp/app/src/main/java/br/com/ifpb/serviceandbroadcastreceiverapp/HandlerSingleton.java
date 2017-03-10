package br.com.ifpb.serviceandbroadcastreceiverapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class HandlerSingleton {
    private static Handler handler = null;

    public static void init(Looper looper){
        handler = new Handler(looper);
    }

    public static void init(Looper looper, Handler.Callback callback){
        handler = new Handler(looper, callback);
    }

    public static Handler getHandlerInstance(){
        return handler;
    }
}
