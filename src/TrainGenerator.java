

//import java.util.Random;

public class TrainGenerator implements Runnable {
	private DelayGenerator delayGenerator;
//	private final Random rand = new Random();
	private Express express;
	private Railway r = new Railway();
	private Local local;
	private Train train;
	private RailwaySection startPos = new Station("Glasgow", 3, 100);
	private String id;
	public TrainGenerator(RailwaySection rs, Railway r,DelayGenerator delayGenerator,Train train,String id) {
		startPos = rs;
		this.r = r;
		this.train = train;
		this.delayGenerator = delayGenerator;
		this.id = id;
	}
		
	public void run() {
		try {
//			while (startPos.getTrains().size()<3) {
			for (int i = 0; i<r.getRailway().length;i++) {
			int delay = delayGenerator.getDelay();
			Thread.sleep(delay);
			RailwaySection position = r.getRailway()[i];
			TrainMover tm = new TrainMover (delay,startPos,r,id);
			Thread m = new Thread(tm,id);
			m.start();
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}
}

