package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import database.WinningNum;
import database.WinningNumData;
import utility.IconData;

public class UnderLotteryPage extends JDialog implements ActionListener{
	private WinningNumData winningNumData;
	private JLabel label;
	private ImageIcon underLotteryPage;
	private ImageIcon bonuseIcon;
	private ImageIcon emptyIcon;
	private JLabel selectEmptyJLabels[];
	private JLabel bonuseEmptyJLabels;
	private JLayeredPane layeredPane;
	private Random random = new Random();
	int count;
	IconData iconData = new IconData();
	private Timer timer;
	private Set<Integer> randomNums;
	private int bonusNum;
	
    
    public void name() {
		winningNumData.setWinningNum(new WinningNum(randomNums, 5));
	}
    
	/**
     * Create the frame.
     */
    public UnderLotteryPage() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

        // 이미지 아이콘을 사용하는 레이블 생성
        makeLabel();
        
        // JLayeredPane 생성 및 설정
        JLayeredPaneAdd();

        // 레이블 및 버튼 위치 설정
        labelBounds();
        
        // 레이블 및 버튼을 JLayeredPane에 추가
        addLabeleAndBtn();
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        timer = new Timer(1000, this);
        timer.start();
        randomNums = new HashSet<>();
        while (randomNums.size() < 6) {
        	int num = random.nextInt(45);
        	randomNums.add(num);
		}
        
        generateBonusNumber();
        
        pack();
    }
    private void makeLabel() {
    	label = new JLabel(iconData.underLotteryIcon());//기본 페이지화면
    	
    	//선택된 empty라벨 6개 배열선언
    	selectEmptyJLabels = new JLabel[6];
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i] = new JLabel(iconData.emptyBtn());
		}
		bonuseEmptyJLabels = new JLabel(iconData.emptyBtn());//empty보너스 라벨 1개
    }
    private void labelBounds() {
    	//기본 페이지화면 위치와 크기설정
		label.setBounds(0, 0, iconData.underLotteryIcon().getIconWidth(), iconData.underLotteryIcon().getIconHeight());
		//선택된 empty라벨 위치와 크기설정
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i].setBounds(34 + i * 50, 362, 40, 40);

		}
		//보너스번호 라벨 위치와 크기설정
		bonuseEmptyJLabels.setBounds(358, 362, 40, 40);	

	} 
    private void makeIcon() {
    	//그림파일 로드
    	
    }
    private void addLabeleAndBtn() {
    	layeredPane.add(label, new Integer(1));
    	//empty라벨6개 레이어에 추가
    	for (int i = 0; i < selectEmptyJLabels.length; i++) {
			layeredPane.add(selectEmptyJLabels[i], new Integer(2));
    	}
    	layeredPane.add(bonuseEmptyJLabels, new Integer(4));
    	
	}
    private void JLayeredPaneAdd() {
    	layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); 
    }
    @Override
	public void actionPerformed(ActionEvent e) {
    	
    	if (count < 6) {
			selectEmptyJLabels[count].setIcon(iconData.LCIcons()[randomNums.toArray(new Integer[0])[count]]);
		}
    	if (count == 6) {
			bonuseEmptyJLabels.setIcon(iconData.LCIcons()[bonusNum]);
		}
    	if (count > 6) {
			timer.stop();
			dispose();
		}
    	count++;
	}
    private void generateBonusNumber() {
        do {
            bonusNum = random.nextInt(45);
        } while (randomNums.contains(bonusNum));
    }
}
