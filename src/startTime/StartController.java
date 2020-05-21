package startTime;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import taptap.TapController;
import taptap.TaptapMain;

public class StartController implements Initializable{

	private Parent root;
	private double time = 3.0;
	@FXML private ImageView imgview;

	public void setRoot(Parent root) {
		this.root = root;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		Timer timer = new Timer();
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {

				if(time == 3.0) {
					imgview.setImage(new Image("img/3b.png"));
				}else if(time == 2.0){
					imgview.setImage(new Image("img/2b.png"));
				}else if(time == 1.0) {
					imgview.setImage(new Image("img/1b.png"));
				}else if(time == 0) {
					imgview.setImage(new Image("img/startbutton.png"));
					timer.cancel();
				}
				time -= 1;
			}
		};
		timer.schedule(tt,0,1000);
	}

}








