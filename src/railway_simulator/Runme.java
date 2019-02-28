package railway_simulator;

import java.util.Random;

public class Runme {

	public static void main(String[] args) {
		Railway r = new Railway();
		Thread t = new Thread(new PrintStatus(r));
		t.start();
		Station s1 = new Station("Glasgow", 3, 100);
		Delay delay = new Delay();
		Train express = new Express();
		Train local = new Local();
		
		int NumInStation = s1.getTrains().size();
		while (NumInStation<4) {
		int nProduced = 0;
		Random rand = new Random();
		int i = rand.nextInt(2);
		if (i == 0) {
			new Thread(new TrainGenerator(s1,express.getSpeed())).start();
		}
		else {
			new Thread((new TrainGenerator(s1,local.getSpeed()))).start();
		}
		nProduced++;
	}
	}
}
