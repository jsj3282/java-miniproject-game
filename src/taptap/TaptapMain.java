package taptap;



import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import startTime.Time01;

public class TaptapMain{
	public void taptastart() {
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EventTest.fxml"));
			Pane root;
			try {
				root = loader.load();
				TapController ct = loader.getController();
				Scene scene = new Scene(root);
				ct.setRoot(root);				
					
				sg.setTitle("TapTap");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		});
	}
}



