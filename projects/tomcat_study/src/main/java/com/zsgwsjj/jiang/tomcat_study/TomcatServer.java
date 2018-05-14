package com.zsgwsjj.jiang.tomcat_study;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.StringTokenizer;

/**
 * @author : jiang
 * @time : 2018/5/10 15:48
 */
public class TomcatServer {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            ServerHandler serverHandler = new ServerHandler(server);
            serverHandler.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ServerHandler extends Thread {
        ServerSocket server = null;

        public ServerHandler(ServerSocket server) {
            this.server = server;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Socket client = null;
                    client = server.accept();
                    if (client != null) {
                        System.out.println("received a request from client!");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        String line = reader.readLine();
                        System.out.println("line: " + line);

                        String resource = line.substring(line.indexOf('/'), line.lastIndexOf('/') - 5);
                        System.out.println("the resources you request is: " + resource);
                        resource = URLDecoder.decode(resource, "UTF-8");

                        String method = new StringTokenizer(line).nextElement().toString();
                        System.out.println("the request method you send is: " + method);

                        while ((line = reader.readLine()) != null) {
                            if (line.equals("")) {
                                break;
                            }
                            System.out.println("the header is : " + line);
                        }

                        if (method.toLowerCase().equals("post")) {
                            System.out.println("the post request body is: " + reader.readLine());
                        } else if ("get".equals(method.toLowerCase())) {
                            if (resource.endsWith(".jpg")) {
                                transferFileHandle("d://123.jpg", client);
                                closeSocket(client);
                                continue;
                            } else {
                                PrintStream write = new PrintStream(client.getOutputStream(), true);
                                write.println("HTTP/1.0 200 OK");
                                write.println("Content-Type:text/html;charset=utf-8");
                                write.println();
                                write.println("<html><body>");
                                write.println("<a href='www.baidu.com'>百度</a>");
                                write.println("<img src='http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E7%99%BE%E5%" +
                                        "BA%A6&step_word=&hs=0&pn=1&spn=0&di=120210580930&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&i" +
                                        "e=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1645649503%2C3446658575&os=2882650515%2C336198689" +
                                        "3&simid=4205767217%2C676622381&adpicid=0&lpn=0&ln=1955&fr=&fmq=1525947747551_R&fm=&ic=undefined&s" +
                                        "=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&ist=&jit=&cg=&bdtype=0&" +
                                        "oriquery=&objurl=http%3A%2F%2Fwww.swkweike.com%2Fdata%2Fuploads%2F2015%2F08%2F18%2F44760555255d2d" +
                                        "bff72977.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bfohojthj_z%26e3Bv54AzdH3Fw6ptvsj-tgu5-dcb" +
                                        "0_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0&islist=&querylist='></img>");
                                write.println("</html></body>");
                                write.println();
                                write.close();
                                closeSocket(client);
                                continue;
                            }
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
            System.out.println(socket + "离开了Http服务器");
        }

        private void transferFileHandle(String path, Socket client) {

            File fileToSend = new File(path);
            if (fileToSend.exists() && !fileToSend.isDirectory()) {
                try {
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("Http/1.0 200 OK");
                    writer.println("Content-Type:application/binary");
                    writer.println("Content-Length:" + fileToSend.length());
                    writer.println();

                    FileInputStream fis = new FileInputStream(fileToSend);
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    writer.write(bytes);
                    writer.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
