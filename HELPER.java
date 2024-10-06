package helperClass;

public class HELPER {

	//method for finding coords of a specific value in 2D array
	public static String location(String[][] A, String val) {
		int rowNum = 0;
		int colNum = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] == val) {
					rowNum = i;
					colNum = j;
				}
			}
		}
		
		String coords = "[" + rowNum + ", " + colNum +"]";
		return coords;
 	}
	
	//method for calculating distance between two points in 2D array
	public static int distance(String[][] A, String start, String end) {
		int startRow = 0;
		int endRow = 0;
		int startCol = 0;
		int endCol = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] == start) {
					startRow = i;
					startCol = j;
				}
				
				if (A[i][j] == end) {
					endRow = i;
					endCol = j;
				}
			}
		}
		
		int rowDiff = Math.abs(startRow - endRow);
		int colDiff = Math.abs(startCol - endCol); 
		
		return rowDiff + colDiff;
		
	}
	
	
	public static String moves(String[][] A, String start, String end) {
		int startRow = 0;
		int endRow = 0;
		int startCol = 0;
		int endCol = 0;
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[i][j] == start) {
					startRow = i;
					startCol = j;
				}
				
				if (A[i][j] == end) {
					endRow = i;
					endCol = j;
				}
			}
		}
		
		int rowDiff = Math.abs(startRow - endRow);
		int colDiff = Math.abs(startCol - endCol); 
		
		String rowDirection = "";
		String colDirection = "";
		
		if (rowDiff != 0) {
			if (startRow > endRow) {
				rowDirection = "Move UP " + rowDiff + " Squares";
			} else {
				rowDirection = "Move DOWN " + rowDiff + " Squares";
			}
		}
		
		if (colDiff != 0) {
			if (startCol > endCol) {
				colDirection = "Move LEFT " + colDiff + " Squares";
			} else {
				colDirection = "Move RIGHT " + colDiff + " Squares";
			}
		}
		
		if (rowDiff == 0) {
			return colDirection;
		}
		
		if (colDiff == 0) {
			return rowDirection;
		}
		
		return rowDirection +"\n" + colDirection;
		
	}
	
	
}
