package MainGame;

import java.net.URL;
import java.util.ResourceBundle;

import Server.Sender;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GamerController implements Initializable {

	Parent root;
	private int port;
	private int portServer;
	private String name;
	@FXML Label fxPort;
	@FXML TextField fxChat;
	
	
	public void setname(String name) {
		this.name = name;
	}
	
	public void setportServer(int portServer) {
		this.portServer = portServer;
	}
	
	
	public void setPort(int port) {
		this.port = port;
		fxPort.setText(port+"");
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}


	public void okProc() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg(name+"\t: "+fxChat.getText());
		sd.start();
		fxChat.clear();
	}

}
