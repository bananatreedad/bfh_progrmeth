package ch.bfh.modulBTX8051.Aufg14.base;

/**
 * The class describes a mailing address with <i>street</i>, <i>street
 * number</i>, <i>postal code (zip)</i>, and <i>city</i>.
 * <p>
 * Methods for getting and setting components of the <code>Address</code> are
 * provided.
 * <p>
 * The input data are not validated.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V11.06.2014
 */
public class Address implements Cloneable {
	private String street;
	private String streetNumber;
	private String postalCode;
	private String city;

	/**
	 * Constructs a complete mailing address.
	 * 
	 * @param aStreet
	 *           The street of the <code>Address</code>.
	 * @param aStreetNumber
	 *           The street number of the <code>Address</code>.
	 * @param aPostalCode
	 *           The postal code of the <code>Address</code>.
	 * @param aCity
	 *           The city of the <code>Address</code>.
	 */
	public Address(String aStreet, String aStreetNumber, String aPostalCode,
			String aCity) {
		street = aStreet;
		streetNumber = aStreetNumber;
		postalCode = aPostalCode;
		city = aCity;
	}

	/**
	 * Create a clone of this <code>Address</code> object.
	 * 
	 * @return the cloned <code>Address</code> object.
	 */
	@Override
	public Address clone() {
		try {
			return (Address) super.clone();
		} catch (CloneNotSupportedException ex) {
			return null; // Can't happen, Cloneable is implemented.
		}
	}

	/**
	 * Tests if two <code>Address</code> objects are equal, i.e. if they have the
	 * same <i>street</i>, <i>postal code</i> and <i>city</i> attributes.
	 * 
	 * @param obj
	 *           the object to be compared to this object.
	 * @return <tt>true</tt> if both objects are equal, <tt>false</tt> otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		Address addr = (Address) obj;
		boolean sameStreet = (street == null && addr.street == null)
				|| (street != null && street.equals(addr.street));
		boolean sameStreetNumber = (streetNumber == null && addr.streetNumber == null)
				|| (streetNumber != null && streetNumber.equals(addr.streetNumber));
		boolean samePostalCode = (postalCode == null && addr.postalCode == null)
				|| (postalCode != null && postalCode.equals(addr.postalCode));
		boolean sameCity = (city == null && addr.city == null)
				|| (city != null && city.equals(addr.city));
		return sameStreet && sameStreetNumber && samePostalCode && sameCity;
	}

	/**
	 * Returns the city of this <code>Address</code>.
	 * 
	 * @return the city of this <code>Address</code>.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Returns the postal code of this <code>Address</code>.
	 * 
	 * @return the postal code of this <code>Address</code>.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Returns the street of this <code>Address</code>.
	 * 
	 * @return the street of this <code>Address</code>.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Returns the street number of this <code>Address</code>.
	 * 
	 * @return the street number of this <code>Address</code>.
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * Calculates a hash code according to the equals method.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		int hash = 17;
		if (street != null)
			hash = 31 * hash + street.hashCode();
		if (streetNumber != null)
			hash = 31 * hash + streetNumber.hashCode();
		if (postalCode != null)
			hash = 31 * hash + postalCode.hashCode();
		if (city != null)
			hash = 31 * hash + city.hashCode();

		return hash;
	}

	/**
	 * Sets the city of this <code>Address</code>.
	 * 
	 * @param aCity
	 *           the city of this <code>Address</code>.
	 */
	public void setCity(String aCity) {
		city = aCity;
	}

	/**
	 * Sets the postal code of this <code>Address</code>.
	 * 
	 * @param aPostalCode
	 *           the postal code of this <code>Address</code>.
	 */
	public void setPostalCode(String aPostalCode) {
		postalCode = aPostalCode;
	}

	/**
	 * Sets the street of this <code>Address</code>.
	 * 
	 * @param aStreet
	 *           the street of this <code>Address</code>.
	 */
	public void setStreet(String aStreet) {
		street = aStreet;
	}

	/**
	 * Sets the street number of this <code>Address</code>.
	 * 
	 * @param aStreetNumber
	 *           the street number of this <code>Address</code>.
	 */
	public void setStreetNumber(String aStreetNumber) {
		streetNumber = aStreetNumber;
	}

	/**
	 * Returns a string representation of this <code>Address</code>.
	 * 
	 * @return String representation of this <code>Address</code>.
	 */
	@Override
	public String toString() {
		return street + " " + streetNumber + ", " + postalCode + " " + city;
	}
}