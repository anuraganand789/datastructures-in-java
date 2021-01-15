import java.util.Map;
import java.util.Deque;

import java.util.ArrayDeque;
import java.util.HashMap;

public class BalancedParentheses{
    private static boolean parenthesesIsClosed(final String parentheses){
        return ")}]".indexOf(parentheses) > -1;
    }

    private static boolean parenthesesIsOpened(final String parentheses){
        return "({[".indexOf(parentheses) > -1;
    }

    private static Map<String, String> mapFromCloseToOpen = new HashMap<>();

    public static void main(final String[] commandlineArguments){
        mapFromCloseToOpen.put(")", "(");
        mapFromCloseToOpen.put("]", "[");
        mapFromCloseToOpen.put("}", "{");

        final String[] tests = {"(()]", "(())", "[()]", "}{}}" };

	for(final String test : tests){
	    final char[] chars = test.toCharArray();
	    final Deque<String> stack = new ArrayDeque<>();
	    System.out.format("Testing %s -> ", test);

	    for(final char ch : chars){
		final String currentParentheses = ch + "";
		boolean parenIsClosed = parenthesesIsClosed(currentParentheses);

	        if(parenIsClosed && stack.isEmpty()) { 
		    System.out.println("The string is unbalanced");
		    break;
		}

		if(parenIsClosed){
		    String paren = stack.removeFirst();
		    String parenInMap = mapFromCloseToOpen.get(currentParentheses);

		    //System.out.format("paren From stack %s, and paren from Map %s. %n", paren, parenInMap);
		    if(!paren.equals(parenInMap)){
		        System.out.println("The string is unbalanced...");
			break;
	            }
		}

		if(parenthesesIsOpened(currentParentheses)) stack.addFirst(currentParentheses);
	    }
	}
    }
}
