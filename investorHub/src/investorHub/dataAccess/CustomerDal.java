package investorHub.dataAccess;

import investorHub.entity.Customer;

public interface CustomerDal {
	
	void getAll();
	
	void add(Customer customer);
	
	void updatePassword(Customer customer);
	
	void deleteCustomer(Customer customer);

}
