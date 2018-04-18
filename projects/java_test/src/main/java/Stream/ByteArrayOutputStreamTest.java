package Stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/4/18 17:31
 */
public class ByteArrayOutputStreamTest {

    private static final int LEN = 5;

    private static final byte[] ArrayLetters = {0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A};

    public static void main(String[] args) {
        testByteArrayOutputStream();
    }

    private static void testByteArrayOutputStream() {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        b.write(0x41);
        b.write(0x42);
        b.write(0x43);
        System.out.printf("b=%s\n", b);

        b.write(ArrayLetters, 3, 5);
        System.out.printf("b=%s\n", b);

        int size = b.size();
        System.out.println(size);

        byte[] buf = b.toByteArray();
        String str = new String(buf);
        System.out.printf("str=%s\n", str);

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            b.writeTo(outputStream);
            System.out.printf("out=%s\n",outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
