package investorHub.businessAccess;

import investorHub.dataAccess.CustomerDal;
import investorHub.entity.Customer;

public class CustomerManager implements CustomerService{
	
	private CustomerDal customerDal;
	
	public CustomerManager(CustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	@Override
	public void getAll() {
		this.customerDal.getAll();
		
	}

	@Override
	public void add(Customer customer) {
		this.customerDal.add(customer);
		
	}

	@Override
	public void updatePassword(Customer customer) {
		this.customerDal.updatePassword(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		this.customerDal.deleteCustomer(customer);
		
	}

}
