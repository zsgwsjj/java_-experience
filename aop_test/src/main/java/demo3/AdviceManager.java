package demo3;

/**
 * @author : jiang
 * @time : 2018/3/20 18:39
 */
public class AdviceManager {

    public String manyAdvices(String param1, String param2) {
        System.out.println("method: manyAdvices");
        return param1 + "、" + param2;
    }
}
