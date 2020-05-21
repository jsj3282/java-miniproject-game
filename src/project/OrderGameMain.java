package project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Roulette.Common;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.game.OrderGameImpl;
import startTime.Time01;


public class OrderGameMain {
	public static double timerset;

	public void OrderGameStart() {
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("eventTest.fxml"));
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				Controller ctr = loader.getController();
				ctr.setRoot(root);
		
				sg.setTitle("순서대로 게임");
				sg.setScene(scene);
				sg.setOnCloseRequest(event->Common.Alert("종료하면 에러 떠요.. 시간지나면 종료해주세요~"));
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
	}
}
