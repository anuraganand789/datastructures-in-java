public class CountPairInSortedArray{
    public static void main(final String ... args){
        final int[] arrayOne
	= {1, 2, 2};

	final int[] arrayTwo
	= {1, 1, 1, 2, 2, 2, 3};
        
	countPair(arrayOne, arrayTwo);
    }

    private static void countPair(final int[] arrayOne, final int[] arrayTwo){
        final int lengthOfArrayOne = arrayOne.length;
	int   indexInArrayOne  = 0;

	final int lengthOfArrayTwo = arrayTwo.length;
	int   indexInArrayTwo  = 0;

	while(indexInArrayOne < lengthOfArrayOne && indexInArrayTwo < lengthOfArrayTwo){
	    final int currentNumberInArrayOne = arrayOne[indexInArrayOne];
	    final int currentNumberInArrayTwo = arrayTwo[indexInArrayTwo];

	    if(currentNumberInArrayOne == currentNumberInArrayTwo){
	        int frequencyInArrayOne = 1;
		int frequencyInArrayTwo = 1;

		while(++indexInArrayOne < lengthOfArrayOne && currentNumberInArrayOne == arrayOne[indexInArrayOne]) ++frequencyInArrayOne;
		while(++indexInArrayTwo < lengthOfArrayTwo && currentNumberInArrayTwo == arrayTwo[indexInArrayTwo]) ++frequencyInArrayTwo;
                
		System.out.format("Pair (%d, %d), Count %d.%n", 
		                   currentNumberInArrayOne, currentNumberInArrayTwo, (frequencyInArrayOne * frequencyInArrayTwo));
	    } else if(currentNumberInArrayOne < currentNumberInArrayTwo){
	        ++indexInArrayOne;
	    } else {
	       ++indexInArrayTwo;
	    }
	}
    }
}
