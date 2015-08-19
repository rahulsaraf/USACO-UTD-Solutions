package com.utdallas.camp.day2;

public class Moo6 {

	static int n = 0;
	static int[][] a = new int[5][5];

	public static void main(String[] args) {

		n = 2;
		for (int i = 0; i < n; i++) {
			a[2][i] = 1;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println(countNoOfPaths(0, 0));

	}

	private static int countNoOfPaths(int i, int j) {
		int count = 0;
		if (i < 0 || i > 4 || j < 0 || j > 4 || a[i][j] != 0)
			return 0;
		a[i][j] = 1;
		n++;
		if (n == 25 && i == 4 && j == 4)
			count = 1;
		else
			count = countNoOfPaths(i - 1, j) + countNoOfPaths(i + 1, j)
					+ countNoOfPaths(i, j - 1) + countNoOfPaths(i, j + 1);
		a[i][j] = 0;
		n--;
		return count;
	}
}
