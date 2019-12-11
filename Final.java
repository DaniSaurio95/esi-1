package Final;

import java.util.Scanner;

public class final {
	
	final public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {


		int row,col,B1,B2;
		row = askRow();
		col = askCol();
		B1 = askB1();
		B2 = askB2();

		int board1[][]= generateBoard(3,3);
		int board2[][]= generateBoard(3,3);
		boolean visual1[][]= generateBoolean(3,3);
		boolean visual2[][]= generateBoolean(3,3);
	}


	public static int askRow() {
		int row;
		System.out.println("Introduce the number of rows: ");
		row = sc.nextInt();
		return row;
	}
	public static int askCol() {
		int col;
		System.out.println("Introduce the number of columns: ");
		col = sc.nextInt();
		return col;
	}
	public static int askB1() {
		int B1;
		System.out.println("Introduce the number of boats of length 1: ");
		B1 = sc.nextInt();
		return B1;
	}
	public static int askB2() {
		int B2;
		System.out.println("Introduce the number of boats of length 2: ");
		B2 = sc.nextInt();
		return B2;
	}


	public static int[][]generateBoard(int a,int b){
		int array1[][]=new int[a][b];

		return array1;
	}
	public static boolean[][]generateBoolean(int a, int b) {
		boolean array2[][]=new boolean[a][b];
		for(int i=0; i<array2.length; i++) {
			for (int j=0; j<array2[0].length; j++) {
				array2[i][j]=true;
			}
		}
		
		return array2;
	}
}
