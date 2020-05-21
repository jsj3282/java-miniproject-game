package game;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ReadyGameMain{
	
	public static int num;

	public void ReadyGameStart(){
		Platform.runLater(()->{
//		System.setProperty("prism.lcdtext", "false");
//		Font.loadFont(getClass().getResourceAsStream("Nanumsquare_acR.ttf"), 14);
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RandomGame.fxml"));//불러오기
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				Controller ctrler = loader.getController();	//추가된 부분_로드한 컨트롤러를 갖고 온 것임.
				ctrler.setRoot(root);		
				
				sg.setTitle("TimingGame");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//따로 로드한다. Parent=부모형태 
			//Pane, GridPane 등으로 해도됨.

		});
	}

}
