package mini_project;

import javafx.scene.Parent;


public class rspServiceImpl implements rspService {
	private Parent root;
	private int victoryNum = 0;
	private String pic;
//	@Override
//	public void clickRock() {
//		pic = rspCon.getPic();
//		System.out.println("���� ȭ��� �׸��� " + this.pic);
//		if(this.pic=="����") {
//			victoryNum++;
//		}
//	}
//
//	@Override
//	public void clickScissors() {
//		pic = rspCon.getPic();
//		System.out.println("���� ȭ��� �׸���" + pic);
//		if(pic=="��") {
//			victoryNum++;
//		}
//	}
//
//	@Override
//	public void clickPaper() {
//		pic = rspCon.getPic();
//		System.out.println("���� ȭ��� �׸��� " + pic);
//		if(pic=="����") {
//			victoryNum++;
//		}
//	}

	@Override
	public String makePicture() {
		int num = (int) (Math.random()*3+1);
		System.out.println(num);
		if(num==1) {
			this.pic = "����";
		}else if(num==2) {
			this.pic = "����";
		}else {
			this.pic = "��";
		}
		return this.pic;
	}

	@Override
	public int getVictoryNum() {
		return victoryNum;
	}
	
	
	
	

}
