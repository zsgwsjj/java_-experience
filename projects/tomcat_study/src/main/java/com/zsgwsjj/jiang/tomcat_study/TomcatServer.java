package com.zsgwsjj.jiang.tomcat_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

/**
 * @author : jiang
 * @time : 2018/4/25 16:50
 */
public class TomcatServer {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            ServletHandler serverHandler = new ServletHandler(serverSocket);
            serverHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ServletHandler extends Thread {
        ServerSocket serverSocket = null;

        public ServletHandler(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Socket client = null;
                    client = serverSocket.accept();
                    if (client != null) {
                        try {
                            System.out.println("接收到一个客户端的请求！");
                            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            String line = reader.readLine();
                            System.out.println("line: " + line);
                            String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/' - 5));
                            System.out.println("the resource you request is: " + resource);
                            resource = URLDecoder.decode(resource, "UTF-8");
                            String method = new StringTokenizer(line).nextElement().toString();

                            System.out.println("the request method you send is: " + method);
                            while ((line = reader.readLine()) != null) {
                                if (line.equals("")) {
                                    break;
                                }
                                System.out.println("the Http Header is : " + line);
                            }
                            if ("post".equals(method.toLowerCase())) {
                                System.out.println("the post request body is: " + reader.readLine());
                            } else if ("get".equals(method.toLowerCase())) {
                                if (resource.endsWith(".jpg")) {
                                    transferFileHandle("/Users/wangjia/Desktop/表情包/59cf01289a05e.jpg", client);
                                    closeSocket(client);
                                } else {
                                    PrintStream writer = new PrintStream(client.getOutputStream(), true);
                                    writer.println("HTTP/1.0 200 OK");
                                    writer.println("Content-Type:text/html;charset=utf-8");
                                    writer.println();
                                    writer.println("<html><body>");
                                    writer.println("<a href='www.baidu.com'>百度</a>");
                                    writer.println("<img src='https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/" +
                                            "logo/bd_logo1_31bdc765.png'></img>");
                                    writer.println("</html></body>");
                                    writer.println();
                                    writer.close();
                                    closeSocket(client);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void closeSocket(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(socket + "离开了HTTP服务器");
        }

        private void transferFileHandle(String path, Socket client) {
            File fileToSend = new File(path);
            if (fileToSend.exists() && !fileToSend.isDirectory()) {
                try {
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("HTTP/1.0 200 OK");
                    writer.println("Content-Type:application/binary");
                    writer.println("Content-Length:" + fileToSend.length());
                    writer.println();

                    FileInputStream inputStream = new FileInputStream(fileToSend);
                    byte[] buf = new byte[inputStream.available()];
                    inputStream.read(buf);
                    writer.write(buf);
                    writer.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
