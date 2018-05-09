package Stream.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author : jiang
 * @time : 2018/4/18 18:05
 */
public class Sender extends Thread {

    private PipedOutputStream out = new PipedOutputStream();

    public PipedOutputStream getOut() {
        return out;
    }

    @Override
    public void run() {
        writeLongMessage();
    }

    private void writeShortMessage() {
        String strInfo = "enjoygame";
        try {
            out.write(strInfo.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeLongMessage() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 102; i++) {
            sb.append("0123456789");
        }
        sb.append("abcdefghijklmnopqrstuvwxyz");
        String str = sb.toString();
        System.out.println(str);
        try {
            out.write(str.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
