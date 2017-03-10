package ifpb.pdm;

import ifpb.pdm.servicebinder.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements ServiceConnection {
	private Counter counter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//
		final TextView text = (TextView) findViewById(R.id.valorContador);
		//connect and bind service
		Button btnBind = (Button) findViewById(R.id.btnBind);
		btnBind.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CounterService.class);
				bindService(intent, MainActivity.this, Context.BIND_AUTO_CREATE);
			}
		});
		//unbind service
		Button btnUnbind = (Button) findViewById(R.id.btnUnbind);
		btnUnbind.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				unbindService(MainActivity.this);
			}
		});
		//get counter
		Button btnGet = (Button) findViewById(R.id.btnLerContador);
		btnGet.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					int count = counter.get();
					text.setText("" + count);
				} 
				catch (RemoteException e) {
					Log.e("[Ari] - get", e.getMessage());
				}
			}
		});
		//reset counter
		Button btnReset = (Button) findViewById(R.id.btnZerarContador);
		btnReset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					counter.reset();
					//text.setText("0");
				} catch (RemoteException e) {
					Log.e("[Ari] - reset", e.getMessage());
				}
			}
		});
	}

	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		counter = (CounterImpl) service;
	}

	@Override
	public void onServiceDisconnected(ComponentName name) {
		counter = null;//regra
	}

}
