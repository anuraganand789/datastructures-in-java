public class RotateAnArray{
    public static void main(final String ... args){
        final int[] numbers       = { 1, 2, 3, 4, 5, 6};
	final int   noOfRotations = 3;
        
	System.out.println("Before Rotations");
	printArray(numbers);

	rotateTheArray(numbers, noOfRotations);

	System.out.println("After Rotations");
	printArray(numbers);
    }

    private static void rotateTheArray(final int[] numbers, final int noOfRotations){
	final int lastIndex = numbers.length - 1;

        int rotationsDoneSoFar = 0;
	int firstValueOfArray;

        int index;
	while(rotationsDoneSoFar < noOfRotations){
	    firstValueOfArray = numbers[0];
            index = 0;
	    while(index < lastIndex){
	        numbers[index] = numbers[index + 1];
		++index;
	    }
	    numbers[lastIndex] = firstValueOfArray;
	    ++rotationsDoneSoFar;
	}
    }

    private static void printArray(final int[] numbers){
        for(final int number : numbers){ System.out.format("%d ", number); }
	System.out.println();
    }
}
