package railway_simulator;

//import java.util.Random;

public class TrainGenerator implements Runnable {
	private final DelayGenerator delayGenerator;
//	private final Random rand = new Random();
	private Express express;
	private final Railway r;
	private Local local;
	private final Train train;
	private RailwaySection startPos = new Station("Glasgow", 3, 100);
	private String id;
	public TrainGenerator(RailwaySection rs, Railway r, DelayGenerator delayGenerator,Train train, String id) {
		startPos = rs;
		this.r = r;
		this.delayGenerator = delayGenerator;
		this.train = train;
		this.setId(id);
	}
		
	public void run() {
		try {
//			while (startPos.getTrains().size()<3) {
			for (int i = 0; i<r.getRailway().length;i++) {
			int delay = delayGenerator.getDelay();
			Thread.sleep(delay);
			RailwaySection position = r.getRailway()[i];
			TrainMover tm = new TrainMover (train.getSpeed(),position, r,id);
			Thread m = new Thread(tm,"I am mover");
			m.start();
//			new Thread(new TrainMover(train.getSpeed(),position, r)).start();
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
			}
//			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

