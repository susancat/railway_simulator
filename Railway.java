package railway_simulator;

public class Railway {
	private Station s1 = new Station("Glasgow", 3, 100);
	private Station s2 = new Station("Stirling", 2, 100);
	private Station s3 = new Station("Perth", 2, 100);
	private Station s4 = new Station("Inverness", 3, 100);
	private Track t1 = new Track("track",1,1000);
	private Track t2 = new Track("track",1,1000);
	private Track t3 = new Track("track",1,1000);
	
	RailwaySection[] railway = {s1,t1,s2,t2,s3,t3,s4};
//	private int position = 0;
	
//    public RailwaySection getNext (int position) {
//		for (int i = 0; i<railway.length;i++) {
//			railway [position] = railway [i];
	//		}
//  }
	public Railway() {
	}
	public void draw() {
		for(int i = 0; i<railway.length;i++) {
			System.out.print("|----" + railway[i].getName() + "--" + Thread.currentThread().getId()+ "----|");
//			railway[i].getTrains().toString()
		}
	}
}
