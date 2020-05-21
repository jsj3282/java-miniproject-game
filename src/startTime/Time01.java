package startTime;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Time01 {


	public void start() {
		Platform.runLater(()->{
			
			Stage sg =  new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EventTest.fxml"));
			Pane root;
			
			try {
				root = loader.load();
				StartController ct = loader.getController();
				Scene scene = new Scene(root);
				
				sg.setTitle("startTime");
				sg.setScene(scene);
				sg.show();
				
				Timer timer = new Timer();
				TimerTask tt = new TimerTask() {
					
					@Override
					public void run() {
						Platform.runLater(()->{
							sg.close();
						});
					}
				};
				timer.schedule(tt,4000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
}