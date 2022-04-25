import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Commande extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarque;
	private JTextField txtModele;
	private JTextField txtDate;
	private JTextField txtCouleur;
	private JTextField txtPrix;
	private JTextField txtQuantite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commande frame = new Commande();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Commande() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 965, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marque");
		lblNewLabel.setBounds(53, 10, 142, 34);
		panel.add(lblNewLabel);
		
		JLabel lblModele = new JLabel("Modele");
		lblModele.setBounds(53, 81, 142, 34);
		panel.add(lblModele);
		
		JLabel lblDateDeFabrication = new JLabel("Date de Fabrication");
		lblDateDeFabrication.setBounds(53, 157, 142, 34);
		panel.add(lblDateDeFabrication);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setBounds(53, 225, 142, 34);
		panel.add(lblCouleur);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setBounds(53, 295, 142, 34);
		panel.add(lblPrix);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setBounds(53, 368, 142, 34);
		panel.add(lblQuantite);
		
		txtMarque = new JTextField();
		txtMarque.setBounds(223, 11, 201, 34);
		panel.add(txtMarque);
		txtMarque.setColumns(10);
		
		txtModele = new JTextField();
		txtModele.setColumns(10);
		txtModele.setBounds(223, 81, 201, 34);
		panel.add(txtModele);
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		txtDate.setBounds(223, 157, 201, 34);
		panel.add(txtDate);
		
		txtCouleur = new JTextField();
		txtCouleur.setColumns(10);
		txtCouleur.setBounds(223, 233, 201, 34);
		panel.add(txtCouleur);
		
		txtPrix = new JTextField();
		txtPrix.setColumns(10);
		txtPrix.setBounds(223, 303, 201, 34);
		panel.add(txtPrix);
		
		txtQuantite = new JTextField();
		txtQuantite.setColumns(10);
		txtQuantite.setBounds(223, 376, 201, 34);
		panel.add(txtQuantite);
		
		JButton btnNewButton = new JButton("Commander");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				commande();
			}
		});
		btnNewButton.setBounds(772, 415, 159, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Commande de Voiture");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(556, 21, 375, 81);
		panel.add(lblNewLabel_1);
	}
	
	static Connection con () {
		try {
			String drive ="com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost/cybercar";
			Class.forName(drive);
			return DriverManager.getConnection(url,"root","");
		}catch(Exception e) {
			System.out.println("error de connection" + e);
		}
		return null;
	}
	
	private void commande() {
		Connection con = (Connection) con();
		try {
			String query = "INSERT INTO `commandevoiture`(`Marque`, `Modèle`, `Date_de_Fabrication`, `Couleur`, `Prix`,`Quantité`) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtMarque.getText() );
			ps.setString(2, txtModele.getText() );
			ps.setString(3, txtDate.getText() );
			ps.setString(4, txtCouleur.getText() );
			ps.setString(5, txtPrix.getText() );
			ps.setString(6, txtQuantite.getText() );
			ps.execute();

		} catch (Exception e) {
			System.out.println("error" + e);
		}
	}
}

