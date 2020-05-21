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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("RandomGame.fxml"));//�ҷ�����
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				Controller ctrler = loader.getController();	//�߰��� �κ�_�ε��� ��Ʈ�ѷ��� ���� �� ����.
				ctrler.setRoot(root);		
				
				sg.setTitle("TimingGame");
				sg.setScene(scene);
				sg.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//���� �ε��Ѵ�. Parent=�θ����� 
			//Pane, GridPane ������ �ص���.

		});
	}

}
