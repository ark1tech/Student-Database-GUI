package MP;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class meowWindow {
	
	public JFrame meowFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new meowWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	meowWindow() {
		initialize();
	}
	
	private void initialize() {
		meowFrame = new JFrame();
		meowFrame.setBounds(100, 100, 450, 431);
		meowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		meowFrame.setAlwaysOnTop(true);
		meowFrame.setLocationRelativeTo(null);
		meowFrame.getContentPane().setLayout(null);
		meowFrame.setResizable(false);
		
		JPanel meowPanel = new JPanel();
		meowPanel.setBounds(0, 0, 450, 403);
		meowPanel.setBackground(new Color(230, 230, 250));
		
		meowFrame.getContentPane().add(meowPanel);
		meowPanel.setLayout(null);
		
		JLabel meowIcon = new JLabel("");
		meowIcon.setIcon(new ImageIcon(meowWindow.class.getResource("/MP/meowIcon.jpeg")));
		meowIcon.setBounds(94, 46, 250, 249);
		meowPanel.add(meowIcon);
		
		JLabel meowLabel = new JLabel("Meow! You found our easter egg. ");
		meowLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		meowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		meowLabel.setBounds(114, 302, 214, 16);
		meowPanel.add(meowLabel);
		
		JLabel meowLabel_2 = new JLabel("<html> <center> Here's a reminder that you're doing a great job. <br> <b> You should keep smiling! </html>");
		meowLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		meowLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		meowLabel_2.setBounds(51, 319, 334, 49);
		
		meowPanel.add(meowLabel_2);
		
		meowFrame.setVisible(true);
	}
}
