package railway_simulator;

public class Move implements Runnable{
	private int delay;
	private RailwaySection current;
	private RailwaySection next;
	private Railway r;
	
	public Move (int delay, RailwaySection s1, Railway railway) {
		this.delay = delay;
		current = s1;
		this.r = railway;
	}
	
	public void run() {
		current.enter();
		while (getNext(current)!=null) {
			try {
				Thread.sleep(this.delay);
				next.enter();
				current.leave();
				current = next;
			}catch(InterruptedException e) {
		     }
	    }
		try {
			Thread.sleep(this.delay);
		}catch(InterruptedException e) {
			
		}
		current.leave();
	}
	public RailwaySection getNext(RailwaySection current) {
		for (int i = 0; i<r.railway.length; i++) {
			if (r.railway[i] == current ) {
				next = r.railway[i+1];
			}
		}
		return next;
		
	}
	public void resetDelay() {
	}
}
