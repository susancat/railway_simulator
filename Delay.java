package railway_simulator;

import java.util.Random;

public class Delay implements DelayGenerator {
	Random r = new Random();
	public int getDelay() {
		int delay = r.nextInt(10000);
		return delay;		
	}
}
