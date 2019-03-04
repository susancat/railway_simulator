public class Railway {
//	int j;
	private Station s1 = new Station("Glasgow", 3,100);
	private Station s2 = new Station("Stirling", 3, 100);
	private Station s3 = new Station("Perth", 3, 100);
	private Station s4 = new Station("Inverness", 3, 100);
	private Track t1 = new Track("track",1,1000);
	private Track t2 = new Track("track",1,1000);
	private Track t3 = new Track("track",1,1000);
	
	private RailwaySection[] railway = {s1,t1,s2,t2,s3,t3,s4};
	public Railway() {
		
	}
	
	public void draw() {
//		for(int i = 0; i<getRailway()[i].getTrains().size();i++) {
			System.out.print("|----" + s1.getName() + "-" + s1.getTrains().toString() + " ----|" 
						   + "|----" + t1.getName() + "-" + t1.getTrains().toString() + "----|" 
						   + "|----" + s2.getName() + s2.getTrains().toString() + "----|" 
						   + "|----" + t2.getName() + t2.getTrains().toString() + "----|" 
						   + "|----" + s3.getName() + s3.getTrains().toString() + "----|" 
						   + "|----" + t3.getName() + t3.getTrains().toString() + "----|" 
						   + "|----" + s4.getName() + s4.getTrains().toString() + "----|" );
//			
//		}
	}
	public String toString() {
		String str = null;
		for (int i = 0;i<getRailway().length;i++) {
		for (int j = 0;i<getRailway()[i].getTrains().size();i++) {
		str = getRailway()[i].getTrains().get(j).getId();
		}
		
	}
		return str;
	}
	public RailwaySection[] getRailway() {
		
		return railway;
	}
}
