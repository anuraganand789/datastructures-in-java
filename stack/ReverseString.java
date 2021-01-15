import java.util.Deque;
import java.util.ArrayDeque;

public class ReverseString{
    public static void main(final String[] commandlineArguments){
        final String myName = "Anurag Anand";
	final Deque<String>  stack = new ArrayDeque<>();

	final int lengthOfMyName = myName.length();

	final char[] charsInMyName = myName.toCharArray();

        for(final char ch : charsInMyName){
	    stack.addFirst(ch + "");
	}

	while(!stack.isEmpty()){
	    System.out.print(stack.removeFirst());
	}
	
	System.out.println();
    }
}
