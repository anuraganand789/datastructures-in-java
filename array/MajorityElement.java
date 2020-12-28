import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityElement{
    public static void main(final String ... args){
        final int[] dataSet = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 6 };
	final int   dataSetLength = dataSet.length;

	final Map<Integer, Integer> numberFrequency = new LinkedHashMap<>(dataSetLength);

	for(final int number : dataSet){
	    numberFrequency.putIfAbsent(number, 0);
	    numberFrequency.put(number, 1 + (numberFrequency.get(number)));
	}

	int majorityElement = -1;
	for(Map.Entry<Integer, Integer> entry : numberFrequency.entrySet()){
	    if(entry.getValue() > dataSetLength / 2) {
	        majorityElement = entry.getKey(); 
		break;
            }
	}

	if(majorityElement == -1 ) System.out.println("No majority element was found");
	else                       System.out.format("Majority Element %d is found.%n", majorityElement);
    }
}
