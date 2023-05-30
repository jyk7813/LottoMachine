package Pages;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuyCheckPage extends JFrame {
	private JButton backBtn;
	private JButton yesBtn;
	private JButton noBtn;
	private ImageIcon icon;
	private ImageIcon backIcon;
	private ImageIcon yesIcon;
	private ImageIcon noIcon;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyCheckPage frame = new BuyCheckPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BuyCheckPage() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932); // 창의 크기를 설정
        setResizable(false); // 창 크기 변경을 비활성화

        iconSettingBuyCheckPage();

        // 이미지 아이콘 로드
        

        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);
        btnBoundsBuyCheckPage();

        // 버튼 생성
        //yesBtn = new JButton("Click me");
         // 위치와 크기 설정

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2));
        layeredPane.add(yesBtn, new Integer(3)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(noBtn, new Integer(4));

        btnUnVisuableBuyCheckPage();
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
    }
    
    private void iconSettingBuyCheckPage() {
    	icon = new ImageIcon(getClass().getClassLoader().getResource("buycheck(BG).png"));
    	backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
    	yesIcon = new ImageIcon(getClass().getClassLoader().getResource("yesBtn.png"));
    	noIcon = new ImageIcon(getClass().getClassLoader().getResource("noBtn.png"));
    	
    }
    private void btnBoundsBuyCheckPage() {
    	backBtn = new JButton(backIcon);
    	backBtn.setBounds(19,41,33,38);
    	
    	yesBtn = new JButton(yesIcon);
    	yesBtn.setBounds(94,459,107,41);
    	
    	noBtn = new JButton(noIcon);
    	noBtn.setBounds(229,459,107,41);
    	
    }
    private void btnUnVisuableBuyCheckPage() {
    	backBtn.setOpaque(false);
    	backBtn.setContentAreaFilled(false);
    	yesBtn.setBorderPainted(false);
    	
    	yesBtn.setOpaque(false);
    	yesBtn.setContentAreaFilled(false);
    	yesBtn.setBorderPainted(false);
    	
    	noBtn.setOpaque(false);
    	noBtn.setContentAreaFilled(false);
    	noBtn.setBorderPainted(false);
    }
}
