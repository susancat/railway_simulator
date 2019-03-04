
import java.util.Random;
public class Runme {

	public static void main(String[] args) {
		Railway r = new Railway();
		RailwaySection rs;
				
		Thread t = new Thread(new PrintStatus(r));
		t.start();
		DelayGenerator delay = new Delay();
		Train express = new Express();
		Train local = new Local();
		final Random rand = new Random();
		
		while (r.getRailway()[0].getTrains().size()<3) {
		int i = rand.nextInt(100);
		
			if (i % 2 == 0) {
				String id = "E" + i;
//			System.out.println(id);
			TrainGenerator tg1 = new TrainGenerator(r.getRailway()[0],r,delay,express,id);
			Thread e = new Thread(tg1,id);
			e.start();
//			new Thread(new TrainGenerator(s1,r,delay,express,id)).start();
			}
			else {
				String id = "L" + i;
//			System.out.println(id);
			TrainGenerator tg2 = new TrainGenerator(r.getRailway()[0],r,delay,local,id);
			Thread l = new Thread(tg2,id);
//				new Thread(new TrainGenerator(s1,r,delay,local,id)).start();
			l.start();
			}
		}
		
		
	
	}
}

	

