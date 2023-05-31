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
		return new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
	}

	public ImageIcon emptyBtn() {
		return new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
	}

	public ImageIcon emptySBtn() {
		return new ImageIcon(getClass().getClassLoader().getResource("emptySBtn.png"));
	}

	public ImageIcon emptyLBtn() {
		return new ImageIcon(getClass().getClassLoader().getResource("emptyLBtn.png"));
	}

	public ImageIcon winningNumIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("winningNum(BG).png"));
	}

	public ImageIcon myNumCheckIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("myNumCheck(BG).png"));
	}
	public ImageIcon underLotteryIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("underLottery(BG).png"));

	}

	public ImageIcon[] LCIcons() {
		ImageIcon[] colorNumIcon = new ImageIcon[45];
		for (int i = 0; i < colorNumIcon.length; i++) {
			String filename = "LC" + (i + 1) + ".png";
			colorNumIcon[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}
		return colorNumIcon;

	}
}
