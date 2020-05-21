package mini_project;

import javafx.scene.Parent;


public class rspServiceImpl implements rspService {
	private Parent root;
	private int victoryNum = 0;
	private String pic;
//	@Override
//	public void clickRock() {
//		pic = rspCon.getPic();
//		System.out.println("이전 화면속 그림은 " + this.pic);
//		if(this.pic=="가위") {
//			victoryNum++;
//		}
//	}
//
//	@Override
//	public void clickScissors() {
//		pic = rspCon.getPic();
//		System.out.println("이전 화면속 그림은" + pic);
//		if(pic=="보") {
//			victoryNum++;
//		}
//	}
//
//	@Override
//	public void clickPaper() {
//		pic = rspCon.getPic();
//		System.out.println("이전 화면속 그림은 " + pic);
//		if(pic=="바위") {
//			victoryNum++;
//		}
//	}

	@Override
	public String makePicture() {
		int num = (int) (Math.random()*3+1);
		System.out.println(num);
		if(num==1) {
			this.pic = "가위";
		}else if(num==2) {
			this.pic = "바위";
		}else {
			this.pic = "보";
		}
		return this.pic;
	}

	@Override
	public int getVictoryNum() {
		return victoryNum;
	}
	
	
	
	

}
