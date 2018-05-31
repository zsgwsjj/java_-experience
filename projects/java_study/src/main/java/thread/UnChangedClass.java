package thread;

/**
 * @author : jiang
 * @time : 2018/5/31 14:37
 */
public final class UnChangedClass {

    private final String name;
    private final Integer age;
    private final int[] myArray;

    public UnChangedClass(String name, Integer age, int[] myArray) {
        this.name = name;
        this.age = age;
        this.myArray = myArray.clone();
    }

    public int[] getMyArray() {
        return myArray.clone();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
