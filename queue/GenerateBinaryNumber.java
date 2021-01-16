import java.util.Deque;
import java.util.ArrayDeque;

public class GenerateBinaryNumber{
    public static void main(final String[] args){
        int number = 10;

	final Deque<String> queue = new ArrayDeque<>();
	queue.addLast("1");

	while(number-- > 0){
            String binaryNumber = queue.removeFirst();
	    System.out.println(binaryNumber);

	    queue.addLast(binaryNumber + "0");
	    queue.addLast(binaryNumber + "1");
	}
    }
}
