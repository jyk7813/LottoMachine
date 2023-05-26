import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
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
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430,932);
        setResizable(false);

        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon("mainImege.jpeg");
        ImageIcon buyIcon = new ImageIcon("buyButten.png");
        ImageIcon myNumIcon = new ImageIcon("myNumButten.png");
        ImageIcon makeLotteryIcon = new ImageIcon("makeLotteryButten.png");
        ImageIcon nextTurnIcon = new ImageIcon("nextTurnButten.png");
        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon);

        // 버튼 생성
        JButton buyButton = new JButton(buyIcon);
        buyButton.setBounds(78, 610, 280, 81); // 위치와 크기 설정
        JButton myNumButton = new JButton(myNumIcon);
        myNumButton.setBounds(30,780,111,36);
        JButton makeLotteryButton = new JButton(makeLotteryIcon);
        makeLotteryButton.setBounds(160, 780, 111, 36);
        JButton nextTurnButton = new JButton(nextTurnIcon);
        nextTurnButton.setBounds(290, 780, 111, 36);
        

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(myNumButton,new Integer(2));
        layeredPane.add(makeLotteryButton, new Integer(2));
        layeredPane.add(nextTurnButton, new Integer(3));
//        button.setOpaque(false);
//        button.setContentAreaFilled(false);
        buyButton.setBorderPainted(false);
        myNumButton.setBorderPainted(false);
        makeLotteryButton.setBorderPainted(false);
        nextTurnButton.setBorderPainted(false);
        

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        pack();
    }
}
