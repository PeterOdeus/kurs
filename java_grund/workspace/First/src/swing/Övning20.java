package swing;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Övning20 extends JFrame {

	public Övning20(){
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		//NORTH
		JLabel label = new JLabel("Header Label");
		this.add(label, BorderLayout.NORTH);
		
		//CENTER
		CenterPanel centerPanel = new CenterPanel();		
		this.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Övning20();
	}

}
