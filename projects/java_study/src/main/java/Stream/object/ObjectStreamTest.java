package Stream.object;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/4/18 18:31
 */
public class ObjectStreamTest {

    private static final String TMP_FILE = "box.tmp";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            out.writeBoolean(true);
            out.writeByte((byte) 65);
            out.writeChar('a');
            out.writeInt(11111);
            out.writeFloat(112.11f);
            out.writeDouble(1.2121d);

            HashMap map = new HashMap();
            map.put("1", "red");
            map.put("2", "green");
            map.put("3", "blue");

            out.writeObject(map);

            Box box = new Box(80, 40, "desk");
            out.writeObject(box);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));
            System.out.printf("boolean:%b\n", in.readBoolean());
            System.out.printf("byte:%d\n", in.readByte());
            System.out.printf("char:%c\n", in.readChar());
            System.out.printf("int:%d\n", in.readInt());
            System.out.printf("float:%f\n", in.readFloat());
            System.out.printf("double:%f\n", in.readDouble());

            HashMap map = (HashMap) in.readObject();
            for (Object o : map.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                System.out.printf("%-6s -- %s\n", entry.getKey(), entry.getValue());
            }
            Box box = (Box) in.readObject();
            System.out.println("box:" + box);
            in.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }


}

class Box implements Serializable {

    private int width;
    private int height;
    private String name;

    public Box(int width, int height, String name) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public Box setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Box setHeight(int height) {
        this.height = height;
        return this;
    }

    public String getName() {
        return name;
    }

    public Box setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
