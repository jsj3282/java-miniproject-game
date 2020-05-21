package Roulette;

import Server.Mainserver;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Gamer_Result extends Thread{
	Parent root;
	private int angle;

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public void result() {
		
//		TextField fxUser = (TextField)root.lookup("#fxUser");
		TextField rt = (TextField)root.lookup("#res");
		if(Gamer_RoulettsMain.UserNum==2 || Gamer_RoulettsMain.UserNum==1) {
			if(angle % 360 >=0 && angle % 360<180) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
			
		}if(Gamer_RoulettsMain.UserNum==3) {
			if(angle % 360 >=0 && angle % 360<120) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angle % 360 >=120 && angle % 360<240) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Gamer_RoulettsMain.UserNum==4) {
			if(angle % 360 >=0 && angle % 360<90) {
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angle % 360 >=90 && angle % 360<180) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angle % 360 >=180 && angle % 360<270){
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Gamer_RoulettsMain.UserNum==5) {
			if(angle % 360 >=0 && angle % 360<72) {
				Common.Info("축하합니다.", "No.5");
				rt.setText("No.5");
			}else if(angle % 360 >=72 && angle % 360<144) {
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angle % 360 >=144 && angle % 360<216){
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angle % 360 >=216 && angle % 360<288) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Gamer_RoulettsMain.UserNum==6) {
			if(angle % 360 >=0 && angle % 360<60) {
				Common.Info("축하합니다.", "No.6");
				rt.setText("No.6");
			}else if(angle % 360 >=60 && angle % 360<120) {
				Common.Info("축하합니다.", "No.5");
				rt.setText("No.5");
			}else if(angle % 360 >=120 && angle % 360<180){
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angle % 360 >=180 && angle % 360<240) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angle % 360 >=240 && angle % 360<300){
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}
	}

	public void run() {
 
		TextField fxUser = (TextField)root.lookup("#fxUser");
		TextField rt = (TextField)root.lookup("#res");
		rt.clear();
	
		try {
			Thread.sleep(5050);
			result();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
