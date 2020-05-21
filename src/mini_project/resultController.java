package mini_project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class resultController implements Initializable{
	
	private Parent root;
	@FXML Label fxResult;
	
	public void setRoot(Parent root) {
		this.root = root;
		System.out.println(root);
//		fxResult = (Label)root.lookup("fxResult");
//		fxResult.setText("당신의 최종 승점은 : " + rspController.num);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		fxResult = (Label)root.lookup("fxResult");
//		fxResult.setText("당신의 최종 승점은 : " + rspController.num);
		
	}
}
