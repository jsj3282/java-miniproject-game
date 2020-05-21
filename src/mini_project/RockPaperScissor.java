package mini_project;

import java.io.IOException;

import Roulette.Common;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RockPaperScissor {
	//String pic = null;
	rspService rsp;

	public void RockPaperScissorsStart(){
		Platform.runLater(()->{
			Stage sg = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/mini_project/rsp.fxml"));
			Parent root;
			try {
				root = loader.load();
				rspController ctrler = loader.getController();
				ctrler.setRoot(root);


				Scene scene = new Scene(root);
				sg.setTitle("���� ���� �� ����");
				sg.setScene(scene);
				sg.show();
				sg.setOnCloseRequest(event -> {	Common.Alert("�����ϸ� ���� ����.. �ð������� �������ּ���~");} );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
