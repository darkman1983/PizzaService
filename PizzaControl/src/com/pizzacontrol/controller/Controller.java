package com.pizzacontrol.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.pizzacontrol.model.BaseModel;
import com.pizzacontrol.utils.ExtJTable;
import com.pizzacontrol.view.BaseView;

//Controller.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

//Controller is a Listener

public class Controller implements ActionListener, ListSelectionListener, MouseListener {

	// Joe: Controller has BaseModel and BaseView hardwired in
	BaseModel model;
	BaseView view;

	public Controller() {
		System.out.println("Controller()");
	} // Controller()

	// invoked when a button is pressed
	public void actionPerformed(ActionEvent e) {
		// uncomment to see what action happened at view
		/**/
		System.out.println("Controller: The " + e.getActionCommand() + " button is clicked at "
				+ new java.util.Date(e.getWhen()) + " with e.paramString " + e.paramString());
		/**/

		switch (e.getActionCommand()) {
		case "Beenden":
			System.exit(0);
			break;
		case "Alle Kunden anzeigen":
			view.showCustomers(this);
			view.addMouseListener(this);
			model.updateAllCustomers();
			break;
		case "Kunde anzeigen":
			if(view.isCustomersVisible() && view.getSelectedCustomer() != null && !view.getSelectedCustomer().isEmpty())
				view.showCustomer();
			if(view.getSelectedCustomer() == null || view.getSelectedCustomer().isEmpty() || !view.isCustomersVisible())
				view.showMessage("Sie haben keinen Kunden ausgewählt!", "Information", JOptionPane.INFORMATION_MESSAGE);
			if(view.isCustomersVisible())
				model.updateCustomerViewData(view.getSelectedCustomer());
			break;
		}
	} // actionPerformed()

	// Joe I should be able to add any model/view with the correct API
	// but here I can only add BaseModel/BaseView
	public void addModel(BaseModel m) {
		System.out.println("Controller: adding model");
		this.model = m;
	} // addModel()

	public void addView(BaseView v) {
		System.out.println("Controller: adding view");
		this.view = v;
	} // addView()

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
            return;
        }

		DefaultListSelectionModel model = (DefaultListSelectionModel) e.getSource();
		ListSelectionListener[] listeners = model.getListSelectionListeners();
	    for (ListSelectionListener listener : listeners) {
	        if (listener instanceof ExtJTable) {
	        	ExtJTable table = ((ExtJTable)listener);
	        	System.out.println("The table ID is: " + table.getTableID());
	        	System.out.println("The selected row is: " + table.getSelectedRow());
	        	System.out.println("The Customer ID is: " + table.getModel().getValueAt(table.getSelectedRow(), 0));
	        }
	    }
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		ExtJTable table = (ExtJTable) me.getSource();
        /*Point p = me.getPoint();
        int row = table.rowAtPoint(p);*/

        if (me.getClickCount() == 2) {
            System.out.println("Mouse clicked: " + me.getClickCount());

            switch(table.getTableID()) {
            case "customerTable":
            	view.showCustomer();
    			model.updateCustomerViewData(view.getSelectedCustomer());
            	break;
            }
        }
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
} // Controller
