package tasksClass;

import helperClass.HELPER;

public class TASKS {

	//task 0
	public static String[][] buildBoard(int dimension) {
		String[][] gameBoard = new String[dimension][dimension];
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard.length; j++) {
				gameBoard[i][j] = "[-]";
			}
		}
		
		int pIndex = 0;
		int tIndex = 0;
		
		while (pIndex == tIndex) {
			pIndex = (int)Math.floor(Math.random() * gameBoard.length);
			tIndex = (int)Math.floor(Math.random() * gameBoard.length);
		}
		
		gameBoard[(int)Math.floor(Math.random() * gameBoard.length)][pIndex] = "[P]";
		gameBoard[(int)Math.floor(Math.random() * gameBoard.length)][tIndex] = "[T]";
		
		return gameBoard;
	}
	
	
	//task 1
	public static void displayBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	//task 2
	public static void showCaptureSummary(String[][] board) {
		displayBoard(board);
		System.out.println();
		
		//printing pokemon and trainer locations
		System.out.println("Trainer Located At: " + HELPER.location(board, "[T]"));
		System.out.println("Pokemon Located At: " + HELPER.location(board, "[P]"));
		
		//printing number of moves
		System.out.println("Pokemon Capture in: " + HELPER.distance(board, "[P]", "[T]") + " move(s)");
		System.out.println(HELPER.moves(board, "[T]", "[P]"));
	}
	
	
	//task 3
	public static void showCaptureRoute(String[][] board) {
	    String[][] pathBoard = new String[board.length][board[0].length];
	    int startRow = 0;
	    int endRow = 0;
	    int startCol = 0;
	    int endCol = 0;

	    for (int i = 0; i < board.length; i++) {
	        for (int j = 0; j < board[i].length; j++) {
	            pathBoard[i][j] = board[i][j];
	            
	            if (board[i][j].equals("[P]")) {
	            	endRow = i;
	            	endCol = j;
	            	pathBoard[i][j] = "<P>";
	            }
	            
	            if (board[i][j].equals("[T]")) {
	            	startRow = i;
	            	startCol = j;
	            }
	        }
	    }

	    int rowDiff = startRow - endRow;
	    int colDiff = endCol - startCol;
	    int totalMoves = 0;
	    String moveString = "";
	    
	    if (rowDiff != 0) {
	    if (rowDiff < 0) {
	    	for (int i = 0; i < Math.abs(rowDiff); i++) {
	    		pathBoard[startRow + i + 1][startCol] = "[t]";
	    		totalMoves += 1;
	    		moveString += "DOWN ";
	    	}
	    } else {
	    	for (int i = 0; i < Math.abs(rowDiff); i++) {
	    		pathBoard[startRow - i - 1][startCol] = "[t]";
	    		totalMoves += 1;
	    		moveString += "UP ";
	    	}
	    }
	    }
	    
	    if (colDiff != 0) {
	    	if (colDiff < 0) {
	    		for (int i = 0; i < Math.abs(colDiff); i++) {
	    			if (!pathBoard[endRow][endCol + i + 1].equals("[T]")) {
	    			pathBoard[endRow][endCol + i + 1] = "[t]";
	    			}
	    			totalMoves += 1;
	    			moveString += "LEFT ";
	    		}
	    	} else {
	    		for (int i = 0; i < Math.abs(colDiff); i++) {
	    			if (!pathBoard[endRow][endCol - i - 1].equals("[T]")) {
	    			pathBoard[endRow][endCol - i - 1] = "[t]";
	    			}
	    			totalMoves += 1;
	    			moveString += "RIGHT ";
	    		}
	    	}
	    }
	    
	    displayBoard(pathBoard);
	    System.out.println();
	    System.out.println(totalMoves + " move(s) -> " + moveString);
	    System.out.println("Pokemon Captured At X:" + endRow + " Y:" + endCol);
	}


	
	
}
