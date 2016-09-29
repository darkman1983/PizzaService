/**
 *
 */
package com.pizzacontrol.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.pizzacontrol.dao.DAOFactory;
import com.pizzacontrol.model.Customer;
import com.pizzacontrol.utils.ExtJTable;

/**
 * @author Der_B
 *
 */
public class Customers extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -3852790315908974890L;
	private ExtJTable customerTable;
	private String[] customerTableColumnNames = { "ID", "Name", "Vorname", "Benutzername", "Passwort", "email",
			"Straﬂe", "Hausnummer", "Postleitzahl", "Ort", "Telefon", "Mobil" };

	public Customers() {
		super(Messages.getString("BaseView.customers"));

		setFrameIcon(new ImageIcon(BaseView.class.getResource("/images/customers-icon.png"))); //$NON-NLS-1$
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(20, 116, 764, 208);
		setClosable(true);

		customerTable = new ExtJTable("customerTable");
		customerTable.setFont(new Font("Arial", Font.PLAIN, 10));
		customerTable.setFillsViewportHeight(true);
		customerTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // this is obvious part
		getContentPane().add(new JScrollPane(customerTable), BorderLayout.CENTER);

		setVisible(true);
	}

	private DefaultTableModel customerTableModel(ArrayList<Customer> customers) {
		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(this.customerTableColumnNames);

		for (Customer customer : customers) {
			Object[] rowData = { customer.getId(), customer.getName(), customer.getFirstname(), customer.getUsername(),
					customer.getPassword(), customer.getEmail(), customer.getStreet(), customer.getHousenumber(),
					customer.getZip(), customer.getCity(), customer.getPhone(), customer.getMobile() };

			model.addRow(rowData);
		}

		return model;
	}

	/**
	 * @return the customerTable
	 */
	public ExtJTable getCustomerTable() {
		return customerTable;
	}

	public void updateCustomerTableModel(ArrayList<Customer> customers) {
		customerTable.setModel(customerTableModel(customers));
	}
}
