package swing.övning22;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import telefonbok.PhoneBook;


public class Övning22 extends JFrame {

	public Övning22(){
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		//NORTH
		JLabel label = new JLabel("Header Label");
		this.add(label, BorderLayout.NORTH);
		
		//CENTER
		PhoneBook phoneBook = new PhoneBook();
		PhoneBookController phoneBookController = new PhoneBookController(phoneBook);
		
		CenterPanel centerPanel = new CenterPanel(phoneBookController);		
		this.add(centerPanel, BorderLayout.CENTER);
		
		//SOUTH
		SouthPanel southPanel = new SouthPanel(phoneBookController);
		this.add(southPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Övning22();
	}

}
