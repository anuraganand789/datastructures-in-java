public class LeadersInArray{
    public static void main(final String ... args){
        final int[] numbers = { 112, 9, 8, 16, 31, 15, 14, 19 };

	final int length = numbers.length;

	int maxOnRight = Integer.MIN_VALUE;

	for(int currIndex = length - 1; currIndex > -1; --currIndex){
	    final int number = numbers[currIndex];
	    if(number > maxOnRight){
	        System.out.format("%d is a LEADER.%n", number);
		maxOnRight = number;
	    }
	}
    }
}
