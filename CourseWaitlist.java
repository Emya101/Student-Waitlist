import java.util.Random;
import java.util.Scanner;

/**Emhenya Supreme
 * Represents a waitlist for a course with simulation functionality.
 */
public class CourseWaitlist {

    private CircularDoublyLinkedList<WaitlistedStudent> waitlist; // List of waitlisted students

    /**
     * Constructs a CourseWaitlist object with no students in the waitlist.
     */
    public CourseWaitlist() {
        this.waitlist = null;
    }

    /**
     * Constructs a CourseWaitlist object with the specified list of waitlisted students.
     * Sets the registration status and days left for the first student in the list.
     *
     * @param listed the list of waitlisted students
     */
    public CourseWaitlist(CircularDoublyLinkedList<WaitlistedStudent> listed) {
        this.waitlist = listed;

        waitlist.first().setRegistrationStatus(Status.PERMITTED_TO_REGISTER);
        waitlist.first().setDaysLeft(2);
    }

    /**
     * Starts the simulation of the course waitlist.
     */
    public void StartSimulation() {
        Random rd = new Random();
        Scanner kb = new Scanner(System.in);
        int counter = 0;

        System.out.println("ACS-2947 Waitlist");
        System.out.println(waitlist);

        while (!(waitlist.isEmpty())) {
            if (counter != 20) {
                int RandomNum = rd.nextInt(4) + 1;
                switch (RandomNum) {
                    case 1:
                        System.out.println("System chose option 1: No addition to waitlist (status/days left may change)");
                        updateWaitlistOnOption1();
                        System.out.println(waitlist);
                        break;
                    case 2:
                        System.out.println("System chose option 2: a new student joins the waitlist");
                        updateWaitlistOnOption2(kb);
                        System.out.println(waitlist);
                        break;
                    case 3:
                        System.out.println("System chose option 3: " + waitlist.first().getName() + " registers");
                        updateWaitlistOnOption3();
                        System.out.println(waitlist);
                        break;
                    case 4:
                        System.out.println("System chose option 4: Checks if a student is waitlisted");
                        checkStudentInWaitlist(kb);
                        System.out.println(waitlist);
                        break;
                }
                counter++;
            } else {
                break;
            }
        }

        if (waitlist.isEmpty()) {
            System.out.println("There are no more students in the list");
        }
        if (counter == 20) {
            System.out.println("Reached 20 days/Operations!\nFinal Waitlist: ");
            System.out.println(waitlist);
        }
    }

    // Helper method for option 1
    private void updateWaitlistOnOption1() {
        if (waitlist.first().getRegistrationStatus().equals(Status.PERMITTED_TO_REGISTER) && waitlist.first().getDaysLeft() > 0) {
            int days = waitlist.first().getDaysLeft();
            days--;
            waitlist.first().setDaysLeft(days);
        }

        if (waitlist.first().getRegistrationStatus().equals(Status.PERMITTED_TO_REGISTER) && waitlist.first().getDaysLeft() == 0) {
            waitlist.first().setRegistrationStatus(Status.WAITLISTED);
            waitlist.rotate();
            waitlist.first().setRegistrationStatus(Status.PERMITTED_TO_REGISTER);
            waitlist.first().setDaysLeft(2);
        }
    }

    // Helper method for option 2
    private void updateWaitlistOnOption2(Scanner kb) {
        updateWaitlistOnOption1(); // Updating waitlist status

        System.out.print("Enter student number and name: ");
        String newNum = kb.next();
        String StuNam = kb.next();
        boolean isValid = false;

        // Validate student number
        while (!isValid) {
            if (isInteger(newNum)) {
                isValid = true;
            } else {
                System.out.println("Enter a valid Student Number");
                newNum = kb.next();
            }
        }

        WaitlistedStudent addedStudent = new WaitlistedStudent(StuNam, newNum);
        addedStudent.setRegistrationStatus(Status.WAITLISTED);
        waitlist.addLast(addedStudent);
    }

    // Helper method for option 3
    private void updateWaitlistOnOption3() {
        waitlist.removeFirst();
        waitlist.first().setRegistrationStatus(Status.PERMITTED_TO_REGISTER);
        waitlist.first().setDaysLeft(2);
    }

    // Helper method for option 4
    private void checkStudentInWaitlist(Scanner kb) {
        updateWaitlistOnOption1(); // Updating waitlist status

        System.out.print("Enter student number and name: ");
        String newNum = kb.next();
        String StuNam = kb.next();
        WaitlistedStudent addedStudent = new WaitlistedStudent(StuNam, newNum);
        boolean confirm = false;

        if (waitlist.first().getRegistrationStatus().equals(Status.PERMITTED_TO_REGISTER) && waitlist.first().getDaysLeft() == 0) {
            waitlist.first().setRegistrationStatus(Status.WAITLISTED);
            waitlist.rotate();
            waitlist.first().setRegistrationStatus(Status.PERMITTED_TO_REGISTER);
            waitlist.first().setDaysLeft(2);
        }

        for (int i = 0; i < waitlist.size(); i++) {
            if (waitlist.first().equals(addedStudent)) {
                confirm = true;
            }
            waitlist.rotate();
        }

        if (confirm) {
            System.out.println("Student found in waitlist!");
        } else {
            System.out.println("Student not found in waitlist");
        }
    }

    // Helper method to check if a string is an integer
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
