package railway_simulator;

public class TrainMover implements Runnable{
	private RailwaySection current;
//	private RailwaySection next;
	private Train train;
	private Railway r;
	private int delay;
//	private String id;
	private int d;
	
	public TrainMover (int d, RailwaySection init, Railway r) {
		this.d = d;
		this.current = init;
		this.r = r;
//		this.setId(id);
	}
	
	public void run() {
		current.enter(this);
//		train.getSpeed()
		delay = (current.getLength()/500) + 5000;
		System.out.println(current.getLength());
//		while (getNext(current)!=null) {
			try {
//				next.enter(this);
				current.enter(this);
				Thread.sleep(delay);
				current.leave();
//				current = next;
			}catch(InterruptedException e) {
		     }
	    
		
	}
//	public RailwaySection getNext(RailwaySection current) {
//		for (int i = 0; i<r.railway.length; i++) {
//			if (r.railway[i] == current ) {
//				next = r.railway[i+1];
//			}
//		}
//		return next;
//		
//	}
//	public void resetDelay() {
//	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
}
