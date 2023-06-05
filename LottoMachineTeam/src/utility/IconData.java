package utility;

//나중에 혼자 작업
import javax.swing.ImageIcon;

public class IconData {

	public ImageIcon mainIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("main(BG).png"));
	}

	public ImageIcon buyLimitIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buyLimit.png"));
	}

	public ImageIcon buyIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buyBigBtn.png"));
	}

	public ImageIcon buyErrorIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buyErrorBtn.png"));
	}

	public ImageIcon winnerCheckIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("winnerCheckBtn.png"));
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

	public ImageIcon nextGrayTurnIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("nextGrayBtn.png"));
	}

	public ImageIcon buyPageIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("buy(BG).png"));
	}

	public ImageIcon subErrorIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("subError(BG).png"));
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

	public ImageIcon skipBtn() {
		return new ImageIcon(getClass().getClassLoader().getResource("skipBtn.png"));
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

	public ImageIcon lottoMachineIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("lottoMachine.gif"));
	}

	public ImageIcon rankingIcon1() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_1.png"));
	}

	public ImageIcon rankingIcon2() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_2.png"));
	}

	public ImageIcon rankingIcon3() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_3.png"));
	}

	public ImageIcon rankingIcon4() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_4.png"));
	}

	public ImageIcon rankingIcon5() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_5.png"));
	}

	public ImageIcon rankingIconFail() {
		return new ImageIcon(getClass().getClassLoader().getResource("ranking_fail.png"));
	}

	public ImageIcon autoIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("autoBtn-1.png"));
	}

	public ImageIcon semiAutoIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("semiAutoBtn.png"));
	}

	public ImageIcon manualIcon() {
		return new ImageIcon(getClass().getClassLoader().getResource("manualBtn.png"));
	}

	public ImageIcon[] LCIcons() {
		ImageIcon[] colorNumIcon = new ImageIcon[45];
		for (int i = 0; i < colorNumIcon.length; i++) {
			String filename = "LC" + (i + 1) + ".png";
			colorNumIcon[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}
		return colorNumIcon;

	}

	public ImageIcon[] SCIcons() {
		ImageIcon[] SCIcons = new ImageIcon[45];
		for (int i = 0; i < SCIcons.length; i++) {
			String filename = "SC" + (i + 1) + ".png";
			SCIcons[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}
		return SCIcons;

	}

	public ImageIcon[] SIcons() {
		ImageIcon[] SIcons = new ImageIcon[45];
		for (int i = 0; i < SIcons.length; i++) {
			String filename = "S" + (i + 1) + ".png";
			SIcons[i] = new ImageIcon(getClass().getClassLoader().getResource(filename));
		}
		return SIcons;

	}
}
