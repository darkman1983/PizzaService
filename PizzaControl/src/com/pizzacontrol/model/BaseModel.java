package com.pizzacontrol.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import com.pizzacontrol.dao.DAOFactory;

//BaseModel.java
//(C) Joseph Mack 2011, jmack (at) wm7d (dot) net, released under GPL v3 (or any later version)

//inspired by Joseph Bergin's MVC gui at http://csis.pace.edu/~bergin/mvc/mvcgui.html

//BaseModel holds an int counter (that's all it is).
//BaseModel is an Observable
//BaseModel doesn't know about BaseView or Controller

public class BaseModel extends Observable {

	private int counter;	//primitive, automatically initialised to 0

	public BaseModel(){

		//System.out.println("BaseModel()");

		/**
		Problem initialising both model and view:

		On a car you set the speedometer (view) to 0 when the car (model) is stationary.
		In some circles, this is called calibrating the readout instrument.
		In this MVC example, you would need two separate pieces of initialisation code,
			in the model and in the view. If you changed the initialisation value in one
			you'd have to remember (or know) to change the initialisation value in the other.
			A recipe for disaster.

		Alternately, when instantiating model, you could run

		setValue(0);

		as part of the constructor, sending a message to the view.
		This requires the view to be instantiated before the model,
		otherwise the message will be send to null (the unitialised value for view).
		This isn't a particularly onerous requirement, and is possibly a reasonable approach.

		Alternately, have RunMVC tell the view to intialise the model.
		The requires the view to have a reference to the model.
		This seemed an unneccesary complication.

		I decided instead in RunMVC, to instantiate model, view and controller, make all the connections,
		then since the Controller already has a reference to the model (which it uses to alter the status of the model),
		to initialise the model from the controller and have the model automatically update the view.
		*/

	} //BaseModel()

	public void updateAllCustomers() {
		HashMap<String, ArrayList<?>> tmpMap = new HashMap<String, ArrayList<?>>();
		tmpMap.put("allCustomers", DAOFactory.getDAOFactory(DAOFactory.MYSQL).getCustomerDAO().selectAllCustomers());
		setChanged();
		notifyObservers(tmpMap);
	}

	public void updateCustomerViewData (String id) {
		HashMap<String, Customer> tmpMap = new HashMap<String, Customer>();
		tmpMap.put("customerData", DAOFactory.getDAOFactory(DAOFactory.MYSQL).getCustomerDAO().findCustomer(id));
		setChanged();
		notifyObservers(tmpMap);
	}

} //BaseModel
