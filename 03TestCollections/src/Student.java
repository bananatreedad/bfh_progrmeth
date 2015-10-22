/**
 * An objects of the class <code>Student</code> represents a student by the
 * <i>name</i> and the <i>grade</i> (simplification).
 * <p>
 * The class contains the methods <i>compareTo()</i>, <i>equals()</i> and
 * <i>hashCode()</i>. Therefore <code>Student</code> objects can be stored in
 * <code>Collection</code>s and the methods of the class
 * <code>Collections</code> (e.g. <i>min()</i>, <i>max()</i>, ..) can be used.
 * <p>
 * The input data (<i>name</i>, <i>grade</i>) are fully validated.
 * 
 * @version V24.03.2015
 * @author hans.roethlisberger@bfh.ch
 */
public class Student implements Cloneable, Comparable<Student> {
	private final String name;
	private final int grade;

	/**
	 * Constructs a <code>Student</code> object.
	 * 
	 * @param aName
	 *           <i>forename</i> and <i>name</i> of this <code>Student</code>.
	 * @param aGrade
	 *           The <i>grade</i> of this <code>Student</code> (0.0 <=
	 *           <i>grade</i> <= 100.0).
	 * @throws IllegalArgumentException
	 *            is thrown if no name ("") or <code>null</code> is defined. The
	 *            exception is also thrown if the grade is <0 or >100.
	 */
	public Student(String aName, int aGrade) throws IllegalArgumentException {
		if (aName.equals("") || aName == null)
			throw new IllegalArgumentException(
					"A name can't be \"null\" or an empty String.");
		name = aName;
		if (aGrade < 0 || aGrade > 100)
			throw new IllegalArgumentException("A grade must be >=0 and <=100.");
		grade = aGrade;
	}

	/**
	 * Creates a clone of this object.
	 * 
	 * @return a clone of this instance.
	 */
	@Override
	public Student clone() {
		try {
			return (Student) super.clone();
		} catch (CloneNotSupportedException ex) {
			// Cannot happen, clone() is supported.
			return null;
		}
	}

	/**
	 * Compares this <code>Student</code> to the specified <code>Student</code>
	 * by <i>grade</i> (<i>"natural ordering"</i>, ascending).
	 * 
	 * @param otherStudent
	 *           another <code>Student</code> object.
	 * @return a negative value if this <code>Student</code> has a lower
	 *         <i>grade</i> than <i>otherStudent</i>, a positive value otherwise;
	 *         0 if the <i>grade</i> is the same.
	 */
	public int compareTo(Student otherStudent) {
		if (grade < otherStudent.grade)
			return -1;
		if (grade > otherStudent.grade)
			return 1;
		return 0;
	}

	/**
	 * Compares this <code>Student</code> to the specified object.
	 * 
	 * @param otherObject
	 *           The object to compare this <code>Student</code> against.
	 * 
	 * @return <i>true</i> if the given object represents a <code>Student</code>
	 *         equivalent to this <code>Student</code>, <i>false</i> otherwise.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return name.equals(other.name) && grade == other.grade;
	}

	/**
	 * Returns the <i>grade</i> of this <code>Student</code>.
	 * 
	 * @return the <i>grade</i> of this <code>Student</code>.
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Returns the <i>name</i> of this <code>Student</code>.
	 * 
	 * @return the <i>name</i> of this <code>Student</code>.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a hash code for this <code>Student</code>.
	 * 
	 * @return a hash code value for this object.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + grade;
		result = prime * result + name.hashCode();
		return result;
	}

	/**
	 * Returns a string representation of this <code>Student</code>.
	 * 
	 * @return a string representation of this object.
	 */
	@Override
	public String toString() {
		return getClass().getName() + "[name=" + name + ", grade=" + grade + "%]";
	}
}
