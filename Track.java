package railway_simulator;

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
public class Track extends RailwaySection{
	private ArrayList<TrainMover> trains = new ArrayList<TrainMover>();
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private TrainMover mover;
	private Railway r;
	int pos = 0;
	
	public Track (String name, int length, int capacity) {
		super(name,capacity,length);
	}
	// make the train enter into a station or a track
//	public void enter(TrainMover occupant) {
//		lock.lock();
//		try {
//			while (mover != null) {
//				cond.await();
//			}
//			mover = occupant;
//			occupant.resetDelay();
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}finally {
//			lock.unlock();
//		}
//	}
//	public void leave() {
//		lock.lock();
//		mover = null;
//		cond.signalAll();
//		lock.unlock();
//	}
	public void enter(TrainMover mover) {
		
//		try {
			for (RailwaySection s: r.railway) {
				
			while (!full(pos,this)) {
				lock.lock();
				cond.signalAll();
				trains.add(mover);
				pos++;
				lock.unlock();
			}
		} 
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}finally {
			
		}
//	}
	
	public void leave() {
		
		try {
			for (RailwaySection s: r.railway) {
				while (full(pos,this)) {
					lock.lock();
					cond.await();
					trains.remove(mover);
					pos --;
					lock.unlock();
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
//		}finally {
//			
		}
	}
	
	public boolean full(int pos, RailwaySection current) {
		boolean full;
		if (pos<current.getCapacity()) {
			full = false;
		}
		else {full = true;}
		return full;
	}
}
	