package Roulette;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Server.Mainserver;
import javafx.animation.RotateTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.RotateBuilder;
import javafx.util.Duration;

public class Captain_Controller implements Initializable{
	Parent root;
	Captain_RouletteSet rs;
	private int port;
	private int portServer;
	
	public void setPort(int port) {
		this.port = port;
	}
	public void setportServer(int portServer) {
		this.portServer = portServer;
		Captain_Result rt = new Captain_Result();
		rt.setRoot(this.root);
		rt.start();
		rs.setportServer(this.portServer);
		rs.setRoot(this.root);
		image();
		rs.rotation();
	}
	
	public Parent getRoot() {
		return root;
	}
	
	public void setRoot(Parent root) {
		this.root = root;

	}


	public void image() {
		TextField fxUser = (TextField)root.lookup("#fxUser");
		ImageView fxView = (ImageView)root.lookup("#fxView");
		for(int i = 2 ;i<7;i++) {
			if(Mainserver.hm.size()==i) {
				fxView.setImage(new Image("/img/roulett"+i+".png"));
			}
		}
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		rs = new Captain_RouletteSet();
		

	}



}