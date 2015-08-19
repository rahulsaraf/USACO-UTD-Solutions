/**
 * 
 */
package com.utdallas.camp.day2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rahul
 *
 */
public class PaintingFence {

	/**
	 * @param args
	 */
	
	static Scanner scan;
    static PrintWriter out;
    static int leastNoOfCoats;
    static ArrayList<Position> positions = new ArrayList<Position>();
	
	public static void main(String[] args) throws Exception {
		 scan = new Scanner(new File("D:/UTDallasStudy/JavaProjects/ProblemSolving/src/com/utdallas/camp/day2/painting.in"));
		 out = new PrintWriter(new BufferedWriter(new FileWriter("D:/UTDallasStudy/JavaProjects/ProblemSolving/src/com/utdallas/camp/day2/painting.out")));
		 compute();
		 out.close();
	}

	private static void compute() {
		
		int noOfMoves = scan.nextInt();
		leastNoOfCoats = scan.nextInt();
		
		int[][] moveGrid = new int[noOfMoves][2];
		
		for (int i = 0; i < noOfMoves; i++) {
			int move = scan.nextInt();
			String direction = scan.next();
			if(direction.equals("R")){
				moveGrid[i][0] = 0;
				moveGrid[i][1] = move;
			}else{
				moveGrid[i][0] = 1;
				moveGrid[i][1] = move;
			}
		}
		int start=0,end = 0;
		for (int i = 0; i < moveGrid.length; i++) {
			end = (moveGrid[i][0] == 0) ? end + moveGrid[i][1] : end - moveGrid[i][1];
			if(moveGrid[i][0] == 1){
				positions.add(new Position(end, start, 1));
			}else{
				positions.add(new Position(start, end, 1));	
			}
			insureCoats(positions,i);
			start = end;
		}
		int count = 0;
		int sum = 0;
		ArrayList<Position> finalList = new ArrayList<Position>();
		for (int i = 0; i < positions.size(); i++) {
			if(positions.get(i).getCount() >= leastNoOfCoats){
				System.out.println(positions.get(i).getStart()+", " + positions.get(i).getEnd()+" - count = " + positions.get(i).getCount());
				finalList.add(new Position(positions.get(i).getStart(),positions.get(i).getEnd(),positions.get(i).getCount()));
				count++;
			}
		}

		
		int fstart =0,fend=0,fcount=0;
		ArrayList<Position> finalList1 = new ArrayList<Position>();
		for (int i = 0; i < finalList.size(); i++) {
			fstart = finalList.get(i).getStart();
			fend = finalList.get(i).getEnd();
			fcount = finalList.get(i).getCount();
			for (int j = 0; j < finalList.size(); j++) {
				if(fend == finalList.get(j).getStart() && fcount == finalList.get(j).getCount()){
					finalList.get(i).setEnd(finalList.get(j).getEnd());
					finalList.get(j).setCount(-1);
				}
			}
		}
		
		for (int i = 0; i < finalList.size(); i++) {
			for (int j = 0; j < finalList.size(); j++) {
				if(i!=j && finalList.get(i).equals(finalList.get(j))){
					finalList.get(i).setCount(finalList.get(i).getCount() + finalList.get(i).getCount());
				}
			}
		}
		
		
		
		
		System.out.println(sum);
 	}

	private static void insureCoats(ArrayList<Position> positions, int i) {
		Position current = positions.get(i);
		for (int j = i-1; j >= 0; j--) {
			Position prev = positions.get(j);
			if(prev.getCount() < leastNoOfCoats){
				current.exists(prev);				
			}
		}
	}
}

class Position{
	
	private int start;
	private int end;
	private int count;
	
	public Position(int start, int end, int count){
		this.start = start;
		this.end = end;
		this.count = count;
	}
	
	public void exists(Position prev) {
		if (this.getEnd() - prev.getStart() >= 0 && prev.getEnd() - this.getStart() >=0 ){
			int start = this.getStart() > prev.getStart()?this.getStart():prev.getStart();
			int end = prev.getEnd()<this.getEnd()?prev.getEnd():this.getEnd();
			Position p = null;
			if(start > end){
			p = new Position(end, start, 1);
			}else if(end > start){
			p = new Position(start, end, 1);
			}
			if(null != p ){
				int i = PaintingFence.positions.indexOf(p);
				if(!PaintingFence.positions.contains(p)){					
					PaintingFence.positions.add(p);
				}else{
					i = PaintingFence.positions.indexOf(p);
					PaintingFence.positions.get(i).setCount(PaintingFence.positions.get(i).getCount() + 1);
				}
			}
			
		}
	}

	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public boolean equals(Object o) {  
	        if (o == this) {
	            return true;
	        }
	 
	        Position p = (Position)o;
	        
	        
	        	if(p.getEnd() == this.getEnd()){
	        		if(p.getStart() == this.getStart()){
	        			return true;
	        		}
	        	}
	        
	        return false;
	 
	 }
}