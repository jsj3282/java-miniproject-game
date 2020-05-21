package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class Sender extends Thread {
	
	DatagramSocket ms;
	DatagramPacket send;
	String msg =null;
	private int portServer;
	
	public void setportServer(int portServer) {
		this.portServer = portServer;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	
	public void run(){
		
		try {
			InetAddress ia = InetAddress.getByName("192.168.0.255");
			ms = new DatagramSocket();
			send = new DatagramPacket(msg.getBytes(), msg.getBytes().length,ia,portServer);
			ms.send(send);
		

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
