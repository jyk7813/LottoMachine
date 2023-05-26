import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BuyPage extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	BuyPage frame = new BuyPage();
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
    public BuyPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 932);
		setResizable(false);
        // 이미지 아이콘 로드
        ImageIcon buyPageIcon = new ImageIcon(getClass().getClassLoader().getResource("buyPage.jpeg"));
        ImageIcon initBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("initButten.png"));
        ImageIcon autoBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("autoBtn.png"));
        ImageIcon addBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("addBtn.png"));
        ImageIcon longBuyBtnIcon = new ImageIcon(getClass().getClassLoader().getResource("LBuyBtn.png"));
        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(buyPageIcon);

        // 버튼 생성
        JButton resetButton = new JButton(initBtnIcon);
        resetButton.setBounds(40, 523, 80, 37); // 위치와 크기 설정
        JButton autoButton = new JButton(autoBtnIcon);
        autoButton.setBounds(140, 523, 80, 37);
        JButton addButton = new JButton(addBtnIcon);
        addButton.setBounds(240, 523, 152, 36);
        JButton lbuyButton = new JButton(longBuyBtnIcon);
        lbuyButton.setBounds(90, 804, 251, 41);
        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight()));

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, buyPageIcon.getIconWidth(), buyPageIcon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(resetButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(autoButton,new Integer(2));
        layeredPane.add(addButton, new Integer(2));
        layeredPane.add(lbuyButton, new Integer(2));
        
        
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setBorderPainted(false);
        autoButton.setOpaque(false);
        autoButton.setContentAreaFilled(false);
        autoButton.setBorderPainted(false);
        addButton.setOpaque(false);
        addButton.setContentAreaFilled(false);
        addButton.setBorderPainted(false);
        lbuyButton.setOpaque(false);
        lbuyButton.setContentAreaFilled(false);
        lbuyButton.setBorderPainted(false);
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        
      
    }
}
