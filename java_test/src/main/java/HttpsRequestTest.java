import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author : jiang
 * @time : 2018/4/11 14:15
 */
public class HttpsRequestTest {

    private final static HostnameVerifier DO_NOT_VERIFY = (s, sslSession) -> true;

    private static void trustAllHosts() {
        TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustManagers, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String sendHttps(String a, String url) {
        StringBuilder result = new StringBuilder();
        PrintWriter writer = null;
        BufferedReader in = null;
        HttpsURLConnection conn;
        try {
            trustAllHosts();
            URL realUrl = new URL(url);
            if (realUrl.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) realUrl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpsURLConnection) realUrl.openConnection();
            }
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            writer = new PrintWriter(conn.getOutputStream());
            writer.print(a);
            writer.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(sendHttps("", "https://api.mch.weixin.qq.com/pay/orderquery"));
    }
}
