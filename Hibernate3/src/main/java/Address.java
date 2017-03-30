import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "door_number")
	private String doorNumber;

	@Column(name = "street_name")
	private String streetName;

	public Address() {

	}

	public Address(String doorNumber, String streetName) {
		this.doorNumber = doorNumber;
		this.streetName = streetName;

	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}