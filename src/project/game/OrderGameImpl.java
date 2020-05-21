package project.game;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Server.Sender;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.OrderGameMain;

public class OrderGameImpl {
	int num=1;
	int count = 1; 
	private double time =10.0;
	private double score = 0.0;
	public double getTime() {
		return time;
	}

	public void ordergamestart(Parent root){
		int i=0;
		Button[] btn = new Button[15];
		ImageView[] Imv = new ImageView[15];
		ArrayList num = new ArrayList();
		int ran;
		for(i=0; i<15;i++) {
			ran = (int)(Math.random()*15+1);
			for(int j=0; j<i;j++) {
				if(num.contains(ran)) {
					ran = (int)(Math.random()*15+1);
					j=0;
				}
			}
			num.add(ran);
		}

		for(i=0;i<btn.length;i++) {
			btn[i] = (Button)root.lookup("#btn"+(i+1));
			//Imv[i] = (ImageView)root.lookup("#imv"+(i+1));
		}
		for(i=0;i<15;i++) {
			btn[i].setText(num.get(i)+"");
			btn[i].setStyle("-fx-background-image: url('/img/num"+num.get(i)+".png')");
//			FileInputStream input = null;
//			try {
//				input = new FileInputStream("src/img/num"+num.get(i)+".png");
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(input);
//	        Image image = new Image(input);
			//System.out.println(Imv[i]);
			//Imv[i].setImage(new Image("/img/num"+num.get(i)+".png"));
		}


	}
	public void ordergamejudge(Button btn) {
		String num = this.num+"";
		if(num.equals(btn.getText())) {
			btn.setDisable(true);
			this.num++;
			btn.setStyle("-fx-background-image: url('/img/ok.png')");
		}else {
			this.count++;
		}
	}
//	public void ordergameend(Parent root) {
//		if(count==4) {
//			Stage stage = (Stage)root.getScene().getWindow();
//			stage.close();
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("게임종료!"); alert.setHeaderText("실패!!!");
//			alert.setContentText("3번 틀리셨습니다"); alert.show();
//		}	
//	}
//	public void ordergamewin(Parent root) {
//		if(num==16) {
//			Stage stage = (Stage)root.getScene().getWindow();
//			stage.close();
//			Alert alert = new Alert(AlertType.INFORMATION);
//			alert.setTitle("게임종료!"); alert.setHeaderText("성공!!!");
//			alert.setContentText("모두 맞추셨습니다!!"); alert.show();
//		}
//	}
	public void timenow(Parent root){
		Close close = new Close();
		Timer timeset = new Timer();
		Label fxtime = (Label)root.lookup("#fxtime");	
		Stage stage = (Stage)root.getScene().getWindow();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {	
				String timer = String.format("%.2f", time)+" 초";
				String playerscore = String.format("%.2f", score)+" 초";
				Platform.runLater(()->{
					fxtime.setText(timer);	
					if(count==4) {
						timeset.cancel();
						OrderGameMain.timerset = 10000;
						close.WinClose(root);
						close.fail("3번 틀렸습니다.");
					}else if(num==16) {
						timeset.cancel();
						OrderGameMain.timerset = score;
						close.WinClose(root);
						close.success(playerscore+" 안에 모두 맞추셨습니다!");
						
					}else if(time<=0) {
						timeset.cancel();
						OrderGameMain.timerset = score;
						close.WinClose(root);
						close.fail("시간이 다됐습니다ㅠㅠ");
						
					}
				});
				time = time-0.01;	
				score = score+0.01;
	
			}
		};
		
		timeset.schedule(tt, 0,10);
	}
}
