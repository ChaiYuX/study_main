package com.study;

import com.httpServelet.HttPResponse;
import com.httpServelet.HttpRequset;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("启动一个服务 端口8080");
        while(true){
            Socket clientSocket = serverSocket.accept();
           /*
            byte[] bytes = new byte[1024];
            System.out.println("准备read");
            int read = clientSocket.getInputStream().read(bytes);
            System.out.println("读取完毕");
            System.out.println("读取结果：======  " + read);
            if (-1 != read){
                System.out.println("服务端接收到的数据 ======== " + new String(bytes , 0 , read));
            }
            System.out.println("返回成功过");
            clientSocket.getOutputStream().write("fuck off hellow world".getBytes());
            clientSocket.getOutputStream().flush();
            clientSocket.close();*/

            //解析信息为HTTPrequest
            try{
                HttpRequset request = new HttpRequset(new InputStreamReader(clientSocket.getInputStream() , "utf-8"));
                //返回的信息
                String data = "{\n" +
                        "  \"code\": 200,\n" +
                        "  \"message\": \"success\"\n" +
                        "  \"path\": \""+request.getPathInfo()+"\"\n" +
                        "}";
                HttPResponse response = new HttPResponse(data);
                try{
                    clientSocket.getOutputStream().write(response.getBytes());
                    clientSocket.getOutputStream().flush();
                }finally {
                    //给输出流关闭了
                    clientSocket.getOutputStream().close();
                }
            }finally {
                clientSocket.close();
            }
        }

    }
}