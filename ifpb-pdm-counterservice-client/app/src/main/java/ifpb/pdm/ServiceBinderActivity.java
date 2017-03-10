package ifpb.pdm;

import ifpb.pdm.client.R;
import android.app.Activity;
import android.content.ComponentName;
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
import android.widget.Toast;

public class ServiceBinderActivity extends Activity implements ServiceConnection{
	private Counter counter;
	
	private void initService(){
		Log.d("[Ari]", "initializing service");
		Intent intent = new Intent();
		intent.setAction("ifpb.pdm.AIDLCounter");
		if (bindService(intent, this, BIND_AUTO_CREATE)){
			Log.d("[Ari]", "binding service with success");
		}
		else {
			Log.d("[Ari]", "binding service with fail");
		}	
	}
	
	private void releaseService(){
		unbindService(this);
		Log.d("[Ari]", "unbinding service");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//
		final TextView text = (TextView) findViewById(R.id.valorContador);
		//get counter
		Button btnGet = (Button) findViewById(R.id.btnLerContador);
		btnGet.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Log.e("[Ari]", "getting...");
					int count = counter.get();
					text.setText("" + count);
				} 
				catch (RemoteException e) {
					Log.e("[Ari] - get", "");
				}
			}
		});
		//reset counter
		Button btnReset = (Button) findViewById(R.id.btnZerarContador);
		btnReset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Log.e("[Ari]", "reseting...");
					counter.reset();
				} catch (RemoteException e) {
					Log.e("[Ari] - reset", "error on btnReset", e);
				}
				
			}
		});
	}
	
	@Override
	protected void onStart() {
		initService();
		super.onStart();
	}
	
	@Override
	protected void onStop() {
		releaseService();
		super.onStop();
	}
	
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		Log.d("[Ari]", "service connected");
		counter = Counter.Stub.asInterface(service);
		Toast.makeText(
				getApplicationContext(),
				"Service Connected", 
				Toast.LENGTH_SHORT
		).show();
	}
	
	@Override
	public void onServiceDisconnected(ComponentName name) {
		Log.d("[Ari]", "service disconnected");
		Toast.makeText(
				getApplicationContext(),
				"Service Disconnected", 
				Toast.LENGTH_SHORT
		).show();
	}
		
}
