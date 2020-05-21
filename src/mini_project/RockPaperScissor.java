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
				sg.setTitle("가위 바위 보 게임");
				sg.setScene(scene);
				sg.show();
				sg.setOnCloseRequest(event -> {	Common.Alert("종료하면 에러 떠요.. 시간지나면 종료해주세요~");} );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
