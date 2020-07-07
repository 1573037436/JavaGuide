package com.zzj.javaSE.socket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(8090);
			Socket socket=new Socket();
			//循环监听等待客户端的连接
            while(true){
            	// 监听客户端
            	socket = serverSocket.accept();
            	
            	ServerThread thread = new ServerThread(socket);
            	thread.start();
            	
            	InetAddress address=socket.getInetAddress();
                System.out.println("当前客户端的IP："+address.getHostAddress());
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
