package railway_simulator;
import java.util.Random;
public class Runme {

	public static void main(String[] args) {
		Railway r = new Railway();
		Thread t = new Thread(new PrintStatus(r));
		t.start();
		DelayGenerator delay = new Delay();
		Train express = new Express();
		Train local = new Local();
		final Random rand = new Random();
		
		int i = rand.nextInt(100);
		if (i % 2 == 0) {
//			String id = "E" + i;
//			System.out.println(id);
			new Thread(new TrainGenerator(r,delay,express)).start();
		}
		else {
//			String id = "L" + i;
//			System.out.println(id);
			new Thread(new TrainGenerator(r,delay,local)).start();
		}
		
		
	
	}
}

	

