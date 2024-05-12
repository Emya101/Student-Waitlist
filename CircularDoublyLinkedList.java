/**
 * Represents a circular doubly linked list.
 */
public class CircularDoublyLinkedList<E> {
    private Node<E> tail; // Tail of the linked list
    private int size = 0; // Size of the linked list

    /**
     * Constructs an empty circular doubly linked list.
     */
    public CircularDoublyLinkedList() {
        this.tail = new Node<>(null, null, null);
    }

    // Inner class representing a node in the linked list
    private static class Node<E> {
        private E element;       // Element stored in the node
        private Node<E> next;    // Reference to the next node
        private Node<E> prev;    // Reference to the previous node

        /**
         * Constructs a node with the given element and references to the previous and next nodes.
         */
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        // Getter methods for element, previous node, and next node
        public E getElement() { return this.element; }
        public Node<E> getPrev() { return this.prev; }
        public Node<E> getNext() { return this.next; }

        // Setter methods for previous node and next node
        public void setPrev(Node<E> p) { this.prev = p; }
        public void setNext(Node<E> n) { this.next = n; }
    }

    /**
     * Returns the number of elements in the list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks whether the list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element of the list.
     */
    public E first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement();
    }

    /**
     * Returns the last element of the list.
     */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /**
     * Adds an element to the front of the list.
     */
    public void addFirst(E e) {
        addBetween(e, tail, tail.getNext());
    }

    /**
     * Adds an element to the end of the list.
     */
    public void addLast(E e) {
        addBetween(e, tail, tail.getNext());
        this.tail = this.tail.getNext();
    }

    /**
     * Adds an element between two existing nodes.
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        if (isEmpty()) {
            this.tail = newest;
            this.tail.setNext(this.tail);
            this.tail.setPrev(this.tail);
        } else {
            predecessor.setNext(newest);
            successor.setPrev(newest);
        }
        size++;
    }

    /**
     * Removes the first element of the list.
     */
    public E removeFirst() {
        return remove(this.tail.getNext());
    }

    /**
     * Removes the last element of the list.
     */
    public E removeLast() {
        return remove(this.tail);
    }

    /**
     * Removes a specified node from the list.
     */
    private E remove(Node<E> node) {
        if (isEmpty()) {
            return null;
        }
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        if (node == this.tail) {
            this.tail = predecessor;
        }
        size--;
        return node.getElement();
    }

    /**
     * Moves the tail pointer to the next node.
     */
    public void rotate() {
        this.tail = tail.getNext();
    }

    /**
     * Checks if the list contains a specified element.
     */
    public boolean contains(E e) {
        Node<E> successor = this.tail.getNext();
        E search;
        for (int i = 0; i < this.size; i++) {
            search = successor.getElement();
            successor = successor.getNext();
            if (search.equals(e)) return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the list.
     */
    public String toString() {
        if (isEmpty()) {
            return "CircularDoublyLinkedList is empty";
        }
        StringBuilder sb = new StringBuilder();
        Node<E> current = tail.getNext();
        do {
            sb.append(current.getElement()).append(" ");
            current = current.getNext();
        } while (current != tail.getNext());
        return sb.toString();
    }
}
