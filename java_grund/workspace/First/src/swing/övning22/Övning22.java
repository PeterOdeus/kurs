package swing.övning22;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import telefonbok.PhoneBook;


public class Övning22 extends JFrame {

	public Övning22(){
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addWindowStateListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
			}
		});
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
