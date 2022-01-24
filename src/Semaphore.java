
public class Semaphore {
  protected int counter =0;
  protected Semaphore() {
	  counter=0;
  }
  protected Semaphore(int initial) {
	  counter=initial;
  }
  public synchronized int acquire() {
	  counter--;
	  int pos=0;
	  if(counter<0) 
		  try {
		  this.wait();
		  pos=-1;
		  
		  }
		  catch(InterruptedException e) {}
		
		 return pos; 
	  
  }
	  public synchronized void release() {
		  counter++;
		  if(counter<=0)
			  this.notify();
		  
	  }
  }

