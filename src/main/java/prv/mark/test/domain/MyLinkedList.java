package prv.mark.test.domain;

/**
 * http://stackoverflow.com/questions/22605050/reverse-singly-linked-list-java
 *
 * Created by mlglenn on 10/13/2016.
 */
public class MyLinkedList<E> {
    protected Node<E> head;

    public MyLinkedList() {
        head = null;
    }

    public MyLinkedList(E[] list) {
        this();
        addAll(list);
    }

    public void addAll(E[] list) {
        for (int i = 0; i < list.length; i++)
            add(list[i]);
    }

    public void add(E e) {
        if (head == null)
            head = new Node<E>(e);
        else {
            Node<E> temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new Node<E>(e);
        }
    }

    public void reverseList() {
        Node<E> curr = head;
        Node<E> pre = null;
        Node<E> incoming = null;

        while (curr != null) {
            incoming = curr.next;   // store incoming item

            curr.next = pre;        // swap nodes
            pre = curr;             // increment also pre

            curr = incoming;        // increment current
        }

        head = pre; // pre is the latest item where
        // curr is null
    }

    public void printList() {
        Node<E> temp = head;

        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}
