package math;

import java.util.Arrays;

/**
 * @author : jiang
 * @time : 2018/5/23 11:03
 */
public class Sort {

    private static void sort(int a[], int low, int high) {
        int i, j, index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = a[i];
        while (i < j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < index) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = index;
        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

    private static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
