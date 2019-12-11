package FInal;

public class Final {
	
	final public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int row,col,B1,B2;
		row = askRow();
		col = askCol();
		B1 = askB1();
		B2 = askB2();
		int board1[][]= generateBoard(row,column);
		int board2[][]= generateBoard(row,column);
		int visual1[][]= generateVisual(row,column);
		int visual2[][]= generateVisual(row,column);
		int numRows = board1.length;

	}

	public static int askRow() {
		int row;
		do{
		System.out.println("Introduce the number of rows: ");
		row = sc.nextInt();
		}while(row>=3);
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
