import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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

//	@CollectionId(columns = { @Column(name="doorNumber") }, generator = "", type = @Type(type = "string"))
	@JoinTable(name="Address")
	@ElementCollection
	private Set<Address> listAddresses = new HashSet<Address>();
	
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

	public Set<Address> getListAddresses() {
		return listAddresses;
	}

	public void setListAddresses(Set<Address> listAddresses) {
		this.listAddresses = listAddresses;
	}

}