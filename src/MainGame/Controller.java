package MainGame;

import java.net.URL;
import java.util.ResourceBundle;

import Roulette.Common;
import Server.Captain;
import Server.Gamer;
import Server.Mainserver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Controller implements Initializable{
	Parent root;
	@FXML TextField fxPort;
	@FXML TextField fxName;
	private Mainserver mainServer;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void Join(){
		Gamer ga =  new Gamer();
		ga.setRoot(root);
		try {
		ga.setPort(Integer.parseInt(fxPort.getText()));
		ga.setportServer(Integer.parseInt(fxPort.getText())+1);
		}catch(Exception e) {
			Common.Alert("숫자로 입력해주세요");
			fxPort.clear();
			fxPort.requestFocus();
			return;
		}
		ga.setname(fxName.getText());

		ga.Join();
		ga.start();
	}
	
	public void Create() {
		Captain us = new Captain();
		us.setRoot(root);
		us.Create();
		us.start();
	}
	
}
