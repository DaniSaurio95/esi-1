package theoreticalWork;
import java.util.Scanner;

public class BoatsGame {
final public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int row,col,B1,B2;
		boolean isEnd = false;
		row = askDimension("rows");
		col = askDimension("columns");
		B1 = askBoats("1");
		B2 = askBoats("2");
		System.out.println("Player 1");
		int board1[][]= generateBoard(row,col,B1,B2);
		System.out.println("Player 2");
		int board2[][]= generateBoard(row,col,B1,B2);
		
		int visual1[][]=generateVisual(board1.length, board1[0].length);
		int visual2[][]=generateVisual(board2.length, board2[0].length);

		mainLoop(visual1, visual2, board1, board2, isEnd, B1, B2);
	}

	public static void mainLoop(int[][]visual1, int[][] visual2, int[][]board1, int[][] board2, boolean isEnd, int B1, int B2) {
		do {
			System.out.println("Turn for player 1, this is what you see");
			printVisual(visual2);
			visual2=attack(board2, visual2);
			printVisual(visual2);
			isEnd =isTheEnd(visual2,1,B1,B2);
			
			if(isEnd==false) {
			System.out.println("Turn for player 2, this is what you see");
			printVisual(visual1);
			visual1=attack(board1,visual1);
			printVisual(visual1);
			isEnd = isTheEnd(visual1,2,B1,B2);
			}else {
				isEnd=true;
			}
		}while(isEnd==false);
	}
	
	public static int askDimension(String message) {
		int dimension;
		do{
		System.out.println("Introduce the number of "+message+": ");
		dimension = sc.nextInt();
		}while(dimension<3);
		return dimension;
	}
	public static int askBoats(String number) {
		int boat;
		do{
		System.out.println("Introduce the number of boats of length "+number+": ");
		boat = sc.nextInt();
		}while(boat<0);
		return boat;
	}

	public static int[][]generateBoard(int row,int col,int b1, int b2){
		int a=0;
		int b=0;
		int lastRow=row-1;
		int lastCol=col-1;
		int typeOfBoat=1;
		int array[][]=generateB1(row,col,b1,a,b,lastRow,lastCol,typeOfBoat);
		typeOfBoat=2;
		array=generateB2(array,row,col,b2,a,b,lastRow,lastCol,typeOfBoat);
		return array;
	}

	private static int[][]generateB1(int row, int col, int b1, int a, int b, int lastRow, int lastCol, int typeOfBoat) {
		int array[][]=new int[row][col];
		for(int i=0;i<b1;i++) {
			do {
				System.out.println("Introduce the row you want your B1 boat to be: [1,"+ row+"]");
				a = sc.nextInt();
				System.out.println("Introduce the column you want your B1 boat to be: [1,"+ col+"]");
				b = sc.nextInt();
			}while(a<1 || a>row || b<1 || b>col);
			a=a-1;
			b=b-1;
			
			if(a==0 && b==0)
				array=checkTopLeft(array, a, b, i, typeOfBoat);
			
			if(a==lastRow && b==0)
				array=checkBottomLeft(array, a, b, i, typeOfBoat);
			
			if(a==0 && b==lastCol)
				array=checkTopRight(array, a, b, i, typeOfBoat);
			
			if(a==lastRow && b==lastCol)
				array=checkBottomRight(array, a, b, i, typeOfBoat);
			
			if(a==0 && b>0 && b<lastCol)
				array=checkFirstRow(array, a, b, i, typeOfBoat);
			
			if(a==lastRow && b>0 && b<lastCol)
				array=checkLastRow(array, a, b, i, typeOfBoat);
			
			if(b==0 && a>0 && a<lastRow)
				array=checkFirstCol(array, a, b, i, typeOfBoat);
			
			if(b==lastCol && a>0 && a<lastRow)
				array=checkLastCol(array, a, b, i, typeOfBoat);
			
			if(a>0 && a<lastRow && b>0 && b<lastCol)
				array=checkInside(array, a, b, i, typeOfBoat);
			
			if(array[a][b]==0)
				i--;
			
			//We print the board
			printBoard(array);
		}
		return array;
	}
	
	private static int[][]generateB2(int[][] array, int row, int col, int b2, int a, int b, int lastRow, int lastCol, int typeOfBoat) {
		for(int i=0;i<b2;i++) {
			do {
				System.out.println("Introduce the row you want your B2 boat to be: [1,"+ row+"]");
				a = sc.nextInt();
				System.out.println("Introduce the column you want your B2 boat to be: [1,"+ col+"]");
				b = sc.nextInt();
			}while(a<1 || a>row || b<1 || b>col);
			a=a-1;
			b=b-1;
			if(a==0 && b==0) {
				array=checkTopLeft(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			if(a==lastRow && b==0) {
				array=checkBottomLeft(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(a==0 && b==lastCol) {
				array=checkTopRight(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(a==lastRow && b==lastCol) {
				array=checkBottomRight(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(a==0 && b>0 && b<lastCol) {
				array=checkFirstRow(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(a==lastRow && b>0 && b<lastCol) {
				array=checkLastRow(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(b==0 && a>0 && a<lastRow) {
				array=checkFirstCol(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(b==lastCol && a>0 && a<lastRow) {
				array=checkLastCol(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			if(a>0 && a<lastRow && b>0 && b<lastCol) {
				array=checkInside(array, a, b, i, typeOfBoat);
				if(array[a][b]==0)
					i--;
				else {
					printBoard(array);
					array=askForOtherPart(array, a, b);
				}
			}
			
			//We print the board
			printBoard(array);
				

		}
		return array;
	}
	
	private static int[][] askForOtherPart(int[][] array, int a, int b) {
		int row2,col2;
		boolean cantPutHere;
		a++;
		b++;
		do {
			cantPutHere=false;
			do {
				System.out.println("Introduce the row of the other part of the boat");
				row2=sc.nextInt();
				System.out.println("Introduce the column of the other part of the boat");
				col2=sc.nextInt();
			}while((col2!=b || (row2!=a+1 && row2!=a-1)) && (row2!=a || (col2!=b+1 && col2!=b-1)) && (row2==a && col2==b));
		cantPutHere=canPutOtherPart(array,row2,col2,a,b,cantPutHere);
		if (cantPutHere) {
			System.out.println("You can't put it here");
		}
		}while(cantPutHere);
		array[row2-1][col2-1]=2;
		return array;
	}
	
	private static boolean canPutOtherPart (int[][] array, int row2, int col2, int a, int b, boolean cantPutHere) {
		a--;
		b--;
		row2--;
		col2--;
		if (row2==a-1) {
			cantPutHere=otherPartAtTop(row2,col2,cantPutHere,array);
		}
		if (row2==a+1) {
			cantPutHere=otherPartAtBottom(row2,col2,cantPutHere,array);
		}
		if (col2==b-1) {
			cantPutHere=otherPartAtLeft(row2,col2,cantPutHere,array);
		}
		if (col2==b+1) {
			cantPutHere=otherPartAtRight(row2,col2,cantPutHere,array);
		}
		return cantPutHere;
	}
	
	private static boolean otherPartAtTop(int row2, int col2, boolean cantPutHere, int[][] array) {
		if (row2==0) {
			cantPutHere=false;
		}
		else {
			if (col2==0) {
				if (array[row2-1][col2]==1||array[row2-1][col2]==2||array[row2-1][col2+1]==1||array[row2-1][col2+1]==2) {
					cantPutHere=true;
				}
			}
			if (col2==array[0].length-1) {
				if (array[row2-1][col2]==1||array[row2-1][col2]==2||array[row2-1][col2-1]==1||array[row2-1][col2-1]==2) {
					cantPutHere=true;
				}
			}
			if (col2!=0&&col2!=array[0].length-1) {
				if (array[row2-1][col2]==1||array[row2-1][col2]==2||array[row2-1][col2+1]==1||array[row2-1][col2+1]==2||array[row2-1][col2-1]==1||array[row2-1][col2-1]==2) {
					cantPutHere=true;
				}
			}
		}
		return cantPutHere;
	}
	
	private static boolean otherPartAtBottom(int row2, int col2, boolean cantPutHere, int[][] array) {
		if (row2==array.length) {
			cantPutHere=false;
		}
		else {
			if (col2==0) {
				if (array[row2+1][col2]==1||array[row2+1][col2]==2||array[row2+1][col2+1]==1||array[row2+1][col2+1]==2) {
					cantPutHere=true;
				}
			}
			if (col2==array[0].length-1) {
				if (array[row2+1][col2]==1||array[row2+1][col2]==2||array[row2+1][col2-1]==1||array[row2+1][col2-1]==2) {
					cantPutHere=true;
				}
			}
			if(col2!=0&&col2!=array[0].length-1) {
				if (array[row2+1][col2]==1||array[row2+1][col2]==2||array[row2+1][col2+1]==1||array[row2+1][col2+1]==2||array[row2+1][col2-1]==1||array[row2+1][col2-1]==2) {
					cantPutHere=true;
				}
			}
		}
		return cantPutHere;
	}
	
	private static boolean otherPartAtLeft(int row2, int col2, boolean cantPutHere, int[][] array) {
		if (col2==0) {
			cantPutHere=false;
		}
		else {
			if (row2==0) {
				if (array[row2][col2-1]==1||array[row2][col2-1]==2||array[row2+1][col2-1]==1||array[row2+1][col2-1]==2) {
					cantPutHere=true;
				}
			}
			if (row2==array.length-1) {
				if (array[row2][col2-1]==1||array[row2][col2-1]==2||array[row2-1][col2-1]==1||array[row2-1][col2-1]==2) {
					cantPutHere=true;
				}
			}
			if(row2!=0&&row2!=array.length-1) {
				if (array[row2][col2-1]==1||array[row2][col2-1]==2||array[row2+1][col2-1]==1||array[row2+1][col2-1]==2||array[row2-1][col2-1]==1||array[row2-1][col2-1]==2) {
					cantPutHere=true;
				}
			}
		}
		return cantPutHere;
	}
	
	private static boolean otherPartAtRight(int row2, int col2, boolean cantPutHere, int[][] array) {
		if (col2==array[0].length) {
			cantPutHere=false;
		}
		else {
			if (row2==0) {
				if (array[row2][col2+1]==1||array[row2][col2+1]==2||array[row2+1][col2+1]==1||array[row2+1][col2+1]==2) {
					cantPutHere=true;
				}
			}
			if (row2==array.length-1) {
				if (array[row2][col2+1]==1||array[row2][col2+1]==2||array[row2-1][col2+1]==1||array[row2-1][col2+1]==2) {
					cantPutHere=true;
				}
			}
			if(row2!=0&&row2!=array.length-1) {
				if (array[row2][col2+1]==1||array[row2][col2+1]==2||array[row2+1][col2+1]==1||array[row2+1][col2+1]==2||array[row2-1][col2+1]==1||array[row2-1][col2+1]==2) {
					cantPutHere=true;
				}
			}
		}
		return cantPutHere;
	}

	private static int[][] checkInside(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b-1])>0 || (array[a][b+1])>0 || (array[a-1][b])>0 || (array[a+1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkLastCol(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a-1][b])>0 || (array[a+1][b])>0 || (array[a][b-1])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkFirstCol(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a-1][b])>0 || (array[a+1][b])>0 || (array[a][b+1])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkLastRow(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b-1])>0 || (array[a][b+1])>0 || (array[a-1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkFirstRow(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b-1])>0 || (array[a][b+1])>0 || (array[a+1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkBottomRight(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b-1])>0 || (array[a-1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkTopRight(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b-1])>0 || (array[a+1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkBottomLeft(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b+1])>0 || (array[a-1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static int[][] checkTopLeft(int[][] array, int a, int b, int i, int typeOfBoat) {
		if((array[a][b+1])>0 || (array[a+1][b])>0) {
			System.out.println("You can't put a boat here. It is contigous to another one");
		}
		else {
			array[a][b]=typeOfBoat;
		}
		return array;
	}

	private static void printBoard(int[][] array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static int[][]generateVisual(int a, int b) {
		int visual[][]=new int[a][b];
		for(int i=0; i<visual.length; i++) {
			for (int j=0; j<visual[i].length; j++) {
				visual[i][j]=5;
			}
			System.out.println();
		}
		
		return visual;
	}
		
	public static void printVisual(int[][]visual) {
		for(int i=0; i<visual.length; i++) {
			for (int j=0; j<visual[i].length; j++) {
				if(visual[i][j]==5) {
					System.out.print("~ ");		
				}else if(visual[i][j]==6) {
					System.out.print("# ");
				}else if (visual[i][j]==7) {
					System.out.print("X ");
				}else if (visual[i][j]==8) {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}

	public static int[][]attack(int[][]board,int[][]visual){
		System.out.println("Select the coordenates for your attack");
		int coorX;
		int coorY;
		coorX = askCoor(board,"X")-1;
		coorY = askCoor(board,"Y")-1;
		if(coorX>board.length-2 || coorY>board[0].length-2 || coorX<0 || coorY<0) {
			System.out.println("Those coordenates are out of the map");
		}
		checkPhrase(board,visual,coorY,coorX);	
			
		if(board[coorY][coorX]==1) {
			visual[coorY][coorX]=7;
		}else if(board[coorY][coorX]==2) {
			visual[coorY][coorX]=6;
			visual=killTwo(visual,coorY,coorX);
		}else if (board[coorY][coorX]==0) {
			visual[coorY][coorX]=8;
		}

		return visual;
	}

	public static void checkPhrase(int[][]board,int[][]visual, int a, int b) {

		if(board[a][b]==1) {
			System.out.println("Sunk");
		}
		if (board[a][b]==2) {
			System.out.println("Hit");		
		}
		if (board[a][b]==0){
			System.out.println("You missed");
				
		}
		
	}

	public static int askCoor(int[][]board,String message) {
		int coor;
		do{
			System.out.println("Introduce the "+message+" coordenate: ");
			coor = sc.nextInt();
		}while(coor>board.length || coor<0);
		return coor;
	}

	public static int[][]killTwo(int[][]visual, int a, int b){
		if(a!=0) {
			visual=killTwoUp(visual, a, b);
		}
		if(a!=visual.length-1) {
			visual=killTwoDown(visual, a, b);
		}
		if(b!=0) {
			visual=killTwoLeft(visual, a, b);
		}
		if(b!=visual[a].length-1) {
			visual=killTwoRight(visual, a, b);
		}
		return visual;
	}

	public static int[][]killTwoUp(int[][]visual, int a, int b){
		if(visual[a-1][b]==6) {
			visual[a-1][b]=7;
			visual[a][b]=7;
			System.out.println("and sunk");
		}
		return visual;
	}

	public static int[][]killTwoDown(int[][]visual, int a, int b){
		if(visual[a+1][b]==6) {
			visual[a+1][b]=7;
			visual[a][b]=7;
			System.out.println("and sunk");
		}
		return visual;
	}

	public static int[][]killTwoLeft(int[][]visual, int a, int b){
		if(visual[a][b-1]==6) {
			visual [a][b-1]=7;
			visual[a][b]=7;
			System.out.println("and sunk");
		}
		return visual;
	}

	public static int[][]killTwoRight(int[][]visual, int a, int b){
		if(visual[a][b+1]==6) {
			visual [a][b+1]=7;
			visual[a][b]=7;
			System.out.println("and sunk");
		}
		return visual;
	}

	public static boolean isTheEnd (int[][]visual, int player, int B1, int B2) {
		boolean isEnd=false;
		int alive=B1+(2*B2);
		int sunk=sunkBoats(visual);
		if(alive==sunk) {
			isEnd=true;
			System.out.println("Player " + player+ " wins");
		}
		return isEnd;
	}

	public static int sunkBoats(int[][]visual) {
		int sunk =0;
		for(int i=0; i<visual.length; i++) {
			for(int j=0; j<visual[0].length; j++) {
				if (visual[i][j]==7) {
					sunk++;
				}
			}
		}
		
		return sunk;
	}
}
