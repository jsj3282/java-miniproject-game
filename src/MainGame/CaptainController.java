package MainGame;

import java.net.URL;
import java.util.ResourceBundle;

import Server.Mainserver;
import Server.Sender;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CaptainController implements Initializable {

	Parent root;
	private int port;
	private int portServer;
	@FXML Label fxPort;
	@FXML TextField fxChat;
	@FXML Label fxUser1;
	@FXML Label fxUser2;
	@FXML Label fxUser3;
	@FXML Label fxUser4;
	@FXML Label fxUser5;
	@FXML Label fxUser6;
	
	
	
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


	public void OrderGameGo() {
		
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("º¯º≠¥Î∑Œ");
		sd.start();
	}
	
	public void RouletteGo() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("∑Í∑ø");
		sd.start();
	}
	
	public void okProc() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("πÊ¿Â\t: "+ fxChat.getText());
		sd.start();
		fxChat.clear();
		
	}
	
	public void rspStart() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("∞°¿ßπŸ¿ß∫∏");
		sd.start();
	}
	
	public void ReadyStrart() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("Ready");
		sd.start();
	}
	
	public void TaptapStart() {
		Sender sd = new Sender();
		sd.setportServer(portServer);
		sd.setMsg("≈«≈«");
		sd.start();
	}
}
