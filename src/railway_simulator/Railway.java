package railway_simulator;

public class Railway {
	Station s1 = new Station("Glasgow", 3, 100);
	Station s2 = new Station("Stirling", 2, 100);
	Station s3 = new Station("Perth", 2, 100);
	Station s4 = new Station("Inverness", 3, 100);
	Track t1 = new Track("track1",1,1000);
	Track t2 = new Track("track2",1,1000);
	Track t3 = new Track("track3",1,1000);
	RailwaySection[] railway = {s1,t1,s2,t2,s3,t3,s4};
//	private int position = 0;
	
//	public Railway (int position) {
//		for (int i = 0; i<railway.length;i++) {
//			railway [position] = railway [i];
//		}
//	}
	public Railway() {
		
	}
	public void draw() {
		for(int i = 0; i<railway.length;i++) {
			System.out.print("|----" + railway[i].getName() + "--" + Thread.currentThread().getName()  
			                   + "," + Thread.currentThread().getName() + "," + Thread.currentThread().getName() 
			                   + "----|");
		}
	}
}
