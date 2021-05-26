package com.geektime.ql.nioDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer01 {

	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = new ServerSocket(8081);
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				service(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	private static void service(Socket socket) {
		try {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			printWriter.println("HTTP/1.1 200 OK");
			printWriter.println("Content-Type:text/html;charset=utf-8");
			String body="hello nio01";
			printWriter.println("Content-Length:"+body.getBytes().length);
			printWriter.println();
			printWriter.write(body);
			printWriter.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
