package project.game;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Close {
	public void WinClose(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public void success(String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("��������!"); alert.setHeaderText("����!!!");
		alert.setContentText(text); alert.show();
	}
	public void fail(String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("��������!"); alert.setHeaderText("����!!!");
		alert.setContentText(text); alert.show();
	}
}
