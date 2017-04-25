/**
 * GameGUI.java
 * 
 * DESCRIPTION
 * 
 * @author Robert Bruce
 * @version 0.4
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
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ItemListener;

public class GameGUI extends JFrame {

	private JPanel contentPane;
		
	private static int playerNumber;
	private static int dayNumber;
	private static int currentDay = 1;
	private static int actionPoints = 2;
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
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
		contentPane.setBackground(Color.RED);
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
		gameSaveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				SaveLoad.saveGame("test", players, playerNumber, dayNumber, currentDay, actionPoints);
			}
		});
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
		
		JLabel gameActionPointsText = new JLabel("Action Points Remaining: " + actionPoints);
		gameActionPointsText.setHorizontalAlignment(SwingConstants.CENTER);
		gameActionPointsText.setFont(new Font("Tahoma", Font.BOLD, 14));
		gameActionPointsText.setBounds(1048, 20, 200, 30);
		panelGame.add(gameActionPointsText);
		
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
							playerNumber = 0;
							CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
							currentLayout.show(contentPane, "GAME");
							gameTitle.setText("Day " + currentDay + " - " + players.get(playerNumber).getName());
							displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3);
						}
					}
				}
			}
		});
		
		//TEST HANDLER
		startLoadButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SaveLoad.loadGame("test");
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
				currentLayout.show(contentPane, "GAME");
				gameTitle.setText("Day " + currentDay + " - " + players.get(playerNumber).getName());
				displayGameSpace(panelGamePet1, panelGamePet2, panelGamePet3);
			}
		});
	}
	
	//private void displayPet
	
	private void displayGamePet (JPanel panel, Pet pet)
	{
		((JLabel) panel.getComponent(0)).setIcon(pet.getImage()); // Image.
		((JLabel) panel.getComponent(1)).setText(pet.getName()); // Name.
		((JLabel) panel.getComponent(2)).setText(pet.getMood()); // Mood.
		
		// Display Boredom
		((JLabel) panel.getComponent(9)).setBounds(95, 220, pet.getBoredom() * 3, 20);
		((JLabel) panel.getComponent(9)).setBackground(getBarColour(pet.getBoredom()));
		
		// Display Fatigue
		((JLabel) panel.getComponent(11)).setBounds(95, 250, pet.getFatigue() * 3, 20);
		((JLabel) panel.getComponent(11)).setBackground(getBarColour(pet.getFatigue()));
		
		// Display Hunger
		((JLabel) panel.getComponent(13)).setBounds(95, 280, pet.getHunger() * 3, 20);
		((JLabel) panel.getComponent(13)).setBackground(getBarColour(pet.getHunger()));
		
		// Display Bladder
		((JLabel) panel.getComponent(15)).setBounds(95, 310, pet.getBladder() * 3, 20);
		((JLabel) panel.getComponent(15)).setBackground(getBarColour(pet.getBladder()));
		
		// Display Weight
		double normalWeight = pet.getWeight() / pet.getSpeciesWeight();
		if (normalWeight >= 1.0) {
			normalWeight = (normalWeight - 1) * 1500;
			((JLabel) panel.getComponent(18)).setBounds(345, 340, (int) normalWeight, 20);
		} else {
			normalWeight = (normalWeight - 1) * -1500;
			((JLabel) panel.getComponent(18)).setBounds(345 - (int) normalWeight, 340, (int) normalWeight, 20);
		}
	}
	
	private Color getBarColour(int barValue)
	{
		// Division by 100.1 to prevent invalid Color parameters.
		float red = (float) (0.0 + (barValue / 100.1));
		float green = (float) (1.0 - (barValue / 100.1));
		
		return new Color(red, green, (float) 0.0);
	}
	
	private void displayGameSpace(JPanel pet1, JPanel pet2, JPanel pet3)
	{
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
