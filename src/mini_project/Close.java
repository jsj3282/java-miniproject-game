package mini_project;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Close {

	public boolean WinClose(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
		return true;
	}
	public void success() {
		System.out.println("��� â ���.");
		Stage resultForm = new Stage();
		Parent root = null;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
		try {
			root = loader.load();
		}catch(IOException e) {
			e.printStackTrace();
		}
		resultForm.setScene(new Scene(root));
		resultController ctrler = loader.getController();
		ctrler.setRoot(root);
		Label fxResult = (Label)root.lookup("#fxResult");
		resultForm.show();
		fxResult.setText("����� ���� ������ : " + rspController.num);
		System.out.println(rspController.num);
	}
	
//	Label fxTime = (Label)root.lookup("#fxTime");
//	public void setRoot(Parent root) {
//		this.root = root;
////		Label fxTime = (Label)root.lookup("#fxTime");
//	}
//
//	public void run() {
//		Timer ti = new Timer();
//		System.out.println(root);
//		Label fxTime = (Label)root.lookup("#fxTime");
//		timer = String.format("%.2f", time)+ "��";
//		fxTime.setText(timer);
//		TimerTask tt = new TimerTask() {			
//			@Override
//			public void run() {
//				//timer = String.format("%.2f", time)+ "��";
//				System.out.println(timer);
//				System.out.println("����� ���� ������ : " + rspController.num);
//				Platform.runLater(()->{
////					fxTime.setText(timer);
////					fxTime.setText("hi");
//					Stage sg = (Stage)root.getScene().getWindow();
//					sg.close();
//					
//				});
//				time = time-0.01;
//			}
//		};
//		ti.schedule(tt, 10000);
//		
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("result.fxml"));
//		
//		try {
//			root = loader.load();
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		resultController ctrler = loader.getController();
//		ctrler.setRoot(root);
//		Scene scene = new Scene(root);
	}




