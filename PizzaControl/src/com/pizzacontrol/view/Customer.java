/**
 *
 */
package com.pizzacontrol.view;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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

		setFrameIcon(new ImageIcon(BaseView.class.getResource("/images/customers-icon.png"))); //$NON-NLS-1$
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(5, 120, 780, 335);
		setClosable(true);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);

		JPanel general = new JPanel();
		tabbedPane.addTab("Allgemein", null, general, null);
		general.setLayout(null);

		JLabel LabelID = new JLabel("ID");
		LabelID.setHorizontalAlignment(SwingConstants.RIGHT);
		LabelID.setBounds(115, 14, 69, 14);
		general.add(LabelID);

		customerID = new JTextField();
		customerID.setEditable(false);
		customerID.setBounds(194, 11, 86, 20);
		general.add(customerID);
		customerID.setColumns(10);

		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setBounds(115, 39, 69, 14);
		general.add(lblVorname);

		customerFirstname = new JTextField();
		customerFirstname.setBounds(194, 36, 86, 20);
		general.add(customerFirstname);
		customerFirstname.setColumns(10);

		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(336, 39, 50, 14);
		general.add(lblNachname);

		customerName = new JTextField();
		customerName.setBounds(396, 36, 86, 20);
		general.add(customerName);
		customerName.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 117, 780, 2);
		general.add(separator);

		JLabel lblRechnungsAdresse = new JLabel("Rechnungs Adresse");
		lblRechnungsAdresse.setBounds(29, 172, 95, 14);
		general.add(lblRechnungsAdresse);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 185, 780, 2);
		general.add(separator_1);

		JLabel lblStrasse = new JLabel("Strasse");
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setBounds(130, 202, 54, 14);
		general.add(lblStrasse);

		customerStreet = new JTextField();
		customerStreet.setBounds(194, 199, 120, 20);
		general.add(customerStreet);
		customerStreet.setColumns(10);

		JLabel lblHausnummer = new JLabel("Hausnummer");
		lblHausnummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHausnummer.setBounds(324, 202, 62, 14);
		general.add(lblHausnummer);

		customerHousenumber = new JTextField();
		customerHousenumber.setBounds(396, 199, 40, 20);
		general.add(customerHousenumber);
		customerHousenumber.setColumns(10);

		JLabel lblPostleitzahl = new JLabel("Postleitzahl");
		lblPostleitzahl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostleitzahl.setBounds(130, 227, 54, 14);
		general.add(lblPostleitzahl);

		customerZip = new JTextField();
		customerZip.setBounds(194, 224, 60, 20);
		general.add(customerZip);
		customerZip.setColumns(10);

		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setBounds(324, 227, 62, 14);
		general.add(lblOrt);

		customerCity = new JTextField();
		customerCity.setBounds(396, 224, 100, 20);
		general.add(customerCity);
		customerCity.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefon.setBounds(123, 64, 61, 14);
		general.add(lblTelefon);

		customerPhone = new JTextField();
		customerPhone.setBounds(194, 61, 86, 20);
		general.add(customerPhone);
		customerPhone.setColumns(10);

		JLabel lblMobil = new JLabel("Mobil");
		lblMobil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobil.setBounds(336, 64, 50, 14);
		general.add(lblMobil);

		customerMobile = new JTextField();
		customerMobile.setBounds(396, 61, 86, 20);
		general.add(customerMobile);
		customerMobile.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(505, 64, 24, 14);
		general.add(lblEmail);

		customerEmail = new JTextField();
		customerEmail.setBounds(539, 61, 86, 20);
		general.add(customerEmail);
		customerEmail.setColumns(10);

		JLabel lblLoginDaten = new JLabel("Login Daten");
		lblLoginDaten.setBounds(29, 104, 95, 14);
		general.add(lblLoginDaten);

		JLabel lblBenutzername = new JLabel("Benutzername");
		lblBenutzername.setBounds(115, 133, 69, 14);
		general.add(lblBenutzername);

		customerUsername = new JTextField();
		customerUsername.setBounds(194, 130, 105, 20);
		general.add(customerUsername);
		customerUsername.setColumns(10);

		JLabel lblPasswort = new JLabel("Passwort");
		lblPasswort.setBounds(340, 133, 46, 14);
		general.add(lblPasswort);

		customerPassword = new JTextField();
		customerPassword.setBounds(396, 130, 100, 20);
		general.add(customerPassword);
		customerPassword.setColumns(10);

		JPanel deliveryAdresses = new JPanel();
		tabbedPane.addTab("Lieferadressen", null, deliveryAdresses, null);

		setVisible(true);
	}

	public void updateCustomerData(com.pizzacontrol.model.Customer customer) {
		if(customer != null) {
			customerID.setText(customer.getId());
			customerFirstname.setText(customer.getFirstname());
			customerName.setText(customer.getName());
			customerStreet.setText(customer.getStreet());
			customerHousenumber.setText(customer.getHousenumber());
			customerZip.setText(customer.getZip());
			customerCity.setText(customer.getCity());
			customerPhone.setText(customer.getPhone());
			customerMobile.setText(customer.getMobile());
			customerEmail.setText(customer.getEmail());
			customerUsername.setText(customer.getUsername());
			customerPassword.setText(customer.getPassword());
		}
	}
}
