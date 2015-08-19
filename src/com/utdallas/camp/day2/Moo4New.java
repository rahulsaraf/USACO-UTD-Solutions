/**
 * 
 */
package com.utdallas.camp.day2;

/**
 * @author Rahul
 *
 */
public class Moo4New {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] lines = {"................",
						  "..XXXX..........",
						  "...XXXX.........",
						  ".XXXX...........",
						  "................",
						  ".........XXX...."};
		int[][] myPattern = new int [6][16];
		int[][] patternMapping1 = new int[1000][2];
		int[][] patternMapping2 = new int[1000][2];
		int spotNo = 1;
		for (int i = 0; i < lines.length; i++) {
			String[] chars = lines[i].split("");
			for (int j = 0; j < chars.length; j++) {
				if(!chars[j].isEmpty()){
					if(chars[j].equals(".")){
						myPattern [i][j-1] = 0;
					}else{
						myPattern [i][j-1] = 9;
					}					
				}
			}
		}
		
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				//assignSpotNo(myPattern,i,j,spotNo);
				System.out.print(myPattern[i][j]);
			}
			System.out.println("");
		}
		
		
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				if(myPattern[i][j] == 9){
				assignSpotNo(myPattern,i,j,spotNo++);
				}
			}
		}
		
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				if(myPattern[i][j] == 1){
					patternMapping1[counter1][0] =i;
					patternMapping1[counter1][1] =j;
					counter1++;
				}else if(myPattern[i][j] == 2){
					patternMapping2[counter2][0] = i;
					patternMapping2[counter2][1] = j;
					counter2++;
				}
			}
		}
		int rowdistance = 0;
		int coldistance = 0;
		int mindistance = 10000;
		int finPoint1row = 0;
		int finPoint1col = 0;
		int finPoint2row = 0;
		int finPoint2col = 0;
		for (int i = 0; i < counter1; i++) {
			for (int j = 0; j < counter2; j++) {
				rowdistance = Math.abs(patternMapping2[j][0] - patternMapping1[i][0]);
				coldistance = Math.abs(patternMapping2[j][1] - patternMapping1[i][1]);
				if(mindistance > (rowdistance + coldistance)){
					mindistance = rowdistance + coldistance;
					finPoint1row = patternMapping1[i][0];
					finPoint1col = patternMapping1[i][1];
					finPoint2row = patternMapping2[j][0];
					finPoint2col = patternMapping2[j][1];
				}
			}
		}
		System.out.println("first " +finPoint1row + ", " + finPoint1col);
		System.out.println("second " +finPoint2row + ", " + finPoint2col);
		joinSpots(myPattern,finPoint1row,finPoint2row,finPoint1col,finPoint2col);
		
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				System.out.print(myPattern[i][j]);
			}
			System.out.println("");
		}
	}

	private static void joinSpots(int[][] myPattern, int finPoint1row,int finPoint2row, int finPoint1col, int finPoint2col) {
		boolean isReached = false; 
		while(!isReached){
			if(Math.abs(finPoint1row - finPoint2row) > 1){
				myPattern[++finPoint1row][finPoint1col] = 3;
			}else if(Math.abs(finPoint1col - finPoint2col) >= 1){
				myPattern[finPoint1row][++finPoint1col] = 3;
			}else{
				isReached = true;
			}
		}
	}

	private static void assignSpotNo(int[][] myPattern, int i, int j, int k) {
		
		if(myPattern[i][j] != 9){
			return;
		}
		myPattern[i][j] = k;
		if(i < myPattern.length - 1)
		assignSpotNo(myPattern, i+1,j,k);
		if(j < myPattern[i].length - 1)
		assignSpotNo(myPattern, i,j+1,k);
		if(i > 0)
		assignSpotNo(myPattern, i-1,j,k);
		if(j > 0)
		assignSpotNo(myPattern, i,j-1,k);
		
	}	
}
