package ch.bfh.modulBTX8051.Aufg14.base;

/**
 * Represents a medical doctor in a hospital information system (HIS).
 * 
 * @version V12.04.2015
 */
public class Doctor extends Person {
	private String title;
	private String phone;

	/**
	 * Initializes an object representing a <code>Doctor</code>.
	 * 
	 * @param aFirstName
	 *           The first name of a doctor.
	 * @param aName
	 *           The name of a doctor.
	 * @param aTitle
	 *           The title of a doctor.
	 * @param aPhone
	 *           The phone number of a doctor.
	 */
	public Doctor(String aFirstName, String aName, String aBirthyear, String aGender, String aTitle,
			String aPhone) {
		super(aFirstName, aName, aBirthyear, aGender);

		title = aTitle;
		phone = aPhone;
	}

	/**
	 * Create a clone of this object.
	 * 
	 * @return the cloned object.
	 */
	@Override
	public Doctor clone() {
		Doctor cloned = (Doctor) super.clone();
		return cloned;
	}

	/**
	 * Tests if two <code>Doctor</code> objects are equal. i.e. if they have the
	 * same <i>first name</i>, <i>last name</i>, <i>title</i> and <i>phone
	 * number</i>.
	 * 
	 * @param obj
	 *           the object to be compared to this object.
	 * @return true if both object are equal, false otherwise.
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
		Doctor other = (Doctor) obj;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Returns the phone number of this <code>Doctor</code>.
	 * 
	 * @return the phone number.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the title of this <code>Doctor</code>.
	 * 
	 * @return the title.
	 */
	public String getTitle() {
		return title;
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
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this <code>Doctor</code>.
	 * 
	 * @return the string representation.
	 */
	@Override
	public String toString() {
		return String.format("%s, %s, %s", super.toString(), title, phone);
	}
}
