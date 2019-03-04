import java.util.Random;

public class TrainMover implements Runnable{
	private Railway r = new Railway();
	private RailwaySection position;
	private RailwaySection next;
	private Train train;
	
	private long delay;
//	private int delay_steps;
	private String id;
//	private int d;
	
	public TrainMover (int d,RailwaySection init, Railway r, String id) {
		delay = d;
		position = init;
		this.r = r;
//		this.delay_steps = 0;
		this.id = id;
	}
	
	public void run() {
		r.getRailway()[0].enter(this);
		for (int i = 1; i<r.getRailway().length-1;i++) {
			try {
				Thread.sleep(5000);
				r.getRailway()[i].enter(this);
				r.getRailway()[i-1].leave();
				r.getRailway()[i-1] = r.getRailway()[i];
			}catch(InterruptedException e) {
//				e.printStackTrace();
				}
		}
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		} r.getRailway()[0].leave();
		}
		
		
	
	public void resetDelay() {
	}

	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}
	public long calSpeed (String id) {
		for (int i = 0;i<r.getRailway().length;i++) {
		if (id.startsWith("E")) {
			 delay = 5000 + 1000 * (r.getRailway()[i].getLength()/500);
		 }
		if (id.startsWith("L")) {
			 delay = 5000 + 1000 * (r.getRailway()[i].getLength()/100);
		 }
		
	}return delay;
}
}