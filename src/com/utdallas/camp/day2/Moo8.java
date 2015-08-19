/**
 * 
 */
package com.utdallas.camp.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Rahul
 *
 */
public class Moo8 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static Integer[][] array = null;
	static int  x = 0;
	static boolean xFound = false;
	public static void main(String[] args) throws IOException {
		
		String content;

		FileReader fileReader = new FileReader(new File("D:/UTDallasStudy/JavaProjects/ProblemSolving/src/com/utdallas/camp/day2/photo.in"));

		 BufferedReader br = new BufferedReader(fileReader);

		 String line = null;
		 // if no more lines the readLine() returns null
		 
		 
		 
		 line = br.readLine();
		 int noOfCows = Integer.parseInt(line.trim());
		 array = new Integer[5][20000];
		 Integer[] orig_array = new Integer [noOfCows];
		 for (int i = 0; i < 5; i++) {
			for (int j = 0; j < noOfCows; j++) {
				line = br.readLine();
				array[i][Integer.parseInt(line.trim())] = j;
				orig_array[j] = Integer.parseInt(line.trim());
			}
		}
		 
			 Arrays.sort(orig_array, PhotoComparator);
		 
	
	for (int i = 0; i < orig_array.length; i++) {
			System.out.println(orig_array[i]);
		}
		
		
	}
	
	public static Comparator<Integer> PhotoComparator 
    = new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			int count = 0;
			for (int i = 0; i < array.length; i++) {
				if(array[i][arg0] < array[i][arg1]){
					count+=1;
				}
				
			}
			if(count > 2){
				return 1;
			}else{
				return 0;
			}
		}

};

}
