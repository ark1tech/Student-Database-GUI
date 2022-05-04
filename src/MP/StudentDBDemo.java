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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class StudentDBDemo {

	private JFrame frame;

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

	/**
	 * Create the application.
	 */
	public StudentDBDemo() {
		initialize();
	}

	/*
	 * Initialize the contents of the frame.
	 *
	 * menuPanel.setBounds(0, 6, 196, 429);
	 * displayPanel.setBounds(195, 6, 541, 429);
	 *
	*/
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
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				viewButton.setBackground(new Color(0xb996ff));
//				viewIcon.setIcon(new ImageIcon("/Users/ray/Documents/Coding Journey/Github Collab/java-files-dump/MP1/src/MP/eyeIcon.png"));
//			}
//			@Override
//			public void mouseExited(MouseEvent e) {
//				viewButton.setBackground(new Color(0x8c52ff));
//				viewIcon.setIcon(new ImageIcon("/Users/ray/Documents/Coding Journey/Github Collab/java-files-dump/MP1/src/MP/eyeIcon.png"));
//			}
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
				
				JPanel displayPanel = new JPanel();
				//displayPanel.setBounds(195, 6, 716, 573);
				displayPanel.setPreferredSize(new Dimension(702, 775));
				displayPanel.setLayout(new CardLayout(0, 0));
				
				JPanel viewCard = new JPanel();
				displayPanel.add(viewCard, "view");
				viewCard.setLayout(null);
				
				JPanel entryPanel_1 = new JPanel();
				entryPanel_1.setBackground(new Color(250, 250, 210));
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
				
				JPanel entryPanel_2 = new JPanel();
				entryPanel_2.setLayout(null);
				entryPanel_2.setBackground(new Color(255, 240, 245));
				entryPanel_2.setBounds(6, 154, 672, 142);
				viewCard.add(entryPanel_2);
				
				JLabel nameLabel_2 = new JLabel("Raymund Klien B. Mañago");
				nameLabel_2.setFont(new Font("Arial", Font.PLAIN, 25));
				nameLabel_2.setBounds(31, 18, 455, 48);
				entryPanel_2.add(nameLabel_2);
				
				JLabel saisLabel_1_4 = new JLabel("SAIS ID:");
				saisLabel_1_4.setForeground(Color.DARK_GRAY);
				saisLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_4.setBounds(31, 69, 57, 24);
				entryPanel_2.add(saisLabel_1_4);
				
				JLabel saisLabel_1_1_1 = new JLabel("STUDENT NUMBER:");
				saisLabel_1_1_1.setForeground(Color.DARK_GRAY);
				saisLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_1_1.setBounds(172, 69, 150, 24);
				entryPanel_2.add(saisLabel_1_1_1);
				
				JLabel saisLabel_1_2_3 = new JLabel("235412");
				saisLabel_1_2_3.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_3.setBounds(97, 69, 63, 24);
				entryPanel_2.add(saisLabel_1_2_3);
				
				JLabel saisLabel_1_2_1_1 = new JLabel("201054321");
				saisLabel_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_1_1.setBounds(326, 69, 105, 24);
				entryPanel_2.add(saisLabel_1_2_1_1);
				
				JLabel saisLabel_1_3_1 = new JLabel("ADDRESS:");
				saisLabel_1_3_1.setForeground(Color.DARK_GRAY);
				saisLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_3_1.setBounds(31, 90, 91, 24);
				entryPanel_2.add(saisLabel_1_3_1);
				
				JLabel saisLabel_1_2_2_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
				saisLabel_1_2_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_2_1.setBounds(117, 90, 345, 24);
				entryPanel_2.add(saisLabel_1_2_2_1);
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(new Color(230, 230, 250));
				panel_1_1.setBounds(6, 450, 672, 142);
				viewCard.add(panel_1_1);
				
				JLabel nameLabel_1_1_1 = new JLabel("Raymund Klien B. Mañago");
				nameLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 25));
				nameLabel_1_1_1.setBounds(31, 18, 455, 48);
				panel_1_1.add(nameLabel_1_1_1);
				
				JLabel saisLabel_1_4_1 = new JLabel("SAIS ID:");
				saisLabel_1_4_1.setForeground(Color.DARK_GRAY);
				saisLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_4_1.setBounds(31, 69, 57, 24);
				panel_1_1.add(saisLabel_1_4_1);
				
				JLabel saisLabel_1_1_1_1 = new JLabel("STUDENT NUMBER:");
				saisLabel_1_1_1_1.setForeground(Color.DARK_GRAY);
				saisLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_1_1_1.setBounds(172, 69, 150, 24);
				panel_1_1.add(saisLabel_1_1_1_1);
				
				JLabel saisLabel_1_2_3_1 = new JLabel("235412");
				saisLabel_1_2_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_3_1.setBounds(97, 69, 63, 24);
				panel_1_1.add(saisLabel_1_2_3_1);
				
				JLabel saisLabel_1_2_1_1_1 = new JLabel("201054321");
				saisLabel_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_1_1_1.setBounds(326, 69, 105, 24);
				panel_1_1.add(saisLabel_1_2_1_1_1);
				
				JLabel saisLabel_1_3_1_1 = new JLabel("ADDRESS:");
				saisLabel_1_3_1_1.setForeground(Color.DARK_GRAY);
				saisLabel_1_3_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_3_1_1.setBounds(31, 90, 91, 24);
				panel_1_1.add(saisLabel_1_3_1_1);
				
				JLabel saisLabel_1_2_2_1_1 = new JLabel("Ili Sur, San Juan, 2514, La Union");
				saisLabel_1_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_2_1_1.setBounds(117, 90, 345, 24);
				panel_1_1.add(saisLabel_1_2_2_1_1);
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBackground(new Color(255, 228, 196));
				panel_2.setBounds(6, 302, 672, 142);
				viewCard.add(panel_2);
				
				JLabel nameLabel_1_2 = new JLabel("Raymund Klien B. Mañago");
				nameLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 25));
				nameLabel_1_2.setBounds(31, 18, 455, 48);
				panel_2.add(nameLabel_1_2);
				
				JLabel saisLabel_1_5 = new JLabel("SAIS ID:");
				saisLabel_1_5.setForeground(Color.DARK_GRAY);
				saisLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_5.setBounds(31, 69, 57, 24);
				panel_2.add(saisLabel_1_5);
				
				JLabel saisLabel_1_1_2 = new JLabel("STUDENT NUMBER:");
				saisLabel_1_1_2.setForeground(Color.DARK_GRAY);
				saisLabel_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_1_2.setBounds(172, 69, 150, 24);
				panel_2.add(saisLabel_1_1_2);
				
				JLabel saisLabel_1_2_4 = new JLabel("235412");
				saisLabel_1_2_4.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_4.setBounds(97, 69, 63, 24);
				panel_2.add(saisLabel_1_2_4);
				
				JLabel saisLabel_1_2_1_2 = new JLabel("201054321");
				saisLabel_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_1_2.setBounds(326, 69, 105, 24);
				panel_2.add(saisLabel_1_2_1_2);
				
				JLabel saisLabel_1_3_2 = new JLabel("ADDRESS:");
				saisLabel_1_3_2.setForeground(Color.DARK_GRAY);
				saisLabel_1_3_2.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_3_2.setBounds(31, 90, 91, 24);
				panel_2.add(saisLabel_1_3_2);
				
				JLabel saisLabel_1_2_2_2 = new JLabel("Ili Sur, San Juan, 2514, La Union");
				saisLabel_1_2_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
				saisLabel_1_2_2_2.setBounds(117, 90, 345, 24);
				panel_2.add(saisLabel_1_2_2_2);
				
				JPanel titleCard = new JPanel();
				displayPanel.add(titleCard, "title");
				titleCard.setLayout(null);
				
				JLabel displayTitlePage = new JLabel("");
				displayTitlePage.setBounds(0, 5, 716, 573);
				titleCard.add(displayTitlePage);
				displayTitlePage.setIcon(new ImageIcon(StudentDBDemo.class.getResource("/MP/displayPage.png")));
				
				JScrollPane scrollPane = new JScrollPane(displayPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollPane.setPreferredSize(new Dimension(702, 575));
				scrollPane.setBounds(195, 6, 702, 575);
				bottomCard.add(scrollPane);
				
				JPanel addCard = new JPanel();
				displayPanel.add(addCard, "add");
				addCard.setLayout(null);
				
				JPanel deleteCard = new JPanel();
				displayPanel.add(deleteCard, "delete");
				deleteCard.setLayout(null);
				
				JPanel editCard = new JPanel();
				displayPanel.add(editCard, "edit");
				editCard.setLayout(null);
				
				JPanel searchCard = new JPanel();
				displayPanel.add(searchCard, "search");
				searchCard.setLayout(null);
		
		frame.setResizable(false);
	}
}
