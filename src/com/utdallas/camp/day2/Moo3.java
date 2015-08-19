/**
 * 
 */
package com.utdallas.camp.day2;

import java.util.Arrays;

/**
 * @author Rahul
 *
 */
public class Moo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] notes = new int[6];
		int [] notes = {1,8,5,7,9,10};
		int [] chords = {4,6,7};
		int [] cordsCopy = {4,6,7};
		int counter = 0;
		int [] positions= new int[10000]; 
		for (int i = 0; i < notes.length && (notes.length - i >= chords.length); i++) {
			int [] chordsFromSong = new int[chords.length];
			for (int j = 0; j < chords.length; j++) {
				chordsFromSong[j] = notes[i+j];
			}
			Arrays.sort(chordsFromSong);
			Arrays.sort(cordsCopy);
			int minS=chordsFromSong[0] + 1;
			int minC=cordsCopy[0] + 1;
			for (int j = 0; j < chordsFromSong.length; j++) {
				chordsFromSong[j] = chordsFromSong[j] - minS ;
				cordsCopy[j] = cordsCopy[j] - minC ;
			}
			if(checkIfBothArraysMatches(chordsFromSong, cordsCopy)){
				positions[counter] = i + 1;
				counter++;		
			}
		}
		System.out.println("Number of Chords = " + counter);
		for (int i = 0; i < counter; i++) {
				System.out.println("Position of Chords = " + positions[i]);				
		}
	}
	private static boolean checkIfBothArraysMatches(int[] chordsFromSong,int[] cordsCopy) {
		for (int i = 0; i < cordsCopy.length; i++) {
			if(chordsFromSong[i] != cordsCopy[i]){
				return false;
			}
		}
		return true;
	}
}
