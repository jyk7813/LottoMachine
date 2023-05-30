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
        ImageIcon lBtn = new ImageIcon(getClass().getClassLoader().getResource("emptyLBtn.png"));;

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
        JLabel lottoNum1_0 = new JLabel(lBtn);
        lottoNum1_0.setBounds(337, 340, 52, 36);
        
        JLabel lottoNum2_1 = new JLabel(sNumber);
        lottoNum2_1.setBounds(71, 390, 36, 36);
        JLabel lottoNum2_2 = new JLabel(sNumber);
        lottoNum2_2.setBounds(115, 390, 36, 36);
        JLabel lottoNum2_3 = new JLabel(sNumber);
        lottoNum2_3.setBounds(159, 390, 36, 36);
        JLabel lottoNum2_4 = new JLabel(sNumber);
        lottoNum2_4.setBounds(203, 390, 36, 36);
        JLabel lottoNum2_5 = new JLabel(sNumber);
        lottoNum2_5.setBounds(247, 390, 36, 36);
        JLabel lottoNum2_6 = new JLabel(sNumber);
        lottoNum2_6.setBounds(291, 390, 36, 36);
        JLabel lottoNum2_0 = new JLabel(lBtn);
        lottoNum2_0.setBounds(337, 390, 52, 36);
        
        JLabel lottoNum3_1 = new JLabel(sNumber);
        lottoNum3_1.setBounds(71, 440, 36, 36);
        JLabel lottoNum3_2 = new JLabel(sNumber);
        lottoNum3_2.setBounds(115, 440, 36, 36);
        JLabel lottoNum3_3 = new JLabel(sNumber);
        lottoNum3_3.setBounds(159, 440, 36, 36);
        JLabel lottoNum3_4 = new JLabel(sNumber);
        lottoNum3_4.setBounds(203, 440, 36, 36);
        JLabel lottoNum3_5 = new JLabel(sNumber);
        lottoNum3_5.setBounds(247, 440, 36, 36);
        JLabel lottoNum3_6 = new JLabel(sNumber);
        lottoNum3_6.setBounds(291, 440, 36, 36);
        JLabel lottoNum3_0 = new JLabel(lBtn);
        lottoNum3_0.setBounds(337, 440, 52, 36);
        
        JLabel lottoNum4_1 = new JLabel(sNumber);
        lottoNum4_1.setBounds(71, 490, 36, 36);
        JLabel lottoNum4_2 = new JLabel(sNumber);
        lottoNum4_2.setBounds(115, 490, 36, 36);
        JLabel lottoNum4_3 = new JLabel(sNumber);
        lottoNum4_3.setBounds(159, 490, 36, 36);
        JLabel lottoNum4_4 = new JLabel(sNumber);
        lottoNum4_4.setBounds(203, 490, 36, 36);
        JLabel lottoNum4_5 = new JLabel(sNumber);
        lottoNum4_5.setBounds(247, 490, 36, 36);
        JLabel lottoNum4_6 = new JLabel(sNumber);
        lottoNum4_6.setBounds(291, 490, 36, 36);
        JLabel lottoNum4_0 = new JLabel(lBtn);
        lottoNum4_0.setBounds(337, 490, 52, 36);
        
        JLabel lottoNum5_1 = new JLabel(sNumber);
        lottoNum5_1.setBounds(71, 540, 36, 36);
        JLabel lottoNum5_2 = new JLabel(sNumber);
        lottoNum5_2.setBounds(115, 540, 36, 36);
        JLabel lottoNum5_3 = new JLabel(sNumber);
        lottoNum5_3.setBounds(159, 540, 36, 36);
        JLabel lottoNum5_4 = new JLabel(sNumber);
        lottoNum5_4.setBounds(203, 540, 36, 36);
        JLabel lottoNum5_5 = new JLabel(sNumber);
        lottoNum5_5.setBounds(247, 540, 36, 36);
        JLabel lottoNum5_6 = new JLabel(sNumber);
        lottoNum5_6.setBounds(291, 540, 36, 36);
        JLabel lottoNum5_0 = new JLabel(lBtn);
        lottoNum5_0.setBounds(337, 540, 52, 36);
        
        JLabel lottoNum6_1 = new JLabel(sNumber);
        lottoNum6_1.setBounds(71, 590, 36, 36);
        JLabel lottoNum6_2 = new JLabel(sNumber);
        lottoNum6_2.setBounds(115, 590, 36, 36);
        JLabel lottoNum6_3 = new JLabel(sNumber);
        lottoNum6_3.setBounds(159, 590, 36, 36);
        JLabel lottoNum6_4 = new JLabel(sNumber);
        lottoNum6_4.setBounds(203, 590, 36, 36);
        JLabel lottoNum6_5 = new JLabel(sNumber);
        lottoNum6_5.setBounds(247, 590, 36, 36);
        JLabel lottoNum6_6 = new JLabel(sNumber);
        lottoNum6_6.setBounds(291, 590, 36, 36);
        JLabel lottoNum6_0 = new JLabel(lBtn);
        lottoNum6_0.setBounds(337, 590, 52, 36);
        
        JLabel lottoNum7_1 = new JLabel(sNumber);
        lottoNum7_1.setBounds(71, 640, 36, 36);
        JLabel lottoNum7_2 = new JLabel(sNumber);
        lottoNum7_2.setBounds(115, 640, 36, 36);
        JLabel lottoNum7_3 = new JLabel(sNumber);
        lottoNum7_3.setBounds(159, 640, 36, 36);
        JLabel lottoNum7_4 = new JLabel(sNumber);
        lottoNum7_4.setBounds(203, 640, 36, 36);
        JLabel lottoNum7_5 = new JLabel(sNumber);
        lottoNum7_5.setBounds(247, 640, 36, 36);
        JLabel lottoNum7_6 = new JLabel(sNumber);
        lottoNum7_6.setBounds(291, 640, 36, 36);
        JLabel lottoNum7_0 = new JLabel(lBtn);
        lottoNum7_0.setBounds(337, 640, 52, 36);
        
        JLabel lottoNum8_1 = new JLabel(sNumber);
        lottoNum8_1.setBounds(71, 690, 36, 36);
        JLabel lottoNum8_2 = new JLabel(sNumber);
        lottoNum8_2.setBounds(115, 690, 36, 36);
        JLabel lottoNum8_3 = new JLabel(sNumber);
        lottoNum8_3.setBounds(159, 690, 36, 36);
        JLabel lottoNum8_4 = new JLabel(sNumber);
        lottoNum8_4.setBounds(203, 690, 36, 36);
        JLabel lottoNum8_5 = new JLabel(sNumber);
        lottoNum8_5.setBounds(247, 690, 36, 36);
        JLabel lottoNum8_6 = new JLabel(sNumber);
        lottoNum8_6.setBounds(291, 690, 36, 36);
        JLabel lottoNum8_0 = new JLabel(lBtn);
        lottoNum8_0.setBounds(337, 690, 52, 36);
        
        JLabel lottoNum9_1 = new JLabel(sNumber);
        lottoNum9_1.setBounds(71, 740, 36, 36);
        JLabel lottoNum9_2 = new JLabel(sNumber);
        lottoNum9_2.setBounds(115, 740, 36, 36);
        JLabel lottoNum9_3 = new JLabel(sNumber);
        lottoNum9_3.setBounds(159, 740, 36, 36);
        JLabel lottoNum9_4 = new JLabel(sNumber);
        lottoNum9_4.setBounds(203, 740, 36, 36);
        JLabel lottoNum9_5 = new JLabel(sNumber);
        lottoNum9_5.setBounds(247, 740, 36, 36);
        JLabel lottoNum9_6 = new JLabel(sNumber);
        lottoNum9_6.setBounds(291, 740, 36, 36);
        JLabel lottoNum9_0 = new JLabel(lBtn);
        lottoNum9_0.setBounds(337, 740, 52, 36);
        
        JLabel lottoNum10_1 = new JLabel(sNumber);
        lottoNum10_1.setBounds(71, 790, 36, 36);
        JLabel lottoNum10_2 = new JLabel(sNumber);
        lottoNum10_2.setBounds(115, 790, 36, 36);
        JLabel lottoNum10_3 = new JLabel(sNumber);
        lottoNum10_3.setBounds(159, 790, 36, 36);
        JLabel lottoNum10_4 = new JLabel(sNumber);
        lottoNum10_4.setBounds(203, 790, 36, 36);
        JLabel lottoNum10_5 = new JLabel(sNumber);
        lottoNum10_5.setBounds(247, 790, 36, 36);
        JLabel lottoNum10_6 = new JLabel(sNumber);
        lottoNum10_6.setBounds(291, 790, 36, 36);
        JLabel lottoNum10_0 = new JLabel(lBtn);
        lottoNum10_0.setBounds(337, 790, 52, 36);

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
        
        layeredPane.add(lottoNum2_1, new Integer(2));
        layeredPane.add(lottoNum2_2, new Integer(2));
        layeredPane.add(lottoNum2_3, new Integer(2));
        layeredPane.add(lottoNum2_4, new Integer(2));
        layeredPane.add(lottoNum2_5, new Integer(2));
        layeredPane.add(lottoNum2_6, new Integer(2));
        layeredPane.add(lottoNum2_0, new Integer(2));
        
        layeredPane.add(lottoNum3_1, new Integer(2));
        layeredPane.add(lottoNum3_2, new Integer(2));
        layeredPane.add(lottoNum3_3, new Integer(2));
        layeredPane.add(lottoNum3_4, new Integer(2));
        layeredPane.add(lottoNum3_5, new Integer(2));
        layeredPane.add(lottoNum3_6, new Integer(2));
        layeredPane.add(lottoNum3_0, new Integer(2));
        
        layeredPane.add(lottoNum4_1, new Integer(2));
        layeredPane.add(lottoNum4_2, new Integer(2));
        layeredPane.add(lottoNum4_3, new Integer(2));
        layeredPane.add(lottoNum4_4, new Integer(2));
        layeredPane.add(lottoNum4_5, new Integer(2));
        layeredPane.add(lottoNum4_6, new Integer(2));
        layeredPane.add(lottoNum4_0, new Integer(2));
        
        layeredPane.add(lottoNum5_1, new Integer(2));
        layeredPane.add(lottoNum5_2, new Integer(2));
        layeredPane.add(lottoNum5_3, new Integer(2));
        layeredPane.add(lottoNum5_4, new Integer(2));
        layeredPane.add(lottoNum5_5, new Integer(2));
        layeredPane.add(lottoNum5_6, new Integer(2));
        layeredPane.add(lottoNum5_0, new Integer(2));
        
        layeredPane.add(lottoNum6_1, new Integer(2));
        layeredPane.add(lottoNum6_2, new Integer(2));
        layeredPane.add(lottoNum6_3, new Integer(2));
        layeredPane.add(lottoNum6_4, new Integer(2));
        layeredPane.add(lottoNum6_5, new Integer(2));
        layeredPane.add(lottoNum6_6, new Integer(2));
        layeredPane.add(lottoNum6_0, new Integer(2));
        
        layeredPane.add(lottoNum7_1, new Integer(2));
        layeredPane.add(lottoNum7_2, new Integer(2));
        layeredPane.add(lottoNum7_3, new Integer(2));
        layeredPane.add(lottoNum7_4, new Integer(2));
        layeredPane.add(lottoNum7_5, new Integer(2));
        layeredPane.add(lottoNum7_6, new Integer(2));
        layeredPane.add(lottoNum7_0, new Integer(2));
        
        layeredPane.add(lottoNum8_1, new Integer(2));
        layeredPane.add(lottoNum8_2, new Integer(2));
        layeredPane.add(lottoNum8_3, new Integer(2));
        layeredPane.add(lottoNum8_4, new Integer(2));
        layeredPane.add(lottoNum8_5, new Integer(2));
        layeredPane.add(lottoNum8_6, new Integer(2));
        layeredPane.add(lottoNum8_0, new Integer(2));
        
        layeredPane.add(lottoNum9_1, new Integer(2));
        layeredPane.add(lottoNum9_2, new Integer(2));
        layeredPane.add(lottoNum9_3, new Integer(2));
        layeredPane.add(lottoNum9_4, new Integer(2));
        layeredPane.add(lottoNum9_5, new Integer(2));
        layeredPane.add(lottoNum9_6, new Integer(2));
        layeredPane.add(lottoNum9_0, new Integer(2));
       
        layeredPane.add(lottoNum10_1, new Integer(2));
        layeredPane.add(lottoNum10_2, new Integer(2));
        layeredPane.add(lottoNum10_3, new Integer(2));
        layeredPane.add(lottoNum10_4, new Integer(2));
        layeredPane.add(lottoNum10_5, new Integer(2));
        layeredPane.add(lottoNum10_6, new Integer(2));
        layeredPane.add(lottoNum10_0, new Integer(2));
        

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
    }
}
