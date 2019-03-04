

import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
public class Track extends RailwaySection{
	private ReentrantLock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	private TrainMover mover;
	private Railway r;
	private ArrayList<TrainMover> trains = new ArrayList<TrainMover>();
	int pos = 0;
	public boolean full;
	
	public Track (String name, int length, int capacity) {
		super(name,capacity,length);
	}
	public void enter(TrainMover mover) {
		lock.lock();
		try {
			while(pos == 1) {
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
		trains.remove(0);
		pos--;
		full = false;
		cond.signalAll();
		lock.unlock();
	}
	public ArrayList<TrainMover> getTrains(){
		return trains;
	}
}