package com.pizzacontrol.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.pizzacontrol.model.BaseModel;
import com.pizzacontrol.utils.ExtJTable;
import com.pizzacontrol.view.View;

//Controller.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

//Controller is a Listener

public class Controller implements ActionListener, TableModelListener {

	// Joe: Controller has BaseModel and View hardwired in
	BaseModel model;
	View view;

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
		}

		System.out.println("Controller: acting on BaseModel");
	} // actionPerformed()

	// Joe I should be able to add any model/view with the correct API
	// but here I can only add BaseModel/View
	public void addModel(BaseModel m) {
		System.out.println("Controller: adding model");
		this.model = m;
	} // addModel()

	public void addView(View v) {
		System.out.println("Controller: adding view");
		this.view = v;
	} // addView()

	public void initModel(int x) {
		model.setValue(x);
	} // initModel()

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Controller: Some table action was performed... \nThe table was: " + e.toString());

		AbstractTableModel model = (AbstractTableModel) e.getSource();
	    TableModelListener[] listeners = model.getTableModelListeners();
	    for (TableModelListener listener : listeners) {
	        if (listener instanceof ExtJTable) {
	        	System.out.println("The table ID is: " + ((ExtJTable)listener).getTableID());
	        	System.out.println(((ExtJTable)listener).toString());
	            System.out.println(((ExtJTable)listener).getName());
	        }
	    }
	}

} // Controller
