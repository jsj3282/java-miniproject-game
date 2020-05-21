package Roulette;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import Server.Sender;
import javafx.animation.RotateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Captain_RouletteSet {

	Parent root;
	private int port;
	private int portServer;
	DatagramSocket ms;
	InetAddress addr;
	
	public void setPort(int port) {
		this.port = port;
	}
	public void setportServer(int portServer) {
		this.portServer = portServer;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	public void rotation() {
		ImageView iv = (ImageView)root.lookup("#fxView");
		ImageView iv1 = (ImageView)root.lookup("#fxShine");
		RotateTransition rt = new RotateTransition(Duration.millis(5000),iv);
		RotateTransition rt1 = new RotateTransition(Duration.millis(5000),iv1);
		Captain_Result.angleCaptaion = 0;
		int a = (int)(Math.random()*5000+1);
		rt.setFromAngle(0);
		rt.setByAngle(3000+a);
		rt.setCycleCount(1);
		
		rt1.setByAngle(-((3000+a)/10));
		rt1.setCycleCount(1);
		Captain_Result.angleCaptaion = (int)(rt.getByAngle());
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg((a+3000)+"");
		sd.start();
		rt.play();
		rt1.play();
		
	}
	

}

