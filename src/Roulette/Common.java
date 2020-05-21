package Roulette;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Common {
	Parent root;

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void WinClose(Parent root) {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public static void Alert(String message) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Alert al = new Alert(AlertType.WARNING);
				al.setContentText(message);
				al.show();
			}
		});
	}

	public void close() {
		Stage sg = (Stage)root.getScene().getWindow();
		sg.close();
	}

	public static void Info(String message, String prize ) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				Alert al = new Alert(AlertType.INFORMATION);
				al.setTitle(message);
				al.setHeaderText(prize+" ¥‘≤≤º≠ º±≈√µ«ºÃΩ¿¥œ¥Ÿ.");
				al.setContentText(message);
				al.show();
			}
		});

	}


}
