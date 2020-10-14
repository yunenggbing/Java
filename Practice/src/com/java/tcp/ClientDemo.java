package com.java.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-09-07 19:48
 * @Modified By:
 */
public class ClientDemo {
    /**
     * 客户端
     * @param args
     */
    public static void main(String[] args) throws IOException {
        //连接服务器
        Socket socket = new Socket("localhost",8081);
        System.out.println("连接成功");

        //接收服务器的消息
        InputStream is = socket.getInputStream();
        BufferedReader bf =  new BufferedReader(new InputStreamReader(is));
        String  text = bf.readLine();
        System.out.println("服务器的消息是："+text);

        //给服务器发消息
        OutputStream os  =  socket.getOutputStream();
        PrintStream ps =  new PrintStream(os);
        ps.println("谢谢服务器！");

    }
}
