import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblUser")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Embedded
	@AttributeOverrides({
	@AttributeOverride(column = @Column(name="localAddressDoorNumber"), name = "doorNumber"),
	@AttributeOverride(column = @Column(name="localAddressStreetName"), name = "streetName")})
	private Address local_address;
	
	@Embedded
	private Address permanent_address;
	
	public User() {

	}

	public User(String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public Address getLocal_address() {
		return local_address;
	}

	public void setLocal_address(Address local_address) {
		this.local_address = local_address;
	}

	public Address getPermanent_address() {
		return permanent_address;
	}

	public void setPermanent_address(Address permanent_address) {
		this.permanent_address = permanent_address;
	}
}