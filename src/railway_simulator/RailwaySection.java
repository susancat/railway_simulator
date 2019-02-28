package railway_simulator;

public abstract class RailwaySection {
	private int capacity;
	private String name;
	private int length;
	
	public RailwaySection(String name, int capacity, int length) {
	this.name = name;
	this.capacity = capacity;
	this.length = length;
	}
	
	public abstract void enter();
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
