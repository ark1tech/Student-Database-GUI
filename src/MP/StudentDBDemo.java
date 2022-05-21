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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.Arrays;
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

	private JFrame frame;
	private JTextField nameAddField;
	private JTextField saisAddField;
	private JTextField studNoAddField;
	private JTextField addressAddField;
	private JTextField textField_4;
	private JTextField editWindowField;
	private JPanel deleteCard;
	private JPanel editCard;
	private JButton editEntryBtn;

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

	public StudentDBDemo() throws FileNotFoundException {
		initialize();
	}

	private void initialize() throws FileNotFoundException {

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
		displayPanel.setPreferredSize(new Dimension(702, 2000));
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

		editCard = new JPanel();
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
		
		deleteCard = new JPanel();
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
					try {
						printFile(nameAddField.getText(), saisAddField.getText(), studNoAddField.getText(), addressAddField.getText());
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
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

		JPanel searchCard = new JPanel();
		displayPanel.add(searchCard, "search");
		searchCard.setLayout(null);

		JPanel searchEntryPanel = new JPanel();
		searchEntryPanel.setLayout(null);
		searchEntryPanel.setBackground(new Color(230, 230, 250));
		searchEntryPanel.setBounds(6, 6, 672, 39);
		searchCard.add(searchEntryPanel);

		textField_4 = new JTextField();
		textField_4.setBounds(6, 6, 535, 26);
		searchEntryPanel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel viewCard_4 = new JPanel();
		viewCard_4.setLayout(null);
		viewCard_4.setBounds(0, 51, 702, 573);
		searchCard.add(viewCard_4);

		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.setBounds(549, 6, 117, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().isEmpty()) {
					textField_4.setText("a");
				}
				else {
					viewCard_4.removeAll();
					
					File f = new File(".");
					File [] files = f.listFiles(filter());
					int n = 1;
			        for (File file : files) {
			        	
						try {
						Scanner sc = new Scanner(new File(file.getName()));
						
			        	String name = sc.nextLine();
			        	String dataLine = sc.nextLine(); sc.close();
			        	if (dataLine.toLowerCase().contains(textField_4.getText().toLowerCase()) || name.toLowerCase().contains(textField_4.getText().toLowerCase())) {
			        		String [] data = dataLine.split("\\s");
			        		
			        		JPanel entryPanel = new JPanel();
			    			entryPanel.setBackground(new Color(230, 230, 250));
			    			entryPanel.setBounds(6, 6 + 148 * (n - 1), 672, 142);
			    			entryPanel.setPreferredSize(new Dimension(672, 142));
			    			entryPanel.setLayout(null);
			    			viewCard_4.add(entryPanel); n++;

			    			JLabel nameLabel = new JLabel(name);
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

			    			JLabel saisInfo = new JLabel(data[0]);
			    			saisInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			    			saisInfo.setBounds(97, 69, 63, 24);
			    			entryPanel.add(saisInfo);

			    			JLabel studNoInfo = new JLabel(data[1]);
			    			studNoInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			    			studNoInfo.setBounds(326, 69, 105, 24);
			    			entryPanel.add(studNoInfo);

			    			JLabel addressLabel = new JLabel("ADDRESS:");
			    			addressLabel.setForeground(Color.DARK_GRAY);
			    			addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			    			addressLabel.setBounds(31, 90, 91, 24);
			    			entryPanel.add(addressLabel);

			    			JLabel addressInfo = new JLabel(String.join(" ", Arrays.copyOfRange(data, 2, data.length)));
			    			addressInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			    			addressInfo.setBounds(117, 90, 345, 24);
			    			entryPanel.add(addressInfo);
			        	}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        }
			        
			        viewCard_4.repaint();
				}
			}
		});
		searchEntryPanel.add(btnNewButton_2);

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
				try {
					createPanel(viewCard, 1);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
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
				try {
					createPanel(deleteCard, 2);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
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
				try {
					createPanel(editCard, 3);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
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
	
	public class openEditWindow{
		openEditWindow(String name) {
			JFrame editFrame = new JFrame();
			editFrame.setBounds(100, 100, 300, 223);
			editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			editFrame.setLocationRelativeTo(null);
			editFrame.setResizable(false);
			editFrame.getContentPane().setLayout(null);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "SAIS ID", "Student Number", "Address"}));
			comboBox.setBounds(36, 35, 226, 27);
			editFrame.getContentPane().add(comboBox);
			
			editWindowField = new JTextField();
			editWindowField.setBounds(69, 66, 161, 26);
			editWindowField.setColumns(10);
			editFrame.getContentPane().add(editWindowField);
			
			JLabel incompleteLabel = new JLabel("");
			incompleteLabel.setForeground(Color.RED);
			incompleteLabel.setHorizontalAlignment(SwingConstants.CENTER);
			incompleteLabel.setBounds(66, 146, 161, 16);
			editFrame.getContentPane().add(incompleteLabel);
			
			JButton saveEditBtn  = new JButton("Save");
			saveEditBtn.setBounds(89, 103, 117, 29);
			saveEditBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					boolean isIncomplete = editWindowField.getText().isEmpty();
						if(isIncomplete){
							incompleteLabel.setText("Incomplete Entry!");
							editEntryBtn.setEnabled(false);
						}
						else {
							try {
								Scanner sc = new Scanner(new File(name + ".txt"));
								String name = sc.nextLine();
								String dataLine = sc.nextLine(); sc.close();
								String [] data = dataLine.split("\\s");
								
								switch(comboBox.getSelectedIndex() + 1) {
									case 1:
										new File(name + ".txt").delete();
										name = editWindowField.getText();
										break;
									case 2:
										data[0] = editWindowField.getText(); break;
									case 3:
										data[1] = editWindowField.getText(); break;
									case 4:
										data[2] = editWindowField.getText();
								}
								
								printFile(name, data[0], data[1], data[2]);
							}
							catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							try {
								createPanel(editCard, 3);
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							editFrame.dispose();
							editEntryBtn.setEnabled(true);
						}
					}
			});
			editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			editFrame.getContentPane().add(saveEditBtn);
			editFrame.setVisible(true);
		}
	}

	private void createPanel(JPanel entryCard, int state) throws FileNotFoundException{
		Dimension dim = new Dimension(672, 142);
		entryCard.removeAll();
		File f = new File(".");
		File [] files = f.listFiles(filter());

		int n = 1;
		for (File file : files) {
			
			Scanner sc = new Scanner(new File(file.getName()));
			String name = sc.nextLine();
			String dataLine = sc.nextLine(); sc.close();
			String [] data = dataLine.split("\\s");
			
			JPanel entryPanel = new JPanel();
			entryPanel.setBackground(new Color(230, 230, 250));
			entryPanel.setBounds(6, 6 + 148 * (n - 1), 672, 142);
			entryPanel.setPreferredSize(dim);
			entryPanel.setLayout(null);
			entryCard.add(entryPanel);
			
			/*
		 		JLabel previewLabel = new JLabel("Preview");
				previewLabel.setForeground(Color.DARK_GRAY);
				previewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				previewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
				previewLabel.setBounds(17, 12, 57, 24);
				previewPanel.add(previewLabel);
				
			*/

			//System.out.print("\nEntry " + n);
			n++;

			JLabel nameLabel = new JLabel(name);
			nameLabel.setFont(new Font("Arial", Font.PLAIN, 25));
			nameLabel.setBounds(31, 18, 455, 48);
			entryPanel.add(nameLabel);
			
			if (state == 2) {
				JButton deleteEntryBtn = new JButton("Delete");
				deleteEntryBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(new File(name + ".txt").delete()){
							System.out.println(name + "'s record has been deleted.");
						} else System.out.println("Student record does not exist.");
						try {
							createPanel(deleteCard, 2);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						
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
						editEntryBtn.setEnabled(false);
						new openEditWindow(name);
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

			JLabel saisInfo = new JLabel(data[0]);
			saisInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			saisInfo.setBounds(97, 69, 63, 24);
			entryPanel.add(saisInfo);

			JLabel studNoInfo = new JLabel(data[1]);
			studNoInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			studNoInfo.setBounds(326, 69, 105, 24);
			entryPanel.add(studNoInfo);

			JLabel addressLabel = new JLabel("ADDRESS:");
			addressLabel.setForeground(Color.DARK_GRAY);
			addressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
			addressLabel.setBounds(31, 90, 91, 24);
			entryPanel.add(addressLabel);

			JLabel addressInfo = new JLabel(String.join(" ", Arrays.copyOfRange(data, 2, data.length)));
			addressInfo.setFont(new Font("Arial", Font.PLAIN, 15));
			addressInfo.setBounds(117, 90, 345, 24);
			entryPanel.add(addressInfo);

		}
		
		entryCard.repaint();
	}

	private void printFile(String name, String id, String num, String address) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(name + ".txt");
		pw.print(name + "\n" + id + " " + num + " " + address);
		pw.close();

	}
	
	public static FilenameFilter filter () {
		
		FilenameFilter textFilter = new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.toLowerCase().endsWith(".txt");
			}
		};
		
		return textFilter;
	}
	
}
