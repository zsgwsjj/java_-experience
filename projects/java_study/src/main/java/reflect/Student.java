package reflect;

/**
 * @author : jiang
 * @time : 2018/4/13 10:59
 */
public class Student {

    Student(String str) {
        System.out.println("（默认）的构造方法 s = " + str);
    }

    public Student() {
        System.out.println("共有，无参的构造方法 ");
    }

    public Student(char name) {
        System.out.println("姓名：" + name);
    }

    public Student(String name, int age) {
        System.out.println("姓名：" + name + "年龄：" + age);//这的执行效率有问题，以后解决。
    }

    protected Student(boolean n) {
        System.out.println("受保护的构造方法 n = " + n);
    }

    private Student(int age) {
        System.out.println("私有的构造方法   年龄："+ age);
    }

    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public char getSex() {
        return sex;
    }

    public Student setSex(char sex) {
        this.sex = sex;
        return this;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Student setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        return this;
    }
}
