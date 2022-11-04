import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Rekenmachine extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new Rekenmachine();
		frame.setSize(270, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new Rekenmachinepaneel());
		frame.setTitle("Rekenmachine");
		frame.setVisible(true);
	}
}


class Rekenmachinepaneel extends JPanel {
	private JTextField uitvoervak;
	private JButton knop7, knop8, knop9, deelKnop,
					knop4, knop5, knop6, vermenigvuldigKnop,
					knop1, knop2, knop3, plusKnop,
					knop0, resetKnop, isKnop, minusKnop;
	
	private int eersteNum,
				tweedeNum,
				resultaat;

	private String 	operation;
	
	
	public Rekenmachinepaneel() {
		setLayout(null);				// Ik heb de Layout uitgezet voor setBounds.
		setBackground(Color.WHITE);		// Achtergrondkleur = wit

		// Deze twee font stijlen zijn voor de knoppen heel belangrijk.
		Font fontstijl = new Font("SansSerif", Font.BOLD, 16);
		Font fontstijl2 = new Font("SansSerif", Font.BOLD, 18);
		
		// Uitvoervak voor rekenmachine.
		uitvoervak = new JTextField("");
		uitvoervak.setBounds(20, 20, 230, 55);	// Positie en 
		uitvoervak.setFont(new Font("MonoSpaced", Font.BOLD, 24));	// Font stijl voor het uitvoer
		uitvoervak.setHorizontalAlignment(JTextField.RIGHT);	// Zorgt ervoor dat tekst rechts uitgelijnd blijft

		// Knoppen voor het toetsenblok.
		// 1ste rij:
		knop7 = new JButton("7");					// Knop 7
		knop7.setFont(fontstijl);
		knop7.setBounds(20, 90, 50, 50);
		knop8 = new JButton("8");					// Knop 8
		knop8.setFont(fontstijl);
		knop8.setBounds(80, 90, 50, 50);
		knop9 = new JButton("9");					// Knop 9
		knop9.setFont(fontstijl);
		knop9.setBounds(140, 90, 50, 50);
		deelKnop = new JButton("/");				// Knop voor het delen
		deelKnop.setFont(fontstijl2);
		deelKnop.setBounds(200, 90, 50, 50);
		
		// 2e rij:
		knop4 = new JButton("4");					// Knop 4
		knop4.setFont(fontstijl);
		knop4.setBounds(20, 150, 50, 50);
		knop5 = new JButton("5");					// Knop 5
		knop5.setFont(fontstijl);
		knop5.setBounds(80, 150, 50, 50);
		knop6 = new JButton("6");					// Knop 6
		knop6.setFont(fontstijl);
		knop6.setBounds(140, 150, 50, 50);
		vermenigvuldigKnop = new JButton("*");		// Knop voor het vermenigvuldigen
		vermenigvuldigKnop.setFont(fontstijl2);
		vermenigvuldigKnop.setBounds(200, 150, 50, 50);
		
		// 3e rij:
		knop1 = new JButton("1");					// Knop 1
		knop1.setFont(fontstijl);
		knop1.setBounds(20, 210, 50, 50);
		knop2 = new JButton("2");					// Knop 2
		knop2.setFont(fontstijl);
		knop2.setBounds(80, 210, 50, 50);
		knop3 = new JButton("3");					// Knop 3
		knop3.setFont(fontstijl);
		knop3.setBounds(140, 210, 50, 50);
		plusKnop = new JButton("+");				// Knop voor het optellen
		plusKnop.setFont(fontstijl2);
		plusKnop.setBounds(200, 210, 50, 50);
		
		// 4e rij:
		knop0 = new JButton("0");					// Knop 0
		knop0.setFont(fontstijl);
		knop0.setBounds(20, 270, 50, 50);
		resetKnop = new JButton("C");				// Knop om het ingevoerde getal te "resetten"
		resetKnop.setFont(fontstijl2);
		resetKnop.setBounds(80, 270, 50, 50);
		isKnop = new JButton("=");					// Knop voor resultaat
		isKnop.setFont(fontstijl2);
		isKnop.setBounds(140, 270, 50, 50);
		minusKnop = new JButton("-");				// Knop voor het aftrekken
		minusKnop.setFont(fontstijl2);
		minusKnop.setBounds(200, 270, 50, 50);
		
		// link naar de bedrijfswebsite:
		ImageIcon logo = new ImageIcon("bin/Images/CSC_logo.png");
		JButton logoKnop = new JButton(logo);
		logoKnop.setBounds(20, 330, 230, 55);
		
		// Event handlers: 
		// Rij 1
		knop7.addActionListener(new Knop7H());
		knop8.addActionListener(new Knop8H());
		knop9.addActionListener(new Knop9H());
		deelKnop.addActionListener(new DeelKnopH());
		
		// Rij 2
		knop4.addActionListener(new Knop4H());
		knop5.addActionListener(new Knop5H());
		knop6.addActionListener(new Knop6H());
		vermenigvuldigKnop.addActionListener(new VmKnopH());
		
		// Rij 3
		knop1.addActionListener(new Knop1H());
		knop2.addActionListener(new Knop2H());
		knop3.addActionListener(new Knop3H());
		plusKnop.addActionListener(new PlusKnopH());
		
		// Rij 4
		knop0.addActionListener(new Knop0H());
		resetKnop.addActionListener(new ResetKnopH());
		isKnop.addActionListener(new IsKnopH());
		minusKnop.addActionListener(new MinusKnopH());
		
		// Link naar website
		logoKnop.addActionListener(new LogoKnopH());
		
		// Voeg objecten toe aan JFrame
		add(uitvoervak);
		add(knop7);		add(knop8);		add(knop9);		add(deelKnop);
		add(knop4);		add(knop5);		add(knop6);		add(vermenigvuldigKnop);
		add(knop1);		add(knop2);		add(knop3);		add(plusKnop);
		add(knop0);		add(resetKnop);	add(isKnop);	add(minusKnop);
		add(logoKnop);
	}
	
	// Klassen met ActionListener: maakt rekenmachine werkend
	
	class Knop7H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop7.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop8H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop8.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop9H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop9.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class DeelKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eersteNum = Integer.parseInt(uitvoervak.getText());
			uitvoervak.setText("");
			operation = "/";
		}
	}
	
	class Knop4H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop4.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop5H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop5.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop6H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop6.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class VmKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eersteNum = Integer.parseInt(uitvoervak.getText());
			uitvoervak.setText("");
			operation = "*";
		}
	}
	
	class Knop1H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop1.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop2H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop2.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class Knop3H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop3.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class PlusKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eersteNum = Integer.parseInt(uitvoervak.getText());
			uitvoervak.setText("");
			operation = "+";
		}
	}
	
	class Knop0H implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String Invoergetal = uitvoervak.getText() + knop0.getText();
			uitvoervak.setText(Invoergetal);
		}
	}
	
	class ResetKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			uitvoervak.setText(null);
		}
	}
	
	class IsKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String antwoord;
			tweedeNum = Integer.parseInt(uitvoervak.getText());
			if(operation == "+") {
				resultaat = eersteNum + tweedeNum;
				antwoord = String.format("%d", resultaat);
				uitvoervak.setText(antwoord);
			} if(operation == "-") {
				resultaat = eersteNum - tweedeNum;
				antwoord = String.format("%d", resultaat);
				uitvoervak.setText(antwoord);
			} if(operation == "*") {
				resultaat = eersteNum * tweedeNum;
				antwoord = String.format("%d", resultaat);
				uitvoervak.setText(antwoord);
			} if(operation == "/") {
				double resultaat = eersteNum / (double) tweedeNum;
				antwoord = String.format("%.1f", resultaat);
				uitvoervak.setText(antwoord);
			}
		}
	}
	
	class MinusKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			eersteNum = Integer.parseInt(uitvoervak.getText());
			uitvoervak.setText("");
			operation = "-";
		}
	}
	
	class LogoKnopH implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Desktop browser = Desktop.getDesktop();
			try {
				browser.browse(new URI("https://www.dxc.technology/nl"));
			} 
			catch(IOException err) {}
			catch(URISyntaxException err) {}
		}
	}
}