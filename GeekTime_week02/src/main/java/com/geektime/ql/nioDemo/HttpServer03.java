package com.geektime.ql.nioDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.omg.SendingContext.RunTime;

public class HttpServer03 {

	public static void main(String[] args) throws IOException{
		ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+2);
		ServerSocket serverSocket = new ServerSocket(8083);
		while (true) {
			try {
				final Socket socket = serverSocket.accept();
				executorService.execute(()->{
					service(socket);
				});
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
			String body="hello nio003";
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
