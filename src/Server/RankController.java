package Server;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class RankController implements Initializable{
	Parent root;
	LinkedHashMap<Double, String> hs;
	
	
	public void setMap(LinkedHashMap<Double, String> hs) {
		this.hs = hs;
	}
	
	public Parent getRoot() {
		return root;
	}

	
	
	public void setRoot(Parent root) {
		this.root = root;

		
	}
	
	public void set() {

	}
	
	public void setRoot(Parent root,double[] d) {
		this.root = root;
		HBox[] hbox = new HBox[d.length];
		Label[] label = new Label[d.length];
		Label[] name = new Label[d.length];
		for(int i=0;i<d.length;i++) {
			label[i] = (Label)root.lookup("#rankla"+(i+1));
			hbox[i] = (HBox)root.lookup("#fxhbox"+(i+1));
			name[i] = (Label)root.lookup("#name"+(i+1));
		}
		for(int i=0;i<d.length;i++) {
			label[i].setText(String.format("%.2f", d[i])+"초");
			hbox[i].setOpacity(1);
		}
		
	}
	public void setRoot(Parent root,int[] d) {
		this.root = root;
		HBox[] hbox = new HBox[d.length];
		Label[] label = new Label[d.length];
		Label[] name = new Label[d.length];
		for(int i=0;i<d.length;i++) {
			label[i] = (Label)root.lookup("#rankla"+(i+1));
			hbox[i] = (HBox)root.lookup("#fxhbox"+(i+1));
			name[i] = (Label)root.lookup("#name"+(i+1));
		}
		for(int i=0;i<d.length;i++) {
			String score = d[i]+"점";
			label[i].setText(score);
			hbox[i].setOpacity(1);
		}
		
	}
	public void setRoot(Parent root,LinkedHashMap<Double, String> hs) {
		this.root = root;
		System.out.println("헤쉬맵 사이즈"+hs.size());
		HBox[] hbox = new HBox[hs.size()];
		Label[] label = new Label[hs.size()];
		Label[] name = new Label[hs.size()];
		int i;
		for(i=0;i<hs.size();i++) {
			label[i] = (Label)root.lookup("#rankla"+(i+1));
			hbox[i] = (HBox)root.lookup("#fxhbox"+(i+1));
			name[i] = (Label)root.lookup("#name"+(i+1));
		}
		for(i=0;i<hs.size();i++) {		
			hbox[i].setOpacity(1);
		}
		i=0;
		for(Double k : hs.keySet()) {
			
			label[i].setText(String.format("%.2f", k)+"초");
			name[i].setText(hs.get(k));
			i++;
		}
//		Iterator<Double> keys = hs.keySet().iterator();
//		i=0;
//		while(keys.hasNext()) {
//			System.out.println(i);
//			String score = keys.next()+"초";
//			double key = keys.next();
//			label[i].setText(score);
//			name[i].setText(hs.get(key));
//			System.out.println("1번 들어감");
//			i++;
//			System.out.println("i 증가함");
//		}
		
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
	}

	
}
