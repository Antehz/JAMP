package com.epam.module1.core.impl;

import com.epam.module1.core.ClientService;
import com.epam.module1.core.spring.beans.Client;

//Separate service from Application
public class DefaultClientService implements ClientService {

	public boolean saveCurrentClient(String message, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteCurrentClient(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCurrentClient(String message, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Client loadClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerCustomerToEvent(Client client) {
		// TODO Auto-generated method stub

	}

	public void unregisterCustomerFromEvent(Client client) {
		// TODO Auto-generated method stub

	}

}
