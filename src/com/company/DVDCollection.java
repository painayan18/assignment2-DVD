package com.company;

import java.io.*;
import java.util.Comparator;
import java.util.Locale;

public class DVDCollection {

	// Data fields
	
	/** The current number of DVDs in the array */
	private int numdvds;
	
	/** The array to contain the DVDs */
	private DVD[] dvdArray;
	
	/** The name of the data file that contains dvd data */
	private String sourceName;
	
	/** Boolean flag to indicate whether the DVD collection was
	    modified since it was last saved. */
	private boolean modified;
	
	/**
	 *  Constructs an empty directory as an array
	 *  with an initial capacity of 7. When we try to
	 *  insert into a full array, we will double the size of
	 *  the array first.
	 */
	public DVDCollection() {
		numdvds = 0;
		dvdArray = new DVD[7];
	}
	
	public String toString() {
		// Return a string containing all the DVDs in the
		// order they are stored in the array along with
		// the values for numdvds and the length of the array.
		// See homework instructions for proper format.

		String List = "";

		List = "numdvds = " + numdvds + "\n";
		List = "dvdarray.length = " + dvdArray.length + "\n";

		for (int i = 0; i <+ numdvds; i++) {
			List = List + dvdArray[i].getTitle() + '/'
						+ dvdArray[i].getRating() + '/'
						+ dvdArray[i].getRunningTime() + "\n";
 		}

		return List;
	}

	public void addOrModifyDVD(String title, String rating, String runningTime) {
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.



	
	}

	public void removeDVD(String title) {

		title.toUpperCase();
		boolean titleMatch = false;

		for (int i = 0; i < dvdArray.length; i++) {
			DVD currentDVD = dvdArray[i];
			for (int j = 0; j < title.length(); j++) {
				//if (title[j] == dvdArray){

			}
		}
	}
		

	
	public String getDVDsByRating(String rating) {






		return null;	// STUB: Remove this line.

	}

	public int getTotalRunningTime() {







		return 0;	// STUB: Remove this line.

	}

	
	public void loadData(String filename) {






		
	}
	
	public void save() {







	}

	// Additional private helper methods go here:

	public int dvdSearch(String titles) {
		if (numdvds > 0) {
			for (int i = 0; i < numdvds; i++) {
				if (dvdArray[i].getTitle().equals(titles))
					return i;
			}
		}
		return -1;
	}
}

class dvdSort implements Comparator<DVD> {
	public int compare(DVD one, DVD two) {
		return one.getTitle().compareTo((two.getTitle()));
	}
}
