package taptap;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

class Timer01 {
	
	private Parent root;
	private double time = 10.0;
	private int cnt;
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public Parent getRoot() {
		return root;
	}

	public void setRoot(Parent root) {
		this.root = root;
	}
	
	
	public void timeStart() {
		
		Label timer01 = (Label)root.lookup("#timer01");
		Timer ti01 = new Timer();
		TimerTask tt01 = new TimerTask() {
			@Override
			public void run() {
				String timer = String.format("%.2f", time);
				Platform.runLater(()->{
					time -= 0.01;
					timer01.setText("Time : "+timer);
					if(time<=0) {
						ti01.cancel();
						Alert al = new Alert(AlertType.INFORMATION);
						al.setContentText("클릭한 횟수  : "+TapController.cnt+" 번");
						al.show();
						
					}
				});
			}
		};
		ti01.schedule(tt01, 0, 10);
	}
	

}