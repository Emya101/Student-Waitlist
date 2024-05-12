/**
 * Represents a student with a student number and name.
 */
public class Student {
    private String studentNumber; // Student's identification number
    private String name;          // Student's name

    /**
     * Constructs a default Student object with null values for student number and name.
     */
    public Student() {
        this.studentNumber = null;
        this.name = null;
    }

    /**
     * Constructs a Student object with the specified student number and name.
     *
     * @param studentNumber the student's identification number
     * @param name          the student's name
     */
    public Student(String studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    /**
     * Retrieves the student's identification number.
     *
     * @return the student's identification number
     */
    public String getStudentNumber() {
        return this.studentNumber;
    }

    /**
     * Sets the student's identification number.
     *
     * @param studentNumber the student's identification number to set
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * Retrieves the student's name.
     *
     * @return the student's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the student's name.
     *
     * @param name the student's name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Checks if this Student object is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student student = (Student) obj;
        return studentNumber.equals(student.studentNumber) && name.equalsIgnoreCase(student.name);
    }

    /**
     * Returns a string representation of the Student object.
     *
     * @return a string containing the student's identification number and name
     */
    
    public String toString() {
        return studentNumber + " : " + name;
    }
}
