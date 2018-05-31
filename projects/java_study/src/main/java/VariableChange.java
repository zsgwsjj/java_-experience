/**
 * @author : jiang
 * @time : 2018/5/31 19:00
 * @desc : 变量交换不使用临时变量
 */
public class VariableChange {


    public static void main(String[] args) {
        int a = 3;
        int b = 1;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a + ",b=" + b);
    }
}
