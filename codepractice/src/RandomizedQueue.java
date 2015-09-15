import java.util.Iterator;


public class RandomizedQueue<Item>implements Iterable<Item>  {
	private Item[] items;
	private int size;s
	private class MyIterator implements Iterator<Item> {
		private int current;
		public boolean hasNext() {
			
		}
		 public void remove() { 
			 throw new UnsupportedOperationException();
			 }
		 public Item next()
		 {
		
		 }
	}
	
	
	 public RandomizedQueue()                 // construct an empty randomized queue
	 {}
	 public boolean isEmpty()                 // is the queue empty?
	 {
		 return size==0;
	 }	 
	 public int size()                        // return the number of items on the queue
	 {
		 return size;
	 }
	 public void enqueue(Item item)           // add the item
	 {}
	 public Item dequeue()                    // remove and return a random item
	 {}
	 public Item sample()                     // return (but do not remove) a random item
	 {}
	 public Iterator<Item> iterator()         // return an independent iterator over items in random order
	 {}
	 public static void main(String[] args)   // unit testing

}

