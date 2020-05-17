package entity;

import java.util.HashMap;
import java.util.Map;

public class Shoppingcart {
	private int number;
	private Map<String,Integer> items = new HashMap<String,Integer> ();
	public void addItem(String book_name)
	{
		if(this.getItems().containsKey(book_name))
		{
			this.setNumber(this.getItems().get(book_name)+1);
			this.getItems().remove(book_name);
			this.getItems().put(book_name, this.getNumber());
		}
		else
		{
			this.setNumber(1);
			this.getItems().put(book_name, this.getNumber());
		}
	}
	public int get()
	{
		int sum=0;
		for(String k:this.getItems().keySet())
	    {
	    	sum+=this.getItems().get(k);
	    }
		return sum;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	/**
	 * @return the items
	 */
	public Map<String, Integer> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(Map<String, Integer> items) {
		this.items = items;
	}
}
