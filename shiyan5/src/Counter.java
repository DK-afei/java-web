
public class Counter {
	private int counter=0;

	public Counter(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	public void add()
	{
		this.setCounter(this.counter+1);
	}
}
