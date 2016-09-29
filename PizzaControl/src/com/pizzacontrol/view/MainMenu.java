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
public class MainMenu extends JMenu {

	/**
	 *
	 */
	private static final long serialVersionUID = -250856970889979521L;
	private ArrayList<JMenuItem> menuItems;

	/**
	 * @param s
	 */
	public MainMenu() {
		super(Messages.getString("BaseView.file"));

		menuItems = new ArrayList<JMenuItem>();

		menuItems.add(new JMenuItem(Messages.getString("BaseView.new"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));

		menuItems.add(new JMenuItem(Messages.getString("BaseView.open"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));

		JSeparator separator = new JSeparator();
		add(separator);

		menuItems.add(new JMenuItem(Messages.getString("BaseView.save"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));

		menuItems.add(new JMenuItem(Messages.getString("BaseView.close"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));

		JSeparator separator_1 = new JSeparator();
		add(separator_1);

		menuItems.add(new JMenuItem(Messages.getString("BaseView.quit"))); //$NON-NLS-1$
		add(menuItems.get(menuItems.size() - 1));
	}

	public void addActionListener(ActionListener controller) {
		menuItems.forEach(item -> {
			item.addActionListener(controller);
		});
	} // addController()
}
