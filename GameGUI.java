package dinosauria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFormattedTextField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private int playerNumber;
	private int dayNumber;
	private ArrayList<Player> players = new ArrayList<Player>();
	
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
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panelStart = new JPanel();
		panelStart.setLayout(null);
		panelStart.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelStart.setBackground(new Color(204, 255, 204));
		contentPane.add(panelStart, "START");
		
		JLabel startWelcomeText = new JLabel("Welcome to");
		startWelcomeText.setHorizontalAlignment(SwingConstants.CENTER);
		startWelcomeText.setFont(new Font("Tahoma", Font.ITALIC, 18));
		startWelcomeText.setBounds(0, 20, 633, 30);
		panelStart.add(startWelcomeText);
		
		JLabel startDinosaurImage = new JLabel("");
		startDinosaurImage.setIcon(new ImageIcon(GameGUI.class.getResource("/dinosauria/Edmontonia dinosaur.png")));
		startDinosaurImage.setHorizontalAlignment(SwingConstants.CENTER);
		startDinosaurImage.setBounds(0, 60, 633, 220);
		panelStart.add(startDinosaurImage);
		
		JLabel startTitleText = new JLabel("DINOSAURIA");
		startTitleText.setHorizontalAlignment(SwingConstants.CENTER);
		startTitleText.setFont(new Font("Times New Roman", Font.PLAIN, 64));
		startTitleText.setBounds(0, 280, 633, 70);
		panelStart.add(startTitleText);
		
		JButton startNewGameButton = new JButton("Start New Game");
		startNewGameButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startNewGameButton.setBounds(66, 355, 501, 30);
		panelStart.add(startNewGameButton);
		
		JButton startHelpButton = new JButton("Help");
		startHelpButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		startHelpButton.setBounds(66, 396, 501, 30);
		panelStart.add(startHelpButton);
		
		JPanel panelHelp = new JPanel();
		panelHelp.setLayout(null);
		panelHelp.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelHelp.setBackground(new Color(204, 255, 204));
		contentPane.add(panelHelp, "HELP");
		
		JLabel helpTitleText = new JLabel("Help");
		helpTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		helpTitleText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpTitleText.setBounds(10, 20, 100, 30);
		panelHelp.add(helpTitleText);
		
		JButton helpReturnButton = new JButton("Return to Menu");
		helpReturnButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpReturnButton.setBounds(66, 396, 501, 30);
		panelHelp.add(helpReturnButton);
		
		JTextArea helpHelpText = new JTextArea();
		helpHelpText.setBackground(new Color(204, 255, 204));
		helpHelpText.setLineWrap(true);
		helpHelpText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		helpHelpText.setWrapStyleWord(true);
		helpHelpText.setText("Dinosauria is a simple Java-based game developed by Robert Bruce and Brandon Lulham for the SENG201 \u2018Virtual Pets\u2019 assignment project. In the game, one to three players care for a small group of dinosaurs over a period of several days. Each player can have up to three dinosaurs, and the player who provides their dinosaurs with the best care will win the game.");
		helpHelpText.setBounds(10, 50, 613, 100);
		panelHelp.add(helpHelpText);
		
		JPanel panelSetup = new JPanel();
		panelSetup.setBackground(new Color(204, 255, 204));
		contentPane.add(panelSetup, "SETUP");
		panelSetup.setLayout(null);
		
		JButton setupContinue = new JButton("Continue");
		setupContinue.setBounds(66, 396, 501, 30);
		setupContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelSetup.add(setupContinue);
		
		JLabel setupTitleText = new JLabel("Start New Game");
		setupTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		setupTitleText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setupTitleText.setBounds(10, 20, 200, 30);
		panelSetup.add(setupTitleText);
		
		// Input mask for setupPlayerNumber text field.
		NumberFormatter validPlayerNumber = new NumberFormatter();
		validPlayerNumber.setMaximum(3);
		validPlayerNumber.setMinimum(1);
		
		JFormattedTextField setupPlayerNumber = new JFormattedTextField(validPlayerNumber);
		setupPlayerNumber.setBounds(262, 160, 100, 20);
		panelSetup.add(setupPlayerNumber);
		
		JLabel setupPlayerNumberText = new JLabel("Number of Players");
		setupPlayerNumberText.setHorizontalAlignment(SwingConstants.CENTER);
		setupPlayerNumberText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setupPlayerNumberText.setBounds(10, 140, 603, 20);
		panelSetup.add(setupPlayerNumberText);
		
		JLabel setupDayNumberText = new JLabel("Number of Days");
		setupDayNumberText.setHorizontalAlignment(SwingConstants.CENTER);
		setupDayNumberText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setupDayNumberText.setBounds(10, 230, 603, 20);
		panelSetup.add(setupDayNumberText);
		
		// Input mask for setupDayNumber text field.
		NumberFormatter validDayNumber = new NumberFormatter();
		validDayNumber.setMaximum(100);
		validDayNumber.setMinimum(1);
		
		JFormattedTextField setupDayNumber = new JFormattedTextField(validDayNumber);
		setupDayNumber.setBounds(262, 250, 100, 20);
		panelSetup.add(setupDayNumber);
		
		JLabel setupPlayerNumberDescText = new JLabel("(1 to 3)");
		setupPlayerNumberDescText.setHorizontalAlignment(SwingConstants.CENTER);
		setupPlayerNumberDescText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		setupPlayerNumberDescText.setBounds(10, 180, 603, 20);
		panelSetup.add(setupPlayerNumberDescText);
		
		JLabel setupDayNumberDescText = new JLabel("(1 to 100)");
		setupDayNumberDescText.setHorizontalAlignment(SwingConstants.CENTER);
		setupDayNumberDescText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		setupDayNumberDescText.setBounds(10, 270, 603, 20);
		panelSetup.add(setupDayNumberDescText);
		
		JPanel panelNewPlayer = new JPanel();
		panelNewPlayer.setLayout(null);
		panelNewPlayer.setBackground(new Color(204, 255, 204));
		contentPane.add(panelNewPlayer, "NEWPLAYER");
		
		JButton newplayerContinueButton = new JButton("Continue");
		newplayerContinueButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newplayerContinueButton.setBounds(66, 396, 501, 30);
		panelNewPlayer.add(newplayerContinueButton);
		
		JLabel newplayerTitleText = new JLabel("Create Player " + (players.size() + 1));
		newplayerTitleText.setHorizontalAlignment(SwingConstants.LEFT);
		newplayerTitleText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newplayerTitleText.setBounds(10, 20, 200, 30);
		panelNewPlayer.add(newplayerTitleText);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(212, 70, 200, 20);
		panelNewPlayer.add(formattedTextField);
		
		JLabel label_1 = new JLabel("Player Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(10, 50, 603, 20);
		panelNewPlayer.add(label_1);
		
		JLabel newplayerPet1TitleText = new JLabel("Pet 1");
		newplayerPet1TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1TitleText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet1TitleText.setBounds(10, 90, 194, 20);
		panelNewPlayer.add(newplayerPet1TitleText);
		
		JLabel newPlayerPet2TitleText = new JLabel("Pet 2");
		newPlayerPet2TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newPlayerPet2TitleText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newPlayerPet2TitleText.setBounds(215, 90, 194, 20);
		panelNewPlayer.add(newPlayerPet2TitleText);
		
		JLabel newplayerPet3TitleText = new JLabel("Pet 3");
		newplayerPet3TitleText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3TitleText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet3TitleText.setBounds(419, 90, 194, 20);
		panelNewPlayer.add(newplayerPet3TitleText);
		
		JComboBox newplayerPet1Species = new JComboBox();
		newplayerPet1Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet1Species.setBounds(10, 110, 194, 20);
		panelNewPlayer.add(newplayerPet1Species);
		
		JComboBox newplayerPet2Species = new JComboBox();
		newplayerPet2Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet2Species.setBounds(215, 110, 194, 20);
		panelNewPlayer.add(newplayerPet2Species);
		
		JComboBox newplayerPet3Species = new JComboBox();
		newplayerPet3Species.setModel(new DefaultComboBoxModel(new String[] {"", "Tyrannosaurus", "Velociraptor", "Brachiosaurus", "Stegosaurus", "Gigantoraptor", "Troodon"}));
		newplayerPet3Species.setBounds(419, 110, 194, 20);
		panelNewPlayer.add(newplayerPet3Species);
		
		JLabel newplayerPet1NameText = new JLabel("Name");
		newplayerPet1NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1NameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet1NameText.setBounds(10, 140, 194, 20);
		newplayerPet1NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet1NameText);
		
		JLabel newplayerPet2NameText = new JLabel("Name");
		newplayerPet2NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet2NameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet2NameText.setBounds(215, 141, 194, 20);
		newplayerPet2NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet2NameText);
		
		JLabel newplayerPet3NameText = new JLabel("Name");
		newplayerPet3NameText.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3NameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet3NameText.setBounds(419, 141, 194, 20);
		newplayerPet3NameText.setVisible(false);
		panelNewPlayer.add(newplayerPet3NameText);
		
		JFormattedTextField newplayerPet1Name = new JFormattedTextField();
		newplayerPet1Name.setBounds(10, 160, 194, 20);
		newplayerPet1Name.setVisible(false);
		panelNewPlayer.add(newplayerPet1Name);
		
		JFormattedTextField newplayerPet2Name = new JFormattedTextField();
		newplayerPet2Name.setBounds(215, 160, 194, 20);
		newplayerPet2Name.setVisible(false);
		panelNewPlayer.add(newplayerPet2Name);
		
		JFormattedTextField newplayerPet3Name = new JFormattedTextField();
		newplayerPet3Name.setBounds(419, 160, 194, 20);
		newplayerPet3Name.setVisible(false);
		panelNewPlayer.add(newplayerPet3Name);
		
		JLabel newplayerPet1Image = new JLabel("IMAGE");
		newplayerPet1Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet1Image.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet1Image.setBounds(10, 190, 194, 90);
		newplayerPet1Image.setVisible(false);
		panelNewPlayer.add(newplayerPet1Image);
		
		JLabel newplayerPet2Image = new JLabel("IMAGE");
		newplayerPet2Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet2Image.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet2Image.setBounds(215, 190, 194, 90);
		newplayerPet2Image.setVisible(false);
		panelNewPlayer.add(newplayerPet2Image);
		
		JLabel newplayerPet3Image = new JLabel("IMAGE");
		newplayerPet3Image.setHorizontalAlignment(SwingConstants.CENTER);
		newplayerPet3Image.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet3Image.setBounds(419, 190, 194, 90);
		newplayerPet3Image.setVisible(false);
		panelNewPlayer.add(newplayerPet3Image);
		
		JTextArea newplayerPet1DescText = new JTextArea();
		newplayerPet1DescText.setWrapStyleWord(true);
		newplayerPet1DescText.setText("PET DESCRIPTION");
		newplayerPet1DescText.setLineWrap(true);
		newplayerPet1DescText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet1DescText.setBackground(new Color(204, 255, 204));
		newplayerPet1DescText.setBounds(10, 280, 194, 110);
		newplayerPet1DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet1DescText);
		
		JTextArea newplayerPet2DescText = new JTextArea();
		newplayerPet2DescText.setWrapStyleWord(true);
		newplayerPet2DescText.setText("PET DESCRIPTION");
		newplayerPet2DescText.setLineWrap(true);
		newplayerPet2DescText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet2DescText.setBackground(new Color(204, 255, 204));
		newplayerPet2DescText.setBounds(215, 280, 194, 110);
		newplayerPet2DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet2DescText);
		
		JTextArea newplayerPet3DescText = new JTextArea();
		newplayerPet3DescText.setWrapStyleWord(true);
		newplayerPet3DescText.setText("PET DESCRIPTION");
		newplayerPet3DescText.setLineWrap(true);
		newplayerPet3DescText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		newplayerPet3DescText.setBackground(new Color(204, 255, 204));
		newplayerPet3DescText.setBounds(419, 280, 194, 110);
		newplayerPet3DescText.setVisible(false);
		panelNewPlayer.add(newplayerPet3DescText);
		
		// EVENT HANDLERS FOR START
		startHelpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "HELP");
			}
		});
		
		startNewGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "SETUP");
			}
		});
		
		// EVENT HANDLERS FOR HELP
		helpReturnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
			    currentLayout.show(contentPane, "START");
			}
		});
		
		// EVENT HANDLERS FOR SETUP
		setupContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (setupPlayerNumber.getValue() == null || setupDayNumber.getValue() == null) {
					JOptionPane.showMessageDialog(contentPane, "Please enter a valid player number and day number.");
				} else {
					CardLayout currentLayout = (CardLayout)(contentPane.getLayout());
				    currentLayout.show(contentPane, "NEWPLAYER");
				}	
			}
		});
		
		// EVENT HANDLERS FOR NEW PLAYER
		newplayerPet1Species.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					System.out.print("YES\n");
				}
			}
		});
	}
}
