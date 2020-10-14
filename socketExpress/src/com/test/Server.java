package com.test;


import com.bean.Express;
import com.dao.Dao;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private ServerSocket server;
    private Dao dao = new Dao();

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start(){
        try {
            server = new ServerSocket(8888);
            System.out.println("服务器已启动");
            dao.readFromFile();
            while (true){
                Socket socket = server.accept();
                System.out.println("一个客户端进入连接");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        receive(socket);
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(server!=null){
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void receive(Socket socket){
        InputStream is = null;
        OutputStream os = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            ois = new ObjectInputStream(is);
            oos = new ObjectOutputStream(os);
            o:while (true){
                switch (ois.readInt()){
                    case 0:
                        dao.writeToFile();
                        System.out.println("一个客户端断开连接");
                        break o;
                    case 1:
                        aindex(ois,oos);
                        break;
                    case 2:
                        uindex(ois,oos);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois!=null) {
                    ois.close();
                }
                if(oos!=null) {
                    oos.close();
                }
                if(socket!=null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void aindex(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        while (true) {
            switch (ois.readInt()){
                case 0:
                    return;
                case 1:
                    insert(ois,oos);
                    break;
                case 2:
                    delete(ois,oos);
                    break;
                case 3:
                    update(ois,oos);
                    break;
                case 4:
                    printAll(ois,oos);
                    break;
                default:
                    break;
            }
        }
    }

    public void insert(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        Express e = (Express) ois.readObject();
        Express e1 = dao.getByNumber(e.getId());
        oos.writeObject(e1);
        oos.flush();
        if (e1==null) {
            Boolean insert = dao.insert(e);
            oos.writeBoolean(insert);
            oos.flush();
        }
    }

    public void update(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        String id = (String)ois.readObject();
        Express e = dao.getByNumber(id);
        oos.writeObject(e);
        oos.flush();
        if(e!=null){
            Express e2 = (Express) ois.readObject();
            Boolean insert = dao.updata(e,e2);
            oos.writeBoolean(insert);
            oos.flush();
        }
    }

    public void delete(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        String id = (String)ois.readObject();
        Express e = dao.getByNumber(id);
        oos.writeObject(e);
        oos.flush();
        if(e!=null){
            switch (ois.readInt()){
                case 1:
                    Boolean delete = dao.delete(e);
                    oos.writeBoolean(delete);
                    oos.flush();
                    break;
                default:
                    break;
            }
        }
    }

    public void printAll(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        List<Express> list = dao.getAll();
        Express[] expresses = new Express[list.size()];
        list.toArray(expresses);
        oos.writeObject(expresses);
        oos.flush();
    }

    public void uindex(ObjectInputStream ois, ObjectOutputStream oos) throws Exception {
        while(true){
            switch (ois.readInt()){
                case 0:
                    return;
                case 1:
                    Express e = dao.getByCode(ois.readInt());
                    oos.writeObject(e);
                    oos.flush();
                    if(e!=null){
                        int index = dao.getIndex(e);
                        oos.writeInt(index);
                        oos.flush();
                        Boolean delete = dao.delete(e);
                        oos.writeBoolean(delete);
                        oos.flush();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
