
import java.util.Arrays;

public class mergeSort {

    public static void sort(int[] initialArray){
        sort(initialArray, 0, initialArray.length-1);
    }

    public static void sort(int[] initialArray, int beginIndex, int endIndex) {
        if (initialArray == null) {
            throw new NullPointerException();
        }  else if (beginIndex < endIndex) {
            int mid = (beginIndex + endIndex) / 2;

            sort(initialArray, beginIndex, mid);
            sort(initialArray, mid + 1, initialArray.length-1);

            merge(initialArray,beginIndex,mid, endIndex);
        }
    }

    public static void merge(int[] initialArray, int beginIndex, int mid, int endIndex) {

        int[] resultArray = new int[endIndex - beginIndex + 1];
        int leftArrayIndex = beginIndex;
        int rightArrayIndex = mid + 1;
        int resultArrayIndex = 0;

        while ((leftArrayIndex <= mid) || (rightArrayIndex <= endIndex)) {
            if (leftArrayIndex > mid) {
                resultArray[resultArrayIndex++] = initialArray[rightArrayIndex++];
            } else if (rightArrayIndex > endIndex) {
                resultArray[resultArrayIndex++] = initialArray[leftArrayIndex++];
            } else if (initialArray[rightArrayIndex] > initialArray[leftArrayIndex]) {
                resultArray[resultArrayIndex++] = initialArray[leftArrayIndex++];
            } else {
                resultArray[resultArrayIndex++] = initialArray[rightArrayIndex++];
            }
        }
        for (int i = 0; i < endIndex - beginIndex + 1; i++) {
            initialArray[i + beginIndex] = resultArray[i];
        }
    }

    public static void main(String args[]) {
        int[] SortingArray = {5,2,4,6,1,3,2,6};
        System.out.println(Arrays.toString(SortingArray));
        sort(SortingArray);
        System.out.println(Arrays.toString(SortingArray));
    }
}