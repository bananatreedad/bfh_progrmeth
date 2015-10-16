package ch.bfh.modulBTX8051.Aufg14.base;

/**
 * Represents a <code>Person</code> with the most important data.
 * 
 * @version V12.04.2015
 */
public class Person implements Cloneable {
	private String firstName;
	private String name;

	/**
	 * Initializes an object representing a <code>Person</code>.
	 * 
	 * @param aFirstName
	 *           The first name of a person.
	 * @param aName
	 *           The name of a person.
	 */
	public Person(String aFirstName, String aName) {
		firstName = aFirstName;
		name = aName;

	}

	/**
	 * Create a clone of this object.
	 * 
	 * @return the cloned object.
	 */
	@Override
	public Person clone() {
		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException ex) {
			return null; // Can't happen, Cloneable is implemented.
		}
	}

	/**
	 * Tests if two <code>Person</code> objects are equal, i.e. if they have the
	 * same <i>first name</i> and <i>last name</i>.
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Returns the first name of this <code>Person</code>.
	 * 
	 * @return The first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the name of this <code>Person</code>.
	 * 
	 * @return The name.
	 */
	public String getName() {
		return name;
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
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this <code>Person</code>.
	 * 
	 * @return The string representation.
	 */
	@Override
	public String toString() {
		return String.format("%s, %s", firstName, name);
	}
}
