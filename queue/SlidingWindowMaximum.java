public class SlidingWindowMaximum{
    public static void main(final String[] args){
        final int[][] testCases = {
				      {2, 4, 3, 4, 5, 11, 0, 1, 1, 0}
	                          };

        final int windowSize = 3;

	for(final int[] test : testCases){
	    maximumInSlidingWindow(test, windowSize);
	}
    }

    private static void printSubArray(final int[] array, int startIndex, int endIndex){
        for(int index = startIndex; index <= endIndex; ++index) {
	    System.out.format("%d ", array[index]);
	}
    }

    private static int maxInTheSubArray(final int[] array, int startIndex, int endIndex){
        int max = Integer.MIN_VALUE;
	for(int index = startIndex; index <= endIndex; ++index) {
	    if(array[index] > max) max = array[index];
	}
	return max;
    }

    private static void maximumInSlidingWindow(final int[] numbers, final int windowSize){
	final int lengthOfTheArray = numbers.length;
        final int subarraySize = windowSize;

        int max = maxInTheSubArray(numbers, 0, subarraySize - 1);

	printSubArray(numbers, 0, subarraySize - 1);
	System.out.format(" => Max is %d.%n", max);

	for(int index = 1; index < lengthOfTheArray - subarraySize; ++index){

	    int lastIndexInThisSubArray = index + subarraySize - 1;
	    int numberRemoved = numbers[index - 1];
	    int numberAdded   = numbers[lastIndexInThisSubArray];

	    if(max == numberRemoved) {
	        max = maxInTheSubArray(numbers, index, lastIndexInThisSubArray);
	    } else if(max < numberAdded) {
	        max = numberAdded;
	    }

	    printSubArray(numbers, index, lastIndexInThisSubArray);
	    System.out.format(" => Max is %d.%n", max);
	}
    }
}
