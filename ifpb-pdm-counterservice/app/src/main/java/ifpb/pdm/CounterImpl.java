package ifpb.pdm;

import android.os.RemoteException;
import android.util.Log;

public class CounterImpl extends Counter.Stub {
	private int count = 0;
	
	public CounterImpl() {
		Log.d("[Ari]", "creating counter impl: " + hashCode());
	}
	
	@Override
	public int get() throws RemoteException {
		Log.d("[Ari]", "call get value");
		return count++;
	}

	@Override
	public void set(int value) throws RemoteException {
		Log.d("[Ari]", "call set value");
		count  = value;
	}

	@Override
	public void reset() throws RemoteException {
		Log.d("[Ari]", "call reset");
		count = 0;
	}

}
