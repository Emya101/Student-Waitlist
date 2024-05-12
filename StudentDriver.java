public class StudentDriver {
    public static void main(String[] args) {
        // Creating the CircularDoublyLinkedList named 'course' to store WaitlistedStudent students.
        CircularDoublyLinkedList<WaitlistedStudent> course = new CircularDoublyLinkedList<>();
        
        // Creating WaitlistedStudent students with specified names and IDs.
        WaitlistedStudent Jeremy = new WaitlistedStudent("Jeremy", "1111111");
        WaitlistedStudent Anne = new WaitlistedStudent("Anne", "2222222");
        WaitlistedStudent Jacob = new WaitlistedStudent("Jacob", "3333333");
        WaitlistedStudent Melissa= new WaitlistedStudent("Melissa", "4444444");

        // Adding WaitlistedStudent objects to the 'course' CircularDoublyLinkedList.
        course.addFirst(Jeremy);
        course.addLast(Anne);
        course.addFirst(Melissa);
        course.addLast(Jacob);

        // Creating a CourseWaitlist object named 'v' with the 'course' CircularDoublyLinkedList.
        CourseWaitlist simulation = new CourseWaitlist(course);
        
        // Starting the simulation using the CourseWaitlist object 'v'.
        simulation.StartSimulation();
    }
}