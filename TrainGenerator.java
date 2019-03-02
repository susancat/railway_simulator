package railway_simulator;

//import java.util.Random;

public class TrainGenerator implements Runnable {
	private final DelayGenerator delayGenerator;
//	private final Random rand = new Random();
	private Express express;
	private final Railway r;
	private Local local;
	private final Train train;
//	private RailwaySection rs;
	    
	public TrainGenerator(Railway r, DelayGenerator delayGenerator,Train train) {
		this.r = r;
		this.delayGenerator = delayGenerator;
		this.train = train;
	}
		
	public void run() {
		try {
			int delay = delayGenerator.getDelay();
			Thread.sleep(delay);
			new Thread(new TrainMover(train.getSpeed(),r.railway[0],r)).start();
//			int i = rand.nextInt(100);
//			if (i % 2 == 0) {
//				String id = "E" + i;
//				System.out.println(id);
//				new Thread(new TrainMover(express.getSpeed(),r.railway[0],r, id)).start();
//			}
//			else {
//				String id = "L" + i;
//				System.out.println(id);
//				new Thread(new TrainMover(local.getSpeed(),r.railway[0],r, id)).start();
//			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

