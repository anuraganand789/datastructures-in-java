public class OddOccurrencesOfNumber{
    public static void main(final String ... args){
        final int[] dataSet = {1, 1, 2, 2, 3, 3, 4, 4, 10, 10, 10, 10, 10 };
	int missingNumber = 0;

	//missingNumber -> 0000
        //1 = 0001 
        // 
	//XOR Truth Table
	//1 ^ 1 = 0
	//0 ^ 0 = 0
	//1 ^ 0 = 1
	//0 ^ 1 = 1

	//missingNumber ^ 1 ->  0  ^ 0 = 0 
        //                      0  ^ 0 = 0
	//		        0  ^ 0 = 0
	//		        0  ^ 1 = 1

	//1 ^ 1 ->              0  ^ 0 = 0 
        //                      0  ^ 0 = 0
	//		        0  ^ 0 = 0
	//		        1  ^ 1 = 0

	//1 ^ 1 ^ 1 ->          0  ^ 0 = 0 ^ 0 = 0 
        //                      0  ^ 0 = 0 ^ 0 = 0 
	//		        0  ^ 0 = 0 ^ 0 = 0 
	//		        1  ^ 1 = 0 ^ 1 = 1 

	for(final int number : dataSet) missingNumber ^= number;

	System.out.format("Number with Odd number of occurrences is %d.%n", missingNumber);
    }
}
