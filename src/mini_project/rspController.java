package mini_project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class rspController implements Initializable{
	private Parent root;
	rspService rsp = new rspServiceImpl();
	private String pic;
	public static double num = 0;
	@FXML ImageView rspImage;
	@FXML Label fxTime;
	TimerThread time = new TimerThread();
	
	public String getPic(){
		System.out.println("ȭ���� �׸��� " + this.pic);
		return this.pic;
	}
	public void setRoot(Parent root) {
		this.root = root;
		time.setRoot(root);
		time.timenow();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rsp = new rspServiceImpl();
		this.pic = rsp.makePicture();
		System.out.println("ó���� �׸��� " + this.pic);
		rspImage.setImage(new Image("/img/"+ this.pic +".png"));
		num=0;
//		for(int i=0; i<10; i++) {
//			fxTime.setText(cl.getTime());
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		fxTime.setText(cl.getTime());
//		time.setRoot(root);
//		
//		time.timenow();
	}
	public void clickRock() {
		rsp = new rspServiceImpl(); 
//		rsp.clickRock();
		if(this.pic.equals("����")) {
			num++;
		}else if(this.pic.equals("��")) {
			num--;
		}
//		System.out.println("����� ���� : " + rsp.getVictoryNum());
		System.out.println("����� ���� : " + num);
		this.pic = rsp.makePicture();
		rspImage.setImage(new Image("/img/"+this.pic+".png"));
	}
	public void clickScissors() {
		rsp = new rspServiceImpl();
//		rsp.clickScissors();
		if(this.pic.equals("��")) {
			num++;
		}else if(this.pic.equals("����")) {
			num--;
		}
//		System.out.println("����� ���� : " + rsp.getVictoryNum());
		System.out.println("����� ���� : " + num);
		this.pic = rsp.makePicture();
		rspImage.setImage(new Image("/img/"+this.pic+".png"));
	}
	public void clickPaper() {
		rsp = new rspServiceImpl();
//		rsp.clickPaper();
		if(this.pic.equals("����")) {
			num++;
		}else if(this.pic.equals("����")) {
			num--;
		}
		System.out.println("����� ���� : " + num);
//		System.out.println("����� ���� : " + rsp.getVictoryNum());
		this.pic = rsp.makePicture();
		rspImage.setImage(new Image("/img/"+this.pic+".png"));
		
	}
}