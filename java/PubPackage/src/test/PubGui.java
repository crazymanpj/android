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
		
		JLabel dirLabel = new JLabel("包目录:");
		dirLabel.setBounds(10, 20, 80, 25);
		panel.add(dirLabel);
		
		JTextField dirText = new JTextField(20);
		dirText.setBounds(100, 20, 500, 25);
		panel.add(dirText);
		
		JLabel versioncodeLabel = new JLabel("APK版本号：");
		versioncodeLabel.setBounds(10, 50, 80, 25);
		panel.add(versioncodeLabel);
		
		JTextField versioncodeText = new JTextField(20);
		versioncodeText.setBounds(100, 50, 165, 25);
		panel.add(versioncodeText);
		
		JCheckBox cb1 = new JCheckBox("应用宝(80009)");
		cb1.setBounds(10, 80, 150, 25);
//		cb1.setSelected(true);
		panel.add(cb1);
		
		JButton pubButton = new JButton("一键发布");
		pubButton.setBounds(10, 120, 150, 40);
		panel.add(pubButton);
		
		pubButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("按钮被点击");
				System.out.println(dirText.getText());
				System.out.println(versioncodeText.getText());
			}
			
		});
		
	}

}
