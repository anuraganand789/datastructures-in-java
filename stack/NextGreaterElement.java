import java.util.Deque;
import java.util.ArrayDeque;

public class NextGreaterElement{
    public static void main(final String[] args){
        final int[] numbers  = { 3, 1, 4, 5, 11, 6, 29 };
	printNextGreaterElement(numbers);
    }
    
    private static void printNextGreaterElement(final int[] numbers){
        if(numbers == null) return;

	final Deque<Integer> stack = new ArrayDeque<>();

	int lengthOfTheArray = numbers.length;
	stack.addFirst(numbers[0]);

        for(int index = 1; index < lengthOfTheArray; ++index){
	    while(!stack.isEmpty() && numbers[index] > stack.peekFirst()){
	        System.out.format("%d is NGE of %d.%n", numbers[index], stack.removeFirst());
	    }
	    stack.addFirst(numbers[index]);
	}

	while(!stack.isEmpty()){
	    System.out.format("%d is NGE of %d.%n", -1, stack.removeFirst());
	}
    }
}
