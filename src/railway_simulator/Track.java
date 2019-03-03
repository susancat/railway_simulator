package railway_simulator;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
public class Track extends RailwaySection{
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private TrainMover occupant = null;
	private Railway r;
		
//	public Track (Railway r) {
//		super(r);
//	}
	public Track (String name, int length, int capacity) {
		super(name,capacity,length);
	}
	public void enter(TrainMover mover) {
		lock.lock();
		try {
			while(occupant != null) { 
				cond.await();
			}
			occupant = mover;
			mover.resetDelay();
		}catch(InterruptedException e) {

		}finally {
			lock.unlock();
		}
	}
	public void leave() {
		lock.lock();
		occupant = null;
		cond.signalAll();
		lock.unlock();
	}
}