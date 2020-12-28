public class RotateArray{
    
    public static void main(final String ... args){
        final int[][] matrix = {
	                        {1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
			       };

        final int xAxis = 3;
	final int yAxis = 4;

	int rowStartsAt = 0;
	int columnStartsAt = 0;

	int rowEndsAt = xAxis - 1;
	int columnEndsAt = yAxis - 1;

	printMatrix(matrix, xAxis - 1, yAxis - 1);

	while(true){

	    if(rowStartsAt == rowEndsAt || columnStartsAt == columnEndsAt) break; 

	    int previousValue = matrix[rowStartsAt][columnStartsAt];
	    int currentValue;

	    for(int columnIndex = columnStartsAt + 1; columnIndex <= columnEndsAt ; ++columnIndex){
	        currentValue = matrix[rowStartsAt][columnIndex];
		matrix[rowStartsAt][columnIndex] = previousValue;
	        previousValue = currentValue;
	    }

	    for(int rowIndex = rowStartsAt + 1; rowIndex <= rowEndsAt; ++rowIndex){
	        currentValue = matrix[rowIndex][columnEndsAt];
		matrix[rowIndex][columnEndsAt] = previousValue;
		previousValue = currentValue;
	    }

	    for(int columnIndex = columnEndsAt - 1; columnIndex >= columnStartsAt; --columnIndex){
	        currentValue = matrix[rowEndsAt][columnIndex];
		matrix[rowEndsAt][columnIndex] = previousValue;
	        previousValue = currentValue;
	    }

	    for(int rowIndex = rowEndsAt - 1; rowIndex >= rowStartsAt; --rowIndex){
	        currentValue = matrix[rowIndex][columnStartsAt];
		matrix[rowIndex][columnStartsAt] = previousValue;
		previousValue = currentValue;
	    }
	    
	    ++rowStartsAt;
	    ++columnStartsAt;

	    --rowEndsAt;
	    --columnEndsAt;
	}
	printMatrix(matrix, xAxis - 1, yAxis - 1);

	
    }

    private static void printMatrix(final int[][] matrix, final int rowEndsAt, final int columnEndsAt){
        for(int rowIndex = 0; rowIndex <= rowEndsAt; ++rowIndex){
	    for(int columnIndex = 0; columnIndex <= columnEndsAt; ++columnIndex){
	        System.out.format("%d ", matrix[rowIndex][columnIndex]);
	    }
	    System.out.println();
	}
	System.out.println();
    }
}
