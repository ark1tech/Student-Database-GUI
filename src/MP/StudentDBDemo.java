package MP;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class StudentDBDemo {

	private JFrame frame;
	private JTextField nameAddField;
	private JTextField saisAddField;
	private JTextField studNoAddField;
	private JTextField addressAddField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDBDemo window = new StudentDBDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentDBDemo() {
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
		mainTitlePage.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/mainTitlePage.png")));
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
		viewIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/eyeIcon.png")));
		viewIcon.setBounds(13, 66, 41, 44);
		menuPanel.add(viewIcon);

		JLabel homeIcon = new JLabel("");
		homeIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/homeIcon.png")));
		homeIcon.setHorizontalAlignment(SwingConstants.CENTER);
		homeIcon.setBounds(14, 339, 41, 44);
		menuPanel.add(homeIcon);

		JLabel searchIcon = new JLabel("");
		searchIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/viewIcon.png")));
		searchIcon.setHorizontalAlignment(SwingConstants.CENTER);
		searchIcon.setBounds(14, 285, 41, 44);
		menuPanel.add(searchIcon);

		JLabel editIcon = new JLabel("");
		editIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/editIcon.png")));
		editIcon.setHorizontalAlignment(SwingConstants.CENTER);
		editIcon.setBounds(14, 230, 41, 44);
		menuPanel.add(editIcon);

		JLabel deleteIcon = new JLabel("");
		deleteIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/deleteIcon.png")));
		deleteIcon.setHorizontalAlignment(SwingConstants.CENTER);
		deleteIcon.setBounds(15, 175, 41, 44);
		menuPanel.add(deleteIcon);

		JLabel addIcon = new JLabel("");
		addIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/addIcon.png")));
		addIcon.setHorizontalAlignment(SwingConstants.CENTER);
		addIcon.setBounds(14, 120, 41, 44);
		menuPanel.add(addIcon);

		CardLayout cl2 = new CardLayout(0, 0);

		JPanel displayPanel = new JPanel();
		//displayPanel.setBounds(195, 6, 716, 573);
		displayPanel.setPreferredSize(new Dimension(702, 573));
		displayPanel.setLayout(cl2);

		JPanel titleCard = new JPanel();
		displayPanel.add(titleCard, "title");
		titleCard.setLayout(null);

		JLabel displayTitlePage = new JLabel("");
		displayTitlePage.setBounds(0, 5, 716, 573);
		titleCard.add(displayTitlePage);
		displayTitlePage.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/displayPage.png")));

		JScrollPane scrollPane = new JScrollPane(displayPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(702, 575));
		scrollPane.setBounds(195, 6, 702, 575);
		bottomCard.add(scrollPane);

		JPanel viewCard = new JPanel();
		displayPanel.add(viewCard, "view");
		viewCard.setLayout(null);

		JPanel entryPanel_1 = new JPanel();
		entryPanel_1.setBackground(new Color(230, 230, 250));
		entryPanel_1.setBounds(6, 6, 672, 142);
		viewCard.add(entryPanel_1);
		entryPanel_1.setLayout(null);

		JLabel nameLabel_1 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_1.setBounds(31, 18, 455, 48);
		entryPanel_1.add(nameLabel_1);

		JLabel saisLabel_1 = new JLabel("SAIS ID:");
		saisLabel_1.setForeground(Color.DARK_GRAY);
		saisLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_1.setBounds(31, 69, 57, 24);
		entryPanel_1.add(saisLabel_1);

		JLabel studNoLabel_1 = new JLabel("STUDENT NUMBER:");
		studNoLabel_1.setForeground(Color.DARK_GRAY);
		studNoLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_1.setBounds(172, 69, 150, 24);
		entryPanel_1.add(studNoLabel_1);

		JLabel saisInfo_1 = new JLabel("235412");
		saisInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1.setBounds(97, 69, 63, 24);
		entryPanel_1.add(saisInfo_1);

		JLabel studNoInfo_1 = new JLabel("201054321");
		studNoInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_1.setBounds(326, 69, 105, 24);
		entryPanel_1.add(studNoInfo_1);

		JLabel addressLabel_1 = new JLabel("ADDRESS:");
		addressLabel_1.setForeground(Color.DARK_GRAY);
		addressLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_1.setBounds(31, 90, 91, 24);
		entryPanel_1.add(addressLabel_1);

		JLabel addressInfo_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_1.setBounds(117, 90, 345, 24);
		entryPanel_1.add(addressInfo_1);

		JPanel editCard = new JPanel();
		displayPanel.add(editCard, "edit");
		editCard.setLayout(null);

		JPanel viewCard_1_1 = new JPanel();
		viewCard_1_1.setBounds(0, 0, 702, 573);
		editCard.add(viewCard_1_1);
		viewCard_1_1.setLayout(null);

		JPanel editPanel = new JPanel();
		editPanel.setLayout(null);
		editPanel.setBackground(new Color(230, 230, 250));
		editPanel.setBounds(6, 6, 672, 142);
		viewCard_1_1.add(editPanel);

		JLabel nameEditLabel_1 = new JLabel("Raymund Klien B. Mañago");
		nameEditLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameEditLabel_1.setBounds(31, 18, 455, 48);
		editPanel.add(nameEditLabel_1);

		JLabel saisEditLabel_1 = new JLabel("SAIS ID:");
		saisEditLabel_1.setForeground(Color.DARK_GRAY);
		saisEditLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisEditLabel_1.setBounds(31, 69, 57, 24);
		editPanel.add(saisEditLabel_1);

		JLabel studNoEditLabel_1 = new JLabel("STUDENT NUMBER:");
		studNoEditLabel_1.setForeground(Color.DARK_GRAY);
		studNoEditLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoEditLabel_1.setBounds(172, 69, 150, 24);
		editPanel.add(studNoEditLabel_1);

		JLabel saisEditInfo_1 = new JLabel("235412");
		saisEditInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		saisEditInfo_1.setBounds(97, 69, 63, 24);
		editPanel.add(saisEditInfo_1);

		JLabel studNoEditInfo_1 = new JLabel("201054321");
		studNoEditInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoEditInfo_1.setBounds(326, 69, 105, 24);
		editPanel.add(studNoEditInfo_1);

		JLabel addressEditLabel_1 = new JLabel("ADDRESS:");
		addressEditLabel_1.setForeground(Color.DARK_GRAY);
		addressEditLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressEditLabel_1.setBounds(31, 90, 91, 24);
		editPanel.add(addressEditLabel_1);

		JLabel addressEditInfo_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressEditInfo_1.setFont(new Font("Arial", Font.PLAIN, 15));
		addressEditInfo_1.setBounds(117, 90, 345, 24);
		editPanel.add(addressEditInfo_1);

		JButton editBtn = new JButton("Edit");
		editBtn.setForeground(Color.BLACK);
		editBtn.setBounds(549, 107, 117, 29);
		editPanel.add(editBtn);

		JPanel addCard = new JPanel();
		displayPanel.add(addCard, "add");
		addCard.setLayout(null);

		JPanel addPanel = new JPanel();
		addPanel.setLayout(null);
		addPanel.setBackground(new Color(230, 230, 250));
		addPanel.setBounds(6, 6, 672, 207);
		addCard.add(addPanel);

		JLabel nameAddLabel = new JLabel("NAME:");
		nameAddLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameAddLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		nameAddLabel.setBounds(57, 49, 112, 24);
		addPanel.add(nameAddLabel);

		JLabel saisAddLabel = new JLabel("SAIS ID:");
		saisAddLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		saisAddLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		saisAddLabel.setBounds(57, 72, 112, 24);
		addPanel.add(saisAddLabel);

		JLabel studNoAddLabel = new JLabel("STUDENT NO.:");
		studNoAddLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		studNoAddLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoAddLabel.setBounds(57, 95, 112, 24);
		addPanel.add(studNoAddLabel);

		JLabel addressAddLabel = new JLabel("ADDRESS:");
		addressAddLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressAddLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		addressAddLabel.setBounds(57, 118, 112, 24);
		addPanel.add(addressAddLabel);

		nameAddField = new JTextField();
		nameAddField.setBounds(182, 48, 426, 26);
		nameAddField.setColumns(10);
		addPanel.add(nameAddField);

		saisAddField = new JTextField();
		saisAddField.setColumns(10);
		saisAddField.setBounds(182, 71, 426, 26);
		addPanel.add(saisAddField);

		studNoAddField = new JTextField();
		studNoAddField.setColumns(10);
		studNoAddField.setBounds(182, 94, 426, 26);
		addPanel.add(studNoAddField);

		addressAddField = new JTextField();
		addressAddField.setColumns(10);
		addressAddField.setBounds(182, 117, 426, 26);
		addPanel.add(addressAddField);

		JLabel addInstruc = new JLabel("Kindly enter the information below.");
		addInstruc.setForeground(Color.DARK_GRAY);
		addInstruc.setHorizontalAlignment(SwingConstants.LEFT);
		addInstruc.setFont(new Font("Arial", Font.PLAIN, 15));
		addInstruc.setBounds(17, 13, 230, 24);
		addPanel.add(addInstruc);

		JLabel addFailLabel = new JLabel("");
		addFailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addFailLabel.setForeground(Color.RED);
		addFailLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		addFailLabel.setBounds(184, 146, 118, 24);
		addPanel.add(addFailLabel);

		JLabel addSuccessLabel = new JLabel("");
		addSuccessLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addSuccessLabel.setForeground(new Color (0x8c52ff));
		addSuccessLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		addSuccessLabel.setBounds(205, 403, 302, 24);
		addCard.add(addSuccessLabel);

		JButton addEntryBtn = new JButton("Add");
		addEntryBtn.setBounds(549, 172, 117, 29);
		addEntryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isIncomplete = nameAddField.getText().isEmpty() || saisAddField.getText().isEmpty() || studNoAddField.getText().isEmpty() || addressAddField.getText().isEmpty();
				if (isIncomplete) {
					addFailLabel.setText("Incomplete entry!");
				}
				else {
					addFailLabel.setText("");
					addSuccessLabel.setText("Your entry has been successfully added.");
				}
			}
		});
		addPanel.add(addEntryBtn);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(420, 172, 117, 29);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameAddField.setText("");
				saisAddField.setText("");
				studNoAddField.setText("");
				addressAddField.setText("");
				addFailLabel.setText("");
				addSuccessLabel.setText("");
			}
		});
		addPanel.add(btnReset);

		JPanel previewPanel = new JPanel();
		previewPanel.setLayout(null);
		previewPanel.setBackground(new Color(230, 230, 250));
		previewPanel.setBounds(6, 219, 672, 172);
		addCard.add(previewPanel);

		JLabel nameLabel_Preview = new JLabel("Raymund Klien B. Mañago");
		nameLabel_Preview.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_Preview.setBounds(31, 41, 455, 48);
		previewPanel.add(nameLabel_Preview);

		JLabel saisLabel_Preview = new JLabel("SAIS ID:");
		saisLabel_Preview.setForeground(Color.DARK_GRAY);
		saisLabel_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_Preview.setBounds(31, 92, 74, 24);
		previewPanel.add(saisLabel_Preview);

		JLabel studNoLabel_Preview = new JLabel("STUDENT NUMBER:");
		studNoLabel_Preview.setForeground(Color.DARK_GRAY);
		studNoLabel_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_Preview.setBounds(172, 92, 150, 24);
		previewPanel.add(studNoLabel_Preview);

		JLabel saisInfo_Preview = new JLabel("235412");
		saisInfo_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_Preview.setBounds(97, 92, 63, 24);
		previewPanel.add(saisInfo_Preview);

		JLabel studNoInfo_Preview = new JLabel("201054321");
		studNoInfo_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_Preview.setBounds(326, 92, 105, 24);
		previewPanel.add(studNoInfo_Preview);

		JLabel addressLabel_Preview = new JLabel("ADDRESS:");
		addressLabel_Preview.setForeground(Color.DARK_GRAY);
		addressLabel_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_Preview.setBounds(31, 113, 91, 24);
		previewPanel.add(addressLabel_Preview);

		JLabel addressInfo_Preview = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_Preview.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_Preview.setBounds(117, 113, 345, 24);
		previewPanel.add(addressInfo_Preview);

		JLabel entryIconLabel_5 = new JLabel("");
		entryIconLabel_5.setBounds(538, 12, 118, 118);
		previewPanel.add(entryIconLabel_5);

		JLabel previewLabel = new JLabel("Preview");
		previewLabel.setForeground(Color.DARK_GRAY);
		previewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		previewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		previewLabel.setBounds(17, 12, 57, 24);
		previewPanel.add(previewLabel);

		JPanel deleteCard = new JPanel();
		displayPanel.add(deleteCard, "delete");
		deleteCard.setLayout(null);

		JPanel viewCard_1 = new JPanel();
		viewCard_1.setLayout(null);
		viewCard_1.setBounds(0, 0, 702, 573);
		deleteCard.add(viewCard_1);

		JPanel deletePanel = new JPanel();
		deletePanel.setLayout(null);
		deletePanel.setBackground(new Color(230, 230, 250));
		deletePanel.setBounds(6, 6, 672, 142);
		viewCard_1.add(deletePanel);

		JLabel nameDeleteLabel_1 = new JLabel("Raymund Klien B. Mañago");
		nameDeleteLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		nameDeleteLabel_1.setBounds(31, 18, 455, 48);
		deletePanel.add(nameDeleteLabel_1);

		JLabel saisLabel_1_2 = new JLabel("SAIS ID:");
		saisLabel_1_2.setForeground(Color.DARK_GRAY);
		saisLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_1_2.setBounds(31, 69, 57, 24);
		deletePanel.add(saisLabel_1_2);

		JLabel studNoLabel_1_2 = new JLabel("STUDENT NUMBER:");
		studNoLabel_1_2.setForeground(Color.DARK_GRAY);
		studNoLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_1_2.setBounds(172, 69, 150, 24);
		deletePanel.add(studNoLabel_1_2);

		JLabel saisInfo_1_3 = new JLabel("235412");
		saisInfo_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_3.setBounds(97, 69, 63, 24);
		deletePanel.add(saisInfo_1_3);

		JLabel studNoInfo_1_2 = new JLabel("201054321");
		studNoInfo_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_1_2.setBounds(326, 69, 105, 24);
		deletePanel.add(studNoInfo_1_2);

		JLabel addressLabel_1_2 = new JLabel("ADDRESS:");
		addressLabel_1_2.setForeground(Color.DARK_GRAY);
		addressLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_1_2.setBounds(31, 90, 91, 24);
		deletePanel.add(addressLabel_1_2);

		JLabel addressInfo_1_2 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_1_2.setBounds(117, 90, 345, 24);
		deletePanel.add(addressInfo_1_2);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(549, 107, 117, 29);
		deletePanel.add(btnNewButton_1);

		JPanel searchCard = new JPanel();
		displayPanel.add(searchCard, "search");
		searchCard.setLayout(null);

		JPanel entryPanel_1_3_2 = new JPanel();
		entryPanel_1_3_2.setLayout(null);
		entryPanel_1_3_2.setBackground(new Color(230, 230, 250));
		entryPanel_1_3_2.setBounds(6, 6, 672, 39);
		searchCard.add(entryPanel_1_3_2);

		textField_4 = new JTextField();
		textField_4.setBounds(6, 6, 535, 26);
		entryPanel_1_3_2.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(549, 6, 117, 29);
		entryPanel_1_3_2.add(btnNewButton_2);

		JPanel entryPanel_1_3_3 = new JPanel();
		entryPanel_1_3_3.setLayout(null);
		entryPanel_1_3_3.setBackground(new Color(230, 230, 250));
		entryPanel_1_3_3.setBounds(6, 51, 672, 142);
		searchCard.add(entryPanel_1_3_3);

		JLabel nameLabel_1_2_2 = new JLabel("Raymund Klien B. Mañago");
		nameLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 25));
		nameLabel_1_2_2.setBounds(31, 18, 455, 48);
		entryPanel_1_3_3.add(nameLabel_1_2_2);

		JLabel saisLabel_1_2_2 = new JLabel("SAIS ID:");
		saisLabel_1_2_2.setForeground(Color.DARK_GRAY);
		saisLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisLabel_1_2_2.setBounds(31, 69, 57, 24);
		entryPanel_1_3_3.add(saisLabel_1_2_2);

		JLabel studNoLabel_1_2_2 = new JLabel("STUDENT NUMBER:");
		studNoLabel_1_2_2.setForeground(Color.DARK_GRAY);
		studNoLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoLabel_1_2_2.setBounds(172, 69, 150, 24);
		entryPanel_1_3_3.add(studNoLabel_1_2_2);

		JLabel saisInfo_1_3_2 = new JLabel("235412");
		saisInfo_1_3_2.setFont(new Font("Arial", Font.PLAIN, 15));
		saisInfo_1_3_2.setBounds(97, 69, 63, 24);
		entryPanel_1_3_3.add(saisInfo_1_3_2);

		JLabel studNoInfo_1_2_2 = new JLabel("201054321");
		studNoInfo_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		studNoInfo_1_2_2.setBounds(326, 69, 105, 24);
		entryPanel_1_3_3.add(studNoInfo_1_2_2);

		JLabel addressLabel_1_2_2 = new JLabel("ADDRESS:");
		addressLabel_1_2_2.setForeground(Color.DARK_GRAY);
		addressLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressLabel_1_2_2.setBounds(31, 90, 91, 24);
		entryPanel_1_3_3.add(addressLabel_1_2_2);

		JLabel addressInfo_1_2_2 = new JLabel("Ili Sur, San Juan, 2514, La Union");
		addressInfo_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		addressInfo_1_2_2.setBounds(117, 90, 345, 24);
		entryPanel_1_3_3.add(addressInfo_1_2_2);

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
				viewIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/eyeIcon.png")));
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
				addIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/addIcon.png")));
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
				deleteIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/deleteIcon.png")));
				deleteButton.setOpaque(true);
			}
		});

		deleteButton.addActionListener(e -> cl2.show(displayPanel, "delete"));
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
				editIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/editIcon.png")));
				editButton.setOpaque(true);
			}
		});

		editButton.addActionListener(e -> cl2.show(displayPanel, "edit"));
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
				searchIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/viewIcon.png")));
				searchButton.setOpaque(true);
			}
		});

		searchButton.addActionListener(e -> cl2.show(displayPanel, "search"));
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
				homeIcon.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/homeIcon.png")));
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
}
