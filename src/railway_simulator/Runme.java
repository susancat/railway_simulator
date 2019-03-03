package railway_simulator;
import java.util.Random;
public class Runme {

	public static void main(String[] args) {
		Station s1 = new Station("Glasgow", 3, 100);
		Station s2 = new Station("Stirling", 2, 100);
		Station s3 = new Station("Perth", 2, 100);
		Station s4 = new Station("Inverness", 3, 100);
		Track t1 = new Track("track",1,1000);
		Track t2 = new Track("track",1,1000);
		Track t3 = new Track("track",1,1000);
		RailwaySection[] railway = {s1,t1,s2,t2,s3,t3,s4};
		Railway r = new Railway(railway);
		RailwaySection rs;
				
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
			new Thread(new TrainGenerator(railway[0],r,delay,express)).start();
		}
		else {
//			String id = "L" + i;
//			System.out.println(id);
			new Thread(new TrainGenerator(railway[0],r,delay,local)).start();
		}
		
		
	
	}
}

	

