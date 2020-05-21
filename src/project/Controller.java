package project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import project.game.OrderGameImpl;

public class Controller implements Initializable{
	private Parent root;
	OrderGameImpl game = new OrderGameImpl();
	public void setRoot(Parent root) {
		this.root = root;
		game.ordergamestart(root);
		game.timenow(root);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void Btnclick1() {
		Button btn = (Button)root.lookup("#btn1");
		game.ordergamejudge(btn);
	}
	public void Btnclick2() {
		Button btn = (Button)root.lookup("#btn2");
		game.ordergamejudge(btn);
	}
	public void Btnclick3() {
		Button btn = (Button)root.lookup("#btn3");
		game.ordergamejudge(btn);
	}
	public void Btnclick4() {
		Button btn = (Button)root.lookup("#btn4");
		game.ordergamejudge(btn);
	}
	public void Btnclick5() {
		Button btn = (Button)root.lookup("#btn5");
		game.ordergamejudge(btn);
	}
	public void Btnclick6() {
		Button btn = (Button)root.lookup("#btn6");
		game.ordergamejudge(btn);
	}
	public void Btnclick7() {
		Button btn = (Button)root.lookup("#btn7");
		game.ordergamejudge(btn);
	}
	public void Btnclick8() {
		Button btn = (Button)root.lookup("#btn8");
		game.ordergamejudge(btn);
	}
	public void Btnclick9() {
		Button btn = (Button)root.lookup("#btn9");
		game.ordergamejudge(btn);
	}
	public void Btnclick10() {
		Button btn = (Button)root.lookup("#btn10");
		game.ordergamejudge(btn);
	}
	public void Btnclick11() {
		Button btn = (Button)root.lookup("#btn11");
		game.ordergamejudge(btn);
	}
	public void Btnclick12() {
		Button btn = (Button)root.lookup("#btn12");
		game.ordergamejudge(btn);
	}
	public void Btnclick13() {
		Button btn = (Button)root.lookup("#btn13");
		game.ordergamejudge(btn);
	}
	public void Btnclick14() {
		Button btn = (Button)root.lookup("#btn14");
		game.ordergamejudge(btn);
	}
	public void Btnclick15() {
		Button btn = (Button)root.lookup("#btn15");
		game.ordergamejudge(btn);
	}
}
