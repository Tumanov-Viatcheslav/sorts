import java.util.Arrays;

public class Sorts {

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i1 = 0, i2 = 0, k = 0;
        while (i1 < arr1.length && i2 < arr2.length) {
            if (arr1[i1] <= arr2[i2]) {
                res[k] = arr1[i1];
                i1++;
            }
            else {
                res[k] = arr2[i2];
                i2++;
            }
            k++;
        }
        if (i1 == arr1.length) {
            System.arraycopy(arr2, i2, res, k, arr2.length - i2);
        }
        else {
            System.arraycopy(arr1, i1, res, k, arr1.length - i1);
        }
        return res;
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 1)
            return;
        int[] arr1 = new int[arr.length / 2], arr2 = new int[arr.length - arr1.length];
        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr1.length, arr2, 0, arr2.length);
        mergeSort(arr1);
        mergeSort(arr2);
        System.arraycopy(merge(arr1, arr2), 0, arr, 0, arr.length);
    }

    public static void radixSortLSD(int[] arr, int radix) {
        int mask = 1, max = ArrayRoutines.max(arr), indexTmp, tmp;
        int[] indexesInBuckets = new int[radix], tmpArr = new int[arr.length];
        int[][] bucket = new int[radix][arr.length];
        Pair[] singleDigits = new Pair[arr.length];
        while (mask < max) {
            for (int i = 0; i < arr.length; i++) {
                tmp = (arr[i] / mask) % radix;
                if (tmp > 0)
                    singleDigits[i] = new Pair(tmp, i);
                else
                    singleDigits[i] = new Pair(0, i);
            }
            Arrays.fill(indexesInBuckets, 0);
            for (int i = 0; i < singleDigits.length; i++) {
                bucket[singleDigits[i].x1][indexesInBuckets[singleDigits[i].x1]] = singleDigits[i].x2;
                indexesInBuckets[singleDigits[i].x1]++;
            }
            indexTmp = 0;
            for (int i = 0; i < indexesInBuckets.length; i++) {
                for (int j = 0; j < indexesInBuckets[i]; j++) {
                    tmpArr[indexTmp] = arr[bucket[i][j]];
                    indexTmp++;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tmpArr[i];
            }
            mask *= radix;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            ArrayRoutines.swapTwoElements(arr, i, ArrayRoutines.indexOfMin(arr, i));
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    ArrayRoutines.swapTwoElements(arr, i, j);
            }
        }
    }

    public static void bubbleSortF(int[] arr) {
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArrayRoutines.swapTwoElements(arr, i, j);
                    flag = true;
                }
            }
            if (!flag)
                return;
        }
    }
}
