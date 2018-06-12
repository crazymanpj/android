package test;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PubGui {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("发包工具");
		
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		frame.add(panel);
		
		placeComponents(panel);
		
		frame.setVisible(true);
	}
	
	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		
		JLabel dirLabel = new JLabel("安装包目录");
		dirLabel.setBounds(10, 20, 80, 25);
		panel.add(dirLabel);
		
		JTextField dirText = new JTextField(20);
		dirText.setBounds(100, 20, 500, 25);
		panel.add(dirText);
		
		JLabel versioncodeLabel = new JLabel("APK版本号");
		versioncodeLabel.setBounds(10, 50, 80, 25);
		panel.add(versioncodeLabel);
		
		JTextField versioncodeText = new JTextField(20);
		versioncodeText.setBounds(100, 50, 165, 25);
		panel.add(versioncodeText);
		
		int ycord = 90;
		JCheckBox cb0 = new JCheckBox("all");
		cb0.setBounds(10, ycord, 150, 25);
		panel.add(cb0);
		
		JCheckBox cb1 = new JCheckBox("应用宝(800009)");
		cb1.setBounds(10, ycord+30, 150, 25);
//		cb1.setSelected(true);
		panel.add(cb1);
		
		JCheckBox cb2 = new JCheckBox("搜狗(800007)");
		cb2.setBounds(10, ycord + 30 *2, 150, 25);
		panel.add(cb2);
		
		JCheckBox cb3 = new JCheckBox("联想(800019)");
		cb3.setBounds(10, ycord+30*3, 150, 25);
		panel.add(cb3);
		
		JCheckBox cb4 = new JCheckBox("OPPO(800020)");
		cb4.setBounds(10, ycord+30*4, 150, 25);
		panel.add(cb4);
		
		JButton pubButton = new JButton("一键发布");
		pubButton.setBounds(10, 300, 150, 40);
		panel.add(pubButton);
		
		pubButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击按钮");
				System.out.println(dirText.getText());
				System.out.println(versioncodeText.getText());
			}
			
		});
		
	}

}
