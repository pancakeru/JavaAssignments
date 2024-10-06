package mainClass;

import tasksClass.TASKS;

public class MAIN {

	public static void main(String[] args) {
		System.out.println("Task 0");
		//TASK 0
		String[][] board = TASKS.buildBoard(5);
		//TASK 1
		System.out.println("Task 1");
		TASKS.displayBoard(board);
		//TASK 2
		System.out.println("Task 2");
		TASKS.showCaptureSummary(board);
		//TASK 3
		System.out.println("Task 3");
		TASKS.showCaptureRoute(board);
 	}

}
