package demo2;

/**
 * @author : jiang
 * @time : 2018/3/20 18:06
 */
public class PersonServiceImpl implements PersonService {

    @AopTest
    @Override
    public void save(String name) {
        System.out.println("do save");
    }

    @Override
    public void update(String name, Integer id) {
        System.out.println("do update");
    }

    @Override
    public String getPersonName(Integer id) {
        System.out.println("do get name");
        return "jiang";
    }
}
