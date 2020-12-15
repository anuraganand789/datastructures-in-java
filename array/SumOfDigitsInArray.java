public class SumOfDigitsInArray{
    
    public static void main(final String ... args){
        final int[] numbers = { 1, 3, 5, 6, 11, 12, 16 };
	final int[] arrayOfSumsToLookFor = {14, 27};

	for(final int sumToLookFor : arrayOfSumsToLookFor) { sumIsPresent(numbers, sumToLookFor); }

    }

    private static void sumIsPresent(final int[] numbers, final int sumToLookFor){
        final int lengthOfArray = numbers.length - 1;

	int leftIndex = 0;
	int rightIndex = lengthOfArray;

	int sumOfNumbers;
	int leftValue;
	int rightValue;

	while(leftIndex < rightIndex){

	    leftValue = numbers[leftIndex];
	    rightValue = numbers[rightIndex];
	    sumOfNumbers = leftValue + rightValue;

	    if(sumOfNumbers == sumToLookFor) {
		System.out.format("Sum %d Found. The Values %d at the index %d, and %d at the index %d. %n"
		                 , sumOfNumbers, leftValue, leftIndex, rightValue, rightIndex);
	        break;
	    } 
	    else if(sumOfNumbers < sumToLookFor) { ++leftIndex; }
	    else { --rightIndex; }
	}
    }
}
