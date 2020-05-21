package Roulette;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gamer_RoulettsMain  {
	private int port;
	private int portServer;
	public static int angleGamer;

	public static int UserNum;
	public void setPort(int port) {
		this.port = port;
	}
	public void setportServer(int portServer) {
		this.portServer = portServer;
	}
	public void roulettsStart(){
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Gamer_RoulettesTool.fxml"));
			Parent root;
			try {
				root = loader.load();
				Gamer_Controller ctr = loader.getController();
				ctr.setRoot(root);

				sg.setTitle("∑Í∑ø ∞‘¿”");
				sg.setScene(new Scene(root));
				sg.setResizable(false);
				sg.show();


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
}

