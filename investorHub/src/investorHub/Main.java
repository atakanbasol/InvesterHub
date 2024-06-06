package investorHub;

import investorHub.businessAccess.CustomerManager;
import investorHub.dataAccess.JdbcCustomerDal;


public class Main {

    public static void main(String[] args) {

        JdbcCustomerDal customerDal = new JdbcCustomerDal();
        CustomerManager customerManager = new CustomerManager(new JdbcCustomerDal());
        
        //get
        customerManager.getAll();
        
        //add
        //customerManager.add(new Customer("Atakan", "atakan@gmail.com","123456"));
        
        //update(id,new password)
        //customerManager.updatePassword(new Customer(9,"987"));
        
        //delete (id)
        //customerManager.deleteCustomer(new Customer(9));
        
        //bağlantilari kapatma
        customerDal.connectionClose();
    }
}
