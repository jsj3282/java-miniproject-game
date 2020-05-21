package game;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller implements Initializable {
	private Parent root;
	@FXML private ImageView zero;
	@FXML private ImageView one;
	@FXML private ImageView two;
	@FXML private ImageView three;
	@FXML private ImageView four;
	@FXML private ImageView five;
	@FXML private Label ComRandom;
	@FXML private Label zeroUser;
	@FXML private Label oneUser;
	@FXML private Label twoUser;
	@FXML private Label threeUser;
	@FXML private Label fourUser;
	@FXML private Label fiveUser;
	@FXML private Label fxtime;
	private double time=4.0;
//	private String name;
	int computer;
	public static int num; 
	
//	public void setName(String name) {
//		this.name=name;
//	}
	public void setRoot(Parent root) {
		this.root=root;
	}

	public void timenow(){
		Timer timeset = new Timer();
		TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				String timer = String.format("%.2f", time)+" 초";
				Platform.runLater(()->{
					fxtime.setText(timer);   
					if(time<=0) {
						timeset.cancel();
						Stage stage = (Stage)root.getScene().getWindow();
						computer = (int)(Math.random()*6);
						System.out.println(computer+" 당첨!");
			//			ComRandom.setText(computer+"");
					}
				});
				time = time-0.01;            
			}
		};
		timeset.schedule(tt, 0,10);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		timenow();
		
		EventHandler<MouseEvent> me0 = e->{
			zero.setTranslateY(-10);
			zero.setScaleX(1.3); zero.setScaleY(1.3);
		};
		zero.setOnMouseEntered(me0);
		zero.setOnMouseExited(e->{
			zero.setTranslateY(0);
			zero.setScaleX(1); zero.setScaleY(1);
		});

		EventHandler<MouseEvent> me1 = e->{
			one.setTranslateY(-10);
			one.setScaleX(1.3); one.setScaleY(1.3);
		};
		one.setOnMouseEntered(me1);
		one.setOnMouseExited(e->{
			one.setTranslateY(0);
			one.setScaleX(1); one.setScaleY(1);
		});

		EventHandler<MouseEvent> me2 = e->{
			two.setTranslateY(-10);
			two.setScaleX(1.3); two.setScaleY(1.3);
		};
		two.setOnMouseEntered(me2);
		two.setOnMouseExited(e->{
			two.setTranslateY(0);
			two.setScaleX(1); two.setScaleY(1);
		});

		EventHandler<MouseEvent> me3 = e->{
			three.setTranslateY(-10);
			three.setScaleX(1.3); three.setScaleY(1.3);
		};
		three.setOnMouseEntered(me3);
		three.setOnMouseExited(e->{
			three.setTranslateY(0);
			three.setScaleX(1); three.setScaleY(1);
		});

		EventHandler<MouseEvent> me4 = e->{
			four.setTranslateY(-10);
			four.setScaleX(1.3); four.setScaleY(1.3);
		};
		four.setOnMouseEntered(me4);
		four.setOnMouseExited(e->{
			four.setTranslateY(0);
			four.setScaleX(1); four.setScaleY(1);
		});

		EventHandler<MouseEvent> me5 = e->{
			five.setTranslateY(-10);
			five.setScaleX(1.3); five.setScaleY(1.3);
		};
		five.setOnMouseEntered(me5);
		five.setOnMouseExited(e->{
			five.setTranslateY(0);
			five.setScaleX(1); five.setScaleY(1);
		});

		zero.setOnMouseClicked(new EventHandler(){
			@Override
			public void handle(Event event) {
				System.out.println("0 선택하셨습니다.");
				zero.setOnMouseEntered(me0);
				zero.setOnMouseExited(e->{
				zero.setTranslateY(-10);
				zero.setScaleX(1.3); zero.setScaleY(1.3);
				});
//				zeroUser.setText(name);
				one.setDisable(true);
				two.setDisable(true);
				three.setDisable(true);
				four.setDisable(true);
				five.setDisable(true);
				num = 0;
			}
		});

		one.setOnMouseClicked(new EventHandler(){
			public void handle(Event event) {
				System.out.println("1 선택하셨습니다.");
				one.setOnMouseEntered(me1);
				one.setOnMouseExited(e->{
				one.setTranslateY(-10);
				one.setScaleX(1.3); one.setScaleY(1.3);
				});
//				oneUser.setText(name);
				zero.setDisable(true);
				two.setDisable(true);
				three.setDisable(true);
				four.setDisable(true);
				five.setDisable(true);
				num = 1;
			}			
		});

		two.setOnMouseClicked(new EventHandler(){
			public void handle(Event event) {
				System.out.println("2 선택하셨습니다.");
				two.setOnMouseEntered(me2);
				two.setOnMouseExited(e->{
				two.setTranslateY(-10);
				two.setScaleX(1.3); two.setScaleY(1.3);
				});
//				twoUser.setText(name);
				one.setDisable(true);
				zero.setDisable(true);
				three.setDisable(true);
				four.setDisable(true);
				five.setDisable(true);
				num = 2;
			}			
		});

		three.setOnMouseClicked(new EventHandler(){
			public void handle(Event event) {
				System.out.println("3 선택하셨습니다.");
				three.setOnMouseEntered(me3);
				three.setOnMouseExited(e->{
				three.setTranslateY(-10);
				three.setScaleX(1.3); three.setScaleY(1.3);
				});
//				threeUser.setText(name);
				one.setDisable(true);
				two.setDisable(true);
				zero.setDisable(true);
				four.setDisable(true);
				five.setDisable(true);
				num = 3;
			}			
		});

		four.setOnMouseClicked(new EventHandler(){
			public void handle(Event event) {
				System.out.println("4 선택하셨습니다.");
				four.setOnMouseEntered(me4);
				four.setOnMouseExited(e->{
				four.setTranslateY(-10);
				four.setScaleX(1.3); four.setScaleY(1.3);
				});
//				fourUser.setText(name);
				one.setDisable(true);
				two.setDisable(true);
				three.setDisable(true);
				zero.setDisable(true);
				five.setDisable(true);
				num = 4;
			}			
		});

		five.setOnMouseClicked(new EventHandler(){
			public void handle(Event event) {
				System.out.println("5 선택하셨습니다.");
				five.setOnMouseEntered(me5);
				five.setOnMouseExited(e->{
				five.setTranslateY(-10);
				five.setScaleX(1.3); five.setScaleY(1.3);
				});
//				fiveUser.setText(name);
				one.setDisable(true);
				two.setDisable(true);
				three.setDisable(true);
				four.setDisable(true);
				zero.setDisable(true);
				num = 5;
			}			
		});

	}
}

