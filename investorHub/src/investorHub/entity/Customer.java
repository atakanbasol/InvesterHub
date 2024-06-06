
package investorHub.entity;

public class Customer {
	
	private int id;
	private String name;
	private String email;
	private String password;
	
    // Constructor with id
    public Customer(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Constructor without id
    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Constructor id and password
    public Customer(int id, String password) {
        this.id = id;
        this.password = password;
    }
    
    // Constructor only id
    public Customer(int id) {
        this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    // toString method
	// Bunu yapmazsak nesnelerin bellekteki adreslerini yazdırır.
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
