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
	public ImageIcon emptyIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
	}
}
