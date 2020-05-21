package Server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import MainGame.CaptainController;
import MainGame.Controller;
import MainGame.GamerController;
import MainGame.Main;
import Roulette.Captain_RoulettsMain;
import Roulette.Common;
import Roulette.Gamer_RouletteSet;
import Roulette.Gamer_RoulettsMain;
import game.ReadyGameMain;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mini_project.RockPaperScissor;
import mini_project.rspController;
import project.OrderGameMain;
import taptap.TapController;
import taptap.TaptapMain;

public class Gamer extends Thread {

	Parent root;
	Parent root1;
	InetAddress addr;
	private int port; //ü����Ʈ
	private int portServer; //���� ��Ʈ
	TextField fxPort;
	private String name;
	String re;
	public static HashMap<String,String> hmGamer;
	Map<Double, String> hs;
	LinkedHashMap<Double,String> lhs; 
	int i =0;
	TimeResult tr = new TimeResult();


	public void setname(String name) {
		this.name = name;
	}


	public void setRoot(Parent root) {
		this.root = root;

	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setportServer(int portServer) {
		this.portServer = portServer;
	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		DatagramSocket ms;
		try {
			ms = new DatagramSocket(port);
			addr = InetAddress.getByName("192.168.0.255");

			String join = name+" �Բ��� �����Ͽ����ϴ�.";
			DatagramPacket send = new DatagramPacket(join.getBytes(),join.getBytes().length,addr,portServer);
			ms.send(send);

			while(true) {
				byte [] by = new byte[1024];
				DatagramPacket receive = new DatagramPacket(by, by.length);
				ms.receive(receive);
				re = new String(receive.getData(),0,receive.getData().length);


				if(re.trim().equals("�귿")){
					//���̸� ��ȣ �ޱ�
					byte [] by1 = new byte[1024];
					DatagramPacket receiveNum = new DatagramPacket(by1, by1.length);
					ms.receive(receiveNum);

					String num = new String(receiveNum.getData());
					TextArea fxReArea = (TextArea)root1.lookup("#fxReArea");
					fxReArea.appendText(num+"\n");

					//���� �ο� �ޱ�
					byte [] by2 = new byte[1024];
					DatagramPacket receiveUSer = new DatagramPacket(by2, by2.length);
					ms.receive(receiveUSer);
					String User = new String(receiveUSer.getData());
					Gamer_RoulettsMain.UserNum = Integer.parseInt(User.trim());


					//�ޱ� �ޱ�
					byte [] by3 = new byte[1024];
					DatagramPacket receiveAnlge = new DatagramPacket(by3, by3.length);
					ms.receive(receiveAnlge);
					String angle = new String(receiveAnlge.getData());
					Gamer_RoulettsMain.angleGamer=Integer.parseInt(angle.trim());
					System.out.println("�ѱ� �ޱ� : "+ Gamer_RoulettsMain.angleGamer);
					//�귿 ����

					Gamer_RoulettsMain rm = new Gamer_RoulettsMain();
					rm.roulettsStart();

					//������� ����	
				}else if (re.trim().equals("�������")){
					OrderGameMain og = new OrderGameMain();
					og.OrderGameStart();
					tr.setPort(port);
					tr.setportServer(portServer);
					tr.setName(name);
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(OrderGameMain.timerset);
						}
					};ti.schedule(tt, 11001);
					TimeResult tr = new TimeResult();
					tr.setRoot(root1);
					tr.chatStop(10);


					//���������� ����
				}else if (re.trim().equals("����������")) {
					RockPaperScissor rps = new RockPaperScissor();
					rps.RockPaperScissorsStart();
					tr.setPort(port);
					tr.setportServer(portServer);
					tr.setName(name);
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(rspController.num);

						}
					};ti.schedule(tt, 11000);
					
					TimeResult tr = new TimeResult();
					tr.setRoot(root1);
					tr.chatStop(10);
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
					TimeResult tr = new TimeResult();
					tr.setRoot(root1);
					tr.chatStop(10);
				}

				
				//����  ����
				else if(re.trim().equals("����")) {
					TaptapMain tap = new TaptapMain();
					tap.taptastart();
					tr.setPort(port);
					tr.setportServer(portServer);
					tr.setName(name);
					Timer ti = new Timer();
					TimerTask tt = new TimerTask() {
						@Override
						public void run() {
							tr.timer(TapController.cnt);
						}
					};ti.schedule(tt, 11001);
					TimeResult tr = new TimeResult();
					tr.setRoot(root1);
					tr.chatStop(10);
				}

				
				else {
					TextArea fxReArea = (TextArea)root1.lookup("#fxReArea");
					fxReArea.appendText(re+"\n");
				}



//				//����� ���� ����
//
//				ListView<String> fxList = (ListView<String>)root1.lookup("#fxList");
//				if(re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {
//			
//					
//					byte [] buffer = new byte[1024];
//					DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
//					ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
//					ObjectInputStream in = new ObjectInputStream(bis);
//					ms.receive(receivePacket);
//
//						hmGamer = (HashMap<String, String>) in.readObject();
//
//					Platform.runLater(()->{
//						fxList.getItems().clear();
//						Iterator<String> it = Mainserver.hm.values().iterator();
//						while(it.hasNext()) {
//							fxList.getItems().add(it.next().trim());
//						}
//					});
//				}else if (re.trim().matches(".*�Բ��� �����Ͽ����ϴ�..*")) {
//					Platform.runLater(()->{
//						fxList.getItems().remove(fxList.getItems().indexOf(re.substring(0,(re.indexOf("��")-1)).trim()));
//					});
//				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void Join() {
		if(Mainserver.hm.size()>7) {
			Common.Alert("�ο��� ��ã���ϴ�. �ٸ� Port�� �������ּ���");
			return;
		}else {
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../MainGame/gamer.fxml"));
			try {
				root1 = loader.load();
				GamerController ct = loader.getController();
				ct.setPort(port);
				ct.setname(name);
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
						String exit = name+" �Բ��� �����Ͽ����ϴ�.";
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
}
