package math;

import java.util.Arrays;

public class BinaryFind {

    private int doSort(int[] array, int num, int high, int low) {
        int mid = (high + low) / 2;
        if (array[mid] == num) {
            return mid;
        }
        if (num > array[mid]) {
            low = mid + 1;
        }
        if (num < array[mid]) {
            high = mid - 1;
        }
        if (high < low || array[high] < num || array[low] > num) {
            return -1;
        }
        return doSort(array, num, high, low);
    }

    public static void main(String[] args) {
        int[] array = {1, 26, 5, 13, 6, 2, 8};
        Arrays.sort(array);
        System.out.println(new BinaryFind().doSort(array, 26, array.length - 1, 0));
    }
}
