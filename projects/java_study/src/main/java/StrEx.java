/**
 * @author : jiang
 * @time : 2018/5/31 16:42
 * @desc : 字符串颠倒
 */
public class StrEx {

    public static void main(String[] args) {
        String s = "jiang";

        System.out.println(doIt(s));
    }

    private static String doIt(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);

        return doIt(right) + doIt(left);

    }
}
