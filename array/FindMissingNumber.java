public class FindMissingNumber{
    public static void main(final String ... args){
        final int[] dataSet = {1, 2, 3, 4, 5, 6};
	final int totalNumbers = 6;
	//SUM of numbers from 1 to n => (n * (n + 1)) / 2
        final int sumThatIsExpected = (totalNumbers * ( totalNumbers + 1) ) / 2;

	int sumThatIsFound = 0;

	for(final int number : dataSet) { sumThatIsFound += number; }
        
	if(sumThatIsFound != sumThatIsExpected) System.out.format("The missing number is %d.%n", (sumThatIsExpected - sumThatIsFound));
	else                                    System.out.println("No Number is missing.");
    }
}
