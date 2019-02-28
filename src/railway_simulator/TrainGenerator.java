package railway_simulator;

import java.util.Random;

public class TrainGenerator implements Runnable {
	private DelayGenerator delayGenerator;
	private Express expressTrain;
	private Local localTrain;
	private Train train;
	private Station s1 = new Station("Glasgow", 3, 100);
//	int NumInStation = s1.getTrains().size();
    private int speed = train.getSpeed();
	public TrainGenerator(Station s1, int speed) {
		this.s1 = s1;
		this.speed  = speed;
	}
		
	public void run() {
		
		try {
			int delay = delayGenerator.getDelay();
//				Random r = new Random();
//				int i = r.nextInt(2);
				Thread.sleep(delay);
				new Thread((new TrainGenerator(s1,train.getSpeed()))).start();
		}catch (InterruptedException e) {
			e.printStackTrace();
			}
	}
}

