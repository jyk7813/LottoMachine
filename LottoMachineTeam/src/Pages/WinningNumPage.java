// 해야할 것
// 언더로터리에서 숫자 다 만들어지면 바로 위닝넘 페이지로 넘겨주기
// 넘겨주는 과정에서 셋을 리스트로 바꾼다음 위닝넘으로 넘겨줘야 한다.
// 맵에 넘기면은 숫자 체크를 할 수 있도록 맵 키를 만들고 (보너스넘이랑 리스트랑 맵에 넘겨줘야한다)

package Pages;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.SelectNum;
import utility.IconData;

public class WinningNumPage extends JDialog {
	private IconData icon = new IconData();
	private JPanel contentPane;
	private JLayeredPane layeredPane;

  
    /**
     * Create the frame.
     */
    public WinningNumPage() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

     // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon.winningNumIcon());
        
        JLabel[][] lottoNum = new JLabel[8][10];
        JLabel[][] lottoNum2 = new JLabel[8][10];
        JLabel[] lottoAuto = new JLabel[10];
        JLabel[] winnerNum = new JLabel[10];
        
        JLabel bonusNum = new JLabel(icon.emptyBtn());
        bonusNum.setBounds(357, 225, 40, 40);
        
        
        
        Map<Integer, SelectNum> map;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight()));
        
        int[] arr = new int[6];
        
        	for (int j = 0; j < 10; j++) {
        		for (int i = 0; i < 7; i++) {
        			if(i == 0) {
        				lottoNum[i][j] = new JLabel();
        				
        			} else {
        				lottoNum[i][j] = new JLabel(icon.emptySBtn());
        			}
        			
        			lottoNum[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
        			layeredPane.add(lottoNum[i][j], new Integer(2));	
        		}
        	}
        	
        	for (int i = 0; i < 10; i++) {
        		lottoAuto[i]= new JLabel(icon.emptyLBtn());
        		lottoAuto[i].setBounds(337, 340 + i * 50, 52, 36);
        		layeredPane.add(lottoAuto[i], new Integer(2));
        	}
        	
        	for (int i = 0; i < 6; i++) {
        		winnerNum[i]= new JLabel(icon.emptyBtn());
        		winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);
        		layeredPane.add(winnerNum[i], new Integer(2));
        	}
        	
        	
        	
        	
        
        // 버튼 생성
        JButton backBtn = new JButton(icon.backIcon());
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정


        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(bonusNum, new Integer(2));
        
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        

        pack();
        
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
    }
}