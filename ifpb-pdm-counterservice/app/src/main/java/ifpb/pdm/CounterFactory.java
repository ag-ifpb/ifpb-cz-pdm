package ifpb.pdm;

public class CounterFactory {
	private static CounterImpl counter = new CounterImpl();
	
	public static CounterImpl singleton(){
		return counter;
	}
}
