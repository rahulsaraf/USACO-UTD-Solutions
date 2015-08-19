package com.utdallas.camp.day2;

public class Moo5New {
	static int n,best = 0;
	
	public static void main(String[] args) {
		//int[] inputArray = { 01, 11, 21, 30, 31, 71, 800, 9000, 1000,100 };
		int[] inputArray = { 522, 6, 80, 7311 };
		n = inputArray.length;
		tryAllCombinations(inputArray, 0, 0 ,0);
		System.out.println(best);
	}

	private static void tryAllCombinations(int[] inputArray, int i, int sum, int count) {
		if(count>best) {
			best = count;
		}
		if(i >= n) {
			return;
		}
		if(checkIfSumCarries(sum, inputArray[i])){
			tryAllCombinations(inputArray,i + 1,sum+inputArray[i],count + 1);
		}
		tryAllCombinations(inputArray,i + 1,sum,count);
	}

	private static boolean checkIfSumCarries(int x, int y) {
		while(x>0 && y>0){
			if(x%10 + y%10 >= 10) {
				return false;
			}
			 x = x / 10; y = y / 10;
		}
		return true;
	}
}