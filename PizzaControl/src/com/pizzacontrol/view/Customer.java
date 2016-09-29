/**
 *
 */
package com.pizzacontrol.view;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 * @author Der_B
 *
 */
public class Customer extends JInternalFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 5071801815743066837L;
	private JTextField customerID;
	private JTextField customerFirstname;
	private JTextField customerName;
	private JTextField customerStreet;
	private JTextField customerHousenumber;
	private JTextField customerZip;
	private JTextField customerCity;
	private JTextField customerPhone;
	private JTextField customerMobile;
	private JTextField customerEmail;
	private JTextField customerUsername;
	private JTextField customerPassword;

	public Customer() {
		super("Kunde");

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel general = new JPanel();
		tabbedPane.addTab("Allgemein", null, general, null);
		general.setLayout(null);

		JLabel LabelID = new JLabel("ID");
		LabelID.setHorizontalAlignment(SwingConstants.RIGHT);
		LabelID.setBounds(10, 11, 69, 14);
		general.add(LabelID);

		customerID = new JTextField();
		customerID.setEditable(false);
		customerID.setBounds(89, 8, 86, 20);
		general.add(customerID);
		customerID.setColumns(10);

		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setBounds(10, 36, 69, 14);
		general.add(lblVorname);

		customerFirstname = new JTextField();
		customerFirstname.setBounds(89, 33, 86, 20);
		general.add(customerFirstname);
		customerFirstname.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(185, 36, 50, 14);
		general.add(lblNachname);

		customerName = new JTextField();
		customerName.setBounds(245, 33, 86, 20);
		general.add(customerName);
		customerName.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 117, 675, 2);
		general.add(separator);

		JLabel lblRechnungsAdresse = new JLabel("Rechnungs Adresse");
		lblRechnungsAdresse.setBounds(10, 171, 95, 14);
		general.add(lblRechnungsAdresse);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 185, 675, 2);
		general.add(separator_1);

		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setBounds(10, 199, 54, 14);
		general.add(lblStrasse);

		customerStreet = new JTextField();
		customerStreet.setBounds(74, 196, 120, 20);
		general.add(customerStreet);
		customerStreet.setColumns(10);

		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHausnummer.setBounds(204, 199, 62, 14);
		general.add(lblHausnummer);

		customerHousenumber = new JTextField();
		customerHousenumber.setBounds(276, 196, 40, 20);
		general.add(customerHousenumber);
		customerHousenumber.setColumns(10);

		JLabel lblPostleitzahl = new JLabel("Postleitzahl");
		lblPostleitzahl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostleitzahl.setBounds(10, 224, 54, 14);
		general.add(lblPostleitzahl);

		customerZip = new JTextField();
		customerZip.setBounds(74, 221, 60, 20);
		general.add(customerZip);
		customerZip.setColumns(10);

		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setBounds(204, 224, 62, 14);
		general.add(lblOrt);

		customerCity = new JTextField();
		customerCity.setBounds(276, 221, 100, 20);
		general.add(customerCity);
		customerCity.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(18, 61, 61, 14);
		general.add(lblTelefon);

		customerPhone = new JTextField();
		customerPhone.setBounds(89, 58, 86, 20);
		general.add(customerPhone);
		customerPhone.setColumns(10);

		JLabel lblMobil = new JLabel("Mobil");
		lblMobil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobil.setBounds(185, 61, 50, 14);
		general.add(lblMobil);

		customerMobile = new JTextField();
		customerMobile.setBounds(245, 58, 86, 20);
		general.add(customerMobile);
		customerMobile.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(341, 61, 24, 14);
		general.add(lblEmail);

		customerEmail = new JTextField();
		customerEmail.setBounds(375, 58, 86, 20);
		general.add(customerEmail);
		customerEmail.setColumns(10);

		JLabel lblLoginDaten = new JLabel("Login Daten");
		lblLoginDaten.setBounds(10, 103, 95, 14);
		general.add(lblLoginDaten);

		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(10, 130, 69, 14);
		general.add(lblBenutzername);

		customerUsername = new JTextField();
		customerUsername.setBounds(89, 127, 105, 20);
		general.add(customerUsername);
		customerUsername.setColumns(10);

		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(220, 130, 46, 14);
		general.add(lblPasswort);

		customerPassword = new JTextField();
		customerPassword.setBounds(276, 127, 100, 20);
		general.add(customerPassword);
		customerPassword.setColumns(10);

		JPanel deliveryAdresses = new JPanel();
		tabbedPane.addTab("Lieferadressen", null, deliveryAdresses, null);
	}
}
