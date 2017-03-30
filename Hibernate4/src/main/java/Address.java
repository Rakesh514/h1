import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String doorNumber;
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