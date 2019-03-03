package railway_simulator;

public class Railway {
//	int j;
	private Station s1 = new Station("Glasgow", 3, 100);
	private Station s2 = new Station("Stirling", 2, 100);
	private Station s3 = new Station("Perth", 2, 100);
	private Station s4 = new Station("Inverness", 3, 100);
	private Track t1 = new Track("track",1,1000);
	private Track t2 = new Track("track",1,1000);
	private Track t3 = new Track("track",1,1000);
	
	private RailwaySection[] railway = {s1,t1,s2,t2,s3,t3,s4};
	public Railway(RailwaySection[] railway) {
		this.setRailway(railway);
	}
	
	public void draw() {
		for(int i = 0; i<getRailway().length;i++) {
			System.out.print("|----" + getRailway()[i].getName() + "--" + getRailway()[i].getTrains().get(i).getId()+ "----|");
//			railway[i].getTrains().toString()
		}
	}

	public RailwaySection[] getRailway() {
		return railway;
	}

	public void setRailway(RailwaySection[] railway) {
		this.railway = railway;
	}
}
