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
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import com.pizzacontrol.model.Customer;
import com.pizzacontrol.utils.ExtJTable;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;

public class BaseView extends JFrame implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 4549469789387173806L;
	private HashMap<String, ArrayList<JMenuItem>> menuItems;
	private JDesktopPane desktopPane;
	private Customers customers;

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

		JMenu mainMenu = new JMenu(Messages.getString("BaseView.file")); //$NON-NLS-1$
		menuBar.add(mainMenu);

		if(menuItems.get("File") == null) {
			menuItems.put("File", new ArrayList<JMenuItem>());
		}

		menuItems.get("File").add(new JMenuItem(Messages.getString("BaseView.new"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		menuItems.get("File").add(new JMenuItem(Messages.getString("BaseView.open"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JSeparator separator = new JSeparator();
		mainMenu.add(separator);

		menuItems.get("File").add(new JMenuItem(Messages.getString("BaseView.save"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		menuItems.get("File").add(new JMenuItem(Messages.getString("BaseView.close"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JSeparator separator_1 = new JSeparator();
		mainMenu.add(separator_1);

		menuItems.get("File").add(new JMenuItem(Messages.getString("BaseView.quit"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JMenu mnKunden = new JMenu(Messages.getString("BaseView.customers")); //$NON-NLS-1$
		menuBar.add(mnKunden);

		menuItems.put("Customers", new ArrayList<JMenuItem>());

		menuItems.get("Customers").add(new JMenuItem("Alle Kunden anzeigen")); //$NON-NLS-1$
		mnKunden.add(menuItems.get("Customers").get(menuItems.get("Customers").size() - 1));

		menuItems.get("Customers").add(new JMenuItem("Kunde Anzeigen")); //$NON-NLS-1$
		mnKunden.add(menuItems.get("Customers").get(menuItems.get("Customers").size() - 1));

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

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Test: " + arg.toString());
		HashMap<?, ?> objMap = (HashMap<?, ?>) arg;
		if (objMap.containsKey("allCustomers")) {
			customers.updateCustomerTableModel((ArrayList<Customer>) objMap.get("allCustomers"));
		}
	}

	public void addAL(ActionListener controller) {
		System.out.println(Messages.getString("BaseView.vac")); //$NON-NLS-1$

		menuItems.get("File").forEach(item -> {
			System.out.println(item.getName());
			item.addActionListener(controller);
		});

		menuItems.get("Customers").forEach(item -> {
			System.out.println(item.getName());
			item.addActionListener(controller);
		});
	} // addController()

	public void showCustomers(ListSelectionListener controller)
	{
		this.customers = new Customers();
		customers.getCustomerTable().getSelectionModel().addListSelectionListener(controller);
		desktopPane.add(customers);
	}

	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		} // windowClosing()
	} // CloseListener
}
