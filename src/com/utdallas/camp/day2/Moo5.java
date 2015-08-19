/**
 * 
 */
package com.utdallas.camp.day2;

import java.util.Arrays;

/**
 * @author Rahul
 *
 */
public class Moo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int inputNo = 4;
		// int[] inputArray = { 522, 6, 80, 7311 };
		int[] inputArray = { 01, 11, 21, 30, 31, 71, 800, 9000, 1000 };
		Arrays.sort(inputArray);
		int mynum = 0;
		int counter1 = 0;
		int counter2 = 0;
		int counter = 0;

		int c1 = 0;
		int c2 = 0;

		int maxCounter = inputArray.length;
		int j = 1;
		int m = 1;
		boolean isComplete = false;
		while ((inputArray[inputArray.length - 1] / (10 * j)) >= 0
				&& !isComplete) {

			counter1 = 0;
			for (int j2 = inputArray.length - 1; j2 >= 0; j2--) {
				if (mynum + (inputArray[j2] % (10 * j)) / m < 10) {
					mynum = mynum + (inputArray[j2] % (10 * j)) / m;
				} else {
					counter1 = counter1 + 1;
				}
			}
			// System.out.println(mynum);
			if (mynum == 0)
				isComplete = true;
			mynum = 0;
			j = j * 10;
			m = m * 10;

			if (counter1 > c1) {
				c1 = counter1;
			}

		}
		j = 1;
		m = 1;
		isComplete = false;
		while ((inputArray[inputArray.length - 1] / (10 * j)) >= 0
				&& !isComplete) {
			counter2 = 0;
			for (int j2 = 0; j2 <= inputArray.length - 1; j2++) {
				if (mynum + (inputArray[j2] % (10 * j)) / m < 10) {
					mynum = mynum + (inputArray[j2] % (10 * j)) / m;
				} else {
					counter2 = counter2 + 1;
				}
			}
			// System.out.println(mynum);
			if (mynum == 0)
				isComplete = true;
			mynum = 0;
			j = j * 10;
			m = m * 10;
			if (counter2 > c2) {
				c2 = counter2;
			}
		}
		System.out.println(c1);
		System.out.println(c2);
		maxCounter = maxCounter - (c1 > c2 ? c2 : c1);
		System.out.println(maxCounter);
	}
}
