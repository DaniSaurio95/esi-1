package FInal;

import java.util.Scanner;

public class Final {
	
	final public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int row,col,B1,B2;
		row = askDimension("rows");
		col = askDimension("columns");
		B1 = askB1();
		B2 = askB2();
		int board1[][]= generateBoard(row,col);
		int board2[][]= generateBoard(row,col);
		int visual1[][]= generateVisual(row,col);
		int visual2[][]= generateVisual(row,col);
		int numRows = board1.length;

	}

	public static int askDimension(String message) {
		int dimension;
		do{
		System.out.println("Introduce the number of "+message+": ");
		dimension = sc.nextInt();
		}while(dimension>=3);
		return dimension;
	}
	public static int askB1() {
		int B1;
		do{
		System.out.println("Introduce the number of boats of length 1: ");
		B1 = sc.nextInt();
		}while(B1>=0);
		return B1;
	}
	public static int askB2() {
		int B2;
		do{
		System.out.println("Introduce the number of boats of length 2: ");
		B2 = sc.nextInt();
		}while(B2>=0);
		return B2;
	}
	
	public static int[][]generateBoard(int row,int col,int b1, int b2){
		
	//B1
	int a,b;
	int array1[][]=new int[row][col];
	for(int i=0;i<b1;i++) {
		do {
			System.out.println("Introduce the row you want your B1 boat to be: [0,"+ row+"]");
			a = sc.nextInt();
			System.out.println("Introduce the column you want your B1 boat to be: [0,"+ col+"]");
			b = sc.nextInt();
		}while(a<0 || a>row || b<0 || b>col || (array1[a-2][b-1]==1) || (array1[a][b-1]==1) || (array1[a-1][b-2]==1) || (array1[a-1][b]==1) );	
			
		array1[a-1][b-1]=1;
	}
		
	//B2
	String direction, upOrDown, leftOrRight;
	for(int i=0;i<b2;i++) {
		do {
		System.out.println("Introduce the row you want your B2 boat to be: [0,"+ row+"]");
		a = sc.nextInt();
		System.out.println("Introduce the column you want your B2 boat to be: [0,"+ col+"]");
		b = sc.nextInt();
		}while(a<0 || a>row || b<0 || b>col);
		array1[a-1][b-1]=2;
		do {
		System.out.println("Do you want to place it vertically (v) or horizontaly (h)? ");
		direction = sc.next();
		}while(!direction.equalsIgnoreCase("v") && !direction.equalsIgnoreCase("h"));
		
		if(direction.equalsIgnoreCase("v")) {   //Vertical
			do {
			System.out.println("Do you want it upwards (u) or downwards (d)?");
			upOrDown = sc.next();
			}while(!upOrDown.equalsIgnoreCase("u") && !upOrDown.equalsIgnoreCase("d"));
			if(upOrDown.equalsIgnoreCase("u")) {
				array1[a-2][b-1]=2;
			}else{
				array1[a][b-1]=2;
			}
		}else { 			//Horizontal
			do {
				System.out.println("Do you want it rightwards (r) or leftwards (l)?");
				leftOrRight = sc.next();
				}while(!leftOrRight.equalsIgnoreCase("r") && !leftOrRight.equalsIgnoreCase("l"));
				if(leftOrRight.equalsIgnoreCase("r")) {
					array1[a-1][b]=2;
				}else{
					array1[a-1][b-2]=2;
				}
		}

	}
		
		
	//We print the board
	for(int i=0;i<array1.length;i++) {
		for(int j=0;j<array1[i].length;j++) {
			if(array1[i][j]==1) {
			System.out.print(1);
			}else if (array1[i][j]==2)
				System.out.print(2);
			else {
				System.out.print("0");
			}
		}
		System.out.println();
	}
	return array1;
}
	
	public static int[][]generateVisual(int a, int b) {
		int array2[][]=new int[a][b];
		for(int i=0; i<array2.length; i++) {
			for (int j=0; j<array2[0].length; j++) {
				array2[i][j]=5;
			}
		}
		
		return array2;
	}
	
	
	public static void main2(String[] args,int[][]visual1) {
		//do {
			
			System.out.println("Turn 1 payer 1");
			printVisual(visual1);
			System.out.println("Locate your attack");
			//Se pidenn coordenadas del ataque
			attack(a,b); // siendo a y b las coordenadas sacadas mediante metodos
		}
		//while 
		
	
	public static void printVisual(int[][]visual) {
		for(int i=0; i<visual.length; i++) {
			for (int j=0; j<visual[0].length; j++) {
				if(visual[i][j]==5) {
					System.out.println("~");		
			}
				if(visual[i][j]==6) {
					System.out.println("#");
				}
				if (visual[i][j]==7) {
					System.out.println("X");
				}
			}
		}
	}
	public static int[][]attack(int[][]board, int a, int b){
		int [][]array = new int[a][b];
		for(int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; i++) {
				board[a][b]=6;
			}
		}
		return array;
	}
	
	
	
}
