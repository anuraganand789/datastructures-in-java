public class FlipZeroToOne{
    public static void main(final String[] commandlineArguments){
        final int[][] tests = {
	                          {1, 1, 1, 1, 1, 1},
	                          {0, 0, 1}    
			      };
        for(final int[] test : tests) System.out.format("Minimumbe Number of flips needed are  %d. %n", flip(test));
    }

    private static int flip(final int[] arrayOfIntegers){
        final int lengthOfArray = arrayOfIntegers.length; 

	final int[] startsWithZero = new int[lengthOfArray];
	fill(startsWithZero, 1);

	final int[] startsWithOne  = new int[lengthOfArray];
	fill(startsWithOne, 0);

        return Math.min(countDiff(arrayOfIntegers, startsWithOne), countDiff(arrayOfIntegers, startsWithZero));
    }

    private static void printIntArray(final int[] arrayOfIntegers){
        for(final int num : arrayOfIntegers) System.out.format("%d ", num);

	System.out.println();
    }

    private static void fill(final int[] arrayOfIntegers, final int startIndex){
        final int lengthOfTheArray = arrayOfIntegers.length;
        
	for(int index = startIndex ; index < lengthOfTheArray; index += 2){
	    arrayOfIntegers[index] = 1;
	}
    }

    private static int countDiff(final int[] arrayOne, final int[] arrayTwo){
	int countOfFlips = 0;

        if(arrayOne == null || arrayTwo == null) return countOfFlips;

	final int lengthOfArrayOne = arrayOne.length;
	final int lengthOfArrayTwo = arrayTwo.length;

	if(lengthOfArrayOne != lengthOfArrayTwo) return countOfFlips;

	for(int index = 0; index  < lengthOfArrayOne; ++index) if(arrayTwo[index] != arrayOne[index]) ++countOfFlips;

	return countOfFlips;
    }

}
