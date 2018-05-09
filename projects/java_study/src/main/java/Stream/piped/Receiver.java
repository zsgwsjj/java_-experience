package Stream.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author : jiang
 * @time : 2018/4/18 17:56
 */
public class Receiver extends Thread {

    private PipedInputStream in = new PipedInputStream();

    public PipedInputStream getInputStream() {
        return in;
    }

    @Override
    public void run() {
        readMessageContinued();
    }

    public void readMessageOnce() {
        byte[] buf = new byte[2048];
        try {
            int len = in.read(buf);
            System.out.println(new String(buf, 0, len));
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessageContinued() {
        int total = 0;
        while (true) {
            byte[] buf = new byte[1024];
            try {
                int len = in.read(buf);
                total += len;
                System.out.println(new String(buf, 0, len));
                if (total > 1024) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
