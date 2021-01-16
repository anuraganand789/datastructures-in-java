import java.util.Deque;
import java.util.ArrayDeque;

public class EvaluatePostfix{
    public static void main(final String[] args){
        final String[] postfixExpressions = {"135*+", "234*6+1*+", "33*55/-"};

	for(final String postfix : postfixExpressions){
	    System.out.format("%s -> %d.%n", postfix, postfixResultAfterEvaluation(postfix));
	}
    }

    private static boolean isOperator(final char testChar){
        return testChar == '+' || testChar == '-' || testChar == '*' || testChar == '/';
    }

    private static int evaluate(final int first, final int second, final char operator){
        return switch(operator){
			           case '+' -> first + second;
			           case '*' -> first * second;
			           case '-' -> first - second;
			           case '/' -> first / second;
				   default -> -1;
	                       };
    }

    private static int postfixResultAfterEvaluation(final String postfix){
        if(postfix == null || postfix.strip().isEmpty()) return 0;

	final Deque<String> numbersInPostfix = new ArrayDeque<>();

	final char[] charsInPostfix = postfix.toCharArray();
	for(final char ch : charsInPostfix){
	    if(isOperator(ch)){
		int firstNumber  = Integer.parseInt(numbersInPostfix.removeFirst());
		int secondNumber = Integer.parseInt(numbersInPostfix.removeFirst());
		int evaluationIs = evaluate(firstNumber, secondNumber, ch);
		numbersInPostfix.addFirst(evaluationIs + "");
		continue;
	    }

	   numbersInPostfix.addFirst(ch + ""); 
	}

	return Integer.parseInt(numbersInPostfix.removeFirst());
    }
}
