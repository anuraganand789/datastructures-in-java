
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicateInArray {
    static final int[] ints = {1, 2, 3, 4, 5, 5, 6, 7, 8, 8, 8, 9, 10, 10};

    static void printArray(final int[] array){
        System.out.println(
            Arrays
                    .stream(array)
                    .filter(integer -> integer != 0)
                    .mapToObj(integer -> integer + "")
                    .collect(Collectors.joining(", "))
        );
    }

    static void printArray(final int[] array, final int startIndex, final int endIndex){
        System.out.println(
                IntStream.range(startIndex, endIndex)
                        .mapToObj(index -> array[index] + "")
                        .collect(Collectors.joining(", "))
        );
    }

    //O(n)
    static int[] removeDupWithExtraSpace(final int[] ints){
        final int lengthOfInts = ints.length;
        final int[] temp = new int[lengthOfInts];

        int indexInInts = 0;
        int indexInTemp = 0;

        int previousElement = ints[indexInInts];

        temp[indexInTemp] = previousElement;

        ++indexInInts;
        ++indexInTemp;

        while(indexInInts < lengthOfInts){
            final int currentInt = ints[indexInInts];

            if(currentInt != previousElement) {
                temp[indexInTemp] = currentInt;
                previousElement   = currentInt;
                ++indexInTemp;
            }

            ++indexInInts;
        }

        return temp;
    }

    //O(1)
    static int removeDupWithConstantSpace(final int[] ints){
        final int intsLength = ints.length;

        int intsIndex   = 0;
        int newEndIndex = 0;

        int previousElement = ints[intsIndex];

        ++intsIndex;
        ++newEndIndex;

        while(intsIndex < intsLength){
            final int currentElement = ints[intsIndex];

            if(currentElement != previousElement) {

                ints[newEndIndex] = currentElement;
                ++newEndIndex;

                previousElement = currentElement;
            }

            ++intsIndex;
        }

        return newEndIndex;
    }


    public static void main(String[] args) {
        printArray(removeDupWithExtraSpace(ints));
        printArray(ints, 0, removeDupWithConstantSpace(ints));
    }
}
