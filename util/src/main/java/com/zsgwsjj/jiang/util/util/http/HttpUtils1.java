package com.zsgwsjj.jiang.util.util.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author : jiang
 * @time : 2018/5/29 15:01
 */
public class HttpUtils1 {

    public static String sendPost(String urlParam, Map<String, Object> params, String charset) {
        StringBuffer resultBuffer = null;

        String sbParams = dealWithParam(params);

        HttpURLConnection con = null;
        OutputStreamWriter osw = null;
        BufferedReader br = null;

        try {
            URL url = new URL(urlParam);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            if (sbParams.length() > 0) {
                osw = new OutputStreamWriter(con.getOutputStream(), charset);
                osw.write(sbParams.substring(0, sbParams.length() - 1));
                osw.flush();
            }

            resultBuffer = new StringBuffer();
            int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
            if (contentLength > 0) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
                String temp;
                while ((temp = br.readLine()) != null) {
                    resultBuffer.append(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    con.disconnect();
                    con = null;
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (con != null) {
                        con.disconnect();
                    }
                }

            }
        }
        return resultBuffer.toString();
    }

    public static void sendGetAndSaveFile(String urlParam, Map<String, Object> params, String charset, String fileSavePath) {
        String sbParams = dealWithParam(params);
        HttpURLConnection con = null;
        BufferedReader br = null;
        FileOutputStream os = null;

        try {
            URL url = null;
            if (sbParams != null && sbParams.length() > 0) {
                url = new URL(urlParam + "?" + sbParams);
            } else {
                url = new URL(urlParam);
            }
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.connect();
            InputStream is = con.getInputStream();
            os = new FileOutputStream(fileSavePath);
            byte buf[] = new byte[1024];
            int count = 0;
            while ((count = is.read(buf)) != -1) {
                os.write(buf, 0, count);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    os = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                    throw new RuntimeException(e);
                } finally {
                    if (con != null) {
                        con.disconnect();
                        con = null;
                    }
                }
            }
        }
    }

    private static String dealWithParam(Map<String, Object> params) {
        StringBuilder sbParams = new StringBuilder();
        if (params != null && params.size() > 0) {
            for (Map.Entry entry : params.entrySet()) {
                sbParams.append(entry.getKey());
                sbParams.append("=");
                sbParams.append(entry.getValue());
                sbParams.append("&");
            }
        }
        return sbParams.substring(0, sbParams.length() - 1);
    }

}
