package com.epam.module1.core;

import com.epam.module1.core.spring.beans.Client;

//violation YAGNI
//violation of interface segregation principle
public interface ClientService {

	public boolean saveCurrentClient(String message, int id);

	public boolean deleteCurrentClient(int id);
	
	public boolean updateCurrentClient(String message, int id);
	
	public Client loadClient(int id);
	
	/**
	 * violation of interface segregation principle
	 * @param client
	 */
	public void registerCustomerToEvent(Client client);
	
	public void unregisterCustomerFromEvent(Client client);
	
}
