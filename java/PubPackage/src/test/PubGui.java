package test;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.regex.*;



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
	
	private static void updateConfig(String dirPath, String versioncode, boolean isupdateText) {
		System.out.println("updateConfig");
        FileOutputStream out = null;
        FileInputStream in = null;
        InputStreamReader isr = null;
        
        String configFilePath = "gobal_config.py";
        System.out.println(System.getProperty("user.dir"));
        
        if(dirPath.equals("")) {
        	dirPath = "dirtext";
        }
        if(versioncode.equals("")) {
        	versioncode = "vertext";
        }

        try{
        	in = new FileInputStream(new File(configFilePath));
        	isr = new InputStreamReader(in, "UTF-8");
        	int ch = 0;
        	String text = "";
        	while((ch = isr.read()) != -1) {
        		text = text + (char) ch;
        	}
        	
        	String pattern = "(DIR = r')(\\S+)(')";
        	String pattern2 = "(APKVER = ')(\\S+)(')";
        	String pattern3 = "(IS_UPDATE_TEXT = )(\\S+)";
        	
        	Pattern r = Pattern.compile(pattern);
        	Matcher m = r.matcher(text);
            if (m.find( )) {
                text = text.replace(m.group(2), dirPath);
            } else {
               System.out.println("NO MATCH");
            }
           
            
        	Pattern r2 = Pattern.compile(pattern2);
        	Matcher m2 = r2.matcher(text);
            if (m2.find()) {
                text = text.replace(m2.group(2), versioncode);
            } else {
               System.out.println("NO MATCH");
            }
          
        	Pattern r3 = Pattern.compile(pattern3);
        	Matcher m3 = r3.matcher(text);
            if (m3.find()) {
            	if(isupdateText == true) {
            		System.out.println(m3.group(2));
            		text = text.replace(m3.group(2), "1");
            	}
            	else {
                    text = text.replace(m3.group(2), "0");
            	}
  
            } else {
               System.out.println("NO MATCH");
            }

            System.out.println(text);
            File file = new File(configFilePath);
            try {  
                out = new FileOutputStream(new File(configFilePath));
                OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8"); 
                osw.write(text);
                osw.close(); 
                System.out.println("end");
             } catch (IOException e) {  
            	 e.printStackTrace();  
             }  
           
     
        }
        catch(Exception e) {
        	e.printStackTrace();
        } finally {
            try {
            	in.close();
            	isr.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
		
		JCheckBox isupdateText = new JCheckBox("是否更新文案(文案请在text.txt文件里面填写)");
		isupdateText.setBounds(300, 50, 300, 25);
		panel.add(isupdateText);
		
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
		
		cb0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox jcb = (JCheckBox)e.getSource();
				if (jcb.isSelected()) {
					cb1.setSelected(true);
					cb2.setSelected(true);
					cb3.setSelected(true);
					cb4.setSelected(true);
				}else {
					cb1.setSelected(false);
					cb2.setSelected(false);
					cb3.setSelected(false);
					cb4.setSelected(false);
				}
			}
		});
		
		pubButton.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击按钮");
				String dirPath = dirText.getText();

				if(dirPath.lastIndexOf('\\') == (dirPath.length() -1)) {
					dirPath = dirPath.substring(0, dirPath.length() - 1);
				}
				String versionCode = versioncodeText.getText();
				boolean isUpdateText = isupdateText.isSelected();
				System.out.println(versionCode + " " + dirPath);
				System.out.println(isUpdateText);
				updateConfig(dirPath, versionCode, isUpdateText);
				
				if(cb1.isSelected()) {
					System.out.println("pub yyb");
					String cmd = new String("python yyb.py");
					try {
						Process process = java.lang.Runtime.getRuntime().exec(cmd);

					}

					catch(Exception e1) {
						e1.printStackTrace();
					}		
				};
				if(cb2.isSelected()) {
					String cmd = new String("python sougou.py");
					try {
						java.lang.Runtime.getRuntime().exec(cmd);
					}

					catch(Exception e1) {
						e1.printStackTrace();
					}		
				};
				if(cb3.isSelected()) {
					String cmd = new String("python lenovo.py");
					try {
						java.lang.Runtime.getRuntime().exec(cmd);
					}

					catch(Exception e1) {
						e1.printStackTrace();
					}		
				};
				if(cb4.isSelected()) {
					String cmd = new String("python oppo.py");
					try {
						java.lang.Runtime.getRuntime().exec(cmd);
					}

					catch(Exception e1) {
						e1.printStackTrace();
					}		
				};
				System.out.println(versioncodeText.getText());
			}
			
		});
		
	}

}
