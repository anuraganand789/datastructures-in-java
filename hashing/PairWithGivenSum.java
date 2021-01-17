import java.util.Set;
import java.util.HashSet;

public class PairWithGivenSum{
    public static void main(final String[] args){
        final Set<Integer> setOfIntegers = new HashSet<>();
	final int[] data = {11, 2, 889, 33, 13, 15, 14};

	final int sum = 25;
	for(final int number : data){ 
	    if(setOfIntegers.contains(sum - number)) 
	       System.out.println("Sum is present");
	    else 
	       setOfIntegers.add(number); 
	}

	final int[] arrayOfSums = { 7, 15, 16, 25 };

	for(final int testSum : arrayOfSums){
	    System.out.format("%d is present in the array %s.%n", testSum, isSumPresent(testSum, setOfIntegers, data) ? "True" : "False" );
	}
    }

    private static boolean isSumPresent(final int sum, final Set<Integer> setOfIntegers, final int[] arrayWithData){
	if(setOfIntegers == null || arrayWithData == null) return false;

        for(final int data : arrayWithData){
	    if(setOfIntegers.contains(sum - data)) return true;
	}

	return false;
    }
}
