import java.util.Arrays;

public class SearchInRotateArray{
    public static void main(final String ... args){
	final int   searchValue = 1;
        final int[] dataSet = { 7, 8, 9, 10, 1, 2, 3 };
	//1st array -> { 7, 8, 9 }
	//2nd array -> { 1, 2, 3 }
	final int   dataSetLength = dataSet.length;

	final int pivotIndex = thePivotIndex(dataSet);
	System.out.format("The pivot index is %d.%n", pivotIndex);
	
	int searchSuccessIndex  =  Arrays.binarySearch(dataSet, 0, pivotIndex + 1, searchValue);
	if(searchSuccessIndex < 0) searchSuccessIndex = Arrays.binarySearch(dataSet, pivotIndex, dataSetLength, searchValue);

	if(searchSuccessIndex < 0) System.out.format("%d was not found in the array.%n", searchValue);
	else                       System.out.format("%d was found @ index %d.%n", searchValue, searchSuccessIndex);

    }

    private static final int thePivotIndex(final int[] dataSet){
	final int lengthOfDataSet = dataSet.length;

        int indexOnTheLeftSide  = 0;
	int indexOnTheRightSide = lengthOfDataSet - 1; 
	int indexBetweenLeftAndRightIndex;

	int valueOnTheLeftIndex;
	int valueOnTheRightIndex;
	int valueOnTheMidIndex;
	int valueOnTheLeftOfMidIndex;
	int valueOnTheRightOfMidIndex;

	while(indexOnTheLeftSide < indexOnTheRightSide){
	    indexBetweenLeftAndRightIndex = ((indexOnTheRightSide - indexOnTheLeftSide) / 2) + indexOnTheLeftSide;

	    valueOnTheLeftIndex  = dataSet[indexOnTheLeftSide];
	    valueOnTheRightIndex = dataSet[indexOnTheRightSide];
	    valueOnTheMidIndex   = dataSet[indexBetweenLeftAndRightIndex];

	    valueOnTheLeftOfMidIndex = dataSet[indexBetweenLeftAndRightIndex - 1];
	    valueOnTheRightOfMidIndex= dataSet[indexBetweenLeftAndRightIndex + 1];

	    if(valueOnTheMidIndex > valueOnTheRightOfMidIndex) return indexBetweenLeftAndRightIndex;
	    if(valueOnTheMidIndex < valueOnTheLeftOfMidIndex)  return indexBetweenLeftAndRightIndex - 1;

	    if(valueOnTheMidIndex > valueOnTheRightIndex)      indexOnTheLeftSide  = indexBetweenLeftAndRightIndex + 1;
	    if(valueOnTheMidIndex < valueOnTheLeftIndex)       indexOnTheRightSide = indexBetweenLeftAndRightIndex - 1;
	}

	return -1;
    }
}
