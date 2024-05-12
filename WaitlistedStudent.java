/**
 * Represents a student who is waitlisted for registration.
 */
public class WaitlistedStudent extends Student {

    private Status registrationStatus; // Registration status of the student
    private int daysLeftToRegister;    // Number of days left for registration

    /**
     * Constructs a WaitlistedStudent object with the specified name and student number.
     * Sets the registration status to WAITLISTED and initializes daysLeftToRegister to 0.
     *
     * @param name          the student's name
     * @param studentNumber the student's identification number
     */
    public WaitlistedStudent(String name, String studentNumber) {
        super(name, studentNumber);
        this.registrationStatus = Status.WAITLISTED;
        this.daysLeftToRegister = 0;
    }

    /**
     * Constructs a WaitlistedStudent object with the specified name, student number, and days left to register.
     * Sets the registration status to WAITLISTED.
     *
     * @param name          the student's name
     * @param studentNumber the student's identification number
     * @param daysLeft      the number of days left for registration
     */
    public WaitlistedStudent(String name, String studentNumber, int daysLeft) {
        super(name, studentNumber);
        this.registrationStatus = Status.WAITLISTED;
        this.daysLeftToRegister = daysLeft;
    }

    /**
     * Retrieves the registration status of the student.
     *
     * @return the registration status of the student
     */
    public Status getRegistrationStatus() {
        return registrationStatus;
    }

    /**
     * Sets the registration status of the student.
     *
     * @param registrationStatus the registration status to set
     */
    public void setRegistrationStatus(Status registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
     * Retrieves the number of days left for registration.
     *
     * @return the number of days left for registration
     */
    public int getDaysLeft() {
        return this.daysLeftToRegister;
    }

    /**
     * Sets the number of days left for registration.
     *
     * @param daysLeft the number of days left to set
     */
    public void setDaysLeft(int daysLeft) {
        this.daysLeftToRegister = daysLeft;
    }

    /**
     * Returns a string representation of the WaitlistedStudent object.
     *
     * @return a string containing the student's information and registration status
     */
    
    public String toString() {
        if (this.registrationStatus.equals(Status.PERMITTED_TO_REGISTER)) {
            return " " + super.toString() + ", Status: " + this.registrationStatus + " Days: " + this.daysLeftToRegister + "\n";
        }
        return super.toString() + ", Status: " + this.registrationStatus + "\n";
    }
}
