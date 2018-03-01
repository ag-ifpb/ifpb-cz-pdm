package br.edu.ifpb.app_calc;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity{
    private final static String TAG = "AGDebug";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal);
    }

    public void btnClick0(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick1(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick2(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick3(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick4(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick5(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick6(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick7(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick8(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClick9(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickPlus(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickDiff(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickTimes(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickDiv(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickDot(View v) {
        Log.d(TAG, "Botão clicado.");
    }

    public void btnClickEqual(View v) {
        Log.d(TAG, "Botão clicado.");
    }

}
