import java.util.Deque;
import java.util.ArrayDeque;

public class SortAStackUsingRecursion{
    public static void main(final String[] args){
        final Deque<Integer> stack = new ArrayDeque<>();
	stack.addFirst(12);
	stack.addFirst(2);
	stack.addFirst(13);
	stack.addFirst(22);
	stack.addFirst(5);

        sortTheStack(stack);
	while(!stack.isEmpty()) System.out.println(stack.removeFirst());

    }

    private static void sortTheStack(final Deque<Integer> stack){
        if(stack.isEmpty()) return;

	Integer value = stack.removeFirst();
	sortTheStack(stack);

	addInSortedFashion(stack, value);
    }

    private static void addInSortedFashion(final Deque<Integer> stack, final Integer intValue){
        if(stack.isEmpty() || intValue.intValue() >   stack.peekFirst().intValue()) {
	    stack.addFirst(intValue);
	    return;
	}

	final Integer value = stack.removeFirst();
	addInSortedFashion(stack, intValue);

	stack.addFirst(value);
    }
}
