package com.utdallas.camp.day2;

public class Moo4 {

	public static void main(String[] args) {
	
		String[] lines = {"................",
						  "..XXXX....XXX...",
						  "...XXXX....XX...",
						  ".XXXX......XXX..",
						  "........XXXXX...",
						  ".........XXX...."};
		int[][] myPattern = new int [6][16];
		int[][] patternMapping = new int[1000][2];
		
		for (int i = 0; i < lines.length; i++) {
			String[] chars = lines[i].split("");
			for (int j = 0; j < chars.length; j++) {
				if(!chars[j].isEmpty()){
					if(chars[j].equals(".")){
						myPattern [i][j-1] = 0;
					}else{
						myPattern [i][j-1] = 1;
					}					
				}
			}
		}
		
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				System.out.print(myPattern[i][j]);
			}
			System.out.println("");
		}
		int counter = 0;
		for (int i = 0; i < myPattern.length; i++) {
			for (int j = 0; j < myPattern[i].length; j++) {
				if(myPattern[i][j] == 1){
					patternMapping[counter][0] =i;
					patternMapping[counter][1] =j;
					counter++;
				}
			}
		}
		int rowdistance = 0;
		int coldistance = 0;
		for (int i = 0; i < counter; i++) {
				System.out.print(patternMapping[i][0] + " , ");
				System.out.print(patternMapping[i][1]);
				rowdistance = patternMapping[i+1][0] - patternMapping[i][0];
				coldistance = patternMapping[i+1][1] - patternMapping[i][1];
				System.out.println("");
				if(rowdistance != 1 && coldistance != 1){
					System.out.println(rowdistance);
					System.out.println(coldistance);
				}else{
					 //patternMapping[i+1][0] = 0;
					 patternMapping[i][0]   = 0;
					 //patternMapping[i+1][1] = 0;
					 patternMapping[i][1]   = 0;
				}
			System.out.println("");
		}
		System.out.println("After seperating ...");
		
		for (int i = 0; i < patternMapping.length; i++) {
			if(patternMapping[i][0] != 0 && patternMapping[i][1] != 0){
				System.out.print(patternMapping[i][0] + " , ");
				System.out.print(patternMapping[i][1]);
				System.out.println("");
			}
		}
	}
	
	
}
