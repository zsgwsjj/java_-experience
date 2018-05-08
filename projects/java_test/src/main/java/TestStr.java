/**
 * @author : jiang
 * @time : 2018/4/10 10:30
 */
public class TestStr {

    public static void main(String[] args) {
        Xuxu xuxu = new Xuxu();
        xuxu.setName("徐旭").setAge(23).setDickLength(3).setMoney(10000000);
        if (xuxu.isYangWei()){
            System.out.println(xuxu.toString()+"是阳痿！");
        }
    }

    static class Xuxu {
        String name;
        int age;
        long dickLength;
        long money;

        public String getName() {
            return name;
        }

        public Xuxu setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Xuxu setAge(int age) {
            this.age = age;
            return this;
        }

        public long getDickLength() {
            return dickLength;
        }

        public Xuxu setDickLength(long dickLength) {
            this.dickLength = dickLength;
            return this;
        }

        public long getMoney() {
            return money;
        }

        public Xuxu setMoney(long money) {
            this.money = money;
            return this;
        }

        private boolean isYangWei() {
            return true;
        }

        @Override
        public String toString() {
            return "Xuxu{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", dickLength=" + dickLength +
                    ", money=" + money +
                    '}';
        }
    }
}
