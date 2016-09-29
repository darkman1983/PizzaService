package com.pizzacontrol.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.ListSelectionListener;

//import com.pizzacontrol.model.Customer;

public class BaseView extends JFrame implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 4549469789387173806L;
	private HashMap<String, ArrayList<JMenuItem>> menuItems;
	private JDesktopPane desktopPane;
	private Customers customers;
	private Customer customer;
	private MainMenu mainMenu;
	private CustomersMenu customersMenu;

	/**
	 * Create the application.
	 */
	public BaseView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuItems = new HashMap<String, ArrayList<JMenuItem>>();

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(BaseView.class.getResource("/images/Pizza-icon.png"))); //$NON-NLS-1$
		this.setTitle(Messages.getString("BaseView.ps")); //$NON-NLS-1$
		this.setBounds(100, 100, 800, 600);
		// this.setExtendedState(this.getExtendedState() |
		// JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		mainMenu = new MainMenu();
		menuBar.add(mainMenu);

		customersMenu = new CustomersMenu();
		menuBar.add(customersMenu);

		JMenu mnBestellungen = new JMenu(Messages.getString("BaseView.orders")); //$NON-NLS-1$
		menuBar.add(mnBestellungen);

		JMenu mnRechnung = new JMenu(Messages.getString("BaseView.bills")); //$NON-NLS-1$
		menuBar.add(mnRechnung);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JLabel statusBar = new JLabel("Willkommen");
		Dimension dim = new Dimension();
		dim.setSize(statusBar.getBounds().x, 100);
		statusBar.setMinimumSize(dim);
		//statusBar.setBounds(statusBar.getBounds().x, statusBar.getBounds().y, statusBar.getBounds().width, 100);
		getContentPane().add(statusBar, BorderLayout.SOUTH);

		this.addWindowListener(new CloseListener());
		// Make the windows appear in Center of Screen
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Test: " + arg.toString());
		HashMap<?, ?> objMap = (HashMap<?, ?>) arg;
		if (objMap.containsKey("allCustomers")) {
			customers.updateCustomerTableModel((ArrayList<com.pizzacontrol.model.Customer>) objMap.get("allCustomers"));
		}
		if (objMap.containsKey("customerData")) {
			customer.updateCustomerData((com.pizzacontrol.model.Customer) objMap.get("customerData"));
		}
	}

	public void addActionListener(ActionListener controller) {
		System.out.println(Messages.getString("BaseView.vac")); //$NON-NLS-1$

		mainMenu.addActionListener(controller);
		customersMenu.addActionListener(controller);
	} // addController()

	public void showCustomers(ListSelectionListener controller)
	{
		this.customers = new com.pizzacontrol.view.Customers();
		customers.getCustomerTable().getSelectionModel().addListSelectionListener(controller);
		desktopPane.add(customers, 10);

		try {
			customers.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showCustomer()
	{
		System.out.println("Showing Customer...");

		customer = new com.pizzacontrol.view.Customer();

		desktopPane.add(customer, 0);

		try {
			customers.setIcon(true);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			customer.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSelectedCustomer() {
		String res = null;

		try {
			res = (String) customers.getCustomerTable().getModel().getValueAt(customers.getCustomerTable().getSelectedRow(), 0);
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		return res;
	}

	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} // windowClosing()
	} // CloseListener
}
