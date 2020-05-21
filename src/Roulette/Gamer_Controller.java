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

public class Gamer_Controller implements Initializable{
	Parent root;
	Gamer_RouletteSet rs;
	private int port;
	private int portServer;
	
	public void setPort(int port) {
		this.port = port;
	}
	public void setportServer(int portServer) {
		this.portServer = portServer;
	}
	
	public Parent getRoot() {
		return root;
	}
	
	public void setRoot(Parent root) {
		this.root = root;
		Gamer_Result rt = new Gamer_Result();
		rs.setRoot(this.root);
		image();
		rs.rotation();
		
		rt.setAngle(Gamer_RoulettsMain.angleGamer);
		rt.setRoot(this.root);
		rt.start();

	}



	public void image() {
		TextField fxUser = (TextField)root.lookup("#fxUser");
		ImageView fxView = (ImageView)root.lookup("#fxView");
		
		for(int i = 2 ;i<7;i++) {
			if(Gamer_RoulettsMain.UserNum==i) {
				fxView.setImage(new Image("/img/roulett"+i+".png"));
			}
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		rs = new Gamer_RouletteSet();
		

	}


//	public void plus() {
//		Button bt = (Button)root.lookup("#plus");
//		TextField fxUser = (TextField)root.lookup("#fxUser");
//		int a = Integer.parseInt(fxUser.getText());
//		a++;
//
//		if(a>=6) {
//			a=6;
//		}
//		fxUser.setText(a+"");
//		image();
//
//	}
//
//	public void minus() {
//		Button bt = (Button)root.lookup("#plus");
//		TextField fxUser = (TextField)root.lookup("#fxUser");
//		int a = Integer.parseInt(fxUser.getText());
//		a--;
//
//		if(a<=2) {
//			a=2;
//		}
//		fxUser.setText(a+"");
//		image();
//	}
//
//


	//	public void click() {
	//		rs.setRoot(root);
	//		rs.click();
	//	}
	//
	//	public void clickOut() {
	//		rs.setRoot(root);
	//		rs.clickOut();
	//	}
	//
	//	public void clickMinus() {
	//		rs.setRoot(root);
	//		rs.clickMinus();
	//	}
	//
	//	public void clickMinusOut() {
	//		rs.setRoot(root);
	//		rs.clickMinusOut();
	//	}
	//	
	//	public void clickPlus() {
	//		rs.setRoot(root);
	//		rs.clickPlus();
	//	}
	//
	//	public void clickPlusOut() {
	//		rs.setRoot(root);
	//		rs.clickPlusOut();
	//	}
}