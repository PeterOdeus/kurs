package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PhoneBookController;


public class NavigationPanel extends JPanel {
	
	private JTextField textField = null;
	private JButton button = null;
	private PhoneBookController _phoneBookController = null;
	
	public NavigationPanel(PhoneBookController phoneBookController){
		this._phoneBookController = phoneBookController;
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		textField = new JTextField("A TEXTFIELD");
		this.add(textField);
		
		button = new JButton("Go");
		this.add(button);
		
		setupEventHandling();
	}

	private void executeButtonLogic() {
		_phoneBookController.findItemByName(textField.getText());
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
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setText("whoaaa");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setText("Go");
			}
		});
	}
}
