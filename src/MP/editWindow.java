package MP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

public class editWindow {

	private JFrame frame;
	private JTextField editWindowField;
	private JLabel lblNewLabel;
	private JButton cancelEditBtn;
	private JButton saveEditBtn;
	private JLabel entryEditLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editWindow window = new editWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public editWindow() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Student Number", "SAIS ID", "Address"}));
		comboBox.setBounds(36, 35, 246, 27);
		frame.getContentPane().add(comboBox);
		
		editWindowField = new JTextField();
		editWindowField.setBounds(80, 69, 202, 26);
		frame.getContentPane().add(editWindowField);
		editWindowField.setColumns(10);
		
		lblNewLabel = new JLabel("Incomplete entry!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 143, 161, 16);
		frame.getContentPane().add(lblNewLabel);
		
		cancelEditBtn = new JButton("Cancel");
		cancelEditBtn.setFont(new Font("Arial", Font.PLAIN, 13));
		cancelEditBtn.setBounds(46, 104, 104, 27);
		frame.getContentPane().add(cancelEditBtn);
		
		saveEditBtn = new JButton("Save");
		saveEditBtn.setBounds(162, 104, 104, 27);
		frame.getContentPane().add(saveEditBtn);
		
		entryEditLabel = new JLabel("Entry:");
		entryEditLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		entryEditLabel.setBounds(36, 74, 61, 16);
		frame.getContentPane().add(entryEditLabel);
	}
}
