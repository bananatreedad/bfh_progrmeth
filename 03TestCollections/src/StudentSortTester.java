import java.util.*;

/**
 * The class <code>StudentsSortTest</code> and the class <code>Student</code>
 * demonstrate the use of the <code>Comparable</code> and the
 * <code>Comparator</code> interfaces, using the methods <i>sort(), min()</i>
 * and <i>max()</i> of the utility class <code>Collections</code>.
 * <p>
 * The data which are sorted are objects of the class <code>Student</code>.
 * 
 * @version V23.03.2014
 * @author hans.roethlisberger@bfh.ch
 */
public class StudentSortTester {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();

		// Appends Student objects (name, grade) to the end of the ArrayList.
		students.add(new Student("Antony Good", 72)); // Index 0
		students.add(new Student("Harry Lazy", 35)); // Index 1
		students.add(new Student("Peter Thebest", 97)); // Index 2
		students.add(new Student("Tony Sufficient", 60)); // Index 3

		System.out.println("\n-ArrayList after add():");
		printStudents(students);

		System.out.println("\n-min(), max() grade according to compareTo() (natural ordering):");
		System.out.println(" Worst student: " + Collections.min(students).getName());
		System.out.println(" Best student: " + Collections.max(students).getName());
		System.out.println(
				"\n-ArrayList sorted with sort() according to compareTo() (natural ordering, grade ascending): ");
		Collections.sort(students);
		printStudents(students);
		System.out.println("\n-ArrayList sorted according to StudComparatorGradeDesc(): ");
		Collections.sort(students, new StudComparatorGradeDesc());
		printStudents(students);
		System.out.println("\n-ArrayList sorted according to StudComparatorNameAsc(): ");
		Collections.sort(students, new StudComparatorNameAsc());
		printStudents(students);
		System.out.println("\n-ArrayList sorted according to StudComparatorNameDesc(): ");
		Collections.sort(students, new StudComparatorNameDesc());
		printStudents(students);
		System.out.println("\n-min(), max() grade according to StudComparatorGradeDesc():");
		System.out.println(" Best student: " + Collections.min(students, new StudComparatorGradeDesc()).getName());
		System.out.println(" Worst student: " + Collections.max(students, new StudComparatorGradeDesc()).getName());
	}

	/**
	 * Prints (Standard output) the <code>ArrayList</code> of all
	 * <code>Student</code> in the defined order (<code>student</code> with
	 * index 0 until the last defined <code>student</code>).
	 * 
	 * @param aStudentList
	 *            the <code>ArrayList</code> to be printed.
	 */
	public static void printStudents(ArrayList<Student> aStudentList) {
		// Print out the sorted information about all student objects
		for (Student student : aStudentList)
			System.out.println(" name: " + student.getName() + "\tgrade: " + student.getGrade() + "%");
	}
}

/**
 * Compares <code>Student</code> objects by <i>grade</i> (descending).
 * 
 * @version V18.03.2014
 * @author hans.roethlisberger@bfh.ch
 */
class StudComparatorGradeDesc implements Comparator<Student> {

	/**
	 * @param student1
	 *            the first <code>Student</code> object to compare the
	 *            <i>grade</i>.
	 * @param student2
	 *            the second <code>Student</code> object to compare the
	 *            <i>grade</i>.
	 * @return a positive value if <i>student1</i> has a lower <i>grade</i> than
	 *         <i>student2</i>, a negative value otherwise; 0 if the
	 *         <i>grade</i> is the same.
	 */
	public int compare(Student student1, Student student2) {
		if (student1.getGrade() > student2.getGrade())
			return -1;
		if (student1.getGrade() < student2.getGrade())
			return 1;
		return 0;
	}
}

/**
 * Compares <code>Student</code> objects by <i>name</i> (<i>
 * "natural ordering"</i>, ascending).
 * 
 * @version V18.03.2014
 * @author hans.roethlisberger@bfh.ch
 */
class StudComparatorNameAsc implements Comparator<Student> {

	/**
	 * @param student1
	 *            the first <code>Student</code> object to compare the
	 *            <i>name</i>.
	 * @param student2
	 *            the second <code>Student</code> object to compare the
	 *            <i>name</i>.
	 * @return a negative value if the <i>name</i> of <i>student1</i> is
	 *         lexicographically less than the <i>name</i> of <i>student2</i>, a
	 *         positive value otherwise; 0 if the <i>name</i> is the same.
	 */
	public int compare(Student student1, Student student2) {
		String[] name1 = student1.getName().split(" ");
		String[] name2 = student2.getName().split(" ");
		return name1[1].compareTo(name2[1]); // Names are compared.
	}
}

/**
 * Compares <i>students</i> by <i>name</i> (<i>"natural ordering"</i>,
 * descending).
 * 
 * @version V18.03.2014
 * @author hans.roethlisberger@bfh.ch
 */
class StudComparatorNameDesc implements Comparator<Student> {

	/**
	 * @param student1
	 *            the first <i>Student</i> object to compare the <i>name</i>.
	 * @param student2
	 *            the second <i>Student</i> object to compare the <i>name</i>.
	 * @return a positive value if the <i>name</i> of <i>student1</i> is
	 *         lexicographically less than the <i>name</i> of <i>student2</i>, a
	 *         negative value otherwise; 0 if the <i>name</i> is the same.
	 */
	public int compare(Student student1, Student student2) {
		String[] name1 = student1.getName().split(" ");
		String[] name2 = student2.getName().split(" ");
		return name2[1].compareTo(name1[1]); // Names are compared.
	}
}