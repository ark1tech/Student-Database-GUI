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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class StudentDBDemo {

	private JPanel deleteCard;
	private JPanel editCard;
	private JButton editEntryBtn;
	private JButton deleteEntryBtn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new StudentDBDemo();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public StudentDBDemo() throws FileNotFoundException {
		mainGUI();
	}
	
	// ---------------- Main Window GUI ---------------- //

	private void mainGUI() throws FileNotFoundException {

		CardLayout cl = new CardLayout(0, 0);

		JFrame mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 911, 607);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.getContentPane().setLayout(cl);

		JPanel topCard = new JPanel(){
			protected void paintComponent(Graphics g) {
				Paint p = new GradientPaint(0.0f, 0.0f, new Color(255, 255, 255, 255),
						getWidth(), getHeight(), new Color(189, 175, 255, 255), true);
				Graphics2D g2d = (Graphics2D)g;
				g2d.setPaint(p);
				g2d.fillRect(0, 0, getWidth(), getHeight());
			}
		};
		mainFrame.getContentPane().add(topCard, "1");
		topCard.setLayout(null);
		
		JPanel bottomCard = new JPanel();
		mainFrame.getContentPane().add(bottomCard, "2");
		bottomCard.setLayout(null);

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

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0x8c52ff));
		bottomCard.add(menuPanel);

		CardLayout cl2 = new CardLayout(0, 0);

		JPanel displayPanel = new JPanel();
		//displayPanel.setBounds(195, 6, 716, 573);
		displayPanel.setPreferredSize(new Dimension(702, 1540));
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
		
		JButton accessButton = new JButton("Access Student Database");
		accessButton.setForeground(Color.WHITE);
		accessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				cl.show(mainFrame.getContentPane(), "2");
				cl2.show(displayPanel, "title");
			}
		});
		accessButton.setOpaque(true);
		accessButton.setBorderPainted(false);
		accessButton.setBackground(new Color(0x8c52ff));
		accessButton.setBounds(325, 381, 270, 42);
		topCard.add(accessButton);
		
		JPanel viewCard = new JPanel();
		displayPanel.add(viewCard, "view");
		viewCard.setLayout(null);

		editCard = new JPanel();
		displayPanel.add(editCard, "edit");
		editCard.setLayout(null);
		
		deleteCard = new JPanel();
		displayPanel.add(deleteCard, "delete");
		deleteCard.setLayout(null);

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

		JTextField nameAddField = new JTextField();
		nameAddField.setBounds(182, 48, 426, 26);
		nameAddField.setColumns(10);
		addPanel.add(nameAddField);

		JTextField saisAddField = new JTextField();
		saisAddField.setColumns(10);
		saisAddField.setBounds(182, 71, 426, 26);
		addPanel.add(saisAddField);

		JTextField studNoAddField = new JTextField();
		studNoAddField.setColumns(10);
		studNoAddField.setBounds(182, 94, 426, 26);
		addPanel.add(studNoAddField);

		JTextField addressAddField = new JTextField();
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
		addFailLabel.setBounds(184, 146, 424, 24);
		addPanel.add(addFailLabel);

		JLabel addSuccessLabel = new JLabel("");
		addSuccessLabel.setHorizontalAlignment(SwingConstants.LEFT);
		addSuccessLabel.setForeground(new Color (0x8c52ff));
		addSuccessLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		addSuccessLabel.setBounds(205, 403, 302, 24);
		addCard.add(addSuccessLabel);
		
		JPanel previewPanel = new JPanel();
		previewPanel.setBackground(new Color(230, 230, 250));
		previewPanel.setBounds(6, 219, 672, 172);
		previewPanel.setLayout(null);
		addCard.add(previewPanel);
		
 		JLabel previewLabel = new JLabel("Preview");
		previewLabel.setForeground(Color.DARK_GRAY);
		previewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		previewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		previewLabel.setBounds(17, 12, 57, 24);
		previewPanel.add(previewLabel);
		
		JLabel saisPreviewLabel = new JLabel("SAIS ID:");
		saisPreviewLabel.setForeground(Color.DARK_GRAY);
		saisPreviewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		saisPreviewLabel.setBounds(27, 101, 57, 24);
		previewPanel.add(saisPreviewLabel);

		JLabel studNumPreviewLabel = new JLabel("STUDENT NUMBER:");
		studNumPreviewLabel.setForeground(Color.DARK_GRAY);
		studNumPreviewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		studNumPreviewLabel.setBounds(168, 101, 150, 24);
		previewPanel.add(studNumPreviewLabel);
		
		JLabel addressPreviewLabel = new JLabel("ADDRESS:");
		addressPreviewLabel.setForeground(Color.DARK_GRAY);
		addressPreviewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		addressPreviewLabel.setBounds(27, 122, 91, 24);
		previewPanel.add(addressPreviewLabel);
		
		JLabel namePreviewInfo = new JLabel();
		namePreviewInfo.setFont(new Font("Arial", Font.PLAIN, 25));
		namePreviewInfo.setBounds(27, 50, 455, 48);
		previewPanel.add(namePreviewInfo);
		
		JLabel saisPreviewInfo = new JLabel();
		saisPreviewInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		saisPreviewInfo.setBounds(93, 101, 63, 24);
		previewPanel.add(saisPreviewInfo);
		
		JLabel studNumPreviewInfo = new JLabel();
		studNumPreviewInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		studNumPreviewInfo.setBounds(322, 101, 105, 24);
		previewPanel.add(studNumPreviewInfo);

		JLabel addressPreviewInfo = new JLabel();
		addressPreviewInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		addressPreviewInfo.setBounds(113, 122, 345, 24);
		previewPanel.add(addressPreviewInfo);

		JButton addEntryBtn = new JButton("Add");
		addEntryBtn.setBounds(549, 172, 117, 29);
		addEntryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Running a series of boolean to handle user input errors
				
				boolean isIncomplete = nameAddField.getText().isEmpty() || saisAddField.getText().isEmpty() || studNoAddField.getText().isEmpty() || addressAddField.getText().isEmpty();
				boolean isWhiteSpace = nameAddField.getText().trim().length() == 0 || saisAddField.getText().trim().length() == 0 || studNoAddField.getText().trim().length() == 0 || addressAddField.getText().trim().length() == 0;
				boolean isDigit = saisAddField.getText().matches("[0-9]+") && studNoAddField.getText().matches("[0-9]+");
				boolean isProperLength = saisAddField.getText().length() < 10 && studNoAddField.getText().length() < 10;
				
				if (isIncomplete) {
					addFailLabel.setText("Incomplete entry!");
					addSuccessLabel.setText("");
				}
				else if (isWhiteSpace) {
					addFailLabel.setText("Entry can't be spaces!");
					addSuccessLabel.setText("");
				}
				else if (!isProperLength) {
					addFailLabel.setText("SAIS ID and Student Number must not exceed 9 digits.");
					addSuccessLabel.setText("");
				}
				else if (!isDigit) {
					addFailLabel.setText("SAIS ID and Student Number must be numbers!");
					addSuccessLabel.setText("");
				}
				else {
					addFailLabel.setText("");
					namePreviewInfo.setText(nameAddField.getText());
					saisPreviewInfo.setText(saisAddField.getText());
					studNumPreviewInfo.setText(studNoAddField.getText());
					addressPreviewInfo.setText(addressAddField.getText());
					try {
						StudentData [] students = StudentDB.read();
						boolean boolChecker = true;
						for (StudentData student : students) {
							boolean isIdentical = nameAddField.getText().equals(student.name) && Integer.parseInt(saisAddField.getText()) == student.SAISID;
							if (isIdentical) boolChecker = false;		
						}
						if (boolChecker) {
							StudentData dbd = new StudentData(nameAddField.getText(), Integer.parseInt(saisAddField.getText()), Integer.parseInt(studNoAddField.getText()), addressAddField.getText());
							if (dbd.fileCount < 11){
								if (new StudentDB().addData(dbd)) {
									addSuccessLabel.setText("Your entry has been successfully added.");
									addFailLabel.setText("");
								}
							}
							else {
								addFailLabel.setText("Maximum number of entries reached.");
								addSuccessLabel.setText("");
								namePreviewInfo.setText("");
								saisPreviewInfo.setText("");
								studNumPreviewInfo.setText("");
								addressPreviewInfo.setText("");
							}
							
						}
						else {
							addFailLabel.setText("Entry with same name and ID already exists.");
							addSuccessLabel.setText("");
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
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
				namePreviewInfo.setText("");
				saisPreviewInfo.setText("");
				studNumPreviewInfo.setText("");
				addressPreviewInfo.setText("");
			}
		});
		addPanel.add(btnReset);

		JPanel searchCard = new JPanel();
		displayPanel.add(searchCard, "search");
		searchCard.setLayout(null);

		JPanel searchEntryPanel = new JPanel();
		searchEntryPanel.setLayout(null);
		searchEntryPanel.setBackground(new Color(230, 230, 250));
		searchEntryPanel.setBounds(6, 6, 672, 39);
		searchCard.add(searchEntryPanel);

		JTextField searchTextField = new JTextField();
		searchTextField.setBounds(6, 6, 535, 26);
		searchEntryPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBounds(0, 51, 702, 1540);
		searchCard.add(searchPanel);

		JButton searchEntryBtn = new JButton("Search");
		searchEntryBtn.setBounds(549, 6, 117, 29);
		searchEntryBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (searchTextField.getText().isEmpty()) {
					searchPanel.removeAll();
					searchPanel.repaint();
				}
				else {
					searchPanel.removeAll();
					
					StudentData [] students = new StudentDB().searchData(searchTextField.getText());
					int studentCount = 1;

					for (StudentData student : students) {

						JPanel entryPanel = new JPanel();
						entryPanel.setBackground(new Color(230, 230, 250));
						entryPanel.setBounds(6, 6 + 148 * (studentCount - 1), 672, 142);
						entryPanel.setPreferredSize(new Dimension(672, 142));
						entryPanel.setLayout(null);
						searchPanel.add(entryPanel); studentCount++;

						JLabel nameLabel = new JLabel(student.name);
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

						JLabel saisInfo = new JLabel(Integer.toString(student.SAISID));
						saisInfo.setFont(new Font("Arial", Font.PLAIN, 15));
						saisInfo.setBounds(97, 69, 63, 24);
						entryPanel.add(saisInfo);

						JLabel studNoInfo = new JLabel(Integer.toString(student.num));
						studNoInfo.setFont(new Font("Arial", Font.PLAIN, 15));
						studNoInfo.setBounds(326, 69, 105, 24);
						entryPanel.add(studNoInfo);

						JLabel addressLabel = new JLabel("ADDRESS:");
						addressLabel.setForeground(Color.DARK_GRAY);
						addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
						addressLabel.setBounds(31, 90, 91, 24);
						entryPanel.add(addressLabel);

						JLabel addressInfo = new JLabel(student.address);
						addressInfo.setFont(new Font("Arial", Font.PLAIN, 15));
						addressInfo.setBounds(117, 90, 345, 24);
						entryPanel.add(addressInfo);

					}
			        
			        searchPanel.repaint();
				}
			}
		});
		searchEntryPanel.add(searchEntryBtn);

		JButton viewButton = new JButton("View All Entries");
		JButton addButton = new JButton("Add an Entry");
		JButton deleteButton = new JButton("Delete an Entry");
		JButton editButton = new JButton("Edit an Entry");
		JButton searchButton = new JButton("Search an Entry");
		JButton homeButton = new JButton("Home");

		viewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				addButton.setBackground(new Color(0x8c52ff));
				deleteButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				homeButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x6827e8));
				cl2.show(displayPanel, "view");
				try {
					createPanel(viewCard, 1, mainFrame);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		viewButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/eyeIcon2.png")));
		viewButton.setHorizontalAlignment(SwingConstants.LEFT);
		viewButton.setIconTextGap(25);
		
		viewButton.setOpaque(true);
		viewButton.setBackground(new Color(0x8c52ff));
		viewButton.setBounds(-2, 60, 200, 58);
		viewButton.setPreferredSize(new Dimension (200, 50));
		viewButton.setFont(new Font("Arial", Font.PLAIN, 13));
		viewButton.setForeground(Color.WHITE);
		viewButton.setBorderPainted(false);

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
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				addButton.setBackground(new Color(0x6827e8));
				viewButton.setBackground(new Color(0x8c52ff));
				deleteButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				homeButton.setBackground(new Color(0x8c52ff));
				cl2.show(displayPanel, "add");
			}
		});
		
		addButton.setIconTextGap(25);
		addButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/addIcon2.png")));
		addButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		addButton.setBounds(-2, 118, 200, 58);
		addButton.setBorderPainted(false);
		addButton.setPreferredSize(new Dimension(200, 60));
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Arial", Font.PLAIN, 13));
		menuPanel.add(addButton);

		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				deleteButton.setBackground(new Color(0x6827e8));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				homeButton.setBackground(new Color(0x8c52ff));
				cl2.show(displayPanel, "delete");
				try {
					createPanel(deleteCard, 2, mainFrame);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		deleteButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/deleteIcon2.png")));
		deleteButton.setIconTextGap(25);
		deleteButton.setHorizontalAlignment(SwingConstants.LEFT);
		
		deleteButton.setBorderPainted(false);
		deleteButton.setBounds(-2, 176, 200, 58);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setPreferredSize(new Dimension(200, 60)); 
		deleteButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		menuPanel.add(deleteButton); 

		editButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x6827e8));
				searchButton.setBackground(new Color(0x8c52ff));
				homeButton.setBackground(new Color(0x8c52ff));
				cl2.show(displayPanel, "edit");
				try {
					createPanel(editCard, 3, mainFrame);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		editButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/editIcon2.png")));
		editButton.setHorizontalAlignment(SwingConstants.LEFT);
		editButton.setIconTextGap(25);
		
		editButton.setBorderPainted(false);
		editButton.setForeground(Color.WHITE);
		editButton.setBounds(-2, 236, 200, 58);
		editButton.setPreferredSize(new Dimension(200, 50)); 
		editButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		menuPanel.add(editButton); 

		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x6827e8));
				homeButton.setBackground(new Color(0x8c52ff));
				cl2.show(displayPanel, "search");
			}
		});

		searchButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/viewIcon2.png")));
		searchButton.setHorizontalAlignment(SwingConstants.LEFT);
		searchButton.setIconTextGap(25);

		searchButton.setBorderPainted(false);
		searchButton.setBounds(-2, 295, 200, 58);
		searchButton.setForeground(Color.WHITE);
		searchButton.setPreferredSize(new Dimension(200, 60));  
		searchButton.setFont(new Font("Arial", Font.PLAIN, 13)); 
		menuPanel.add(searchButton);

		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scrollPane.getViewport().setViewPosition(new Point(0,0));
				deleteButton.setBackground(new Color(0x8c52ff));
				addButton.setBackground(new Color(0x8c52ff));
				viewButton.setBackground(new Color(0x8c52ff));
				editButton.setBackground(new Color(0x8c52ff));
				searchButton.setBackground(new Color(0x8c52ff));
				homeButton.setBackground(new Color(0x6827e8));
				cl.show(mainFrame.getContentPane(), "1");
			}
		});
		
		homeButton.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/homeIcon2.png")));
		homeButton.setHorizontalAlignment(SwingConstants.LEFT);
		homeButton.setIconTextGap(25);
		homeButton.setBorderPainted(false);
		homeButton.setForeground(Color.WHITE);
		homeButton.setBounds(-2, 353, 200, 58);
		homeButton.setPreferredSize(new Dimension(200, 58));
		homeButton.setFont(new Font("Arial", Font.PLAIN, 13));
		menuPanel.add(homeButton);

		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
	}
	
	// ---------------- Edit Window GUI ---------------- //
	
	private class openEditWindow{
		openEditWindow(String name, int SAISID, JFrame mainFrame) {
			JFrame editFrame = new JFrame();
			editFrame.setBounds(100, 100, 320, 226);
			editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			editFrame.setLocationRelativeTo(null);
			editFrame.setResizable(false);
			editFrame.setAlwaysOnTop(true);
			editFrame.getContentPane().setLayout(null);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "SAIS ID", "Student Number", "Address"}));
			comboBox.setBounds(36, 35, 246, 27);
			editFrame.getContentPane().add(comboBox);
			
			JTextField editWindowField = new JTextField();
			editWindowField.setBounds(80, 69, 202, 26);
			editWindowField.setColumns(10);
			editFrame.getContentPane().add(editWindowField);
			
			JButton cancelEditBtn = new JButton("Cancel");
			cancelEditBtn.setBounds(46, 104, 104, 27);
			cancelEditBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					editFrame.dispose();
					mainFrame.setEnabled(true);
				}
			});
			editFrame.getContentPane().add(cancelEditBtn);
			
			JLabel entryEditLabel = new JLabel("Entry:");
			entryEditLabel.setFont(new Font("Arial", Font.PLAIN, 13));
			entryEditLabel.setBounds(36, 74, 61, 16);
			editFrame.getContentPane().add(entryEditLabel);
			
			JLabel incompleteLabel = new JLabel("");
			incompleteLabel.setForeground(Color.RED);
			incompleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
			incompleteLabel.setBounds(79, 143, 161, 16);
			editFrame.getContentPane().add(incompleteLabel);
			
			JButton saveEditBtn  = new JButton("Save");
			saveEditBtn.setBounds(162, 104, 104, 27);
			saveEditBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean isIncomplete = editWindowField.getText().isBlank();
					boolean isDigit = editWindowField.getText().matches("[0-9]+");
					
						if(isIncomplete){
							incompleteLabel.setText("Incomplete Entry!");
						}
						else if ((comboBox.getSelectedIndex() == 1 || comboBox.getSelectedIndex() == 2) && !isDigit) {
							incompleteLabel.setText("Entry should be a number!");
						}
						else {
							try {
								
								// Using GUI ComboBox to determine which information the user wants to edit
								
								Scanner sc = new Scanner(new File(name + " " + SAISID + ".txt"));
								String name = sc.nextLine();
								String id = sc.nextLine();
								String num = sc.nextLine();
								String address = sc.nextLine();
								sc.close();
								
								switch(comboBox.getSelectedIndex() + 1) {
									case 1:
										new File(name + " " + id + ".txt").delete();
										name = editWindowField.getText();
										break;
									case 2:
										new File(name + " " + id + ".txt").delete();
										id = editWindowField.getText();
										break;
									case 3:
										num = editWindowField.getText();
										break;
									case 4:
										address = editWindowField.getText();
								}
								
								StudentData dbd = new StudentData(name, Integer.parseInt(id), Integer.parseInt(num), address);
								new StudentDB().addData(dbd);
							}
							catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							try {
								createPanel(editCard, 3, mainFrame);
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							editFrame.dispose();
							mainFrame.setEnabled(true);
						}
					}
			});
			editFrame.addWindowListener(new WindowAdapter() {
				 public void windowClosed(WindowEvent e) {
					 mainFrame.setEnabled(true);
	            }
			});
			editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			editFrame.getContentPane().add(saveEditBtn);
			editFrame.setVisible(true);
		}
	}
	
	// ---------------- Delete Window GUI ---------------- //
	
	private class openDeleteWindow{
		openDeleteWindow(String name, int SAISID, JFrame mainFrame){
			JFrame deleteFrame = new JFrame();
			deleteFrame.setBounds(100, 100, 251, 133);
			deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			deleteFrame.setAlwaysOnTop(true);
			deleteFrame.getContentPane().setLayout(null);
			
			JLabel confirmDeleteLabel = new JLabel("Are you sure?");
			confirmDeleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
			confirmDeleteLabel.setFont(new Font("Arial", Font.PLAIN, 13));
			confirmDeleteLabel.setBounds(60, 19, 127, 22);
			deleteFrame.getContentPane().add(confirmDeleteLabel);
			
			JButton yesDeleteBtn = new JButton("Yes, delete!");
			yesDeleteBtn.setForeground(Color.RED);
			yesDeleteBtn.setBounds(117, 58, 117, 29);
			yesDeleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainFrame.setEnabled(true);
					try {
						if (new StudentDB().deleteData(name, SAISID)) {
							createPanel(deleteCard, 2, mainFrame);
							deleteFrame.dispose();
						}
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
			deleteFrame.getContentPane().add(yesDeleteBtn);
			
			JButton noDeleteBtn = new JButton("No");
			noDeleteBtn.setBounds(20, 58, 75, 29);
			noDeleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteFrame.dispose();
					mainFrame.setEnabled(true);
				}
			});
			deleteFrame.getContentPane().add(noDeleteBtn);
			
			deleteFrame.addWindowListener(new WindowAdapter() {
				 public void windowClosed(WindowEvent e) {
					 mainFrame.setEnabled(true);
	            }
			});
			deleteFrame.setResizable(false);
			deleteFrame.setLocationRelativeTo(null);
			deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			deleteFrame.setVisible(true);
		}
	}
	
	// ---------------- A method to create GUI Entry Panels ---------------- //

	private void createPanel(JPanel entryCard, int state, JFrame mainFrame) throws FileNotFoundException{
		Dimension dim = new Dimension(672, 142);
		StudentData [] students = StudentDB.read();
		entryCard.removeAll();

		int studentCount = 1;
		for (StudentData student : students) {
			
			// Using a for loop to create panels for each student entries 
			
			JPanel entryPanel = new JPanel();
			entryPanel.setBackground(new Color(230, 230, 250));
			entryPanel.setBounds(6, 6 + 148 * (studentCount - 1), 672, 142);
			entryPanel.setPreferredSize(dim);
			entryPanel.setLayout(null);
			entryCard.add(entryPanel);
		
			studentCount++;

			JLabel nameLabel = new JLabel(student.name);
			nameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
			nameLabel.setBounds(31, 18, 455, 48);
			entryPanel.add(nameLabel);
			
			
			// Using createPanel to create buttons for deletePanel and editPanel
			
			if (state == 2) {
				deleteEntryBtn = new JButton("Delete");
				deleteEntryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mainFrame.setEnabled(false);
						new openDeleteWindow(student.name, student.SAISID, mainFrame);
					}
				});
				deleteEntryBtn.setBounds(549, 107, 117, 29);
				deleteEntryBtn.setForeground(Color.RED);
				entryPanel.add(deleteEntryBtn);
			}
			
			else if (state == 3) {
				editEntryBtn = new JButton("Edit");
				editEntryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						mainFrame.setEnabled(false);
						new openEditWindow(student.name, student.SAISID, mainFrame);
					}
				});
				editEntryBtn.setBounds(549, 107, 117, 29);
				editEntryBtn.setForeground(Color.BLACK);
				entryPanel.add(editEntryBtn);
			}
			
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

			JLabel saisInfo = new JLabel(Integer.toString(student.SAISID));
			saisInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			saisInfo.setBounds(97, 69, 63, 24);
			entryPanel.add(saisInfo);

			JLabel studNoInfo = new JLabel(Integer.toString(student.num));
			studNoInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			studNoInfo.setBounds(326, 69, 105, 24);
			entryPanel.add(studNoInfo);

			JLabel addressLabel = new JLabel("ADDRESS:");
			addressLabel.setForeground(Color.DARK_GRAY);
			addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			addressLabel.setBounds(31, 90, 91, 24);
			entryPanel.add(addressLabel);

			JLabel addressInfo = new JLabel(student.address);
			addressInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			addressInfo.setBounds(117, 90, 345, 24);
			entryPanel.add(addressInfo);

		}
		
		entryCard.repaint();
	}

}
