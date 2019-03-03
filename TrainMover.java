package railway_simulator;

public class TrainMover implements Runnable{
	private RailwaySection position;
	private RailwaySection next;
	private Train train;
	private Railway r;
	private int delay = 5200;
//	private int delay_steps;
	private String id;
	private int d;
	
	public TrainMover (int d,RailwaySection init, Railway r, String id) {
		delay = d;
		position = init;
		this.r = r;
//		this.delay_steps = 0;
//		this.setId(id);
		this.id = id;
	}
	
	public void run() {
		position.enter(this);
		while (this.getNext(position, r)!=null) {
			try {
				Thread.sleep(this.delay);
				next.enter(this);
				position.leave();
				position = next;
			}catch(InterruptedException e) {
//				e.printStackTrace();
				}
		}
		try {
			Thread.sleep(this.delay);
		}catch(InterruptedException e) {
			
		}
		position.leave();
		
		
	}
	public RailwaySection getNext(RailwaySection position,Railway r) {
		for (int i = 0; i<r.getRailway().length - 1; i++) {
			try {
			if (r.getRailway()[i] == position ) {
				next = r.getRailway()[i+1];
			}
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				}
			}
		return next;
	}
	public void resetDelay() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
