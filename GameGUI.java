/**
 * GameGUI.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.3
 * @since 2017-04-20
 */

package dinosauria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ItemListener;

public class GameGUI extends JFrame {

	private JPanel contentPane;
		
	private int playerNumber;
	private int dayNumber;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	private ImageIcon titleImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/titleImage.png"));
	private ImageIcon tyrannosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/tyrannosaurusImage.png"));
	private ImageIcon velociraptorImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/velociraptorImage.png"));
	private ImageIcon brachiosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/brachiosaurusImage.png"));
	private ImageIcon stegosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/stegosaurusImage.png"));
	private ImageIcon gigantoraptorImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/gigantoraptorImage.png"));
	private ImageIcon troodonImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/troodonImage.png"));
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public GameGUI() throws ParseException {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setTitle("Dinosauria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelStart = new JPanel();
		panelStart.setLayout(null);
		panelStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelStart.setBackground(new Color(204, 255, 204));
		contentPane.add(panelStart, "START");
		
		JLabel startWelcomeText = new JLabel("Welcome to...");
		startWelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		startWelcomeText.setFont(new Font("Tahoma", Font.ITALIC, 26));
		startWelcomeText.setBounds(0, 20, 1264, 30);
		panelStart.add(startWelcomeText);
		
		JLabel startDinosaurImage = new JLabel("");
		startDinosaurImage.setIcon(titleImage);
		startDinosaurImage.setHorizontalAlignment(SwingConstants.CENTER);
		startDinosaurImage.setBounds(0, 50, 1264, 581);
		panelStart.add(startDinosaurImage);
		
		JButton startNewGameButton = new JButton("Start New Game");
		startNewGameButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startNewGameButton.setBounds(434, 631, 396, 30);
		startNewGameButton.setFocusPainted(false);
		panelStart.add(startNewGameButton);
		
		JButton startHelpButton = new JButton("Help");
		startHelpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startHelpButton.setBounds(20, 631, 395, 30);
		startHelpButton.setFocusPainted(false);
		panelStart.add(startHelpButton);
		
		JButton startCreditsButton = new JButton("Credits");
		startCreditsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startCreditsButton.setBounds(849, 631, 395, 30);
		startCreditsButton.setFocusPainted(false);
		panelStart.add(startCreditsButton);
		
		JPanel panelHelp = new JPanel();
		panelHelp.setLayout(null);
		panelHelp.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelHelp.setBackground(new Color(204, 255, 204));
		contentPane.add(panelHelp, "HELP");
		
		JLabel helpTitleText = new JLabel("Help");
		helpTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		helpTitleText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		helpTitleText.setBounds(20, 20, 100, 30);
		panelHelp.add(helpTitleText);
		
		JButton helpReturnButton = new JButton("Return to Menu");
		helpReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpReturnButton.setBounds(849, 631, 395, 30);
		helpReturnButton.setFocusPainted(false);
		panelHelp.add(helpReturnButton);
		
		JTextArea helpHelpText = new JTextArea();
		helpHelpText.setBackground(new Color(204, 255, 204));
		helpHelpText.setLineWrap(true);
		helpHelpText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		helpHelpText.setWrapStyleWord(true);
		helpHelpText.setText("Dinosauria is a simple Java-based game developed by Robert Bruce and Brandon Lulham for the SENG201 \u2018Virtual Pets\u2019 assignment project. In the game, one to three players care for a small group of dinosaurs over a period of several days. Each player can have up to three dinosaurs, and the player who provides their dinosaurs with the best care will win the game.");
		helpHelpText.setBounds(20, 70, 1224, 100);
		panelHelp.add(helpHelpText);
		
		JPanel panelSetup = new JPanel();
		panelSetup.setBackground(new Color(204, 255, 204));
		contentPane.add(panelSetup, "SETUP");
		panelSetup.setLayout(null);
		
		JButton setupContinue = new JButton("Continue");
		setupContinue.setBounds(849, 631, 395, 30);
		setupContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setupContinue.setFocusPainted(false);
		panelSetup.add(setupContinue);
		
		JLabel setupTitleText = new JLabel("Start New Game");
		setupTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		setupTitleText.setFont(new Font("Tahoma", Font.PLAIN, 24));
		setupTitleText.setBounds(20, 20, 200, 30);
		panelSetup.add(setupTitleText);
		
		// Input mask for setupPlayerNumber text field.
		NumberFormatter validPlayerNumber = new NumberFormatter();
		validPlayerNumber.setMaximum(3);
		validPlayerNumber.setMinimum(1);
		
		JFormattedTextField setupPlayerNumber = new JFormattedTextField(validPlayerNumber);
		setupPlayerNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setupPlayerNumber.setBounds(582, 230, 100, 25);
		panelSetup.add(setupPlayerNumber);
		
		JLabel setupPlayerNumberText = new JLabel("Number of Players");
		setupPlayerNumberText.setHorizontalAlignment(SwingConstants.CENTER);
		setupPlayerNumberText.setFont(new Font("Tahoma", Font.BOLD, 14));
		setupPlayerNumberText.setBounds(20, 200, 1224, 20);
		panelSetup.add(setupPlayerNumberText);
		
		JLabel setupDayNumberText = new JLabel("Number of Days");
		setupDayNumberText.setHorizontalAlignment(SwingConstants.CENTER);
		setupDayNumberText.setFont(new Font("Tahoma", Font.BOLD, 14));
		setupDayNumberText.setBounds(20, 365, 1224, 20);
		panelSetup.add(setupDayNumberText);
		
		// Input mask for setupDayNumber text field.
		NumberFormatter validDayNumber = new NumberFormatter();
		validDayNumber.setMaximum(100);
		validDayNumber.setMinimum(1);
		
		JFormattedTextField setupDayNumber = new JFormattedTextField(validDayNumber);
		setupDayNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setupDayNumber.setBounds(582, 395, 100, 25);
		panelSetup.add(setupDayNumber);
		
		JLabel setupPlayerNumberDescText = new JLabel("(1 to 3)");
		setupPlayerNumberDescText.setHorizontalAlignment(SwingConstants.CENTER);
		setupPlayerNumberDescText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setupPlayerNumberDescText.setBounds(20, 265, 1224, 20);
		panelSetup.add(setupPlayerNumberDescText);
		
		JLabel setupDayNumberDescText = new JLabel("(1 to 100)");
		setupDayNumberDescText.setHorizontalAlignment(SwingConstants.CENTER);
		setupDayNumberDescText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		setupDayNumberDescText.setBounds(20, 430, 1224, 20);
		panelSetup.add(setupDayNumberDescText);
		
		JPanel panelNewPlayer = new JPanel();
		panelNewPlayer.setLayout(null);
		panelNewPlayer.setBackground(new Color(204, 255, 204));
		contentPane.add(panelNewPlayer, "NEWPLAYER");
		
		JButton newplayerContinueButton = new JButton("Continue");
		newplayerContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newplayerContinueButton.setBounds(849, 631, 395, 30);
		newplayerContinueButton.setFocusPainted(false);
		panelNewPlayer.add(newplayerContinueButton);
		
		JLabel newplayerTitleText = new JLabel("Create Player " + (players.size() + 1));
		newplayerTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		newplayerTitleText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		newplayerTitleText.setBounds(20, 20, 200, 30);
		panelNewPlayer.add(newplayerTitleText);
		
		JTextField newplayerPlayerName = new JTextField();
		newplayerPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPlayerName.setBounds(482, 100, 300, 25);
		newplayerPlayerName.setText("");
		panelNewPlayer.add(newplayerPlayerName);
		
		JLabel newplayerPlayerNameText = new JLabel("Player Name");
		newplayerPlayerNameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPlayerNameText.setFont(new Font("Tahoma", Font.BOLD, 14));
		newplayerPlayerNameText.setBounds(20, 70, 1224, 20);
		panelNewPlayer.add(newplayerPlayerNameText);
		
		JLabel newplayerPet1TitleText = new JLabel("Pet 1");
		newplayerPet1TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1TitleText.setFont(new Font("Tahoma", Font.BOLD, 14));
		newplayerPet1TitleText.setBounds(20, 145, 395, 20);
		panelNewPlayer.add(newplayerPet1TitleText);
		
		JLabel newPlayerPet2TitleText = new JLabel("Pet 2");
		newPlayerPet2TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newPlayerPet2TitleText.setFont(new Font("Tahoma", Font.BOLD, 14));
		newPlayerPet2TitleText.setBounds(434, 145, 396, 20);
		panelNewPlayer.add(newPlayerPet2TitleText);
		
		JLabel newplayerPet3TitleText = new JLabel("Pet 3");
		newplayerPet3TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3TitleText.setFont(new Font("Tahoma", Font.BOLD, 14));
		newplayerPet3TitleText.setBounds(849, 145, 395, 20);
		panelNewPlayer.add(newplayerPet3TitleText);
		
		JComboBox newplayerPet1Species = new JComboBox();
		newplayerPet1Species.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet1Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet1Species.setBounds(20, 175, 395, 25);
		newplayerPet1Species.setSelectedItem("");
		panelNewPlayer.add(newplayerPet1Species);
		
		JComboBox newplayerPet2Species = new JComboBox();
		newplayerPet2Species.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet2Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet2Species.setBounds(434, 175, 396, 25);
		newplayerPet2Species.setSelectedItem("");
		panelNewPlayer.add(newplayerPet2Species);
		
		JComboBox newplayerPet3Species = new JComboBox();
		newplayerPet3Species.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet3Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet3Species.setBounds(849, 175, 395, 25);
		newplayerPet3Species.setSelectedItem("");
		panelNewPlayer.add(newplayerPet3Species);
		
		JLabel newplayerPet1NameText = new JLabel("Name");
		newplayerPet1NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1NameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet1NameText.setBounds(20, 210, 395, 20);
		newplayerPet1NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet1NameText);
		
		JLabel newplayerPet2NameText = new JLabel("Name");
		newplayerPet2NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet2NameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet2NameText.setBounds(434, 210, 396, 20);
		newplayerPet2NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet2NameText);
		
		JLabel newplayerPet3NameText = new JLabel("Name");
		newplayerPet3NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3NameText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet3NameText.setBounds(849, 210, 395, 20);
		newplayerPet3NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet3NameText);
		
		JTextField newplayerPet1Name = new JTextField();
		newplayerPet1Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet1Name.setBounds(20, 240, 395, 25);
		newplayerPet1Name.setText("");
		newplayerPet1Name.setVisible(false);
		panelNewPlayer.add(newplayerPet1Name);
		
		JTextField newplayerPet2Name = new JTextField();
		newplayerPet2Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet2Name.setBounds(434, 240, 396, 25);
		newplayerPet2Name.setText("");
		newplayerPet2Name.setVisible(false);
		panelNewPlayer.add(newplayerPet2Name);
		
		JTextField newplayerPet3Name = new JTextField();
		newplayerPet3Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet3Name.setBounds(849, 240, 395, 25);
		newplayerPet3Name.setText("");
		newplayerPet3Name.setVisible(false);
		panelNewPlayer.add(newplayerPet3Name);
		
		JLabel newplayerPet1Image = new JLabel();
		newplayerPet1Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1Image.setBounds(20, 275, 395, 150);
		newplayerPet1Image.setVisible(false);
		panelNewPlayer.add(newplayerPet1Image);
		
		JLabel newplayerPet2Image = new JLabel();
		newplayerPet2Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet2Image.setBounds(434, 275, 396, 150);
		newplayerPet2Image.setVisible(false);
		panelNewPlayer.add(newplayerPet2Image);
		
		JLabel newplayerPet3Image = new JLabel();
		newplayerPet3Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3Image.setBounds(849, 275, 395, 150);
		newplayerPet3Image.setVisible(false);
		panelNewPlayer.add(newplayerPet3Image);
		
		JTextArea newplayerPet1DescText = new JTextArea();
		newplayerPet1DescText.setWrapStyleWord(true);
		newplayerPet1DescText.setLineWrap(true);
		newplayerPet1DescText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet1DescText.setBackground(new Color(204, 255, 204));
		newplayerPet1DescText.setBounds(20, 435, 395, 178);
		newplayerPet1DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet1DescText);
		
		JTextArea newplayerPet2DescText = new JTextArea();
		newplayerPet2DescText.setWrapStyleWord(true);
		newplayerPet2DescText.setLineWrap(true);
		newplayerPet2DescText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newplayerPet2DescText.setBackground(new Color(204, 255, 204));
		newplayerPet2DescText.setBounds(434, 435, 395, 178);
		newplayerPet2DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet2DescText);
		
		JTextArea newplayerPet3DescText = new JTextArea();
		newplayerPet3DescText.setWrapStyleWord(true);
		newplayerPet3DescText.setLineWrap(true);
		newplayerPet3DescText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet3DescText.setBackground(new Color(204, 255, 204));
		newplayerPet3DescText.setBounds(849, 435, 395, 178);
		newplayerPet3DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet3DescText);
		
		JPanel panelCredits = new JPanel();
		panelCredits.setLayout(null);
		panelCredits.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelCredits.setBackground(new Color(204, 255, 204));
		contentPane.add(panelCredits, "CREDITS");
		
		JLabel creditsTitleText = new JLabel("Credits");
		creditsTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		creditsTitleText.setFont(new Font("Tahoma", Font.PLAIN, 26));
		creditsTitleText.setBounds(20, 20, 100, 30);
		panelCredits.add(creditsTitleText);
		
		JButton creditsReturnButton = new JButton("Return to Menu");
		creditsReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		creditsReturnButton.setBounds(849, 631, 395, 30);
		creditsReturnButton.setFocusPainted(false);
		panelCredits.add(creditsReturnButton);
		
		JTextArea creditsCreditsText = new JTextArea();
		creditsCreditsText.setWrapStyleWord(true);
		creditsCreditsText.setText("Title Image - Adapted from image \u2018Edmontonia Dinosaur\u2019 created by Mariana Ruiz Villarreal.\r\nTyrannosaurus - Adapted from image \u2018Tyrannosaurus BW\u2019 created by Nobu Tamura.\r\nVelociraptor - Adapted from image \u2018The Christmas Velociraptor\u2019 created by Durbed and distributed under the Creative Commons Attribution-ShareAlike 3.0 Unported license.\r\nBrachiosaurus - Adapted from image \u2018Brachiosaurus BW\u2019 created by Nobu Tamura.\r\nStegosaurus - Adapted from image \u2018Stegosaurus BW\u2019 created by Nobu Tamura.\r\nGigantoraptor - Adapted from image \u2018Gigantoraptor BW\u2019 created by Nobu Tamura.\r\nTroodon - Adapted from image \u2018Hand Drawn Troodon\u2019 by Iain James Reid and distributed under the Creative Commons Attribution-ShareALike 3.0 Unported license.");
		creditsCreditsText.setLineWrap(true);
		creditsCreditsText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		creditsCreditsText.setBackground(new Color(204, 255, 204));
		creditsCreditsText.setBounds(20, 100, 1224, 200);
		panelCredits.add(creditsCreditsText);
		
		JLabel lblNewLabel = new JLabel("Images");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 70, 200, 20);
		panelCredits.add(lblNewLabel);
		
		JPanel panelGame = new JPanel();
		panelGame.setLayout(null);
		panelGame.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGame.setBackground(new Color(204, 255, 204));
		contentPane.add(panelGame, "GAME");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(GameGUI.class.getResource("/dinosauria/underconstructionImage.png")));
		lblNewLabel_1.setBounds(0, 0, 1264, 683);
		panelGame.add(lblNewLabel_1);
		
		// EVENT HANDLERS FOR START
		startHelpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "HELP");
			}
		});
		
		startNewGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "SETUP");
			}
		});
		
		startCreditsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "CREDITS");
			}
		});
		
		// EVENT HANDLERS FOR HELP
		helpReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "START");
			}
		});
		
		// EVENT HANDLERS FOR CREDITS
		creditsReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "START");
			}
		});
		
		// EVENT HANDLERS FOR SETUP
		setupContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (setupPlayerNumber.getValue() == null || setupDayNumber.getValue() == null) {
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid player number and day number.");
				} else {
					playerNumber = (int) setupPlayerNumber.getValue();
					dayNumber = (int) setupDayNumber.getValue();
					CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
				    currentLayout.show(contentPane, "NEWPLAYER");
				}	
			}
		});
		
		// EVENT HANDLERS FOR NEW PLAYER
		// Select species of pet 1.
		newplayerPet1Species.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					displaySpecies(newplayerPet1Species, 
							newplayerPet1NameText, newplayerPet1Name,
							newplayerPet1Image, newplayerPet1DescText);
				}
			}
		});
		
		// Select species of pet 2.
		newplayerPet2Species.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					displaySpecies(newplayerPet2Species, 
							newplayerPet2NameText, newplayerPet2Name,
							newplayerPet2Image, newplayerPet2DescText);
				}
			}
		});
		
		// Select species of pet 3.
		newplayerPet3Species.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					displaySpecies(newplayerPet3Species, 
							newplayerPet3NameText, newplayerPet3Name,
							newplayerPet3Image, newplayerPet3DescText);
				}
			}
		});
		
		// Continue button.
		newplayerContinueButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (isNewPlayerValid((String) newplayerPlayerName.getText(),
						(String) newplayerPet1Species.getSelectedItem(),
						newplayerPet1Name.getText(),
						(String) newplayerPet2Species.getSelectedItem(),
						newplayerPet2Name.getText(),
						(String) newplayerPet3Species.getSelectedItem(),
						newplayerPet3Name.getText())) {
					
					int confirmation = JOptionPane.showConfirmDialog(
							contentPane, "Are you sure you wish to continue? " +
							"These options cannot be changed later.", null, 
							JOptionPane.YES_NO_OPTION);
					if(confirmation == JOptionPane.YES_OPTION) {
					createNewPlayer((String) newplayerPlayerName.getText(),
							(String) newplayerPet1Species.getSelectedItem(),
							newplayerPet1Name.getText(),
							(String) newplayerPet2Species.getSelectedItem(),
							newplayerPet2Name.getText(),
							(String) newplayerPet3Species.getSelectedItem(),
							newplayerPet3Name.getText());
					if (playerNumber > players.size()) {
						newplayerTitleText.setText("Create Player " + (players.size() + 1));
						newplayerPlayerName.setText("");
						newplayerPet1Species.setSelectedItem("");
						newplayerPet2Species.setSelectedItem("");
						newplayerPet3Species.setSelectedItem("");
						displaySpecies(newplayerPet1Species, 
								newplayerPet1NameText, newplayerPet1Name,
								newplayerPet1Image, newplayerPet1DescText);
						displaySpecies(newplayerPet2Species, 
								newplayerPet2NameText, newplayerPet2Name,
								newplayerPet2Image, newplayerPet2DescText);
						displaySpecies(newplayerPet2Species, 
								newplayerPet3NameText, newplayerPet3Name,
								newplayerPet3Image, newplayerPet3DescText);
					} else {
						CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
						currentLayout.show(contentPane, "GAME");
					}
				}
				}
			}
		});
	}
	
	private void createNewPlayer (String name,
			String pet1Species, String pet1Name,
			String pet2Species, String pet2Name,
			String pet3Species, String pet3Name)
	{
		Player newPlayer = new Player(name);
		addNewPet(newPlayer, pet1Species, pet1Name);
		addNewPet(newPlayer, pet2Species, pet2Name);
		addNewPet(newPlayer, pet3Species, pet3Name);
		players.add(newPlayer);
	}
	
	private void addNewPet (Player player, String species, String name)
	{
		String favToy = "TEMP"; // REPLACE
		String favFood = "TEMP"; // REPLACE
		
		if (species.equals("Tyrannosaurus")) {
			player.addPet(new Tyrannosaurus(name, favFood, favToy));
			
		} else if (species.equals("Velociraptor")) {
			player.addPet(new Velociraptor(name, favFood, favToy));
			
		} else if (species.equals("Brachiosaurus")) {
			player.addPet(new Brachiosaurus(name, favFood, favToy));
			
		} else if (species.equals("Stegosaurus")) {
			player.addPet(new Stegosaurus(name, favFood, favToy));
			
		} else if (species.equals("Gigantoraptor")) {
			player.addPet(new Gigantoraptor(name, favFood, favToy));
			
		} else if (species.equals("Troodon")) {
			player.addPet(new Troodon(name, favFood, favToy));
		}
			
	}

	
	private boolean isNewPlayerValid (String name,
			String pet1Species, String pet1Name,
			String pet2Species, String pet2Name,
			String pet3Species, String pet3Name)
	{
		boolean isValid = true;
		
		// Check that player name is unique and not null.
		isValid = isValidPlayerName(name);
		
		// Check that at least one pet is selected.
		if (pet1Species.equals("") && pet2Species.equals("") && (pet3Species.equals(""))) {
			JOptionPane.showMessageDialog(contentPane, "A player must have " +
										  "at least one pet.");
			isValid = false;
		}
		
		// Check that pet names are unique and not null if selected.
		if (pet1Species != "" && isValid) {
			isValid = isValidPetName(pet1Name, 1);
			if ((pet1Name.equals(pet2Name) || pet1Name.equals(pet3Name)) && isValid) {
				isValid = false;
				showNonUniquePetNameDialog(pet1Name);
			}
		}
		if (pet2Species != "" && isValid) {
			isValid = isValidPetName(pet2Name, 2);
			if ((pet2Name.equals(pet1Name) || pet2Name.equals(pet3Name)) && isValid) {
				isValid = false;
				showNonUniquePetNameDialog(pet2Name);
			}
		}
		if (pet3Species != "" && isValid) {
			isValid = isValidPetName(pet3Name, 3);
			if ((pet3Name.equals(pet1Name) || pet3Name.equals(pet2Name)) && isValid) {
				isValid = false;
				showNonUniquePetNameDialog(pet3Name);
			}
		}
		return isValid;
	}
	

	
	/**
	 * Takes a set of Swing objects corresponding to the name field and details
	 * of a pet on PanelNewPlayer and displays the correct information based
	 * on the species selected in the species combobox.
	 * 
	 * @param species JComboBox - The species of the pet.
	 * @param nameText JLabel - Label for the pet name field.
	 * @param name JFormattedTextField - Field for the pet name. 
	 * @param image JLabel - Image of the selected species.
	 * @param description JTextArea - Description of the selected species.
	 */
	private void displaySpecies(JComboBox species, JLabel nameText, 
			JTextField name, JLabel image, JTextArea description)
	{
		if (species.getSelectedItem().equals("")) {
			// Hide objects if no species is selected.
			nameText.setVisible(false);
			name.setVisible(false);
			name.setText(""); // Clear name field.
			image.setVisible(false);
			description.setVisible(false);
		} else {
			// Display hidden objects if a species is selected.
			nameText.setVisible(true);
			name.setVisible(true);
			image.setVisible(true);
			description.setVisible(true);
			
			// Update image and description for selected species.
			if (species.getSelectedItem().equals("Tyrannosaurus")) {
				image.setIcon(tyrannosaurusImage);
				description.setText(Tyrannosaurus.getDescription());
				
			} else if (species.getSelectedItem().equals("Velociraptor")) {
				image.setIcon(velociraptorImage);
				description.setText(Velociraptor.getDescription());
				
			} else if (species.getSelectedItem().equals("Brachiosaurus")) {
				image.setIcon(brachiosaurusImage);
				description.setText(Brachiosaurus.getDescription());
				
			} else if (species.getSelectedItem().equals("Stegosaurus")) {
				image.setIcon(stegosaurusImage);
				description.setText(Stegosaurus.getDescription());
				
			} else if (species.getSelectedItem().equals("Gigantoraptor")) {
				image.setIcon(gigantoraptorImage);
				description.setText(Gigantoraptor.getDescription());
				
			} else if (species.getSelectedItem().equals("Troodon")) {
				image.setIcon(troodonImage);
				description.setText(Troodon.getDescription());
			}		
		}
	}
		
	
	private boolean isBlank(String string)
	{
		for (int charIndex = 0; charIndex < string.length(); charIndex ++) {
			if (string.charAt(charIndex) != ' ') {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determines if a player name is valid. Returns false and displays a dialog
	 * message if a player with the same name already exists (case insensitive)
	 * or the name is null. Returns true otherwise.
	 * 
	 * @param newName String - The name to be tested.
	 * @return boolean - True if name is valid, false otherwise.
	 */
	private boolean isValidPlayerName (String newName)
	{
		// Check if name is null or blank.
		if (isBlank(newName)) {
			JOptionPane.showMessageDialog(contentPane, "Please enter a name " +
					"for Player " + (players.size() + 1) + ".");
			return false;
		// Check if name already exists (case insensitive).
		} else {
			for (int player = 0; player < players.size(); player ++) {
				if (newName.toLowerCase().equals(players.get(player).getName()
												 .toLowerCase())) {
					JOptionPane.showMessageDialog(contentPane, "A player " + 
							"with the name '" + newName + "' already exists. " +
							"Please select another and remember that names " +
							"are case insensitive.");
					return false;
				}
			}
		}
		
		// Return true if the above checks fail.
		return true;
	}
	
	
	/**
	 * Determines if a pet name is valid. Returns false if the a pet with the
	 * same name exists (case insensitive) or if the name is null. A
	 * dialog message appears if either case occurs. Returns true otherwise.
	 * 
	 * @param newName String - The pet name to be tested.
	 * @param petNumber int - The number of the pet being tested.
	 * @return boolean - true if name is valid, false otherwise.
	 */	
	private boolean isValidPetName(String newName, int petNumber)
	{
		// Check if name is null.
		if (isBlank(newName)) {
			JOptionPane.showMessageDialog(contentPane, "Pet " + petNumber +
					" has no name. Please add one or deselect it.");
			return false;
			
		// Check if name already exists (case insensitive).
		} else {
			for (int player = 0; player < players.size(); player ++) {
				
				ArrayList<Pet> playersPets = players.get(player).getPets();
				
				for (int pet = 0; pet < playersPets.size(); pet++) {
					
					if (newName.toLowerCase().equals(playersPets.get(pet)
													.getName().toLowerCase())) {
						showNonUniquePetNameDialog(newName);
						return false;
					}
				}
			}
		}
		
		// Return true if the above checks fail.
		return true;
	}
	
	private void showNonUniquePetNameDialog (String name)
	{
		JOptionPane.showMessageDialog(contentPane, "'" + name + 
				"' is not a unique pet name. Remember, pet names are case " +
				"insensitive. Please select another.");
	}
}
