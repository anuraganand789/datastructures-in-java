import java.util.Arrays;

public class MaxPositiveAndNegativeNumber{
    public static void main(final String[] commandlineArguments){
        final int[][] tests = {
			          {1, 2, 3},
				  {-1},
				  {1, -2},
				  {-1, 2, 3, 1},
				  {-100, 100, 1000, -1010}
	                      };

        for(int[] test : tests){
	    printIntArray(test);
	    System.out.format("-> %d.%n", maxPositiveNumber(test));
	}
    }

    private static void printIntArray(final int[] arrayOfIntegers){
        for(final int number : arrayOfIntegers) System.out.format("%d ", number);
    }

    private static int maxPositiveNumber(final int[] arrayOfIntegers){
        if(arrayOfIntegers == null) return 0;

	final int lengthOfTheArray = arrayOfIntegers.length;

	if(lengthOfTheArray < 2) return 0;

	Arrays.sort(arrayOfIntegers);

	for(int index = lengthOfTheArray - 1; index > -1 && arrayOfIntegers[index] > 0; --index){
	    final int currentPositiveNumber = arrayOfIntegers[index];
	    if(Arrays.binarySearch(arrayOfIntegers, -1 * currentPositiveNumber) > -1) return currentPositiveNumber;
	}

	return 0;
    }
}
