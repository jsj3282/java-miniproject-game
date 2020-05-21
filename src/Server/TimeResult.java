package Server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.OrderGameMain;

public class TimeResult {
	String playerscore=null;
	InetAddress addr;
	public int port; //체팅포트
	public int portServer; //서버 포트
	double setTime=0;
	private String name;
	Parent root;

	public void setName(String name) {
		this.name = name;
	}

	public void setportServer(int portServer) {
		this.portServer = portServer;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}
	public void timer(double game) {
		
		playerscore = game+"";
		DatagramSocket ms;
		try {
			addr = InetAddress.getByName("192.168.0.255");
			ms = new DatagramSocket();
			DatagramPacket result = new DatagramPacket(playerscore.getBytes(),playerscore.getBytes().length,addr,portServer);
			ms.send(result);
		}catch(Exception e) {}

	}

	//체팅창 못쓰게 만듬
	
	public void chatStop(int time) {
		TextField fxChat = (TextField)root.lookup("#fxChat");
		Button fxSend = (Button)root.lookup("#fxSend");
		fxChat.setEditable(false);
		fxSend.setDisable(true);
		Timer ti = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				fxChat.setEditable(true);
				fxSend.setDisable(false);
			}
		};ti.schedule(tt, time*1000);
		}

}
