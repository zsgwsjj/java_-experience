package Stream.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author : jiang
 * @time : 2018/4/18 18:12
 */
public class PipedStreamTest {

    public static void main(String[] args) {
        Sender s1 = new Sender();
        Receiver r1 = new Receiver();
        PipedOutputStream out = s1.getOut();
        PipedInputStream in = r1.getInputStream();

        try {
            in.connect(out);
            s1.start();
            r1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
