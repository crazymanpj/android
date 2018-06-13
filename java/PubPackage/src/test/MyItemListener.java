package test;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class MyItemListener implements ItemListener{
	
	public void itemStateChanged(ItemEvent e) {
		JCheckBox jcb = (JCheckBox)e.getItem();
		if (jcb.isSelected()) {
//			cb1.setSelected(true);
		}else {
			System.out.print('b');
		}
	}

}
