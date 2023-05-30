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

public class BuyCompletePage extends JFrame {
	private JButton returnBtn;
	private ImageIcon icon;
	private ImageIcon returnIcon;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BuyCompletePage frame = new BuyCompletePage();
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
    public BuyCompletePage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 창 크기 변경을 비활성화
        
        iconSettingBuyCompletePage();


        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);
        
        // 이미지 아이콘 생성 및 크기위치 설정
        btnBoundsBuyCompletePage();

        // 버튼 생성
//        JButton button = new JButton("Click me");
//        button.setBounds(50, 50, 120, 30); // 위치와 크기 설정

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(returnBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        
        //버튼 숨기기
        btnUnVisuableBuyCompletePage();

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        pack();
    }
    private void iconSettingBuyCompletePage() {
    	icon = new ImageIcon(getClass().getClassLoader().getResource("buyComplete(BG).png"));
    	returnIcon = new ImageIcon(getClass().getClassLoader().getResource("returnBtn.png"));
    }
    private void btnBoundsBuyCompletePage() {
    	returnBtn = new JButton(returnIcon);
    	returnBtn.setBounds(161, 458, 107, 41);
	   
   }
    private void btnUnVisuableBuyCompletePage() {
    	returnBtn.setOpaque(false);
    	returnBtn.setContentAreaFilled(false);
    	returnBtn.setBorderPainted(false);
    }
}
