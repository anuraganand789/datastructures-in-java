import java.util.Deque;
import java.util.ArrayDeque;

public class ReverseAStackUsingRecursion{

    public static void main(final String[] args){
        final Deque<String> stack = new ArrayDeque<>();
        stack.addFirst("My");
        stack.addFirst("name");
        stack.addFirst("is");
        stack.addFirst("Anurag");
        stack.addFirst("Anand");

	while(!stack.isEmpty()) System.out.format("%s %n", stack.removeFirst());

	System.out.println();

        stack.addFirst("My");
        stack.addFirst("name");
        stack.addFirst("is");
        stack.addFirst("Anurag");
        stack.addFirst("Anand");

	reverseTheStack(stack);

	while(!stack.isEmpty()) System.out.format("%s %n", stack.removeFirst());
    }
    
    private static void reverseTheStack(final Deque<String> stack){
        if(stack.isEmpty()) return;

	final String value = stack.removeFirst();
	reverseTheStack(stack);

	reverseTheStackSecondTime(stack, value);
    }

    private static void reverseTheStackSecondTime(final Deque<String> stack, String value){
       if(stack.isEmpty()){
           stack.addFirst(value);
	   return;
       }

       final String currentValue = stack.removeFirst();
       reverseTheStackSecondTime(stack, value);

       stack.addFirst(currentValue);
    }
}
