package math;

import java.util.Random;

/**
 * @author : jiang
 * @time : 2018/5/23 17:43
 */
public class NumberUtils {

    public static int[] getRandomArs(int length, int max) {
        int rs[] = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            rs[i] = random.nextInt(max);
        }
        return rs;
    }

    public static void display(int intArrays[], int type) {
        int count = 0;
        if (type == 2) {
            System.out.print("排序后：");
        } else if (type == 1) {
            System.out.print("排序前：");
        }
        if (intArrays.length < 40) {
            for (int i : intArrays) {
                System.out.print(i + " ");
            }
        } else {
            for (int i : intArrays) {
                count++;
                if (count < 10) {
                    System.out.print(i + " ");
                } else if (count == 10) {
                    System.out.print("......");
                } else if (count > intArrays.length - 10) {
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println();
    }

    public static void exchange(int[] a, int i, int j) {
        int tem = a[i];
        a[i] = a[j];
        a[j] = tem;
    }

}
