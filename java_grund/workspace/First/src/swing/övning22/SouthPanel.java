package swing.övning22;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import telefonbok.Contact;
import telefonbok.PhoneNumber;

public class SouthPanel extends JPanel{

	private JTextField nameField = null;
	private JTextField phoneNumberField = null;
	private JButton button = null;
	private PhoneBookController phoneBookController = null;
	
	public SouthPanel(PhoneBookController phoneBookController) {
		this.phoneBookController = phoneBookController;
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
		nameField = new JTextField("");
		this.add(nameField);
		
		phoneNumberField = new JTextField("");
		this.add(phoneNumberField);
		
		button = new JButton("Go");
		this.add(button);
		
		setupEventHandling();
	}

	private void executeButtonLogic() {
		PhoneNumber phoneNumber = new PhoneNumber(phoneNumberField.getText());
		Contact contact = new Contact(nameField.getText(), phoneNumber);
		this.phoneBookController.insertContact(contact);
	}
	
	private void setupEventHandling() {
		button.addKeyListener(new KeyAdapter(){
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == '\n'){
					executeButtonLogic();
				}
			}						
		});
		button.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				executeButtonLogic();
			}
		});
	}

}
