
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


interface LinkedListInterface {
    void insert(int data); 
    void delete(int data); 
    void display(); 
}


class LinkedList implements LinkedListInterface {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found in the list.");
            return;
        }

        previous.next = current.next;
    }

    
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(50);
        list.insert(100);
        list.insert(85);
        list.insert(20);
        System.out.println("Linked List elements:");
        list.display();

        list.delete(100);
        System.out.println("Linked List after deleting 100:");
        list.display();
    }
}
