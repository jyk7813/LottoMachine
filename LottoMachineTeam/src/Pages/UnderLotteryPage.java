package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import utility.IconData;

public class UnderLotteryPage extends JDialog implements ActionListener{
	
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
	

  
    /**
     * Create the frame.
     */
    public UnderLotteryPage() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

        // 이미지 아이콘 로드
        makeIcon();

        // 이미지 아이콘을 사용하는 레이블 생성
        makeLabel();
        
        // JLayeredPane 생성 및 설정
        JLayeredPaneAdd();

        // 레이블 및 버튼 위치 설정
        labelBounds();
        

        // 레이블 및 버튼을 JLayeredPane에 추가
        addLabeleAndBtn();
        // 뒤로가기버튼 숨기기
        

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        timer = new Timer(1000, this);
        timer.start();
        pack();
    }
    private void makeLabel() {
    	label = new JLabel(underLotteryPage);//기본 페이지화면
    	
    	//선택된 empty라벨 6개 배열선언
    	selectEmptyJLabels = new JLabel[6];
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i] = new JLabel(emptyIcon);
		}
		bonuseEmptyJLabels = new JLabel(bonuseIcon);//empty보너스 라벨 1개
    }
    private void labelBounds() {
    	//기본 페이지화면 위치와 크기설정
		label.setBounds(0, 0, underLotteryPage.getIconWidth(), underLotteryPage.getIconHeight());
		//선택된 empty라벨 위치와 크기설정
		for (int i = 0; i < selectEmptyJLabels.length; i++) {
			selectEmptyJLabels[i].setBounds(34 + i * 50, 362, 40, 40);

		}
		//보너스번호 라벨 위치와 크기설정
		bonuseEmptyJLabels.setBounds(358, 362, 40, 40);	

	} 
    private void makeIcon() {
    	//그림파일 로드
    	underLotteryPage = new ImageIcon(getClass().getClassLoader().getResource("underLottery(BG).png"));
    	emptyIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
    	bonuseIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
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
    	int randomNum = random.nextInt(45);
    	if (count < 6) {
			selectEmptyJLabels[count].setIcon(iconData.LCIcons()[randomNum]);
		}
    	if (count == 6) {
			bonuseEmptyJLabels.setIcon(iconData.LCIcons()[randomNum]);
		}
    	if (count > 6) {
			timer.stop();
		}
    	count++;
	}
    
}
