package Server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Scanner;

public class SendDate {
	
	DatagramSocket ms;
	DatagramPacket send;
	String msg =null;
	private int portServer;
	ByteArrayOutputStream bos;
	ObjectOutputStream out;
	
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
			HashMap<String,String> hmData = new HashMap<String, String>();
			hmData.putAll(Mainserver.hm);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();  
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject((Object)hmData);
			byte[] line = bos.toByteArray();
			
			DatagramPacket hmDataSend = new DatagramPacket(line,line.length,ia,portServer);
			ms.send(hmDataSend);
		

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
