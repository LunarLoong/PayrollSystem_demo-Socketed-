package ui;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) {
        Objectpool objectpool = Objectpool.getInstance();
        try {
            //监听指定端口
            ServerSocket ss = new ServerSocket(4041);
            //接收客户端链接请求，建立相应的socket对象
            Socket socket = ss.accept();
            System.out.println("已连接客户端");
            //读取客户端发来的call对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Call call = (Call) ois.readObject();
            System.out.println("服务端收到执行方案 =>" + call.getClassName() + '.' +call.getMethodName());
//            从对象池中找出对应的对象
            Object object = objectpool.getObject(call.getClassName());
//            从该对象上找出相应的方法对象
//            getSalary(String startTime,String endTime,double dou)
            Method method = object.getClass().getMethod(
                    call.getMethodName(),
                    call.getParamTypes());
//            方法对象执行  (invoke)
            Object rtObj = method.invoke(object, call.getParamValues());
            call.setReturnObj(rtObj);
            //返回方法执行结果
            ObjectOutputStream oos = new ObjectOutputStream(
                    socket.getOutputStream()
            );
            //将call对象返回客户端
            oos.writeObject(call);
            oos.flush();

            ois.close();
            oos.close();
            socket.close();
            ss.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

