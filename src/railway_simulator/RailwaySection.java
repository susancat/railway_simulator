package railway_simulator;

import java.util.ArrayList;

public abstract class RailwaySection {
	private int capacity;
	private String name;
	private int length;
	private TrainMover mover;
	private Railway r;
//	private ArrayList<TrainMover> trains = new ArrayList<TrainMover>();
//	public RailwaySection (Railway r) {
//		this.r = r;
//	}
	public RailwaySection(String name, int length, int capacity) {
	this.name = name;
	this.length = length;
	this.capacity = capacity;
	}
	
	public abstract void enter(TrainMover mover);
	public abstract void leave();
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
