package mini_project;

import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class TimerThread extends Thread{
	private double time = 10.0;
	private Parent root;
	public Parent getRoot() {
		return root;
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public void timenow() {
		Close close = new Close();
		Timer timeset = new Timer();
		Label fxTime = (Label)root.lookup("#fxTime");
		TimerTask tt = new TimerTask() {

			@Override
			public void run() {
				String timer = String.format("%.2f",  time) + "초";
				Platform.runLater(()->{
					fxTime.setText(timer);
					//close.WinClose(root);
					if(time<=0) {
						timeset.cancel();
						close.WinClose(root);
						close.success();
					}
				});
				time = time-0.01;
			}
			
		};
		timeset.schedule(tt, 0,10);
//		close.success();
//		Label fxResult = (Label)root.lookup("#fxResult");
//		fxResult.setText("당신의 최종 점수는 : " + rspController.num);
	}
}
