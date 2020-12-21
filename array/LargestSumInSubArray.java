public class LargestSumInSubArray{
    
    public static void main(final String ... args){
       final int   subArraySize = 3;
       final int[] dataSet = { -7, 9, -4, 2, 3, 1, 5 };
       //{ -7, 9, -4, 2} => S
       //{ 9, -4, 2, 3 }; => S - (-7) and S + 3
       //{ -4, 2, 3, 1};
       //{ 2, 3, 1, 5 };
       final int   dataSetLength = dataSet.length;

       int leftIndex  = 0,                   maxLeftIndex  = leftIndex;
       int rightIndex = subArraySize - 1   , maxRightIndex = rightIndex;

       int currentSum = 0;
       for(int index = 0; index < subArraySize; ++index) { currentSum += dataSet[index]; }
       int maxSum = currentSum;

       int subtractFromSum;
       int addToSum;

       while(rightIndex < dataSetLength){
           subtractFromSum = dataSet[leftIndex];
	   ++leftIndex;

	   ++rightIndex; if(rightIndex == dataSetLength) break;
	   addToSum = dataSet[rightIndex];

	   currentSum -= subtractFromSum;
	   currentSum += addToSum;
           
	   if(maxSum < currentSum) {
	       maxSum        = currentSum;
	       maxLeftIndex  = leftIndex;
	       maxRightIndex = rightIndex;
	   }

       }

       System.out.format("max sum %d, left Index = %d, right index = %d. %n", maxSum, maxLeftIndex, maxRightIndex);
    }
}
