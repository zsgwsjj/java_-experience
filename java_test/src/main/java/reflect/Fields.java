package reflect;

import java.lang.reflect.Field;

/**
 * @author : jiang
 * @time : 2018/4/13 11:56
 */
public class Fields {

    public static void main(String[] args) throws Exception {
        Class stuClass = Class.forName("reflect.Student");
        System.out.println("************获取所有公有的字段********************");
        Field[] fields = stuClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        fields = stuClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("*************获取公有字段**并调用***********************************");
        Field field = stuClass.getField("name");
        Object object = stuClass.getConstructor().newInstance();
        field.set(object, "x");
        Student student = (Student) object;
        System.out.println(student.name);

        System.out.println("**************获取私有字段****并调用********************************");
        field = stuClass.getDeclaredField("phoneNum");
        field.setAccessible(true);
        field.set(object,"1111111");
        System.out.println(student);
    }

}
