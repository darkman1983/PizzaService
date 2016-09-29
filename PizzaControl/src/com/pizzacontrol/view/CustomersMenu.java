/**
 *
 */
package com.pizzacontrol.view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/**
 * @author tstepputtis
 *
 */
public class CustomersMenu extends JMenu {

	/**
	 *
	 */
	private static final long serialVersionUID = 567359350894301680L;
	private ArrayList<JMenuItem> menuItems;

	/**
	 * @param s
	 */
	public CustomersMenu() {
		super(Messages.getString("CustomersMenu.customers"));

		menuItems = new ArrayList<JMenuItem>();

		menuItems.add(new JMenuItem(Messages.getString("CustomersMenu.showAll"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));

		menuItems.add(new JMenuItem(Messages.getString("CustomersMenu.show"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));
	}

	public void addActionListener(ActionListener controller) {
		menuItems.forEach(item -> {
			item.addActionListener(controller);
		});
	} // addController()
}
