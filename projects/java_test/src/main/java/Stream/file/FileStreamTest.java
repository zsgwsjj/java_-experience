package Stream.file;

import java.io.*;

/**
 * @author : jiang
 * @time : 2018/4/19 10:09
 */
public class FileStreamTest {

    private static final String FILE_NAME = "file.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            File file = new File(FILE_NAME);
            FileOutputStream out = new FileOutputStream(file);
            PrintStream printStream = new PrintStream(out);
            printStream.print("abcdefghijklmnopqrstuvwxyz");
            out.close();

            FileOutputStream out2 = new FileOutputStream(file, true);
            PrintStream printStream2 = new PrintStream(out2);
            printStream2.println("0123456789");
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            File file = new File(FILE_NAME);
            FileInputStream in = new FileInputStream(file);

            FileInputStream in2 = new FileInputStream(FILE_NAME);

            FileDescriptor fdin = in2.getFD();
            FileInputStream in3 = new FileInputStream(fdin);

            char c1 = (char) in.read();
            System.out.println("c1=" + c1);
            in.skip(25);
            byte[] buf = new byte[10];

            in.read(buf, 0, 10);
            System.out.println(buf.length);
            System.out.println("buf=" + new String(buf));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(in3);
            char c2 = (char) bufferedInputStream.read();
            System.out.println("c2=" + c2);

            in.close();
            in2.close();
            in3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
