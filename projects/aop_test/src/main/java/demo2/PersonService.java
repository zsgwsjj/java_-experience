package demo2;

/**
 * @author : jiang
 * @time : 2018/3/20 18:05
 */
public interface PersonService {

    void save(String name);

    void update(String name, Integer id);

    String getPersonName(Integer id);
}
