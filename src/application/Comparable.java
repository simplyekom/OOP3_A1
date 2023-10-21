package application;

public interface Comparable<T> {
	int compareTo(T object); 
		/* Comparing shapes' heights. Returns a negative value if the current object is smaller,
		zero if they are equal, and a positive value if it is greater.*/
	boolean[] compare(T object);
		/* Creates an array because we are comparing two different values (base area and volume)
		Will return true if compared shape is smaller.*/
}