import java.util.ArrayList;
import java.util.Scanner;

public class Devices implements Runnable {
	private String name="";
	private String type="";
	private files f=new files();
	private Router r=new Router();

	public Devices() {
            
		this.name="";
		this.type="";
		this.r=null;
	}
	
	public Devices(String name,String type,Router r) {
		this.name=name;
		this.type=type;
		this.r=r;
	}
	
	public String get_name() {
		return this.name;
	}
	
	public String get_type() {
		return this.type;
	}
 /* public void active() {
		
		System.out.println("Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Occupied.");
		String str="Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Occupied.";
		f.writeonfile(str); 
	  
  }*/
	@Override
	public void run() {
		
		this.r.occupy(this);
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		   
		System.out.println("Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Occupied.");
		String str="Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Occupied.";
		f.writeonfile(str); 
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " +"Performs online activity.");
			String ss="Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " +"Performs online activity.";
			f.writeonfile(ss);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Logged out.");
			String sss="Connection  " +this.r.get_connections().indexOf(this) + " "+ this.get_name()+" " + "Logged out.";
	                f.writeonfile(sss);
		this.r.leave(this);
	}
	
	

}