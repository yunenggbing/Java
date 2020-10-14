package com.test;


import com.bean.Express;
import com.view.Views;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Client {
    private Socket socket;
    private Views view = new Views();

    public static void main(String[] args) {
        Client client = new Client();
        client.link();
    }

    //服务器连接
    public void link(){
        OutputStream os = null;
        InputStream is = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("服务器连接成功");
            os = socket.getOutputStream();
            is = socket.getInputStream();
            oos = new ObjectOutputStream(os);
            ois = new ObjectInputStream(is);
            o:while (true){
                int num = view.login();
                oos.writeInt(num);
                oos.flush();
                switch (num){
                    case 0:
                        break o;
                    case 1:
                        aindex(oos,ois);
                        break;
                    case 2:
                        uindex(oos,ois);
                        break;
                    default:
                        view.choiceError();
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

    public void aindex(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        while (true) {
            int num = view.aindex();
            oos.writeInt(num);
            oos.flush();
            switch (num){
                case 0:
                    return;
                case 1:
                    insert(oos,ois);
                    break;
                case 2:
                    delete(oos,ois);
                    break;
                case 3:
                    update(oos,ois);
                    break;
                case 4:
                    printAll(oos,ois);
                    break;
                default:
                    view.choiceError();
                    break;
            }
        }
    }

    public void insert(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        Express e = view.insert();
        oos.writeObject(e);
        oos.flush();
        Express e1 = (Express) ois.readObject();
        if (e1==null) {
            Boolean insert = ois.readBoolean();
            if(insert){
                view.printInsert();
                view.printExpress(e);
            }else{
                view.insertError();
            }
        } else {
            view.youle();
        }
    }

    public void update(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        String id = view.update();
        oos.writeObject(id);
        oos.flush();
        Express e = (Express) ois.readObject();
        if(e!=null){
            view.printExpress(e);
            Express e2 = view.newData();
            oos.writeObject(e2);
            oos.flush();
            Boolean insert = ois.readBoolean();
            if(insert){
                view.printUpdata();
                view.deleteCode(e.getCode());
            }else{
                view.updataError();
            }
        }else{
            view.error();
        }
    }

    public void delete(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        String id = view.delete();
        oos.writeObject(id);
        oos.flush();
        Express e = (Express) ois.readObject();
        if(e!=null){
            int num = view.deleteConfirm();
            oos.writeInt(num);
            oos.flush();
            switch (num){
                case 1:
                    Boolean delete = ois.readBoolean();
                    if(delete){
                        view.printDelete();
                        view.deleteCode(e.getCode());
                    }else{
                        view.deleteError();
                    }
                    break;
                case 2:
                    break;
                default:
                    view.choiceError();
                    break;
            }
        }else{
            view.error();
        }
    }

    public void printAll(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        Express[] expresses = (Express[])ois.readObject();
        List<Express> list = Arrays.asList(expresses);
        if(list.size()>0){
            view.printAll(list);
        }else {
            view.nullExpress();
        }
    }

    public void uindex(ObjectOutputStream oos,ObjectInputStream ois) throws Exception {
        while(true){
            int num = view.uindex();
            oos.writeInt(num);
            oos.flush();
            switch (num){
                case 0:
                    return;
                case 1:
                    int code = view.getExpress();
                    oos.writeInt(code);
                    oos.flush();
                    Express e = (Express) ois.readObject();
                    if(e!=null){
                        view.address(ois.readInt());
                        view.printExpress(e);
                        view.printGet();
                        Boolean delete = ois.readBoolean();
                        if(delete){
                            view.deleteCode(e.getCode());
                        }else{
                            view.getError();
                        }
                    }else{
                        view.error();
                    }
                    break;
                default:
                    view.choiceError();
                    break;
            }
        }
    }
}
