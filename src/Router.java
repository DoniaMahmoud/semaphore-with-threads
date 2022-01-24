import java.util.ArrayList;


//public class  Router extends Semaphore{
public class Router{
	
	private ArrayList <Devices> connections=new ArrayList <Devices>();
	private int value;
	public Semaphore sem;
	public void set_value(int value) {
		this.value=value;
		sem=new Semaphore(value);
	}
	
	

	void occupy(Devices d) {
		String name=d.get_name();
		String type=d.get_type();
		int r=sem.acquire();
		if(r==-1) {
			System.out.println(name + " "+ type +" "+"arrived and waiting");
		}
		connections.add(d);
	

	}
	
	public void leave(Devices d) {
		sem.release();
		connections.remove(d);
	}

	
	public ArrayList<Devices> get_connections(){
		return this.connections;
	}
}
