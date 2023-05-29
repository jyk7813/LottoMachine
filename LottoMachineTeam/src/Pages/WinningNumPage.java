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

public class WinningNumPage extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WinningNumPage frame = new WinningNumPage();
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
    public WinningNumPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 890); // 창의 크기를 설정
        setResizable(false); // 창 크기 변경을 비활성화

        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("winningNum(BG).png"));;
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));;
        ImageIcon bNumber = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));;
        ImageIcon sNumber = new ImageIcon(getClass().getClassLoader().getResource("emptySBtn.png"));;
        ImageIcon cancel = new ImageIcon(getClass().getClassLoader().getResource("emptySBtn.png"));;

        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);
        JLabel lottoNum1 = new JLabel(bNumber);
        lottoNum1.setBounds(33, 225, 40, 40); // 위치와 크기 설정
        JLabel lottoNum2 = new JLabel(bNumber);
        lottoNum2.setBounds(83, 225, 40, 40);
        JLabel lottoNum3 = new JLabel(bNumber);
        lottoNum3.setBounds(133, 225, 40, 40);
        JLabel lottoNum4 = new JLabel(bNumber);
        lottoNum4.setBounds(183, 225, 40, 40);
        JLabel lottoNum5 = new JLabel(bNumber);
        lottoNum5.setBounds(233, 225, 40, 40);
        JLabel lottoNum6 = new JLabel(bNumber);
        lottoNum6.setBounds(283, 225, 40, 40);
        JLabel lottoNum7 = new JLabel(bNumber);
        lottoNum7.setBounds(357, 225, 40, 40);
        
        JLabel lottoNum1_1 = new JLabel(sNumber);
        lottoNum1_1.setBounds(71, 340, 36, 36);
        JLabel lottoNum1_2 = new JLabel(sNumber);
        lottoNum1_2.setBounds(115, 340, 36, 36);
        JLabel lottoNum1_3 = new JLabel(sNumber);
        lottoNum1_3.setBounds(159, 340, 36, 36);
        JLabel lottoNum1_4 = new JLabel(sNumber);
        lottoNum1_4.setBounds(203, 340, 36, 36);
        JLabel lottoNum1_5 = new JLabel(sNumber);
        lottoNum1_5.setBounds(247, 340, 36, 36);
        JLabel lottoNum1_6 = new JLabel(sNumber);
        lottoNum1_6.setBounds(291, 340, 36, 36);
        JLabel lottoNum1_0 = new JLabel(sNumber);
        lottoNum1_0.setBounds(291, 340, 36, 36);

        // 버튼 생성
        JButton backBtn = new JButton(backIcon);
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정
        
        

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(lottoNum1, new Integer(2));
        layeredPane.add(lottoNum2, new Integer(2));
        layeredPane.add(lottoNum3, new Integer(2));
        layeredPane.add(lottoNum4, new Integer(2));
        layeredPane.add(lottoNum5, new Integer(2));
        layeredPane.add(lottoNum6, new Integer(2));
        layeredPane.add(lottoNum7, new Integer(2));
        
        layeredPane.add(lottoNum1_1, new Integer(2));
        layeredPane.add(lottoNum1_2, new Integer(2));
        layeredPane.add(lottoNum1_3, new Integer(2));
        layeredPane.add(lottoNum1_4, new Integer(2));
        layeredPane.add(lottoNum1_5, new Integer(2));
        layeredPane.add(lottoNum1_6, new Integer(2));
        layeredPane.add(lottoNum1_0, new Integer(2));
        

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
    }
}
