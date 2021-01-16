import java.util.Deque;
import java.util.ArrayDeque;

public class InfixToPostfix{
    public static void main(final String ... args){
        final String[] tests = {
			           "1 + 3 * 5",
				   "3 * 3 - 5 / 5",
				   "2 + ( 3 * 4 + 6) * 1"
	                       };
       
       for(final String test : tests){
           final String postfix = convertInfixToPostfix(test);
	   System.out.format("%s -> %s.%n", test, postfix);
       }
    }

    private static boolean isOperator(final char testChar){
        return testChar == '+' || testChar == '-' || testChar == '*' || testChar == '/';
    }

    private static int precedenceOfOperator(final String testChar){
        return switch(testChar) {
				    case "+","-" -> 1;
				    case "*","/" -> 2;
				    default -> 0;
	                        };
    }

    private static String convertInfixToPostfix(final String infix){
       String postfix = ""; 
       
       final Deque<String> stack = new ArrayDeque<>();
       final char[] arrayOfCharacters = infix.toCharArray();

       for(final char testChar : arrayOfCharacters){
	   if(testChar == ' ') continue;

	   if(testChar == '(') {
	       stack.addFirst(testChar + "");
	       continue;
	   }

           if(testChar == ')'){
	       boolean closingParenthesesFound = false;

	       while(!stack.isEmpty()){
	           String operatorInStack = stack.removeFirst();
		   if(closingParenthesesFound = operatorInStack.equals("(")) break;
		   postfix += operatorInStack;
	       }

	       if(!closingParenthesesFound) return String.format("closing parenthese not found for %s.%n", infix);

	       continue;
	   }


           if(!isOperator(testChar)) {
	       postfix += testChar;
	       continue;
	   } 
           
           while(!stack.isEmpty()){
	       String operatorInStack = stack.peekFirst();
	       if(operatorInStack == null) break;
	       int precedenceOfOperatorInStack = precedenceOfOperator(operatorInStack);
	       int precedenceOfOperatorInExpression = precedenceOfOperator(testChar + "");

	       if(precedenceOfOperatorInStack >= precedenceOfOperatorInExpression){
	           postfix += stack.removeFirst();
	           continue;
	       }
	       break;
	   }

	   stack.addFirst(testChar + "");
       }

       while(!stack.isEmpty()) postfix += stack.removeFirst();
       return postfix;
    }
}
