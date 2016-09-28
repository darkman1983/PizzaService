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
import com.pizzacontrol.utils.ExtJTable;
import javax.swing.event.TableModelListener;

public class View extends JFrame implements Observer {

	/**
	 *
	 */
	private static final long serialVersionUID = 4549469789387173806L;
	private HashMap<String, ArrayList<JMenuItem>> menuItems;
	private JDesktopPane desktopPane;

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
		menuItems = new HashMap<String, ArrayList<JMenuItem>>();

		this.setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/images/Pizza-icon.png"))); //$NON-NLS-1$
		this.setTitle(Messages.getString("View.ps")); //$NON-NLS-1$
		this.setBounds(100, 100, 800, 600);
		// this.setExtendedState(this.getExtendedState() |
		// JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu mainMenu = new JMenu(Messages.getString("View.file")); //$NON-NLS-1$
		menuBar.add(mainMenu);

		if(menuItems.get("File") == null) {
			menuItems.put("File", new ArrayList<JMenuItem>());
		}

		menuItems.get("File").add(new JMenuItem(Messages.getString("View.new"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		menuItems.get("File").add(new JMenuItem(Messages.getString("View.open"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JSeparator separator = new JSeparator();
		mainMenu.add(separator);

		menuItems.get("File").add(new JMenuItem(Messages.getString("View.save"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		menuItems.get("File").add(new JMenuItem(Messages.getString("View.close"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JSeparator separator_1 = new JSeparator();
		mainMenu.add(separator_1);

		menuItems.get("File").add(new JMenuItem(Messages.getString("View.quit"))); //$NON-NLS-1$
		mainMenu.add(menuItems.get("File").get(menuItems.get("File").size() - 1));

		JMenu mnKunden = new JMenu(Messages.getString("View.customers")); //$NON-NLS-1$
		menuBar.add(mnKunden);

		menuItems.put("Customers", new ArrayList<JMenuItem>());

		menuItems.get("Customers").add(new JMenuItem("Alle Kunden anzeigen")); //$NON-NLS-1$
		mnKunden.add(menuItems.get("Customers").get(menuItems.get("Customers").size() - 1));

		JMenu mnBestellungen = new JMenu(Messages.getString("View.orders")); //$NON-NLS-1$
		menuBar.add(mnBestellungen);

		JMenu mnRechnung = new JMenu(Messages.getString("View.bills")); //$NON-NLS-1$
		menuBar.add(mnRechnung);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		this.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JInternalFrame orders = new JInternalFrame(Messages.getString("View.orders"));
		orders.setFrameIcon(new ImageIcon(View.class.getResource("/images/order.png"))); //$NON-NLS-1$
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
		try {
			orders.setIcon(true);
		} catch (PropertyVetoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		orders.setVisible(true);

		JInternalFrame bills = new JInternalFrame(Messages.getString("View.bills"));
		bills.setFrameIcon(new ImageIcon(View.class.getResource("/images/bill.png"))); //$NON-NLS-1$
		bills.setMaximizable(true);
		bills.setIconifiable(true);
		bills.setResizable(true);
		bills.setBounds(10, 300, 764, 208);
		desktopPane.add(bills);
		bills.setVisible(true);
		try {
			bills.setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bills.setIcon(true);

			JLabel lblNewLabel = new JLabel(Messages.getString("View.lblNewLabel.text")); //$NON-NLS-1$
			getContentPane().add(lblNewLabel, BorderLayout.SOUTH);

			JLabel statusBar = new JLabel("Willkommen");
			Dimension dim = new Dimension();
			dim.setSize(statusBar.getBounds().x, 100);
			statusBar.setMinimumSize(dim);
			//statusBar.setBounds(statusBar.getBounds().x, statusBar.getBounds().y, statusBar.getBounds().width, 100);
			getContentPane().add(statusBar, BorderLayout.SOUTH);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.addWindowListener(new CloseListener());
		// Make the windows appear in Center of Screen
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void addAL(ActionListener controller) {
		System.out.println(Messages.getString("View.vac")); //$NON-NLS-1$

		menuItems.get("File").forEach(item -> {
			System.out.println(item.getName());
			item.addActionListener(controller);
		});

		menuItems.get("Customers").forEach(item -> {
			System.out.println(item.getName());
			item.addActionListener(controller);
		});
	} // addController()

	public void showCustomers()
	{
		desktopPane.add(new Customers());
	}

	public void addTML(TableModelListener controller)
	{
		//customerTable.getModel().addTableModelListener(controller);
	}

	// to initialise TextField
	public void setValue(int v) {
		// myTextField.setText("" + v);
	} // setValue()

	// uncomment to allow controller to use view to initialise model
	// public void addModel(BaseModel m){
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
