package utility;
	//나중에 혼자 작업
import javax.swing.ImageIcon;

public class IconData {
	
	public ImageIcon mainIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("main(BG).png"));
	}
	public ImageIcon buyIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buyBigBtn.png"));
	}
	public ImageIcon myNumIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("myNumBtn.png"));
	}
	public ImageIcon makeLotteryIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("lotteryBtn.png"));
	}
	public ImageIcon nextTurnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("nextBtn.png"));
	}
	public ImageIcon buyPageIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buy(BG).png"));
	}
	public ImageIcon initBtnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("initButten.png"));
	}
	public ImageIcon autoBtnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("autoBtn.png"));
	}
	public ImageIcon addBtnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("addBtn.png"));
	}
	public ImageIcon longBuyBtnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
	}
	public ImageIcon moreIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("moreBtn.png"));
	}
	public ImageIcon backIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
	}
	public ImageIcon cancleIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));
	}
	public ImageIcon emptyIcon() {
		return  new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
	}
}
