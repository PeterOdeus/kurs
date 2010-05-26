package swing;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class CenterPanel extends JPanel {
	public CenterPanel() {
		setLayout(new BorderLayout());
		NavigationPanel navigationPanel = new NavigationPanel();
		this.add(navigationPanel, BorderLayout.NORTH);
	}
}
