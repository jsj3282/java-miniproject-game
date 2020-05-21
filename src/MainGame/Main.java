package MainGame;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
	Parent root = loader.load();
	Controller ct = loader.getController();
	ct.setRoot(root);
	primaryStage.setTitle("����");
	primaryStage.setScene(new Scene(root));
	primaryStage.show();
	primaryStage.setOnCloseRequest(event -> {
		System.exit(0);
	} );
			
	}

	public static void main(String[] args) {
		launch(args);
	}
}
