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
			while(space(pos,this) == false) {
				cond.await();
			}
			trains.add(mover);
			pos++;
		}catch(InterruptedException e) {

		}finally {
			lock.unlock();
		}
	}
	
	public void leave() {
		lock.lock();
		while(space(pos,this) == true) {
			cond.signalAll();
		}
	
		lock.unlock();
	}

	public boolean space(int pos, RailwaySection position) {
		boolean space;
		if (pos<position.getCapacity()) {
			space = true;
		}
		else {space = false;}
		return space;
	}
}
