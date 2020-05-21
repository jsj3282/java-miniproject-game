package taptap;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import startTime.StartController;

public class TapController implements Initializable{
	
	private Parent root;
	

	@FXML private ImageView imgview,imgview02;
	@FXML private Button btn;
	@FXML private Label timer01;
	@FXML private Label fxlabel;

	public static double cnt=0;
	
	
	public void setRoot(Parent root) {
		this.root = root;
		Timer01 timer01 = new Timer01();
		timer01.setRoot(root);
		timer01.timeStart();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cnt=0;
		Timer ti = new Timer();
		TimerTask tt = new TimerTask() {
			
			@Override
			public void run() {
				btn.setDisable(true);
			}
		};
		ti.schedule(tt, 11000);
		
	}
	
	public void btnTouch() {
		btn.setCursor(Cursor.HAND);	
	}
	
	public void clicked() {
		cnt++;	//hit �닔 利앷� 
		this.cnt = cnt;
		fxlabel.setText("HIT : "+cnt);
		btn.setOnMousePressed(e->{	
			btn.setScaleX(1.1);		
			btn.setScaleY(1.1);
		});
		
		btn.setOnMouseReleased(e->{	
			btn.setScaleX(1.0);
			btn.setScaleY(1.0);
		});
		
		if(cnt % 2 == 0) {
			imgview02.setImage(new Image("img/라이언1.PNG"));			
		}else {
			imgview02.setImage(new Image("img/라이언2.PNG"));			
		}
		

	}

}







