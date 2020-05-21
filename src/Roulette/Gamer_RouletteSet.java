package Roulette;

import java.io.IOException;

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

public class Gamer_RouletteSet {

	Parent root;
	
	public void setRoot(Parent root) {
		this.root = root;
	}


	public void rotation() {
		ImageView iv = (ImageView)root.lookup("#fxView");
		ImageView iv1 = (ImageView)root.lookup("#fxShine");
		RotateTransition rt = new RotateTransition(Duration.millis(5000),iv);
		RotateTransition rt1 = new RotateTransition(Duration.millis(5000),iv1);
		System.out.println("마지막 회전 앵글 : "+Gamer_RoulettsMain.angleGamer);
		rt.setFromAngle(0);
		rt.setByAngle(Gamer_RoulettsMain.angleGamer);
		rt.setCycleCount(1);

		rt1.setByAngle(-((Gamer_RoulettsMain.angleGamer)/10));
		rt1.setCycleCount(1);
		//rt.setAutoReverse(true);
		rt.play();
		rt1.play();

	}



}

