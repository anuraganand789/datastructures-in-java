import java.util.Set;
import java.util.HashSet;

public class IsSubsetOfArray{
    public static void main(final String[] args){
        final Set<String> setOfStrings = new HashSet<>();

	final String[] mainArray = { "I", "Am", "Anurag", "Anand"};
        
	for(final String str : mainArray){ setOfStrings.add(str); }

	final String[][] testsArray = { { "I" }, {"I", "Not"}, {"Anurag", "Anand"} };

	for(final String[] test : testsArray){
	    System.out.format("%s%n", isArrayASubset(test, setOfStrings) ? "True" : "False");
	}
    }

    private static boolean isArrayASubset(final String[] arrayOfStrings, final Set<String> setOfStrings){
        if(arrayOfStrings == null || setOfStrings == null) return false;
	for(final String str : arrayOfStrings){
	    if(!setOfStrings.contains(str)) return false;
	}
	return true;
    }
}
