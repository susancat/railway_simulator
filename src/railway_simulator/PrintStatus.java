package railway_simulator;

public class PrintStatus implements Runnable {
	private int status;
	private Railway railway;
	public PrintStatus(Railway railway) {
		this.railway = railway;
		status = 0;
	}
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000);
				System.out.println(status++);
				railway.draw();
			}
		}catch(InterruptedException e) {
			
		}
	}
}
