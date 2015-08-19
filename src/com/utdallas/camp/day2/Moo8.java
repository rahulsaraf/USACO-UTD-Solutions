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
		 
		/*int[] newArray = new int[noOfCows+1];
		int count = 0;
		boolean var = false;

		for (int i = 0; i < orig_array.length - 1; i++) {
			if(checkIfMatches(orig_array[i],orig_array[i+1],array)){
				newArray[count] = orig_array[i];
				newArray[count+ 1] = orig_array[i+1];
				count++;
				var = true;
			}else if(var){
				count++;
				count++;
				var = false;
			}

		}
		
*/		
	for (int i = 0; i < orig_array.length; i++) {
			System.out.println(orig_array[i]);
		}
		
		
	}

	private static boolean checkIfMatches(int prev, int next, int[][] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length - 1; j++) {
				if((array[i][j] == prev && array[i][j+1] == next)){
					if(prev == 18 || next ==18){
						System.out.println("here");
					}
					result = result + 1;
				}
			}
		} 
		
		
		
		// || (array[i][j] == next && array[i][j+1] == prev)
		
		if(result > 2){
			return true;
		}else{
			if(x == 0){
				x = next;				
			}else if(x == prev){
				xFound = true;
			}
		}
		return false;
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
