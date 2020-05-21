package Server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javafx.scene.Parent;
import javafx.scene.control.TextArea;

public class Mainserver extends Thread {
	private int port;
	private int portServer;
	private Parent root;
	InetAddress addr;
	String re;
	LinkedHashMap<String,Double> hs;
	Map<Integer, String> hs2;
	int i =0;


	public static HashMap<String,String> hm = new HashMap<String, String>();



	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setportServer(int portServer) {
		this.portServer = portServer;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		DatagramSocket ms;
		try {
			ms = new DatagramSocket(portServer);
			addr = InetAddress.getByName("192.168.0.255");


			//�۽�


			//����
			while(true) {
				byte [] by = new byte[1024];
				DatagramPacket receive = new DatagramPacket(by, by.length);
				ms.receive(receive);
				re = new String(receive.getData());
				if(re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {

					hm.put(receive.getAddress()+"", re.substring(0, re.indexOf("�Բ���")-1).trim());
					//System.out.println("������ �������"+hm.size());
					System.out.println(receive.getAddress()+"");
					System.out.println(re.substring(0, re.indexOf("�Բ���")-1).trim());
					System.out.println();
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);
				}else if (re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {
					hm.remove(receive.getAddress()+"");
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);
					//System.out.println("������ �������"+hm.size());
				}else if (re.trim().equals("�������")){
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);

					hs = new LinkedHashMap<String,Double>();		
					String result="=== ������� ���� ��� ===\n";
					while(true) {
						byte [] by3 = new byte[1024];
						DatagramPacket receive5 = new DatagramPacket(by3, by3.length);
						ms.receive(receive5);
						re = new String(receive5.getData(),0,receive5.getData().length);
						hs.put(receive5.getAddress()+"",Double.parseDouble(re));
						i=1;
						if(hs.size()==Mainserver.hm.size()) {
							System.out.println("hs ���" +hs);
							for(String a : hs.keySet()) {
								result += Mainserver.hm.get(a).trim()+" ��� : "+String.format("%.2f",hs.get(a)) +"\n";
							}
							DatagramPacket resultall = new DatagramPacket(result.getBytes(),result.getBytes().length,addr,portServer);
							ms.send(resultall);
							break;
						}
					}
				}else if(re.trim().equals("����������")) {
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);

					hs = new LinkedHashMap<String,Double>();		
					String result="=== ���������� ���� ���  ===\n";
					while(true) {
						byte [] by3 = new byte[1024];
						DatagramPacket receive5 = new DatagramPacket(by3, by3.length);
						ms.receive(receive5);
						re = new String(receive5.getData(),0,receive5.getData().length);
						hs.put(receive5.getAddress()+"",Double.parseDouble(re));
						i=1;
						if(hs.size()==Mainserver.hm.size()) {
							System.out.println("hs ���" +hs);
							for(String a : hs.keySet()) {
								result += Mainserver.hm.get(a).trim()+" ��� : "+String.format("%.2f",hs.get(a)) +"\n";
							}
							DatagramPacket resultall = new DatagramPacket(result.getBytes(),result.getBytes().length,addr,portServer);
							ms.send(resultall);
							break;
						}
					}
				}else if(re.trim().equals("����")) {
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);

					hs = new LinkedHashMap<String,Double>();	
					String result="=== ���� ���� ��� ===\n";
					while(true) {
						byte [] by3 = new byte[1024];
						DatagramPacket receive5 = new DatagramPacket(by3, by3.length);
						ms.receive(receive5);
						re = new String(receive5.getData(),0,receive5.getData().length);
						hs.put(receive5.getAddress()+"",Double.parseDouble(re));
						i=1;
						if(hs.size()==Mainserver.hm.size()) {
							System.out.println("hs ���" +hs);
							for(String a : hs.keySet()) {
								result += Mainserver.hm.get(a).trim()+" ��� : "+String.format("%.2f",hs.get(a)) +"\n";
							}
							DatagramPacket resultall = new DatagramPacket(result.getBytes(),result.getBytes().length,addr,portServer);
							ms.send(resultall);
							break;
						}
					}
				}else if(re.trim().equals("Ready")) {
					int computer = (int)(Math.random()*6);
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);

					hs = new LinkedHashMap<String,Double>();		
					String result="=== ���� ���� ��� ===\n"+"��÷ ��ȣ : "+computer+"\n";
					while(true) {
						byte [] by3 = new byte[1024];
						DatagramPacket receive5 = new DatagramPacket(by3, by3.length);
						ms.receive(receive5);
						re = new String(receive5.getData(),0,receive5.getData().length);
						hs.put(receive5.getAddress()+"",Double.parseDouble(re));
						i=1;
						if(hs.size()==Mainserver.hm.size()) {
							System.out.println("hs ���" +hs);
							for(String a : hs.keySet()) {
								result += Mainserver.hm.get(a).trim()+" ��� : "+String.format("%.2f",hs.get(a)) +"\n";
							}
							DatagramPacket resultall = new DatagramPacket(result.getBytes(),result.getBytes().length,addr,portServer);
							ms.send(resultall);
							break;
						}
					}
				}else {
					DatagramPacket send = new DatagramPacket(re.trim().getBytes(), re.trim().getBytes().length,addr,port);
					ms.send(send);
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

