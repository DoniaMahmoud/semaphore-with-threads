import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class files {
	private String location="D:\\NetBeans\\testtt.txt";
	public void writeonfile(String str) {
		 
			try {
				 BufferedWriter writer;
				writer = new BufferedWriter(new FileWriter(location, true));
				   
		    	    writer.append(str);
		    	    writer.newLine();
		    	    writer.close();
		    		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void clearfilecontent() {
		PrintWriter writer;
		try {
			writer = new PrintWriter(location);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}