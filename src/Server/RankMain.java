package Server;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import project.Controller;

public class RankMain {
	
	LinkedHashMap<Double, String> hs;
	
	public void setMap(LinkedHashMap<Double, String> hs) {
		this.hs = hs;
	}
	
	public void RankStart() {
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RankResult.fxml"));
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				RankController ctr = loader.getController();
				ctr.setRoot(root,hs);	
				sg.setTitle("결과");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
	}
	
	public void RankStart(double[] d) {
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RankResult.fxml"));
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				RankController ctr = loader.getController();
				ctr.setRoot(root,d);	

				sg.setTitle("결과");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
	
	}
	public void RankStart(int[] d) {
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RankResult.fxml"));
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				RankController ctr = loader.getController();
				ctr.setRoot(root,d);	
				
				sg.setTitle("결과");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
		
	}
}
