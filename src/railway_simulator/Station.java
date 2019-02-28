package railway_simulator;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Station extends RailwaySection {
	private ArrayList<Train> trains = new ArrayList<Train>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	public Station (String name, int capacity, int length) {
		super(name,capacity,length);
	}
	// make the train enter into a station or a track
	public void enter() {
		lock.lock();
		try {
			while (this.trains.size()>this.getCapacity()) {
				cond.await();	
			}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		
	public void leave() {
		lock.lock();
		while (this.trains.size()<this.getCapacity()) {
		cond.signalAll();}
		lock.unlock();
	}

	public void setTrains(ArrayList<Train> trains) {
		this.trains = trains;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}
	
}

