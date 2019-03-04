package railway_simulator;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Station extends RailwaySection {
	private ArrayList<TrainMover> trains = new ArrayList<TrainMover>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private TrainMover mover;
	private Railway r;
	int pos = 0;
	public boolean full;
//	public Station (Railway r) {
//		super(r);
//	}
	public Station (String name, int length, int capacity) {
		super(name, length, capacity);
	}
	// make the train enter into a station or a track
	public void enter(TrainMover mover) {
		lock.lock();
		try {
			while(pos == this.getCapacity()) {
				cond.await();
			}
			trains.add(mover);
			pos++;
			full = true;
		}catch(InterruptedException e) {

		}finally {
			lock.unlock();
		}
	}
	
	public void leave() {
		lock.lock();
		trains.remove(mover);
		full = false;
		cond.signalAll();
		lock.unlock();
	}
//	public ArrayList<TrainMover> getTrains(){
//		return trains;
//	}
//	public void setTrains( ArrayList<TrainMover> trains) {
//		this.trains = trains;
//	}
}
