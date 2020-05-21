package Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

import MainGame.CaptainController;
import MainGame.Controller;
import MainGame.GamerController;
import MainGame.Main;
import Roulette.Captain_RouletteSet;
import Roulette.Captain_RoulettsMain;
import game.ReadyGameMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import mini_project.RockPaperScissor;
import mini_project.rspController;
import project.OrderGameMain;
import project.game.OrderGameImpl;
import taptap.TapController;
import taptap.TaptapMain;


public class Captain extends Thread {

	Parent root;
	Parent root1;
	private Mainserver mainServer;
	private int port; //ü����Ʈ
	private int portServer; //���� ��Ʈ
	InetAddress addr;
	String re;
	String playerscore;
	Map<Double, String> hs;
	TreeMap<Double, String> hsRevers;
	LinkedHashMap<Double,String> lhs; 
	int i =0;
	TimeResult tr = new TimeResult();


	public Mainserver getServer() {
		return mainServer;
	}

	public int getPort() {
		return port;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}


	public void run() {

		mainServer = new Mainserver();
		mainServer.setPort(port);
		mainServer.setportServer(portServer);
		mainServer.setRoot(root);
		mainServer.start();



		Scanner sc = new Scanner(System.in);
		DatagramSocket ms;
		try {
			ms = new DatagramSocket(port);
			addr = InetAddress.getByName("192.168.0.255");

			String join = "���� �Բ��� �����Ͽ����ϴ�.";
			DatagramPacket send = new DatagramPacket(join.getBytes(),join.getBytes().length,addr,portServer);
			ms.send(send);


			while(true) {
				byte [] by = new byte[1024];
				DatagramPacket receive = new DatagramPacket(by, by.length);
				ms.receive(receive);
				re = new String(receive.getData(),0,receive.getData().length);

				//�귿���� ����
				if(re.trim().equals("�귿")){
					//���̸� ��ȣ �ο��ؼ�  ������
					Iterator<String> it = Mainserver.hm.values().iterator();
					String [] num = new String [] {"No.1","No.2","No.3","No.4","No.5","No.6"};
					i=0;
					String numresult="=== �귿 ��ȣ�� ===\n";
					while(it.hasNext()) {
						numresult+=it.next() + " ���� ��ȣ�� : "+num[i] + " �Դϴ�.\n"; 
						i++;
					}
					DatagramPacket numResult = new DatagramPacket(numresult.getBytes(),numresult.getBytes().length,addr,portServer);
					ms.send(numResult);
					byte [] by1 = new byte[1024];
					DatagramPacket numCheck = new DatagramPacket(by1, by1.length);
					ms.receive(numCheck);
					TextArea fxReArea = (TextArea)root1.lookup("#fxReArea");
					fxReArea.appendText(new String(numCheck.getData())+"\n");


					//���� �ο��� ������
					String user = Mainserver.hm.size()+"";
					DatagramPacket UserResult = new DatagramPacket(user.getBytes(),user.getBytes().length,addr,portServer);
					ms.send(UserResult);
					byte [] by2 = new byte[1024];
					DatagramPacket userCheck = new DatagramPacket(by2, by2.length);
					ms.receive(userCheck);

					//�귿 ����� �ޱ� ������					
					Captain_RoulettsMain rm = new Captain_RoulettsMain();
					rm.setPort(port);
					rm.setportServer(portServer);
					rm.roulettsStart();
					byte [] by3 = new byte[1024];
					DatagramPacket angleCheck = new DatagramPacket(by3, by3.length);
					ms.receive(angleCheck);

					//������� ����

				}else if (re.trim().equals("�������")){
					OrderGameMain og = new OrderGameMain();
					og.OrderGameStart();
					tr.setPort(port);
					tr.setportServer(portServer);
					//tr.setName("");
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(OrderGameMain.timerset);

						}
					};ti.schedule(tt, 11000);
	
				}		
							
							
			


				//���������� ����

				else if (re.trim().equals("����������")) {
					RockPaperScissor rps = new RockPaperScissor();
					rps.RockPaperScissorsStart();
					tr.setPort(port);
					tr.setportServer(portServer);
					tr.setName("");
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(rspController.num);
						}
					};ti.schedule(tt, 11001);
				}



				//Ready ����
				else if(re.trim().equals("Ready")) {
					ReadyGameMain rg = new ReadyGameMain();
					rg.ReadyGameStart();
					tr.setPort(port);
					tr.setportServer(portServer);
					tr.setName("");
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(game.Controller.num);
						}
					};ti.schedule(tt, 5001);
				}

				//����  ����
				else if(re.trim().equals("����")) {
					TaptapMain tap = new TaptapMain();
					tap.taptastart();
					tr.setPort(port);
					tr.setportServer(portServer);
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(TapController.cnt);
						}
					};ti.schedule(tt, 11001);
				}

				else {
					TextArea fxReArea = (TextArea)root1.lookup("#fxReArea");
					fxReArea.appendText(re+"\n");
				}


				//����� ���� ����

//				ListView<String> fxList = (ListView<String>)root1.lookup("#fxList");
//				if(re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {
//					HashMap<String,String> hmData = new HashMap<String, String>();
//					hmData.putAll(Mainserver.hm);
//					ByteArrayOutputStream bos = new ByteArrayOutputStream();  
//					ObjectOutputStream out = new ObjectOutputStream(bos);
//					out.writeObject((Object)hmData);
//					System.out.println("���¾�");
//					byte[] line = bos.toByteArray();
//					DatagramPacket hmDataSend = new DatagramPacket(line,line.length,addr,portServer);
//					ms.send(hmDataSend);
//					byte [] buffer = new byte[1024];
//					DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
//					ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
//					ObjectInputStream in = new ObjectInputStream(bis);
//					ms.receive(receivePacket);
//					System.out.println("����");
//					
//					
//					
//					Platform.runLater(()->{
//						fxList.getItems().add(re.substring(0,(re.indexOf("��")-1)).trim());
//					});
//				}else if (re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {
//					Platform.runLater(()->{
//						fxList.getItems().remove(fxList.getItems().indexOf(re.substring(0,(re.indexOf("��")-1)).trim()));
//					});
//				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Create() {

		port = (int)(Math.random()*9999)+10000;
		portServer = port+1;


		Stage sg = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../MainGame/captain.fxml"));

		try {
			root1 = loader.load();
			CaptainController ct = loader.getController();
			ct.setPort(port);
			ct.setportServer(portServer);
			ct.setRoot(root1);
			sg.setTitle("����ȭ��");
			sg.setScene(new Scene(root1));
			sg.show();
			sg.setOnCloseRequest(event -> {
				DatagramSocket ms;
				try {
					ms = new DatagramSocket();
					addr = InetAddress.getByName("192.168.0.255");

					String exit = "���� �Բ��� �����Ͽ����ϴ�.";
					DatagramPacket send = new DatagramPacket(exit.getBytes(),exit.getBytes().length,addr,portServer);
					ms.send(send);
				}catch(Exception e) {}
			} );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

