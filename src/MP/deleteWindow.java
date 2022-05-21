package MP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class deleteWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteWindow window = new deleteWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 251, 133);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel confirmDeleteLabel = new JLabel("Are you sure?");
		confirmDeleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmDeleteLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		confirmDeleteLabel.setBounds(60, 19, 127, 22);
		frame.getContentPane().add(confirmDeleteLabel);
		
		JButton yesDeleteBtn = new JButton("Yes, delete!");
		yesDeleteBtn.setForeground(Color.RED);
		yesDeleteBtn.setBounds(117, 58, 117, 29);
		frame.getContentPane().add(yesDeleteBtn);
		
		JButton noDeleteBtn = new JButton("No");
		noDeleteBtn.setBounds(20, 58, 75, 29);
		frame.getContentPane().add(noDeleteBtn);
		frame.setVisible(true);
	}

}
