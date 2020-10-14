package com.java.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: YNB
 * @Description:TCP网络编程
 * @Date Created in 2020-09-07 19:47
 * @Modified By:
 */
public class Tcp {
    /**
     * 服务器
     * @param args
     */

    public static void main(String[] args) throws IOException {
        //搭建服务器
        ServerSocket server  = new ServerSocket(8081);
        System.out.println("服务器启动完成");
        //等待客户端连接
            while(true) {
                Socket socket = server.accept();
                new Thread(){
                    @Override
                    public void run() {
                        //给客户端发送消息
                        OutputStream os = null;
                        try {
                            os = socket.getOutputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        PrintStream ps = new PrintStream(os);
                        ps.println("客户端你好呀！");

                        //接收客户端的消息
                        InputStream is = null;
                        try {
                            is = socket.getInputStream();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        BufferedReader bf =  new BufferedReader(new InputStreamReader(is));

                        String text = null;
                        try {
                            text = bf.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("客户端返回的消息是："+text);
                    }
                }.start();
                System.out.println("连接的客户端是：" + socket);

            }
    }
}
