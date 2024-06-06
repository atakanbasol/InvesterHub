package investorHub.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import investorHub.entity.Customer;

public class JdbcCustomerDal implements CustomerDal {

    private DbHelper helper;
    private Connection connection;
    private Statement statement = null;
    private ResultSet resultSet = null;

    // Constructor
    public JdbcCustomerDal() {
        helper = new DbHelper();
        try {
            connection = helper.getConnection();
            System.out.println("Bağlantı oluşturuldu.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }
    
    public void connectionClose() {
    	try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    	
    }

    @Override
    public void getAll() {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers");
            ArrayList<Customer> customerInfo = new ArrayList<Customer>();
            while (resultSet.next()) {
                customerInfo.add(new Customer(resultSet.getInt("id"), 
                							  resultSet.getString("name"),
                							  resultSet.getString("email"), 
                							  resultSet.getString("password")));
            }
            for (Customer customer : customerInfo) {
                System.out.println(customer);
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    @Override
    public void add(Customer customer) {
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO customers (name, email, password) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            int result = preparedStatement.executeUpdate(); //SQL komutunu çalıştırı ve etkilenen satır sayısını döner
            System.out.println("Kayıt eklendi, etkilenen satır sayısı: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } 
    }

	@Override
	public void updatePassword(Customer customer) {
        PreparedStatement preparedStatement = null;

        try {
            String sql = "update customers set password = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer.getPassword());
            preparedStatement.setInt(2,customer.getId());
            int result = preparedStatement.executeUpdate(); //SQL komutunu çalıştırı ve etkilenen satır sayısını döner
            System.out.println("Kayıt güncellendi, etkilenen satır sayısı: " + result);
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } 
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		PreparedStatement preparedStatement = null;

        try {
            String sql = "delete from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,customer.getId());
            int result = preparedStatement.executeUpdate(); //SQL komutunu çalıştırı ve etkilenen satır sayısını döner
            if(result>0) {
            	System.out.println("Kayıt silindi, etkilenen satır sayısı: " + result);
            }
            else {
            	System.out.println(customer.getId()+ " " + "Numaralı müşteri kaydı bulunamadı.");
            }
            
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } 		
	}
}
