import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
	
	public static ArrayList<Devices> devices= new ArrayList<Devices>();
        private static Router r;
         
	static Devices d=new Devices();
	public static void main(String [] args) throws FileNotFoundException, IOException {
		 files ff=new files(); 
		Router r = new Router();
		System.out.println("Please enter the max no. of connections the router can accept: ");
		Scanner n= new Scanner(System.in);
		int max=n.nextInt();
		r.set_value(max);
		System.out.println("Please enter the total no. of devices that wants to connect: ");
		int num=n.nextInt();
               
		ArrayList<Thread> threads = new ArrayList<Thread>(num);
		ArrayList<Devices> devices= new ArrayList<Devices>(num);
		for(int i=0; i<num; i++) {
			System.out.println("Please enter the name and type of device " + (i+1) + ": ");
			String name= n.next();
			String type= n.next();
			Devices c=new Devices(name,type,r);
			devices.add(c);
                }
                
               
             
		for(int i=0; i<num; i++) {
			d=devices.get(i);
			Thread t=new Thread(d);
			t.start();
                        System.out.println("Device: "+ " " + d.get_name()+" " +d.get_type() + " " +"arrivedd" );
           String FileContent="Device: "+ " " + d.get_name()+" " +d.get_type() + " " +"arrivedd";
          ff.writeonfile(FileContent);    
                        
                        
			
		}
               
		
	}

   
}