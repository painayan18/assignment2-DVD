package com.company;

import javax.annotation.processing.Filer;
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

		String listDVDs = "";

		listDVDs =    "numdvds = " + numdvds + "\n"
				+ "dvdarray.length = " + dvdArray.length + "\n";

		for (int i = 0; i <+ numdvds; i++) {
			listDVDs +=   dvdArray[i].getTitle() + '/'
					+ dvdArray[i].getRating() + '/'
					+ dvdArray[i].getRunningTime() + "\n";
 		}

		return listDVDs;
	}

	public void addOrModifyDVD(String title, String rating, String runningTime) {
		// NOTE: Be careful. Running time is a string here
		// since the user might enter non-digits when prompted.
		// If the array is full and a new DVD needs to be added,
		// double the size of the array first.

		try {

			if (numdvds == dvdArray.length)
				dvdArray = java.util.Arrays.copyOf(dvdArray, dvdArray.length*2);

			// convert runningTime back to String from int
			int runTime = Integer.parseInt(runningTime);

			boolean dvdExists = false;

			for (int i = 0; i < numdvds; i++) {
				if (!dvdExists)
					if (dvdArray[i].getTitle().compareToIgnoreCase(title) == 0) {
						dvdArray[i].setRating(rating);
						dvdArray[i].setRunningTime(runTime);
						dvdExists = true;
					}
				modified = true;
			}

			if (!dvdExists) {
				DVD newDVD = new DVD(title, rating, runTime);
				dvdArray[numdvds++] = newDVD;
				java.util.Arrays.sort(dvdArray);
			}

		} catch (NumberFormatException error) {
			System.out.println("Run time format is invalid.");
		}
	}

	public void removeDVD(String title) {

		for (int i = 0; i < numdvds; i++) {
			if (dvdArray[i].getTitle().compareToIgnoreCase(title) == 1) {
				for (int j = i; j < numdvds-1; j++) {
					dvdArray[i] = dvdArray[i + 1];
					dvdArray[i+1] = null;
				}
			}
		}
	}
	
	public String getDVDsByRating(String rating) {

		String listByRating = "";

		for (int i = 0; i < numdvds; i++) {
			if (dvdArray[i].getRating().compareTo(rating) == 1)
				listByRating += dvdArray[i].toString() + "\n";
		}

		return listByRating;
	}

	public int getTotalRunningTime() {

		if (numdvds == 0)
			return 0;

		int totalRunningTime = 0;

		for (int i = 0; i < numdvds; i++) {
			totalRunningTime += Integer.parseInt(dvdArray[i].getRating());
		}

		return totalRunningTime;
	}

	
	public void loadData(String filename) {

		BufferedReader file;

		try {
			file = new BufferedReader(new FileReader(filename));
			sourceName = filename;
			String line = file.readLine();

			while (line != null) {
				String[] dvdData = line.split(",");
				addOrModifyDVD(dvdData[0], dvdData[1], dvdData[2]);
			}

			file.close();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	public void save() {

		try {
			FileWriter file = new FileWriter("filename.txt");
			for (int i = 0; i < numdvds; i++) {
				file.write(dvdArray[i].getTitle() + "/"
							+ dvdArray[i].getRating() + "/"
							+ dvdArray[i].getRunningTime()
							+ "\n");
			}
		} catch (IOException e) {
			System.out.println("An error occurred: Could not find the file.");
		}
	}

	// Additional private helper methods go here:

	public int dvdSearch(String title) {
		if (numdvds > 0) {
			for (int i = 0; i < numdvds; i++) {
				if (dvdArray[i].getTitle().equals(title))
					return i;
			}
		}
		return -1;
	}
}

//class dvdSort implements Comparator<DVD> {
//	public int compare(DVD one, DVD two) {
//		return one.getTitle().compareTo((two.getTitle()));
//	}
//}

