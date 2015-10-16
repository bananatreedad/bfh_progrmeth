package ch.bfh.modulBTX8051.Aufg14.base;

import java.util.ArrayList;

/**
 * An object of the class <code>PersonFilter</code> has an
 * <code>ArrayList</code> of <code>Person</code> objects.
 * <p>
 * With its methods it is possible to iterate the list and search a
 * <code>Person</code> according to different rules.
 * 
 * @author hans.roethlisberger@bfh.ch
 * @version V20.05.2014
 */
public class PersonFilter {
	ArrayList<Person> personList;

	/**
	 * Constructs a new <code>PersonFilter</code> object.
	 * 
	 * @param aPersonList
	 *           The list to iterate and search for a <code>Person</code>.
	 */
	public PersonFilter(ArrayList<Person> aPersonList) {
		personList = aPersonList;
	}

	/**
	 * All <code>Person</code> objects are returned as <code>String</code>. The
	 * data are sorted according to the order the data are defined in the
	 * <code>ArrayList</code>.
	 * <p>
	 * If the list is empty, <i>null</i> is returned.
	 * 
	 * @return all <code>Person</code> objects of the list in a
	 *         <code>String</code> representation, <i>null</i> if the list is
	 *         empty.
	 */
	public String allPersons() {
		String persons = "";

		for (Person person : personList)
			persons = persons + person.toString() + "\n";

		return persons.equals("") ? null : persons;
	}

	/**
	 * Returns all <code>Person</code> objects in a <code>String</code>
	 * representation that are also a <code>Doctor</code>.
	 * <p>
	 * If the list is empty or no persons were found, <i>null</i> is returned.
	 * 
	 * @return all <code>Doctor</code> objects in a <code>String</code>
	 *         representation; <i>null</i> if the list is empty or no persons
	 *         were found.
	 */
	public String doctorFilter() {
		String doctors = "";

		for (Person person : personList)
			if (person instanceof Doctor)
				doctors = doctors + person.toString() + "\n";

		return doctors.equals("") ? null : doctors;
	}

	/**
	 * Returns only those <code>Person</code> objects whose first character of
	 * the first name matches a single character (in a <code>String</code>
	 * representation).
	 * <p>
	 * If the list is empty or no persons were found, <i>null</i> is returned.
	 * 
	 * @param nameStart
	 *           The single character which is compared with the first character
	 *           of the first name.
	 * @return all <code>Person</code> objects of the list in a
	 *         <code>String</code> representation, whose first character of the
	 *         first name matches <i>nameStart</i>; <i>null</i> if the list is
	 *         empty or no persons were found.
	 */
	public String firstNameFilter(String nameStart) {
		String persons = "";

		for (Person person : personList) {
			if (person.getFirstName().trim().startsWith(nameStart))
				persons = persons + person.toString() + "\n";
		}

		return persons.equals("") ? null : persons;
	}

	/**
	 * Returns all <code>Person</code> objects in a <code>String</code>
	 * representation that are also a <code>Patient</code>.
	 * <p>
	 * If the list is empty or no persons were found, <i>null</i> is returned.
	 * 
	 * @return all <code>Patient</code> objects in a <code>String</code>
	 *         representation; <i>null</i> if the list is empty or no persons
	 *         were found.
	 */
	public String patientFilter() {
		String patients = "";

		for (Person person : personList)
			if (person instanceof Patient)
				patients = patients + person.toString() + "\n";

		return patients.equals("") ? null : patients;
	}
}
