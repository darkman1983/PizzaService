package com.pizzacontrol.view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Color;

public class View implements Observer {

	private JFrame frmPizzaService;
	private ArrayList<JMenuItem> menuItems;

	/**
	 * Create the application.
	 */
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPizzaService = new JFrame();
		menuItems = new ArrayList<JMenuItem>();

		/*
		 * String[] columnNames = {"First Name", "Last Name", "Sport",
		 * "# of Years", "Vegetarian"};
		 *
		 * Object[][] data = { {"Kathy", "Smith", "Snowboarding", new
		 * Integer(5), new Boolean(false)}, {"John", "Doe", "Rowing", new
		 * Integer(3), new Boolean(true)}, {"Sue", "Black", "Knitting", new
		 * Integer(2), new Boolean(false)}, {"Jane", "White", "Speed reading",
		 * new Integer(20), new Boolean(true)}, {"Joe", "Brown", "Pool", new
		 * Integer(10), new Boolean(false)} };
		 */

		frmPizzaService
				.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/images/Pizza-icon.png")));
		frmPizzaService.setTitle("Pizza Service");
		frmPizzaService.setBounds(100, 100, 800, 600);
		// frmPizzaService.setExtendedState(frmPizzaService.getExtendedState() |
		// JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		frmPizzaService.setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu("Datei");
		menuBar.add(mainMenu);

		menuItems.add(new JMenuItem("Neu"));
		// System.out.println("MenuItems: " + menuItems);
		mainMenu.add(menuItems.get(menuItems.size() - 1));

		menuItems.add(new JMenuItem("\u00D6ffnen"));
		mainMenu.add(menuItems.get(menuItems.size() - 1));

		JSeparator separator = new JSeparator();
		mainMenu.add(separator);

		menuItems.add(new JMenuItem("Speichern"));
		mainMenu.add(menuItems.get(menuItems.size() - 1));

		menuItems.add(new JMenuItem("Schlie\u00DFen"));
		mainMenu.add(menuItems.get(menuItems.size() - 1));

		JSeparator separator_1 = new JSeparator();
		mainMenu.add(separator_1);

		menuItems.add(new JMenuItem("Beenden"));
		mainMenu.add(menuItems.get(menuItems.size() - 1));

		JMenu mnKunden = new JMenu("Kunden");
		menuBar.add(mnKunden);

		JMenu mnBestellungen = new JMenu("Bestellungen");
		menuBar.add(mnBestellungen);

		JMenu mnRechnung = new JMenu("Rechnung");
		menuBar.add(mnRechnung);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frmPizzaService.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JInternalFrame orders = new JInternalFrame("Bestellungen");

		orders.setFrameIcon(new ImageIcon(View.class.getResource("/images/order.png")));
		orders.setResizable(true);
		orders.setIconifiable(true);
		orders.setMaximizable(true);
		orders.setBounds(10, 0, 764, 208);
		desktopPane.add(orders);
		try {
			orders.setMaximum(true);
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		orders.setVisible(true);

		JInternalFrame customers = new JInternalFrame("Kunden");
		customers.setFrameIcon(new ImageIcon(View.class.getResource("/images/customers-icon.png")));
		customers.setResizable(true);
		customers.setIconifiable(true);
		customers.setMaximizable(true);
		customers.setBounds(20, 116, 764, 208);
		desktopPane.add(customers);
		customers.setVisible(true);
		try {
			customers.setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JInternalFrame bills = new JInternalFrame("Rechnungen");
		bills.setFrameIcon(new ImageIcon(View.class.getResource("/images/bill.png")));
		bills.setMaximizable(true);
		bills.setIconifiable(true);
		bills.setResizable(true);
		bills.setBounds(10, 300, 764, 208);
		desktopPane.add(bills);
		bills.setVisible(true);
		try {
			bills.setIcon(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frmPizzaService.addWindowListener(new CloseListener());
		// Make the windows appear in Center of Screen
		frmPizzaService.setLocationRelativeTo(null);
		frmPizzaService.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void addController(ActionListener controller) {
		System.out.println("View      : adding controller");
		menuItems.forEach(item -> {
			item.addActionListener(controller);
		});
	} // addController()

	// to initialise TextField
	public void setValue(int v) {
		// myTextField.setText("" + v);
	} // setValue()

	// uncomment to allow controller to use view to initialise model
	// public void addModel(Model m){
	// System.out.println("View : adding model");
	// this.model = m;
	// } //addModel()

	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} // windowClosing()
	} // CloseListener
}
