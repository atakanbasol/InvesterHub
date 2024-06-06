package investorHub.businessAccess;

import investorHub.entity.Customer;

public interface CustomerService {

	void getAll();
	
	void add(Customer customer);
	
	void updatePassword(Customer customer);
	
	void deleteCustomer(Customer customer);
}
