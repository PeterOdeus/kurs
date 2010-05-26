package swing.övning22;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import telefonbok.PhoneBook;

public class CenterPanel extends JPanel implements SearchResultHandler {
	
	private JTextArea phoneBookItems = null;
		
	public CenterPanel(PhoneBookController phoneBookController) {
		
		phoneBookController.addSearchResultHandler(this);
		
		setLayout(new BorderLayout());
		NavigationPanel navigationPanel = new NavigationPanel(phoneBookController);
		this.add(navigationPanel, BorderLayout.NORTH);
		
		phoneBookItems = new JTextArea();
		this.add(phoneBookItems, BorderLayout.CENTER);		
	}

	@Override
	public void handleSearchResults(List<String> resultStrings) {
		for(String s : resultStrings){
			phoneBookItems.append(s);
		}
	}
}
