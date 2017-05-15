/**
 * GameGUI.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.5
 * @since 2017-04-23
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
import javax.swing.JMenuItem;
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
import java.util.Collections;

import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.UIManager;

import java.awt.event.ItemListener;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class GameGUI extends JFrame {

	private JPanel contentPane;
		
	private static int playerNumber;
	private static int dayNumber;
	private static int currentDay = 1;
	private static int actionPoints = 2;
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static String enableType = "all"; // Inventory item type to be enabled in the inventory panel.
	private static Pet selectedPet;
	
	private ImageIcon titleImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/titleImage.png"));
	private ImageIcon tyrannosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/tyrannosaurusImage.png"));
	private ImageIcon velociraptorImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/velociraptorImage.png"));
	private ImageIcon brachiosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/brachiosaurusImage.png"));
	private ImageIcon stegosaurusImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/stegosaurusImage.png"));
	private ImageIcon gigantoraptorImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/gigantoraptorImage.png"));
	private ImageIcon troodonImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/troodonImage.png"));
	private ImageIcon saveImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/saveImage.png"));
	private ImageIcon loadImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/loadImage.png"));
	
	// Food
	private ImageIcon baconBitsImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/baconBitsImage.png"));
	private ImageIcon caesarSaladImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/caesarSaladImage.png"));
	private ImageIcon grassImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/grassImage.png"));
	private ImageIcon meatScrapsImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/meatScrapsImage.png"));
	private ImageIcon plantsImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/plantsImage.png"));
	private ImageIcon roastedChickenImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/roastedChickenImage.png"));
	private ImageIcon roastVegetablesImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/roastVegetablesImage.png"));
	private ImageIcon steakWithCheeseSauceImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/steakWithCheeseSauceImage.png"));
	
	// Toys
	private ImageIcon dinoNipImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/dinoNipImage.png"));
	private ImageIcon explorerImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/explorerImage.png"));
	private ImageIcon giantBoneImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/giantBoneImage.png"));
	private ImageIcon playsetImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/jurassicIslandPlaysetImage.png"));
	private ImageIcon oldTyreImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/oldTyreImage.png"));
	private ImageIcon rubberChickenImage = new ImageIcon(GameGUI.class.getResource("/dinosauria/rubberChickenImage.png"));
	
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
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		

		UIManager.put("OptionPane.background", new Color(204, 255, 204));
		UIManager.put("OptionPane.messagebackground", new Color(204, 255, 204));
		UIManager.put("Panel.background", new Color(204, 255, 204));
		
		
		
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
		startNewGameButton.setBounds(331, 631, 291, 30);
		startNewGameButton.setFocusPainted(false);
		panelStart.add(startNewGameButton);
		
		JButton startHelpButton = new JButton("Help");
		startHelpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startHelpButton.setBounds(20, 631, 291, 30);
		startHelpButton.setFocusPainted(false);
		panelStart.add(startHelpButton);
		
		JButton startCreditsButton = new JButton("Credits");
		startCreditsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startCreditsButton.setBounds(953, 631, 291, 30);
		startCreditsButton.setFocusPainted(false);
		panelStart.add(startCreditsButton);
		
		JButton startLoadButton = new JButton("Load");
		startLoadButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startLoadButton.setFocusPainted(false);
		startLoadButton.setBounds(642, 631, 291, 30);
		panelStart.add(startLoadButton);
		
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
		
		JButton gameSaveButton = new JButton("Save");
		gameSaveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameSaveButton.setFocusPainted(false);
		gameSaveButton.setBounds(20, 631, 291, 30);
		panelGame.add(gameSaveButton);
		
		JButton gameContinueButton = new JButton("Continue");
		gameContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameContinueButton.setFocusPainted(false);
		gameContinueButton.setBounds(953, 631, 291, 30);
		panelGame.add(gameContinueButton);
		
		JButton gameStoreButton = new JButton("Store");
		gameStoreButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameStoreButton.setFocusPainted(false);
		gameStoreButton.setBounds(331, 631, 291, 30);
		panelGame.add(gameStoreButton);
		
		JButton gameInventoryButton = new JButton("Inventory");
		gameInventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameInventoryButton.setFocusPainted(false);
		gameInventoryButton.setBounds(642, 631, 291, 30);
		panelGame.add(gameInventoryButton);
		
		JLabel gameTitle = new JLabel("");
		gameTitle.setHorizontalAlignment(SwingConstants.LEFT);
		gameTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		gameTitle.setBounds(20, 20, 600, 30);
		panelGame.add(gameTitle);
		
		JPanel panelGamePet1 = new JPanel();
		panelGamePet1.setBackground(new Color(204, 255, 204));
		panelGamePet1.setBounds(20, 70, 395, 550);
		panelGame.add(panelGamePet1);
		panelGamePet1.setLayout(null);
		
		JLabel pet1Image = new JLabel("");
		pet1Image.setHorizontalAlignment(SwingConstants.CENTER);
		pet1Image.setBounds(0, 0, 395, 150);
		panelGamePet1.add(pet1Image);
		
		JLabel pet1Name = new JLabel("Pet 1");
		pet1Name.setHorizontalAlignment(SwingConstants.CENTER);
		pet1Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		pet1Name.setBounds(0, 160, 395, 20);
		panelGamePet1.add(pet1Name);
		
		JLabel pet1State = new JLabel("sick and/or angry or dead");
		pet1State.setHorizontalAlignment(SwingConstants.CENTER);
		pet1State.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet1State.setBounds(0, 190, 395, 20);
		panelGamePet1.add(pet1State);
		
		JLabel pet1BoredomText = new JLabel("Boredom");
		pet1BoredomText.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BoredomText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BoredomText.setBounds(0, 220, 95, 20);
		panelGamePet1.add(pet1BoredomText);
		
		JLabel pet1FatigueText = new JLabel("Fatigue");
		pet1FatigueText.setHorizontalAlignment(SwingConstants.CENTER);
		pet1FatigueText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1FatigueText.setBounds(0, 250, 95, 20);
		panelGamePet1.add(pet1FatigueText);
		
		JLabel pet1HungerText = new JLabel("Hunger");
		pet1HungerText.setHorizontalAlignment(SwingConstants.CENTER);
		pet1HungerText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1HungerText.setBounds(0, 280, 95, 20);
		panelGamePet1.add(pet1HungerText);
		
		JLabel pet1BladderText = new JLabel("Bladder");
		pet1BladderText.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BladderText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BladderText.setBounds(0, 310, 95, 20);
		panelGamePet1.add(pet1BladderText);
		
		JLabel pet1WeightText = new JLabel("Weight");
		pet1WeightText.setHorizontalAlignment(SwingConstants.CENTER);
		pet1WeightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1WeightText.setBounds(0, 340, 95, 20);
		panelGamePet1.add(pet1WeightText);
		
		JLabel pet1BoredomBorder = new JLabel("");
		pet1BoredomBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BoredomBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BoredomBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1BoredomBorder.setBounds(95, 220, 300, 20);
		panelGamePet1.add(pet1BoredomBorder);
		
		JLabel pet1BoredomBar = new JLabel("");
		pet1BoredomBar.setOpaque(true);
		pet1BoredomBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BoredomBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BoredomBar.setBackground(Color.RED);
		pet1BoredomBar.setBounds(95, 220, 200, 20);
		panelGamePet1.add(pet1BoredomBar);
		
		JLabel pet1FatigueBorder = new JLabel("");
		pet1FatigueBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet1FatigueBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1FatigueBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1FatigueBorder.setBounds(95, 250, 300, 20);
		panelGamePet1.add(pet1FatigueBorder);
		
		JLabel pet1FatigueBar = new JLabel("");
		pet1FatigueBar.setOpaque(true);
		pet1FatigueBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet1FatigueBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1FatigueBar.setBackground(Color.RED);
		pet1FatigueBar.setBounds(95, 250, 200, 20);
		panelGamePet1.add(pet1FatigueBar);
		
		JLabel pet1HungerBorder = new JLabel("");
		pet1HungerBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet1HungerBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1HungerBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1HungerBorder.setBounds(95, 280, 300, 20);
		panelGamePet1.add(pet1HungerBorder);
		
		JLabel pet1HungerBar = new JLabel("");
		pet1HungerBar.setOpaque(true);
		pet1HungerBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet1HungerBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1HungerBar.setBackground(Color.RED);
		pet1HungerBar.setBounds(95, 280, 200, 20);
		panelGamePet1.add(pet1HungerBar);
		
		JLabel pet1BladderBorder = new JLabel("");
		pet1BladderBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BladderBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BladderBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1BladderBorder.setBounds(95, 310, 300, 20);
		panelGamePet1.add(pet1BladderBorder);
		
		JLabel pet1BladderBar = new JLabel("");
		pet1BladderBar.setOpaque(true);
		pet1BladderBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet1BladderBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1BladderBar.setBackground(Color.RED);
		pet1BladderBar.setBounds(95, 310, 200, 20);
		panelGamePet1.add(pet1BladderBar);
		
		JLabel pet1WeightBorderLeft = new JLabel("");
		pet1WeightBorderLeft.setHorizontalAlignment(SwingConstants.CENTER);
		pet1WeightBorderLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1WeightBorderLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1WeightBorderLeft.setBounds(95, 340, 150, 20);
		panelGamePet1.add(pet1WeightBorderLeft);
		
		JLabel pet1WeightBorderRight = new JLabel("");
		pet1WeightBorderRight.setHorizontalAlignment(SwingConstants.CENTER);
		pet1WeightBorderRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1WeightBorderRight.setBorder(BorderFactory.createLineBorder(Color.black));
		pet1WeightBorderRight.setBounds(245, 340, 150, 20);
		panelGamePet1.add(pet1WeightBorderRight);
		
		JLabel pet1WeightBar = new JLabel("");
		pet1WeightBar.setOpaque(true);
		pet1WeightBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet1WeightBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet1WeightBar.setBackground(Color.RED);
		pet1WeightBar.setBounds(245, 340, 25, 20);
		panelGamePet1.add(pet1WeightBar);
		
		JLabel pet1ActionPoints = new JLabel("Action Points Remaining:");
		pet1ActionPoints.setHorizontalAlignment(SwingConstants.CENTER);
		pet1ActionPoints.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet1ActionPoints.setBounds(0, 370, 395, 20);
		panelGamePet1.add(pet1ActionPoints);
		
		JButton pet1FeedButton = new JButton("Feed");
		pet1FeedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet1FeedButton.setFocusPainted(false);
		pet1FeedButton.setBounds(0, 400, 195, 30);
		panelGamePet1.add(pet1FeedButton);
		
		JButton pet1PlayButton = new JButton("Play");
		pet1PlayButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet1PlayButton.setFocusPainted(false);
		pet1PlayButton.setBounds(200, 400, 195, 30);
		panelGamePet1.add(pet1PlayButton);
		
		JButton pet1SleepButton = new JButton("Sleep");
		pet1SleepButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet1SleepButton.setFocusPainted(false);
		pet1SleepButton.setBounds(0, 440, 195, 30);
		panelGamePet1.add(pet1SleepButton);
			
		JButton pet1ToiletButton = new JButton("Toilet");
		pet1ToiletButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet1ToiletButton.setFocusPainted(false);
		pet1ToiletButton.setBounds(200, 440, 195, 30);
		panelGamePet1.add(pet1ToiletButton);
		
		JButton pet1ReviveButton = new JButton("Revive");
		pet1ReviveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet1ReviveButton.setFocusPainted(false);
		pet1ReviveButton.setBounds(0, 495, 395, 30);
		panelGamePet1.add(pet1ReviveButton);
		
		JPanel panelGamePet2 = new JPanel();
		panelGamePet2.setBackground(new Color(204, 255, 204));
		panelGamePet2.setLayout(null);
		panelGamePet2.setBounds(434, 70, 395, 550);
		panelGame.add(panelGamePet2);
		
		JLabel pet2Image = new JLabel("");
		pet2Image.setHorizontalAlignment(SwingConstants.CENTER);
		pet2Image.setBounds(0, 0, 395, 150);
		panelGamePet2.add(pet2Image);
		
		JLabel pet2Name = new JLabel("Pet 1");
		pet2Name.setHorizontalAlignment(SwingConstants.CENTER);
		pet2Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		pet2Name.setBounds(0, 160, 395, 20);
		panelGamePet2.add(pet2Name);
		
		JLabel pet2State = new JLabel("sick and/or angry or dead");
		pet2State.setHorizontalAlignment(SwingConstants.CENTER);
		pet2State.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet2State.setBounds(0, 190, 395, 20);
		panelGamePet2.add(pet2State);
		
		JLabel pet2BoredomText = new JLabel("Boredom");
		pet2BoredomText.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BoredomText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BoredomText.setBounds(0, 220, 95, 20);
		panelGamePet2.add(pet2BoredomText);
		
		JLabel pet2FatigueText = new JLabel("Fatigue");
		pet2FatigueText.setHorizontalAlignment(SwingConstants.CENTER);
		pet2FatigueText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2FatigueText.setBounds(0, 250, 95, 20);
		panelGamePet2.add(pet2FatigueText);
		
		JLabel pet2HungerText = new JLabel("Hunger");
		pet2HungerText.setHorizontalAlignment(SwingConstants.CENTER);
		pet2HungerText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2HungerText.setBounds(0, 280, 95, 20);
		panelGamePet2.add(pet2HungerText);
		
		JLabel pet2BladderText = new JLabel("Bladder");
		pet2BladderText.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BladderText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BladderText.setBounds(0, 310, 95, 20);
		panelGamePet2.add(pet2BladderText);
		
		JLabel pet2WeightText = new JLabel("Weight");
		pet2WeightText.setHorizontalAlignment(SwingConstants.CENTER);
		pet2WeightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2WeightText.setBounds(0, 340, 95, 20);
		panelGamePet2.add(pet2WeightText);
		
		JLabel pet2BoredomBorder = new JLabel("");
		pet2BoredomBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BoredomBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BoredomBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2BoredomBorder.setBounds(95, 220, 300, 20);
		panelGamePet2.add(pet2BoredomBorder);
		
		JLabel pet2BoredomBar = new JLabel("");
		pet2BoredomBar.setOpaque(true);
		pet2BoredomBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BoredomBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BoredomBar.setBackground(Color.RED);
		pet2BoredomBar.setBounds(95, 220, 200, 20);
		panelGamePet2.add(pet2BoredomBar);
		
		JLabel pet2FatigueBorder = new JLabel("");
		pet2FatigueBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet2FatigueBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2FatigueBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2FatigueBorder.setBounds(95, 250, 300, 20);
		panelGamePet2.add(pet2FatigueBorder);
		
		JLabel pet2FatigueBar = new JLabel("");
		pet2FatigueBar.setOpaque(true);
		pet2FatigueBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet2FatigueBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2FatigueBar.setBackground(Color.RED);
		pet2FatigueBar.setBounds(95, 250, 200, 20);
		panelGamePet2.add(pet2FatigueBar);
		
		JLabel pet2HungerBorder = new JLabel("");
		pet2HungerBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet2HungerBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2HungerBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2HungerBorder.setBounds(95, 280, 300, 20);
		panelGamePet2.add(pet2HungerBorder);
		
		JLabel pet2HungerBar = new JLabel("");
		pet2HungerBar.setOpaque(true);
		pet2HungerBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet2HungerBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2HungerBar.setBackground(Color.RED);
		pet2HungerBar.setBounds(95, 280, 200, 20);
		panelGamePet2.add(pet2HungerBar);
		
		JLabel pet2BladderBorder = new JLabel("");
		pet2BladderBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BladderBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BladderBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2BladderBorder.setBounds(95, 310, 300, 20);
		panelGamePet2.add(pet2BladderBorder);
		
		JLabel pet2BladderBar = new JLabel("");
		pet2BladderBar.setOpaque(true);
		pet2BladderBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet2BladderBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2BladderBar.setBackground(Color.RED);
		pet2BladderBar.setBounds(95, 310, 200, 20);
		panelGamePet2.add(pet2BladderBar);
		
		JLabel pet2WeightBorderLeft = new JLabel("");
		pet2WeightBorderLeft.setHorizontalAlignment(SwingConstants.CENTER);
		pet2WeightBorderLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2WeightBorderLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2WeightBorderLeft.setBounds(95, 340, 150, 20);
		panelGamePet2.add(pet2WeightBorderLeft);
		
		JLabel pet2WeightBorderRight = new JLabel("");
		pet2WeightBorderRight.setHorizontalAlignment(SwingConstants.CENTER);
		pet2WeightBorderRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2WeightBorderRight.setBorder(BorderFactory.createLineBorder(Color.black));
		pet2WeightBorderRight.setBounds(245, 340, 150, 20);
		panelGamePet2.add(pet2WeightBorderRight);
		
		JLabel pet2WeightBar = new JLabel("");
		pet2WeightBar.setOpaque(true);
		pet2WeightBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet2WeightBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet2WeightBar.setBackground(Color.RED);
		pet2WeightBar.setBounds(245, 340, 25, 20);
		panelGamePet2.add(pet2WeightBar);
		
		JLabel pet2ActionPoints = new JLabel("Action Points Remaining:");
		pet2ActionPoints.setHorizontalAlignment(SwingConstants.CENTER);
		pet2ActionPoints.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet2ActionPoints.setBounds(0, 371, 395, 20);
		panelGamePet2.add(pet2ActionPoints);
		
		JButton pet2SleepButton = new JButton("Sleep");
		pet2SleepButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet2SleepButton.setFocusPainted(false);
		pet2SleepButton.setBounds(0, 440, 195, 30);
		panelGamePet2.add(pet2SleepButton);
		
		JButton pet2FeedButton = new JButton("Feed");
		pet2FeedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet2FeedButton.setFocusPainted(false);
		pet2FeedButton.setBounds(0, 400, 195, 30);
		panelGamePet2.add(pet2FeedButton);
		
		JButton pet2PlayButton = new JButton("Play");
		pet2PlayButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet2PlayButton.setFocusPainted(false);
		pet2PlayButton.setBounds(200, 400, 195, 30);
		panelGamePet2.add(pet2PlayButton);
		
		JButton pet2ToiletButton = new JButton("Toilet");
		pet2ToiletButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet2ToiletButton.setFocusPainted(false);
		pet2ToiletButton.setBounds(200, 440, 195, 30);
		panelGamePet2.add(pet2ToiletButton);
		
		JButton pet2ReviveButton = new JButton("Revive");
		pet2ReviveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet2ReviveButton.setFocusPainted(false);
		pet2ReviveButton.setBounds(0, 495, 395, 30);
		panelGamePet2.add(pet2ReviveButton);
		
		JPanel panelGamePet3 = new JPanel();
		panelGamePet3.setBackground(new Color(204, 255, 204));
		panelGamePet3.setLayout(null);
		panelGamePet3.setBounds(849, 70, 395, 550);
		panelGame.add(panelGamePet3);
		
		JLabel pet3Image = new JLabel("");
		pet3Image.setHorizontalAlignment(SwingConstants.CENTER);
		pet3Image.setBounds(0, 0, 395, 150);
		panelGamePet3.add(pet3Image);
		
		JLabel pet3Name = new JLabel("Pet 1");
		pet3Name.setHorizontalAlignment(SwingConstants.CENTER);
		pet3Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		pet3Name.setBounds(0, 160, 395, 20);
		panelGamePet3.add(pet3Name);
		
		JLabel pet3State = new JLabel("sick and/or angry or dead");
		pet3State.setHorizontalAlignment(SwingConstants.CENTER);
		pet3State.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet3State.setBounds(0, 190, 395, 20);
		panelGamePet3.add(pet3State);
		
		JLabel pet3BoredomText = new JLabel("Boredom");
		pet3BoredomText.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BoredomText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BoredomText.setBounds(0, 220, 95, 20);
		panelGamePet3.add(pet3BoredomText);
		
		JLabel pet3FatigueText = new JLabel("Fatigue");
		pet3FatigueText.setHorizontalAlignment(SwingConstants.CENTER);
		pet3FatigueText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3FatigueText.setBounds(0, 250, 95, 20);
		panelGamePet3.add(pet3FatigueText);
		
		JLabel pet3HungerText = new JLabel("Hunger");
		pet3HungerText.setHorizontalAlignment(SwingConstants.CENTER);
		pet3HungerText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3HungerText.setBounds(0, 280, 95, 20);
		panelGamePet3.add(pet3HungerText);
		
		JLabel pet3BladderText = new JLabel("Bladder");
		pet3BladderText.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BladderText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BladderText.setBounds(0, 310, 95, 20);
		panelGamePet3.add(pet3BladderText);
		
		JLabel pet3WeightText = new JLabel("Weight");
		pet3WeightText.setHorizontalAlignment(SwingConstants.CENTER);
		pet3WeightText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3WeightText.setBounds(0, 340, 95, 20);
		panelGamePet3.add(pet3WeightText);
		
		JLabel pet3BoredomBorder = new JLabel("");
		pet3BoredomBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BoredomBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BoredomBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3BoredomBorder.setBounds(95, 220, 300, 20);
		panelGamePet3.add(pet3BoredomBorder);
		
		JLabel pet3BoredomBar = new JLabel("");
		pet3BoredomBar.setOpaque(true);
		pet3BoredomBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BoredomBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BoredomBar.setBackground(Color.RED);
		pet3BoredomBar.setBounds(95, 220, 200, 20);
		panelGamePet3.add(pet3BoredomBar);
		
		JLabel pet3FatigueBorder = new JLabel("");
		pet3FatigueBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet3FatigueBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3FatigueBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3FatigueBorder.setBounds(95, 250, 300, 20);
		panelGamePet3.add(pet3FatigueBorder);
		
		JLabel pet3FatigueBar = new JLabel("");
		pet3FatigueBar.setOpaque(true);
		pet3FatigueBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet3FatigueBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3FatigueBar.setBackground(Color.RED);
		pet3FatigueBar.setBounds(95, 250, 200, 20);
		panelGamePet3.add(pet3FatigueBar);
		
		JLabel pet3HungerBorder = new JLabel("");
		pet3HungerBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet3HungerBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3HungerBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3HungerBorder.setBounds(95, 280, 300, 20);
		panelGamePet3.add(pet3HungerBorder);
		
		JLabel pet3HungerBar = new JLabel("");
		pet3HungerBar.setOpaque(true);
		pet3HungerBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet3HungerBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3HungerBar.setBackground(Color.RED);
		pet3HungerBar.setBounds(95, 280, 200, 20);
		panelGamePet3.add(pet3HungerBar);
		
		JLabel pet3BladderBorder = new JLabel("");
		pet3BladderBorder.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BladderBorder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BladderBorder.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3BladderBorder.setBounds(95, 310, 300, 20);
		panelGamePet3.add(pet3BladderBorder);
		
		JLabel pet3BladderBar = new JLabel("");
		pet3BladderBar.setOpaque(true);
		pet3BladderBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet3BladderBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3BladderBar.setBackground(Color.RED);
		pet3BladderBar.setBounds(95, 310, 200, 20);
		panelGamePet3.add(pet3BladderBar);
		
		JLabel pet3WeightBorderLeft = new JLabel("");
		pet3WeightBorderLeft.setHorizontalAlignment(SwingConstants.CENTER);
		pet3WeightBorderLeft.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3WeightBorderLeft.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3WeightBorderLeft.setBounds(95, 340, 150, 20);
		panelGamePet3.add(pet3WeightBorderLeft);
		
		JLabel pet3WeightBorderRight = new JLabel("");
		pet3WeightBorderRight.setHorizontalAlignment(SwingConstants.CENTER);
		pet3WeightBorderRight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3WeightBorderRight.setBorder(BorderFactory.createLineBorder(Color.black));
		pet3WeightBorderRight.setBounds(245, 340, 150, 20);
		panelGamePet3.add(pet3WeightBorderRight);
		
		JLabel pet3WeightBar = new JLabel("");
		pet3WeightBar.setOpaque(true);
		pet3WeightBar.setHorizontalAlignment(SwingConstants.CENTER);
		pet3WeightBar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pet3WeightBar.setBackground(Color.RED);
		pet3WeightBar.setBounds(245, 340, 25, 20);
		panelGamePet3.add(pet3WeightBar);
		
		JLabel pet3ActionPoints = new JLabel("Action Points Remaining:");
		pet3ActionPoints.setHorizontalAlignment(SwingConstants.CENTER);
		pet3ActionPoints.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pet3ActionPoints.setBounds(0, 371, 395, 20);
		panelGamePet3.add(pet3ActionPoints);
		
		JButton pet3FeedButton = new JButton("Feed");
		pet3FeedButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet3FeedButton.setFocusPainted(false);
		pet3FeedButton.setBounds(0, 400, 195, 30);
		panelGamePet3.add(pet3FeedButton);
		
		JButton pet3PlayButton = new JButton("Play");
		pet3PlayButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet3PlayButton.setFocusPainted(false);
		pet3PlayButton.setBounds(200, 400, 195, 30);
		panelGamePet3.add(pet3PlayButton);
		
		JButton pet3SleepButton = new JButton("Sleep");
		pet3SleepButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet3SleepButton.setFocusPainted(false);
		pet3SleepButton.setBounds(0, 440, 195, 30);
		panelGamePet3.add(pet3SleepButton);
		
		JButton pet3ToiletButton = new JButton("Toilet");
		pet3ToiletButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet3ToiletButton.setFocusPainted(false);
		pet3ToiletButton.setBounds(200, 440, 195, 30);
		panelGamePet3.add(pet3ToiletButton);
		
		JButton pet3ReviveButton = new JButton("Revive");
		pet3ReviveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pet3ReviveButton.setFocusPainted(false);
		pet3ReviveButton.setBounds(0, 495, 395, 30);
		panelGamePet3.add(pet3ReviveButton);
		
		JLabel gameScoreLabel = new JLabel("Score:");
		gameScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameScoreLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		gameScoreLabel.setBounds(1054, 20, 200, 30);
		panelGame.add(gameScoreLabel);
		
		JPanel panelInventory = new JPanel();
		panelInventory.setLayout(null);
		panelInventory.setBackground(new Color(204, 255, 204));
		contentPane.add(panelInventory, "INVENTORY");
		
		JButton inventoryItem1 = new JButton("Empty");
		inventoryItem1.setEnabled(false);
		inventoryItem1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem1.setBounds(361, 70, 167, 167);
		panelInventory.add(inventoryItem1);
		
		JButton inventoryItem2 = new JButton("Empty");
		inventoryItem2.setEnabled(false);
		inventoryItem2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem2.setBounds(548, 70, 167, 167);
		panelInventory.add(inventoryItem2);
		
		JButton inventoryItem3 = new JButton("Empty");
		inventoryItem3.setEnabled(false);
		inventoryItem3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem3.setBounds(735, 70, 167, 167);
		panelInventory.add(inventoryItem3);
		
		JButton inventoryItem4 = new JButton("Empty");
		inventoryItem4.setEnabled(false);
		inventoryItem4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem4.setBounds(361, 257, 167, 167);
		panelInventory.add(inventoryItem4);
		
		JButton inventoryItem5 = new JButton("Empty");
		inventoryItem5.setEnabled(false);
		inventoryItem5.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem5.setBounds(548, 257, 167, 167);
		panelInventory.add(inventoryItem5);
		
		JButton inventoryItem6 = new JButton("Empty");
		inventoryItem6.setEnabled(false);
		inventoryItem6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem6.setBounds(735, 257, 167, 167);
		panelInventory.add(inventoryItem6);
		
		JButton inventoryItem7 = new JButton("Empty");
		inventoryItem7.setEnabled(false);
		inventoryItem7.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem7.setBounds(361, 444, 167, 167);
		panelInventory.add(inventoryItem7);
		
		JButton inventoryItem8 = new JButton("Empty");
		inventoryItem8.setEnabled(false);
		inventoryItem8.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem8.setBounds(548, 444, 167, 167);
		panelInventory.add(inventoryItem8);
		
		JButton inventoryItem9 = new JButton("Empty");
		inventoryItem9.setEnabled(false);
		inventoryItem9.setFont(new Font("Tahoma", Font.ITALIC, 14));
		inventoryItem9.setBounds(735, 444, 167, 167);
		panelInventory.add(inventoryItem9);
		
		JLabel inventoryTitle = new JLabel("Inventory");
		inventoryTitle.setHorizontalAlignment(SwingConstants.LEFT);
		inventoryTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		inventoryTitle.setBounds(20, 20, 200, 30);
		panelInventory.add(inventoryTitle);
		
		JButton inventoryReturnButton = new JButton("Return");
		inventoryReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		inventoryReturnButton.setFocusPainted(false);
		inventoryReturnButton.setBounds(849, 631, 395, 30);
		panelInventory.add(inventoryReturnButton);
		
		JPanel panelStore = new JPanel();
		panelStore.setLayout(null);
		panelStore.setBackground(new Color(204, 255, 204));
		contentPane.add(panelStore, "STORE");
		
		JButton storeReturnButton = new JButton("Return");
		storeReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		storeReturnButton.setFocusPainted(false);
		storeReturnButton.setBounds(849, 631, 395, 30);
		panelStore.add(storeReturnButton);
		
		JLabel storeTitle = new JLabel("Store");
		storeTitle.setHorizontalAlignment(SwingConstants.LEFT);
		storeTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		storeTitle.setBounds(20, 20, 200, 30);
		panelStore.add(storeTitle);
		
		JLabel storeBalanceLabel = new JLabel("Stones:");
		storeBalanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storeBalanceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		storeBalanceLabel.setBounds(1048, 20, 200, 30);
		panelStore.add(storeBalanceLabel);
		
		JButton storeBaconBitsButton = new JButton("");
		storeBaconBitsButton.setIcon(baconBitsImage);
		storeBaconBitsButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeBaconBitsButton.setBounds(174, 70, 167, 167);
		panelStore.add(storeBaconBitsButton);
		
		JButton storeCaesarButton = new JButton("");
		storeCaesarButton.setIcon(caesarSaladImage);
		storeCaesarButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeCaesarButton.setBounds(361, 70, 167, 167);
		panelStore.add(storeCaesarButton);
		
		JButton storeGrassButton = new JButton("");
		storeGrassButton.setIcon(grassImage);
		storeGrassButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeGrassButton.setBounds(548, 70, 167, 167);
		panelStore.add(storeGrassButton);
		
		JButton storeMeatScrapsButton = new JButton("");
		storeMeatScrapsButton.setIcon(meatScrapsImage);
		storeMeatScrapsButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeMeatScrapsButton.setBounds(735, 70, 167, 167);
		panelStore.add(storeMeatScrapsButton);
		
		JButton storePlantsButton = new JButton("");
		storePlantsButton.setIcon(plantsImage);
		storePlantsButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storePlantsButton.setBounds(922, 70, 167, 167);
		panelStore.add(storePlantsButton);
		
		JButton storeRoastChickenButton = new JButton("");
		storeRoastChickenButton.setIcon(roastedChickenImage);
		storeRoastChickenButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeRoastChickenButton.setBounds(268, 257, 167, 167);
		panelStore.add(storeRoastChickenButton);
		
		JButton storeRoastVegetablesButton = new JButton("");
		storeRoastVegetablesButton.setIcon(roastVegetablesImage);
		storeRoastVegetablesButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeRoastVegetablesButton.setBounds(455, 257, 167, 167);
		panelStore.add(storeRoastVegetablesButton);
		
		JButton storeSteakButton = new JButton("");
		storeSteakButton.setIcon(steakWithCheeseSauceImage);
		storeSteakButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeSteakButton.setBounds(642, 257, 167, 167);
		panelStore.add(storeSteakButton);
		
		JButton storeDinoNipButton = new JButton("");
		storeDinoNipButton.setIcon(dinoNipImage);
		storeDinoNipButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeDinoNipButton.setBounds(174, 444, 167, 167);
		panelStore.add(storeDinoNipButton);
		
		JButton storeExplorerButton = new JButton("");
		storeExplorerButton.setIcon(explorerImage);
		storeExplorerButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeExplorerButton.setBounds(361, 444, 167, 167);
		panelStore.add(storeExplorerButton);
		
		JButton storeGiantBoneButton = new JButton("");
		storeGiantBoneButton.setIcon(giantBoneImage);
		storeGiantBoneButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeGiantBoneButton.setBounds(548, 444, 167, 167);
		panelStore.add(storeGiantBoneButton);
		
		JButton storePlaysetButton = new JButton("");
		storePlaysetButton.setIcon(playsetImage);
		storePlaysetButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storePlaysetButton.setBounds(829, 257, 167, 167);
		panelStore.add(storePlaysetButton);
		
		JButton storeOldTyreButton = new JButton("");
		storeOldTyreButton.setIcon(oldTyreImage);
		storeOldTyreButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeOldTyreButton.setBounds(735, 444, 167, 167);
		panelStore.add(storeOldTyreButton);
		
		JButton storeRubberChickenButton = new JButton("");
		storeRubberChickenButton.setIcon(rubberChickenImage);
		storeRubberChickenButton.setFont(new Font("Tahoma", Font.ITALIC, 14));
		storeRubberChickenButton.setBounds(922, 444, 167, 167);
		panelStore.add(storeRubberChickenButton);
		
		JPanel panelGameOver = new JPanel();
		panelGameOver.setLayout(null);
		panelGameOver.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelGameOver.setBackground(new Color(204, 255, 204));
		contentPane.add(panelGameOver, "GAMEOVER");
		
		JLabel gameOverTitle = new JLabel("Game Over");
		gameOverTitle.setHorizontalAlignment(SwingConstants.LEFT);
		gameOverTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		gameOverTitle.setBounds(20, 20, 150, 30);
		panelGameOver.add(gameOverTitle);
		
		JButton gameOverExitButton = new JButton("Exit Game");
		gameOverExitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		gameOverExitButton.setFocusPainted(false);
		gameOverExitButton.setBounds(849, 631, 395, 30);
		panelGameOver.add(gameOverExitButton);
		
		JLabel gameOverScoresTitle = new JLabel("Scores For This Game:");
		gameOverScoresTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		gameOverScoresTitle.setBounds(20, 60, 200, 20);
		panelGameOver.add(gameOverScoresTitle);
		
		JTextArea gameOverScores = new JTextArea();
		gameOverScores.setWrapStyleWord(true);
		gameOverScores.setLineWrap(true);
		gameOverScores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gameOverScores.setBackground(new Color(204, 255, 204));
		gameOverScores.setBounds(20, 90, 1224, 56);
		panelGameOver.add(gameOverScores);
		
		JLabel gameOverHighScoresTitle = new JLabel("High Scores:");
		gameOverHighScoresTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		gameOverHighScoresTitle.setBounds(20, 162, 200, 20);
		panelGameOver.add(gameOverHighScoresTitle);
		
		JTextArea gameOverHighScores = new JTextArea();
		gameOverHighScores.setWrapStyleWord(true);
		gameOverHighScores.setLineWrap(true);
		gameOverHighScores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gameOverHighScores.setBackground(new Color(204, 255, 204));
		gameOverHighScores.setBounds(20, 192, 1224, 300);
		panelGameOver.add(gameOverHighScores);
		
	
		
		// EVENT HANDLERS FOR START
		startHelpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "HELP");
			}
		});
		
		startNewGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "SETUP");
			}
		});
		
		startCreditsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "CREDITS");
			}
		});
		
		startLoadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser loadDialog = new JFileChooser();
				int loadDialogStatus = loadDialog.showOpenDialog(contentPane);
				
				if (loadDialogStatus == JFileChooser.APPROVE_OPTION) {
					String loadPath = loadDialog.getSelectedFile().getAbsolutePath();
					if (SaveLoad.loadGame(loadPath)) {
						// Switch to the loaded game view.
						CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
						currentLayout.show(contentPane, "GAME");
						gameTitle.setText("Day " + currentDay + " - " + players.get(playerNumber).getName());
						displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
					} else {
						// Display an error message.
						JOptionPane.showMessageDialog(contentPane, "The specified save file could not be loaded. It " +
													  "may not exist, or could be corrupted.");
					}
				}			
			}
		});
		

		
		// EVENT HANDLERS FOR HELP
		helpReturnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "START");
			}
		});
		
		// EVENT HANDLERS FOR CREDITS
		creditsReturnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "START");
			}
		});
		
		// EVENT HANDLERS FOR SETUP
		setupContinue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		newplayerContinueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
							playerNumber = 0;
							CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
							currentLayout.show(contentPane, "GAME");
							gameTitle.setText("Day " + currentDay + " - " + players.get(playerNumber).getName());
							displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
						}
					}
				}
			}
		});
		
		// EVENT HANDLERS FOR GAME
		// gameSaveButton - Display an internal frame to save the game.
		gameSaveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {	
				JFileChooser saveDialog = new JFileChooser();
				int saveDialogStatus = saveDialog.showSaveDialog(contentPane);
				
				if (saveDialogStatus == JFileChooser.APPROVE_OPTION) {
					String savePath = saveDialog.getSelectedFile().getAbsolutePath();
					int save = SaveLoad.saveGame(savePath, players, playerNumber, dayNumber,
							 					 currentDay, actionPoints);
					
					// The file already exists.
					if (save == 1) {
						JOptionPane.showMessageDialog(contentPane, "A save already exists with that name. Please " +
								  					  "select another.");
					}

					// The file could not be created.
					else if (save != 0){
						JOptionPane.showMessageDialog(contentPane, "A save file could not be created. Please ensure " +
								  					  "that the name contains no illegal characters and try again.");
					}
				}
			}
		});
		
		
		pet1FeedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		gameInventoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			    enableType = "all"; // Enable the display of all items in the inventory.
			    updateInventory(panelInventory, players.get(playerNumber).getInventory());
			}
		});
		
		gameStoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				storeBalanceLabel.setText("Stones: " + players.get(playerNumber).getBalance());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "STORE");
			    
			}
		});
		
		// PET 1
		pet1FeedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(0);
				enableType = "food";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
		
		pet1PlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(0);
				enableType = "toy";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
		
		pet1SleepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(0);
				selectedPet.makeSleep();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		pet1ToiletButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(0);
				selectedPet.emptyBladder();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		pet1ReviveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				players.get(playerNumber).getPets().get(0).revive();
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		// PET 2
		pet2FeedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(1);
				enableType = "food";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
				
		pet2PlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(1);
				enableType = "toy";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
				
		pet2SleepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(1);
				selectedPet.makeSleep();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
				
			}
		});
				
		pet2ToiletButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(1);
				selectedPet.emptyBladder();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		pet2ReviveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				players.get(playerNumber).getPets().get(1).revive();
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		// PET 3
		pet3FeedButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(2);
				enableType = "food";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
				
		pet3PlayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(2);
				enableType = "toy";
				
				// Update inventory and switch to pane.
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "INVENTORY");
			}
		});
				
		pet3SleepButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(2);
				selectedPet.makeSleep();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
				
		pet3ToiletButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedPet = players.get(playerNumber).getPets().get(2);
				selectedPet.emptyBladder();
				selectedPet.setActionPoints(selectedPet.getActionPoints() - 1);
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		pet3ReviveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				players.get(playerNumber).getPets().get(2).revive();
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		
		gameContinueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playerNumber < players.size() - 1) {
					// Select next player and redisplay game sapce.
					playerNumber += 1;
					displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
				} else {
					processEndOfDay();
					if (currentDay == dayNumber) {
						// The last day has been reached. End the game.
						updateInventory(panelInventory, players.get(playerNumber).getInventory());
						CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
						updateGameOver(gameOverScores, gameOverHighScores, contentPane);
					    currentLayout.show(contentPane, "GAMEOVER");
					} else {
						// A new day has started.
						currentDay += 1;
						playerNumber = 0;
						displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
					}
					
				}
			}
		});
		
		// EVENT HANDLERS FOR STORE
		storeReturnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "GAME");
			}
		});
		
		// Bacon Bits
		storeBaconBitsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(baconBitsImage, new Food7(), storeBalanceLabel);
			}
		});
		
		// Caesar Salad
		storeCaesarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(caesarSaladImage, new Food1(), storeBalanceLabel);
			}
		});
		
		// Grass
		storeGrassButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(grassImage, new Food4(), storeBalanceLabel);
			}
		});
		
		// Meat Scraps
		storeMeatScrapsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(meatScrapsImage, new Food8(), storeBalanceLabel);
			}
		});
		
		// Roast Chicken
		storeRoastChickenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(roastedChickenImage, new Food6(), storeBalanceLabel);
			}
		});
		
		// Plants
		storePlantsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(plantsImage, new Food3(), storeBalanceLabel);
			}
		});
		
		// Roast Vegetables
		storeRoastVegetablesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(roastVegetablesImage, new Food2(), storeBalanceLabel);
			}
		});
		
		// Steak
		storeSteakButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(steakWithCheeseSauceImage, new Food5(), storeBalanceLabel);
			}
		});
		
		// Dino Nip
		storeDinoNipButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(dinoNipImage, new Toy4(), storeBalanceLabel);
			}
		});
		
		// Explorer
		storeExplorerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(explorerImage, new Toy3(), storeBalanceLabel);
			}
		});
		
		// Giant Bone
		storeGiantBoneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(giantBoneImage, new Toy2(), storeBalanceLabel);
			}
		});
		
		// Playset
		storePlaysetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(playsetImage, new Toy1(), storeBalanceLabel);
			}
		});
		
		// Old Tyre
		storeOldTyreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(oldTyreImage, new Toy6(), storeBalanceLabel);
			}
		});
		
		// Rubber Chicken
		storeRubberChickenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				purchaseDialog(rubberChickenImage, new Toy5(), storeBalanceLabel);
			}
		});
		
		//EVENT HANDLERS FOR INVENTORY
		inventoryReturnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "GAME");
			}
		});
		
		inventoryItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (0, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
				
			}
		});
		
		inventoryItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (1, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (2, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (3, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (4, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (5, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (6, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (7, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		inventoryItem9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventoryItemSelected (8, contentPane);
				updateInventory(panelInventory, players.get(playerNumber).getInventory());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3, gameTitle, gameScoreLabel);
			}
		});
		
		// EVENT HANDLERS FOR GAME OVER
		gameOverExitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	protected void updateGameOver(JTextArea gameOverScores, JTextArea gameOverHighScores, JPanel contentPane) {
		// Display the current score.
		Collections.sort(players, new PlayerComparator());
		String gameScores = "";
		for (int player = 0; player < players.size(); player ++) {
			gameScores += (player + 1) + ". " + players.get(player).getName() +
					" (" + players.get(player).getScore() + ")\n";
		}	
		gameOverScores.setText(gameScores);
		
		ArrayList<Player> highScoresArray = updateHighScores(players, contentPane);
		
		String highScores = "";
		for (int player = 0; player < highScoresArray.size(); player ++) {
			highScores += (player + 1) + ". " + highScoresArray.get(player).getName() +
					" (" + highScoresArray.get(player).getScore() + ")\n";
		}
		gameOverHighScores.setText(highScores);
		
		
	}
	
	private ArrayList<Player> updateHighScores(ArrayList<Player> gameScores, JPanel contentPane)
	{
		ArrayList<Player> highScores = SaveLoad.loadHighScores();
		if (highScores == null) {
			JOptionPane.showMessageDialog(contentPane, "Previous high scores could not be retrieved. Creating a new file.");
		} else {
			highScores.addAll(players);
			Collections.sort(players, new PlayerComparator());
			while (highScores.size() > 10) {
				highScores.remove(highScores.size() - 1);
			}
			if (!SaveLoad.saveHighScores(highScores)) {
				JOptionPane.showMessageDialog(contentPane, "The high scores could not be updated.");
			}
		}
		return highScores;
	}
		

	private void processEndOfDay()
	{
		for (int player = 0; player < players.size(); player ++) {
			players.get(player).processEndOfDay();
		}
	}
	
	
	private void inventoryItemSelected (int itemIndex, JPanel contentPane)
	{
		CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
		DinoItem item = players.get(playerNumber).getInventory().get(itemIndex);
		Object[] options;
		String title;
		
		// JTextArea used for dialog text for the purposes of word wrapping.
		JTextArea description = createDialogDescription(item.getDescription());
		
		// Set options for dialog based on enableType.
		if (enableType == "all") {
			options = new String[]{"Discard", "Return"};
			title = item.getName();
		} else {
			options = new String[]{"Use", "Return"};
			title = "Use " + item.getName() + " on " + selectedPet.getName();
		}
		
		// Generate the dialog.
		int selection = JOptionPane.showOptionDialog(contentPane,
													 description,
													 title,
													 JOptionPane.YES_NO_OPTION,
													 JOptionPane.QUESTION_MESSAGE,
													 getImage(item.getName()),
													 options,
													 options[0]);
		
		if (selection == 0) {
			if (enableType == "food") {
				// Food is given to pet and removed from inventory.
				selectedPet.giveFood((DinoFood) item);
				players.get(playerNumber).getInventory().remove(itemIndex);
				currentLayout.show(contentPane, "GAME");
				
			} else if (enableType == "toy") {
				// Toy is given to pet.
				selectedPet.giveToy((DinoToys) item);
				((DinoToys) item).decreaseDurability(selectedPet.getAngry());
				// If durability has reached 0, remove item from inventory.
				if (((DinoToys) item).durability <= 0) {
					players.get(playerNumber).getInventory().remove(itemIndex);
					JOptionPane.showMessageDialog(contentPane, selectedPet.getName() + " broke the toy.");
				}
				
				currentLayout.show(contentPane, "GAME");
			} else {
				// Item is discarded from inventory.
				players.get(playerNumber).getInventory().remove(itemIndex);
			}
		}
		
	}
	
	private void updateInventory(JPanel inventory, ArrayList<DinoItem> playerInventory)
	{
		for (int index = 0; index < 9; index ++) {
			if (index < playerInventory.size()) {
				// Display the corresponding icon image.
				((JButton) inventory.getComponent(index)).setText("");
				((JButton) inventory.getComponent(index)).setIcon(getImage(playerInventory.get(index).getName()));
				
				
				if (enableType == "all" || (enableType == "food" && playerInventory.get(index) 
					instanceof DinoFood) || (enableType == "toy" && playerInventory.get(index) instanceof DinoToys))
				{
					// Enable button if the object it represents is of correct type.
					((JButton) inventory.getComponent(index)).setEnabled(true);
				} else {
					// Otherwise, disable the button.
					((JButton) inventory.getComponent(index)).setEnabled(false);
				}
			} else {
				// If the inventory 'slot' is empty, disable the button and display "Empty".
				((JButton) inventory.getComponent(index)).setEnabled(false);
				((JButton) inventory.getComponent(index)).setText("Empty");
				((JButton) inventory.getComponent(index)).setIcon(null);
			}
		}
	}
	
	private JTextArea createDialogDescription (String description)
	{
		// Create new JTextArea.
		JTextArea dialogDescription = new JTextArea(description);
		
		// Set style parameters for JTextArea.
		dialogDescription.setLineWrap(true);
		dialogDescription.setWrapStyleWord(true);
		dialogDescription.setBackground(new Color(204, 255, 204));
		dialogDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		// Return the new JTextArea.
		return dialogDescription;
	}
	
	private void purchaseDialog (ImageIcon image, DinoItem item, JLabel storeBalanceLabel)
	{
		// JTextArea used for dialog text for the purposes of word wrapping.
		JTextArea description = createDialogDescription(item.getDescription());
		
		Object[] options = {"Purchase for " + item.getPrice() + " stones", "Return"}; // Options for dialog.
		
		int selection = JOptionPane.showOptionDialog(contentPane,
													 description,
													 "Purchase " + item.getName(),
													 JOptionPane.YES_NO_OPTION,
													 JOptionPane.QUESTION_MESSAGE,
													 image,
													 options,
													 options[0]);
		if (selection == 0) {
			Player currentPlayer = players.get(playerNumber);
			if (currentPlayer.getBalance() - item.getPrice() < 0) {
				JOptionPane.showMessageDialog(contentPane, "This item is too expensive.");
			} else if (currentPlayer.getInventory().size() > 8) {
				JOptionPane.showMessageDialog(contentPane, "Your inventory is full. Please remove an item.");
			} else {
				currentPlayer.getInventory().add(item); // Add item to player inventory.
				currentPlayer.setBalance(currentPlayer.getBalance() - item.getPrice()); // Deduct cost from balance.
				storeBalanceLabel.setText("Stones: " + players.get(playerNumber).getBalance());
			}
		}
	}
	
	private ImageIcon getImage(String name)
	{
		if (name == "Tyrannosaurus") {
			return tyrannosaurusImage;
		} else if (name == "Velociraptor") {
			return velociraptorImage;
		} else if (name == "Brachiosaurus") {
			return brachiosaurusImage;
		} else if (name == "Stegosaurus") {
			return stegosaurusImage;
		} else if (name == "Gigantoraptor") {
			return gigantoraptorImage;
		 }else if (name == "Troodon") {
			return troodonImage;
		} else if (name == "Caesar Salad") {
			return caesarSaladImage;
		} else if (name == "Roasted Vegetables") {
			return roastVegetablesImage;
		} else if (name == "Plants") {
			return plantsImage;
		} else if (name == "Grass") {
			return grassImage;
		} else if (name == "Steak with Cheese Sauce") {
			return steakWithCheeseSauceImage;
		} else if (name == "Roast Chicken") {
			return roastedChickenImage;
		} else if (name == "Bacon Bits") {
			return baconBitsImage;
		} else if (name == "Meat Scraps") {
			return meatScrapsImage;
		} else if (name == "Jurassic Island Playset") {
			return playsetImage;
		} else if (name == "Giant Bone") {
			return giantBoneImage;
		} else if (name == "Ford Explorer") {
			return explorerImage;
		} else if (name == "Dino Nip") {
			return dinoNipImage;
		} else if (name == "Rubber Chicken") {
			return rubberChickenImage;
		} else if (name == "Old Tyre") {
			return oldTyreImage;
		} else {
			return null;
		}
	}
	
	//private void displayPet
	
	private void displayGamePet (JPanel panel, Pet pet)
	{
		((JLabel) panel.getComponent(0)).setIcon(pet.getImage()); // Image.
		((JLabel) panel.getComponent(1)).setText(pet.getName()); // Name.
		((JLabel) panel.getComponent(2)).setText(pet.getMood()); // Mood.
		
		// Display Boredom
		((JLabel) panel.getComponent(9)).setBounds(95, 220, pet.getBoredom() * 3, 20);
		((JLabel) panel.getComponent(9)).setBackground(getBarColour(pet.getBoredom(), 100));
		
		// Display Fatigue
		((JLabel) panel.getComponent(11)).setBounds(95, 250, pet.getFatigue() * 3, 20);
		((JLabel) panel.getComponent(11)).setBackground(getBarColour(pet.getFatigue(), 100));
		
		// Display Hunger
		((JLabel) panel.getComponent(13)).setBounds(95, 280, pet.getHunger() * 3, 20);
		((JLabel) panel.getComponent(13)).setBackground(getBarColour(pet.getHunger(), 100));
		
		// Display Bladder
		((JLabel) panel.getComponent(15)).setBounds(95, 310, pet.getBladder() * 3, 20);
		((JLabel) panel.getComponent(15)).setBackground(getBarColour(pet.getBladder(), 100));
		
		// Display Weight
		if (pet.getWeight() > 50) {
			int width = (pet.getWeight() - 50) * 3;
			((JLabel) panel.getComponent(18)).setBounds(245, 340, width, 20);
			((JLabel) panel.getComponent(18)).setBackground(getBarColour(width, 150));
		} else {
			int width = (50 - pet.getWeight()) * 3;
			((JLabel) panel.getComponent(18)).setBounds(245 - width, 340, width, 20);
			((JLabel) panel.getComponent(18)).setBackground(getBarColour(width, 150));
			
		}
		if (pet.getActionPoints() == 0 || !pet.isAlive()) {
			// If action points are depleted, disable the four action buttons.
			((JButton) panel.getComponent(20)).setEnabled(false);
			((JButton) panel.getComponent(21)).setEnabled(false);
			((JButton) panel.getComponent(22)).setEnabled(false);
			((JButton) panel.getComponent(23)).setEnabled(false);
			
		} else {
			((JButton) panel.getComponent(20)).setEnabled(true);
			((JButton) panel.getComponent(21)).setEnabled(true);
			((JButton) panel.getComponent(22)).setEnabled(true);
			((JButton) panel.getComponent(23)).setEnabled(true);
		}
		
		((JLabel) panel.getComponent(19)).setText("Action Points Remaining: " + pet.getActionPoints());
		
		// Display revive button if pet is dead. If the pet was been revived before, it will be disabled.
		if (pet.isAlive()) {
			((JButton) panel.getComponent(24)).setVisible(false);
			((JLabel) panel.getComponent(0)).setEnabled(true);
		} else if (pet.wasDead()) {
			((JButton) panel.getComponent(24)).setVisible(true);
			((JButton) panel.getComponent(24)).setEnabled(false);
			((JLabel) panel.getComponent(0)).setEnabled(false);
		} else {
			((JButton) panel.getComponent(24)).setVisible(true);
			((JButton) panel.getComponent(24)).setEnabled(true);
			((JLabel) panel.getComponent(0)).setEnabled(false);
		}
	}
	
	private Color getBarColour(int barValue, int range)
	{
		double red = 0.0 + (barValue / (double) range);
		double green = 1.0 - (barValue / (double) range);
		
		if (red > 1.0) {
			red = 1.0; 
		} else if (red < 0.0) {
			red = 0.0;
		}
		
		if (green > 1.0) {
			green = 1.0; 
		} else if (green < 0.0) {
			green = 0.0;
		}

		return new Color((float) red, (float) green, (float) 0.0);
	}
	
	private void displayGameSpace(JPanel pet1, JPanel pet2, JPanel pet3, JLabel gameTitle, JLabel gameScoreLabel)
	{
		gameTitle.setText("Day " + currentDay + " - " + players.get(playerNumber).getName());
		gameScoreLabel.setText("Score: " + players.get(playerNumber).getScore());
		
		// Display single panel if player has one pet.
		if (players.get(playerNumber).getPetNumber() == 1) {
			pet1.setVisible(true);
			pet1.setBounds(434, 70, 395, 550);
			displayGamePet(pet1, players.get(playerNumber).getPets().get(0));
			
			pet2.setVisible(false);
			pet3.setVisible(false);
			
		// Display two panels if player has two pets.
		} else if (players.get(playerNumber).getPetNumber() == 2) {
			pet1.setVisible(true);
			pet1.setBounds(158, 70, 395, 550);
			displayGamePet(pet1, players.get(playerNumber).getPets().get(0));
			
			pet2.setVisible(true);
			pet2.setBounds(711, 70, 395, 550);
			displayGamePet(pet2, players.get(playerNumber).getPets().get(1));
			
			pet3.setVisible(false);
			
		// Display three panels if player has three pets.
		} else {
			pet1.setVisible(true);
			pet1.setBounds(20, 70, 395, 550);
			displayGamePet(pet1, players.get(playerNumber).getPets().get(0));
			
			pet2.setVisible(true);
			pet2.setBounds(434, 70, 395, 550);
			displayGamePet(pet2, players.get(playerNumber).getPets().get(1));
			
			pet3.setVisible(true);
			pet3.setBounds(849, 70, 395, 550);
			displayGamePet(pet3, players.get(playerNumber).getPets().get(2));
		}
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
		String favToy = DinoToys.getRandomToy(); 
		String favFood = DinoFood.getRandomFood(); // Carnivores can have plant favourite. 
		
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
	
	public static boolean setGameState (ArrayList<Player> newPlayers, int newPlayerNumber,
			int newDayNumber, int newCurrentDay, int newActionPoints)
	{
		if (newPlayers.size() > 0 && newPlayers.size() < 4 && newPlayerNumber >=
		0 && newPlayerNumber < 3 && newCurrentDay > 0 && newCurrentDay < 101 &&
		newDayNumber > 0 && newDayNumber < 101 && newActionPoints >= 0 &&
		newActionPoints < 3) {
			players = newPlayers;
			playerNumber = newPlayerNumber;
			dayNumber = newDayNumber;
			currentDay = newCurrentDay;
			actionPoints = newActionPoints;
			return true;
		} else {
			return false;
		}
	}
}
