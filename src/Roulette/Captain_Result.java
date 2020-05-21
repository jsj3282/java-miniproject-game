package Roulette;

import Server.Mainserver;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Captain_Result extends Thread{
	Parent root;
	public static int angleCaptaion;

	public void setRoot(Parent root) {
		this.root = root;
	}

	
	public void result() {
		
//		TextField fxUser = (TextField)root.lookup("#fxUser");
		TextField rt = (TextField)root.lookup("#res");
		if(Mainserver.hm.size()==2 || Mainserver.hm.size()==1) {
			if(angleCaptaion % 360 >=0 && angleCaptaion % 360<180) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
			
		}if(Mainserver.hm.size()==3) {
			if(angleCaptaion % 360 >=0 && angleCaptaion % 360<120) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angleCaptaion % 360 >=120 && angleCaptaion % 360<240) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Mainserver.hm.size()==4) {
			if(angleCaptaion % 360 >=0 && angleCaptaion % 360<90) {
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angleCaptaion % 360 >=90 && angleCaptaion % 360<180) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angleCaptaion % 360 >=180 && angleCaptaion % 360<270){
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Mainserver.hm.size()==5) {
			if(angleCaptaion % 360 >=0 && angleCaptaion % 360<72) {
				Common.Info("축하합니다.", "No.5");
				rt.setText("No.5");
			}else if(angleCaptaion % 360 >=72 && angleCaptaion % 360<144) {
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angleCaptaion % 360 >=144 && angleCaptaion % 360<216){
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angleCaptaion % 360 >=216 && angleCaptaion % 360<288) {
				Common.Info("축하합니다.", "No.2");
				rt.setText("No.2");
			}else {
				Common.Info("축하합니다.", "No.1");
				rt.setText("No.1");
			}
		}if(Mainserver.hm.size()==6) {
			if(angleCaptaion % 360 >=0 && angleCaptaion % 360<60) {
				Common.Info("축하합니다.", "No.6");
				rt.setText("No.6");
			}else if(angleCaptaion % 360 >=60 && angleCaptaion % 360<120) {
				Common.Info("축하합니다.", "No.5");
				rt.setText("No.5");
			}else if(angleCaptaion % 360 >=120 && angleCaptaion % 360<180){
				Common.Info("축하합니다.", "No.4");
				rt.setText("No.4");
			}else if(angleCaptaion % 360 >=180 && angleCaptaion % 360<240) {
				Common.Info("축하합니다.", "No.3");
				rt.setText("No.3");
			}else if(angleCaptaion % 360 >=240 && angleCaptaion % 360<300){
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
