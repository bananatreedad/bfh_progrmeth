package ch.bfh.modulBTX8051.Aufg14.base;

/**
 * Represents a patient in a hospital information system (HIS).
 * 
 * @version V12.04.2015
 */
public class Patient extends Person {
	private long pin; // Patient Identification Number
	private Address address;

	/**
	 * Initializes an object representing a <code>Patient</code>.
	 * 
	 * @param aFirstName
	 *           The first name of a patient.
	 * @param aName
	 *           The last name of a patient.
	 * @param aPin
	 *           The PIN (Patient Identification Number) of a patient.
	 * @param anAddress
	 *           The address of a patient.
	 */
	public Patient(String aFirstName, String aName, String aBirthyear, String aGender, long aPin,
			Address anAddress) {
		super(aFirstName, aName, aBirthyear, aGender);
		pin = aPin;
		address = anAddress;
	}

	/**
	 * Create a clone of this object.
	 * 
	 * @return the cloned object.
	 */
	@Override
	public Patient clone() {
		Patient cloned = (Patient) super.clone();
		cloned.address = address == null ? null : address.clone();
		return cloned;
	}

	/**
	 * Tests if two <code>Patient</code> objects are equal. i.e. if they have the
	 * same <i>first name</i>, <i>last name</i>, <i>PIN</i> and <i>address</i>.
	 * 
	 * @param obj
	 *           the object to be compared to this object.
	 * @return <tt>true</tt> if both objects are equal, <tt>false</tt> otherwise.
	 */
	@Override
	// eclipse generated code.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (pin != other.pin)
			return false;
		return true;
	}

	/**
	 * Returns the <code>Address</code> of this <code>Patient</code>.
	 * 
	 * @return the address.
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Returns the PIN (Patient Identification Number) of this
	 * <code>Patient</code>.
	 * 
	 * @return the pin.
	 */
	public long getPin() {
		return pin;
	}

	/**
	 * Calculates a hash code according to the equals method.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	// eclipse generated code.
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (pin ^ (pin >>> 32));
		return result;
	}

	/**
	 * Returns a string representation of this <code>Patient</code>.
	 * 
	 * @return the string representation.
	 */
	@Override
	public String toString() {
		return String.format("%s, %d, %s", super.toString(), pin,
				address.toString());
	}
}
