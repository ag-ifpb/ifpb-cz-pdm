package ifpb.pdm;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class CounterService extends Service {
	
	@Override
	public IBinder onBind(Intent intent) {
		return new CounterImpl();//CounterFactory.singleton();
	}

}
