package prv.mark.test.domain;

/**
 * http://stackoverflow.com/questions/22605050/reverse-singly-linked-list-java
 *
 * Created by mlglenn on 10/13/2016.
 */
public class Node<E> {

    protected E e;
    protected Node<E> next;

    public Node(E e) {
        this.e = e;
        this.next = null;
    }

    @Override
    public String toString() {
        return e.toString();
    }

}
