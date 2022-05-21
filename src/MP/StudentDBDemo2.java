package MP;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentDBDemo2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDBDemo2 window = new StudentDBDemo2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentDBDemo2() {
		initialize();
	}

	private void initialize() {

		CardLayout cl = new CardLayout(0, 0);

		frame = new JFrame();
		frame.setBounds(100, 100, 911, 607);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(cl);

		JPanel topCard = new JPanel(){
			protected void paintComponent(Graphics g) {
				Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 255),
						getWidth(), getHeight(), new Color(189, 175, 255, 255), true);
				Graphics2D g2d = (Graphics2D)g;
				g2d.setPaint(p);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		frame.getContentPane().add(topCard, "1");
		topCard.setLayout(null);

		JButton accessButton = new JButton("Access Student Database");
		accessButton.setForeground(Color.WHITE);
		accessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "2");
			}
		});
		accessButton.setOpaque(true);
		accessButton.setBorderPainted(false);
		accessButton.setBackground(new Color(0x8c52ff));
		accessButton.setBounds(325, 381, 270, 42);
		topCard.add(accessButton);

		JButton mainExitButton = new JButton("Shut Down");
		mainExitButton.setBounds(325, 430, 270, 29);
		mainExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mainExitButton.setOpaque(true);
		mainExitButton.setBorderPainted(false);
		mainExitButton.setBackground(Color.WHITE);
		topCard.add(mainExitButton);	

		JLabel mainTitlePage = new JLabel("");
		mainTitlePage.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/mainTitlePage.png")));
		mainTitlePage.setBounds(0, 0, 911, 579);
		topCard.add(mainTitlePage);

		JPanel bottomCard = new JPanel();
		frame.getContentPane().add(bottomCard, "2");
		bottomCard.setLayout(null);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0x8c52ff));
		bottomCard.add(menuPanel);

		JLabel viewIcon = new JLabel("");
		viewIcon.setHorizontalAlignment(SwingConstants.CENTER);
		viewIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/eyeIcon.png")));
		viewIcon.setBounds(13, 66, 41, 44);
		menuPanel.add(viewIcon);

		JLabel homeIcon = new JLabel("");
		homeIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/homeIcon.png")));
		homeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		homeIcon.setBounds(14, 339, 41, 44);
		menuPanel.add(homeIcon);

		JLabel searchIcon = new JLabel("");
		searchIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/viewIcon.png")));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		searchIcon.setBounds(14, 285, 41, 44);
		menuPanel.add(searchIcon);

		JLabel editIcon = new JLabel("");
		editIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/editIcon.png")));
		editIcon.setHorizontalAlignment(SwingConstants.CENTER);
		editIcon.setBounds(14, 230, 41, 44);
		menuPanel.add(editIcon);

		JLabel deleteIcon = new JLabel("");
		deleteIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/deleteIcon.png")));
		deleteIcon.setHorizontalAlignment(SwingConstants.CENTER);
		deleteIcon.setBounds(15, 175, 41, 44);
		menuPanel.add(deleteIcon);

		JLabel addIcon = new JLabel("");
		addIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/addIcon.png")));
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addIcon.setBounds(14, 120, 41, 44);
		menuPanel.add(addIcon);

		CardLayout cl2 = new CardLayout(0, 0);

		JPanel displayPanel = new JPanel();
		//displayPanel.setBounds(195, 6, 716, 573);
		displayPanel.setPreferredSize(new Dimension(702, 573));
		displayPanel.setLayout(cl2);

		JPanel titleCard = new JPanel();
		displayPanel.add(titleCard, "name_268308325509583");
		titleCard.setLayout(null);

		JLabel displayTitlePage = new JLabel("");
		displayTitlePage.setBounds(0, 5, 716, 573);
		titleCard.add(displayTitlePage);
		displayTitlePage.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/displayPage.png")));

		JPanel viewCard = new JPanel();
		displayPanel.add(viewCard, "view");
		viewCard.setLayout(null);

		newPanel(viewCard);
		
		JScrollPane scrollPane = new JScrollPane(displayPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(702, 575));
		scrollPane.setBounds(195, 6, 702, 575);
		bottomCard.add(scrollPane);

		JPanel addCard = new JPanel();
		displayPanel.add(addCard, "add");
		addCard.setLayout(null);

		JPanel entryPanel_1_1 = new JPanel();
		entryPanel_1_1.setLayout(null);
		entryPanel_1_1.setBackground(new Color(230, 230, 250));
		entryPanel_1_1.setBounds(6, 6, 672, 207);
		addCard.add(entryPanel_1_1);

		JLabel saisInfo_1_1 = new JLabel("NAME:");
		saisInfo_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		saisInfo_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1.setBounds(57, 49, 112, 24);
		entryPanel_1_1.add(saisInfo_1_1);

		textField = new JTextField();
		textField.setBounds(182, 48, 426, 26);
		entryPanel_1_1.add(textField);
		textField.setColumns(10);

		JLabel saisInfo_1_1_1 = new JLabel("SAIS ID:");
		saisInfo_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		saisInfo_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1.setBounds(57, 72, 112, 24);
		entryPanel_1_1.add(saisInfo_1_1_1);

		JLabel saisInfo_1_1_1_1 = new JLabel("STUDENT NO.:");
		saisInfo_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		saisInfo_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1.setBounds(57, 95, 112, 24);
		entryPanel_1_1.add(saisInfo_1_1_1_1);

		JLabel saisInfo_1_1_1_1_1 = new JLabel("ADDRESS:");
		saisInfo_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		saisInfo_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1_1.setBounds(57, 118, 112, 24);
		entryPanel_1_1.add(saisInfo_1_1_1_1_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(182, 71, 426, 26);
		entryPanel_1_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(182, 94, 426, 26);
		entryPanel_1_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(182, 117, 426, 26);
		entryPanel_1_1.add(textField_3);

		JLabel saisInfo_1_1_1_1_1_1 = new JLabel("Kindly enter the information below.");
		saisInfo_1_1_1_1_1_1.setForeground(Color.DARK_GRAY);
		saisInfo_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		saisInfo_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1_1_1.setBounds(17, 13, 230, 24);
		entryPanel_1_1.add(saisInfo_1_1_1_1_1_1);

		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(549, 172, 117, 29);
		entryPanel_1_1.add(btnNewButton);

		JLabel saisInfo_1_1_1_1_1_1_2 = new JLabel("Incomplete entry!");
		saisInfo_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		saisInfo_1_1_1_1_1_1_2.setForeground(Color.RED);
		saisInfo_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1_1_1_2.setBounds(184, 146, 118, 24);
		entryPanel_1_1.add(saisInfo_1_1_1_1_1_1_2);

		JPanel entryPanel_1_2 = new JPanel();
		entryPanel_1_2.setLayout(null);
		entryPanel_1_2.setBackground(new Color(230, 230, 250));
		entryPanel_1_2.setBounds(6, 219, 672, 172);
		addCard.add(entryPanel_1_2);

		JLabel previewIconLabel = new JLabel("");
		previewIconLabel.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/entryIcon.png")));
		previewIconLabel.setBounds(538, 31, 118, 118);
		entryPanel_1_2.add(previewIconLabel);

		JLabel nameLabel_1_1 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_1_1.setBounds(31, 41, 455, 48);
		entryPanel_1_2.add(nameLabel_1_1);

		JLabel saisLabel_1_1 = new JLabel("SAIS ID:");
		saisLabel_1_1.setForeground(Color.DARK_GRAY);
		saisLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_1_1.setBounds(31, 92, 57, 24);
		entryPanel_1_2.add(saisLabel_1_1);

		JLabel studNoLabel_1_1 = new JLabel("STUDENT NUMBER:");
		studNoLabel_1_1.setForeground(Color.DARK_GRAY);
		studNoLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_1_1.setBounds(172, 92, 150, 24);
		entryPanel_1_2.add(studNoLabel_1_1);

		JLabel saisInfo_1_2 = new JLabel("235412");
		saisInfo_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_2.setBounds(97, 92, 63, 24);
		entryPanel_1_2.add(saisInfo_1_2);

		JLabel studNoInfo_1_1 = new JLabel("201054321");
		studNoInfo_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_1_1.setBounds(326, 92, 105, 24);
		entryPanel_1_2.add(studNoInfo_1_1);

		JLabel addressLabel_1_1 = new JLabel("ADDRESS:");
		addressLabel_1_1.setForeground(Color.DARK_GRAY);
		addressLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_1_1.setBounds(31, 113, 91, 24);
		entryPanel_1_2.add(addressLabel_1_1);

		JLabel addressInfo_1_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_1_1.setBounds(117, 113, 345, 24);
		entryPanel_1_2.add(addressInfo_1_1);

		JLabel entryIconLabel_5 = new JLabel("");
		entryIconLabel_5.setBounds(538, 12, 118, 118);
		entryPanel_1_2.add(entryIconLabel_5);

		JLabel saisInfo_1_1_1_1_1_1_1 = new JLabel("Preview");
		saisInfo_1_1_1_1_1_1_1.setForeground(Color.DARK_GRAY);
		saisInfo_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		saisInfo_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1_1_1_1.setBounds(17, 12, 230, 24);
		entryPanel_1_2.add(saisInfo_1_1_1_1_1_1_1);
		
		JLabel saisInfo_1_1_1_1_1_1_2_1 = new JLabel("Your entry has been successfully added.");
		saisInfo_1_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		saisInfo_1_1_1_1_1_1_2_1.setForeground(new Color (0x8c52ff));
		saisInfo_1_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_1_1_1_1_1_2_1.setBounds(209, 403, 266, 24);
		addCard.add(saisInfo_1_1_1_1_1_1_2_1);

		JPanel deleteCard = new JPanel();
		displayPanel.add(deleteCard, "delete");
		deleteCard.setLayout(null);

		JPanel viewCard_1 = new JPanel();
		viewCard_1.setLayout(null);
		viewCard_1.setBounds(0, 0, 702, 573);
		deleteCard.add(viewCard_1);

		JPanel entryPanel_1_3 = new JPanel();
		entryPanel_1_3.setLayout(null);
		entryPanel_1_3.setBackground(new Color(230, 230, 250));
		entryPanel_1_3.setBounds(6, 6, 672, 142);
		viewCard_1.add(entryPanel_1_3);

		JLabel nameLabel_1_2 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_1_2.setBounds(31, 18, 455, 48);
		entryPanel_1_3.add(nameLabel_1_2);

		JLabel saisLabel_1_2 = new JLabel("SAIS ID:");
		saisLabel_1_2.setForeground(Color.DARK_GRAY);
		saisLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_1_2.setBounds(31, 69, 57, 24);
		entryPanel_1_3.add(saisLabel_1_2);

		JLabel studNoLabel_1_2 = new JLabel("STUDENT NUMBER:");
		studNoLabel_1_2.setForeground(Color.DARK_GRAY);
		studNoLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_1_2.setBounds(172, 69, 150, 24);
		entryPanel_1_3.add(studNoLabel_1_2);

		JLabel saisInfo_1_3 = new JLabel("235412");
		saisInfo_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_3.setBounds(97, 69, 63, 24);
		entryPanel_1_3.add(saisInfo_1_3);

		JLabel studNoInfo_1_2 = new JLabel("201054321");
		studNoInfo_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_1_2.setBounds(326, 69, 105, 24);
		entryPanel_1_3.add(studNoInfo_1_2);

		JLabel addressLabel_1_2 = new JLabel("ADDRESS:");
		addressLabel_1_2.setForeground(Color.DARK_GRAY);
		addressLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_1_2.setBounds(31, 90, 91, 24);
		entryPanel_1_3.add(addressLabel_1_2);

		JLabel addressInfo_1_2 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_1_2.setBounds(117, 90, 345, 24);
		entryPanel_1_3.add(addressInfo_1_2);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(549, 107, 117, 29);
		entryPanel_1_3.add(btnNewButton_1);

		JPanel entryPanel_2_1 = new JPanel();
		entryPanel_2_1.setLayout(null);
		entryPanel_2_1.setBackground(new Color(230, 230, 250));
		entryPanel_2_1.setBounds(6, 154, 672, 142);
		viewCard_1.add(entryPanel_2_1);

		JLabel nameLabel_2_1 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_2_1.setBounds(31, 18, 455, 48);
		entryPanel_2_1.add(nameLabel_2_1);

		JLabel saisLabel_2_1 = new JLabel("SAIS ID:");
		saisLabel_2_1.setForeground(Color.DARK_GRAY);
		saisLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_2_1.setBounds(31, 69, 57, 24);
		entryPanel_2_1.add(saisLabel_2_1);

		JLabel studNoLabel_2_1 = new JLabel("STUDENT NUMBER:");
		studNoLabel_2_1.setForeground(Color.DARK_GRAY);
		studNoLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_2_1.setBounds(172, 69, 150, 24);
		entryPanel_2_1.add(studNoLabel_2_1);

		JLabel saisInfo_2_1 = new JLabel("235412");
		saisInfo_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_2_1.setBounds(97, 69, 63, 24);
		entryPanel_2_1.add(saisInfo_2_1);

		JLabel studNoInfo_2_1 = new JLabel("201054321");
		studNoInfo_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_2_1.setBounds(326, 69, 105, 24);
		entryPanel_2_1.add(studNoInfo_2_1);

		JLabel addressLabel_2_1 = new JLabel("ADDRESS:");
		addressLabel_2_1.setForeground(Color.DARK_GRAY);
		addressLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_2_1.setBounds(31, 90, 91, 24);
		entryPanel_2_1.add(addressLabel_2_1);

		JLabel addressInfo_2_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_2_1.setBounds(117, 90, 345, 24);
		entryPanel_2_1.add(addressInfo_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setBounds(549, 107, 117, 29);
		entryPanel_2_1.add(btnNewButton_1_1);

		JPanel entryPanel_3_1 = new JPanel();
		entryPanel_3_1.setLayout(null);
		entryPanel_3_1.setBackground(new Color(230, 230, 250));
		entryPanel_3_1.setBounds(6, 300, 672, 142);
		viewCard_1.add(entryPanel_3_1);

		JLabel nameLabel_3_1 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_3_1.setBounds(31, 18, 455, 48);
		entryPanel_3_1.add(nameLabel_3_1);

		JLabel saisLabel_3_1 = new JLabel("SAIS ID:");
		saisLabel_3_1.setForeground(Color.DARK_GRAY);
		saisLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_3_1.setBounds(31, 69, 57, 24);
		entryPanel_3_1.add(saisLabel_3_1);

		JLabel studNoLabel_3_1 = new JLabel("STUDENT NUMBER:");
		studNoLabel_3_1.setForeground(Color.DARK_GRAY);
		studNoLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_3_1.setBounds(172, 69, 150, 24);
		entryPanel_3_1.add(studNoLabel_3_1);

		JLabel saisInfo_3_1 = new JLabel("235412");
		saisInfo_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_3_1.setBounds(97, 69, 63, 24);
		entryPanel_3_1.add(saisInfo_3_1);

		JLabel studNoInfo_3_1 = new JLabel("201054321");
		studNoInfo_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_3_1.setBounds(326, 69, 105, 24);
		entryPanel_3_1.add(studNoInfo_3_1);

		JLabel addressLabel_3_1 = new JLabel("ADDRESS:");
		addressLabel_3_1.setForeground(Color.DARK_GRAY);
		addressLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_3_1.setBounds(31, 90, 91, 24);
		entryPanel_3_1.add(addressLabel_3_1);

		JLabel addressInfo_3_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_3_1.setBounds(117, 90, 345, 24);
		entryPanel_3_1.add(addressInfo_3_1);
		
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.setForeground(Color.RED);
		btnNewButton_1_2.setBounds(549, 107, 117, 29);
		entryPanel_3_1.add(btnNewButton_1_2);

		JPanel entryPanel_4_1 = new JPanel();
		entryPanel_4_1.setLayout(null);
		entryPanel_4_1.setBackground(new Color(230, 230, 250));
		entryPanel_4_1.setBounds(6, 448, 672, 142);
		viewCard_1.add(entryPanel_4_1);
		
		JButton btnNewButton_1_2_1 = new JButton("Delete");
		btnNewButton_1_2_1.setForeground(Color.RED);
		btnNewButton_1_2_1.setBounds(549, 107, 117, 29);
		entryPanel_4_1.add(btnNewButton_1_2_1);

		JLabel nameLabel_4_1 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_4_1.setBounds(31, 18, 455, 48);
		entryPanel_4_1.add(nameLabel_4_1);

		JLabel saisLabel_4_1 = new JLabel("SAIS ID:");
		saisLabel_4_1.setForeground(Color.DARK_GRAY);
		saisLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_4_1.setBounds(31, 69, 57, 24);
		entryPanel_4_1.add(saisLabel_4_1);

		JLabel studNoLabel_4_1 = new JLabel("STUDENT NUMBER:");
		studNoLabel_4_1.setForeground(Color.DARK_GRAY);
		studNoLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_4_1.setBounds(172, 69, 150, 24);
		entryPanel_4_1.add(studNoLabel_4_1);

		JLabel saisInfo_4_1 = new JLabel("235412");
		saisInfo_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_4_1.setBounds(97, 69, 63, 24);
		entryPanel_4_1.add(saisInfo_4_1);

		JLabel studNoInfo_4_1 = new JLabel("201054321");
		studNoInfo_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_4_1.setBounds(326, 69, 105, 24);
		entryPanel_4_1.add(studNoInfo_4_1);

		JLabel addressLabel_4_1 = new JLabel("ADDRESS:");
		addressLabel_4_1.setForeground(Color.DARK_GRAY);
		addressLabel_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_4_1.setBounds(31, 90, 91, 24);
		entryPanel_4_1.add(addressLabel_4_1);

		JLabel addressInfo_4_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_4_1.setBounds(117, 90, 345, 24);
		entryPanel_4_1.add(addressInfo_4_1);

		JPanel editCard = new JPanel();
		displayPanel.add(editCard, "edit");
		editCard.setLayout(null);

		JPanel searchCard = new JPanel();
		displayPanel.add(searchCard, "search");
		searchCard.setLayout(null);

		JButton addButton = new JButton("          Add an Entry");
		JButton viewButton = new JButton("          View All Entries");
		JButton deleteButton = new JButton("          Delete an Entries");
		JButton editButton = new JButton("          Edit an Entry");
		JButton searchButton = new JButton("          Search an Entry");
		JButton exitButton = new JButton("          Back to Homepage");

		viewButton.setOpaque(true);
		viewButton.setBackground(new Color(0x8c52ff));
		viewButton.setHorizontalAlignment(SwingConstants.LEFT);
		viewButton.setBounds(-2, 60, 200, 58);
		viewButton.setPreferredSize(new Dimension (200, 50));
		viewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		viewButton.setForeground(Color.WHITE);
		viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		viewButton.setBorderPainted(false);
		viewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				addButton.setBackground(new Color(0x8c52ff));
				deleteButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				exitButton.setBackground(new Color(0x8c52ff));
				viewIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/eyeIcon.png")));
				viewIcon.setBounds(13, 66, 41, 44);
				menuPanel.add(viewIcon);
				viewButton.setOpaque(true);
			}
		});

		viewButton.addActionListener(e -> cl2.show(displayPanel, "view"));

		JLabel menuLabel = new JLabel("<html> <b> Menu </b> </html>");
		menuLabel.setBounds(8, 5, 180, 50);
		menuLabel.setForeground(Color.WHITE);
		menuPanel.setBounds(0, 6, 196, 573);
		menuPanel.setLayout(null);
		menuLabel.setPreferredSize(new Dimension (180, 50));
		menuLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		menuLabel.setHorizontalAlignment(SwingConstants.CENTER);
		menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuPanel.add(menuLabel);
		menuPanel.add(viewButton);


		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addButton.setBackground(new Color(0x6827e8));
				viewButton.setBackground(new Color(0x8c52ff));
				deleteButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				exitButton.setBackground(new Color(0x8c52ff));
				addIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/addIcon.png")));
				addButton.setOpaque(true);
			}
		});
		addButton.addActionListener(e -> cl2.show(displayPanel, "add"));
		addButton.setHorizontalAlignment(SwingConstants.LEFT);
		addButton.setBounds(-2, 115, 200, 58);
		addButton.setBorderPainted(false);
		addButton.setPreferredSize(new Dimension(200, 60));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Arial", Font.PLAIN, 13));
		addButton.setAlignmentX(0.5f);
		menuPanel.add(addButton);

		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteButton.setBackground(new Color(0x6827e8));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				exitButton.setBackground(new Color(0x8c52ff));
				deleteIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/deleteIcon.png")));
				deleteButton.setOpaque(true);
			}

		});
		deleteButton.setHorizontalAlignment(SwingConstants.LEFT);
		deleteButton.setBorderPainted(false);
		deleteButton.setBounds(-2, 170, 200, 58);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setPreferredSize(new Dimension(200, 60)); 
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		deleteButton.setAlignmentX(0.5f); 
		menuPanel.add(deleteButton); 

		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x6827e8));
				searchButton.setBackground(new Color(0x8c52ff));
				exitButton.setBackground(new Color(0x8c52ff));
				editIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/editIcon.png")));
				editButton.setOpaque(true);
			}
		});
		editButton.setHorizontalAlignment(SwingConstants.LEFT);
		editButton.setBorderPainted(false);
		editButton.setForeground(Color.WHITE);
		editButton.setBounds(-2, 225, 200, 58);
		editButton.setPreferredSize(new Dimension(200, 50)); 
		editButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		editButton.setAlignmentX(0.5f); 
		menuPanel.add(editButton); 

		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x6827e8));
				exitButton.setBackground(new Color(0x8c52ff));
				searchIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/viewIcon.png")));
				searchButton.setOpaque(true);
			}
		});
		searchButton.setHorizontalAlignment(SwingConstants.LEFT);
		searchButton.setBorderPainted(false);
		searchButton.setBounds(-2, 280, 200, 58);
		searchButton.setForeground(Color.WHITE);
		searchButton.setPreferredSize(new Dimension(200, 60));  
		searchButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		searchButton.setAlignmentX(0.5f);
		menuPanel.add(searchButton);

		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				exitButton.setBackground(new Color(0x6827e8));
				homeIcon.setIcon(new ImageIcon(StudentDBDemo2.class.getResource("/MP/homeIcon.png")));
				exitButton.setOpaque(true);
				cl.show(frame.getContentPane(), "1");
			}
		});
		exitButton.setHorizontalAlignment(SwingConstants.LEFT);
		exitButton.setBorderPainted(false);
		exitButton.setForeground(Color.WHITE);
		exitButton.setBounds(-2, 335, 200, 58);
		exitButton.setPreferredSize(new Dimension(200, 58));
		exitButton.setFont(new Font("Arial", Font.PLAIN, 13));
		exitButton.setAlignmentX(0.5f);
		menuPanel.add(exitButton);

		frame.setResizable(false);
	}
	
private void newPanel(JPanel viewCard) {
		Dimension dim = new Dimension(672, 142);
		for (int i = 0; i < 4; i++) {
			JPanel entryPanel = new JPanel();
			entryPanel.setBackground(new Color(230, 230, 250));
			entryPanel.setBounds(6, 6 + 148 * i, 672, 142);
			entryPanel.setPreferredSize(dim);
			viewCard.add(entryPanel);
			entryPanel.setLayout(null);

			JLabel nameLabel = new JLabel("Raymund Klien B. Mañago");
			nameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
			nameLabel.setBounds(31, 18, 455, 48);
			entryPanel.add(nameLabel);

			JLabel saisLabel = new JLabel("SAIS ID:");
			saisLabel.setForeground(Color.DARK_GRAY);
			saisLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			saisLabel.setBounds(31, 69, 57, 24);
			entryPanel.add(saisLabel);

			JLabel studNoLabel = new JLabel("STUDENT NUMBER:");
			studNoLabel.setForeground(Color.DARK_GRAY);
			studNoLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			studNoLabel.setBounds(172, 69, 150, 24);
			entryPanel.add(studNoLabel);

			JLabel saisInfo = new JLabel("235412");
			saisInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			saisInfo.setBounds(97, 69, 63, 24);
			entryPanel.add(saisInfo);

			JLabel studNoInfo = new JLabel("201054321");
			studNoInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			studNoInfo.setBounds(326, 69, 105, 24);
			entryPanel.add(studNoInfo);

			JLabel addressLabel = new JLabel("ADDRESS:");
			addressLabel.setForeground(Color.DARK_GRAY);
			addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			addressLabel.setBounds(31, 90, 91, 24);
			entryPanel.add(addressLabel);

			JLabel addressInfo = new JLabel("Ili Sur, San Juan, 2514, La Union");
			addressInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			addressInfo.setBounds(117, 90, 345, 24);
			entryPanel.add(addressInfo);
			
			//viewCard.revalidate();
			//viewCard.repaint();
		}
}
	
}	

