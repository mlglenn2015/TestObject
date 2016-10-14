package prv.mark.test.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

/**
 * https://www.tutorialspoint.com/java/java_linkedlist_class.htm
 *
 * Created by mlglenn on 10/13/2016.
 */
public class MyLinkedListTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyLinkedListTests.class);

    @Before
    public void setUp() {
        LOGGER.debug("setUp()");
    }

    @After
    public void tearDown() {
        LOGGER.debug("tearDown()");
    }


    @Test
    public void testReverseLinkedList() {
        LOGGER.debug("MyLinkedListTests.testReverseLinkedList()");

        Integer[] list = { 4, 3, 2, 1 };
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>(list);

        LOGGER.debug("myLinkedList (forward): {}", myLinkedList);
        myLinkedList.printList();

        myLinkedList.reverseList();

        LOGGER.debug("myLinkedList (reversed): {}", myLinkedList);
        myLinkedList.printList();
    }
    /*
    10-14-2016 17:38:41.291 DEBUG p.mark.test.domain.MyLinkedListTests - setUp()
    10-14-2016 17:38:41.295 DEBUG p.mark.test.domain.MyLinkedListTests - MyLinkedListTests.testReverseLinkedList()
    10-14-2016 17:38:41.296 DEBUG p.mark.test.domain.MyLinkedListTests - myLinkedList (forward): MyLinkedList{head=4}
    List: 4 3 2 1
    10-14-2016 17:38:41.297 DEBUG p.mark.test.domain.MyLinkedListTests - myLinkedList (reversed): MyLinkedList{head=1}
    List: 1 2 3 4
    10-14-2016 17:38:41.298 DEBUG p.mark.test.domain.MyLinkedListTests - tearDown()
     */

    @Test
    public void testJavaLinkedList() {
        LOGGER.debug("testJavaLinkedList()");

        // create a linked list
        LinkedList<String> ll = new LinkedList<>();

        // add elements to the linked list
        ll.add("F");
        ll.add("B");
        ll.add("D");
        ll.add("E");
        ll.add("C");
        ll.addLast("Z");
        ll.addFirst("A");
        ll.add(1, "A2");
        LOGGER.debug("Original contents of ll: " + ll);  //Original contents of ll: [A, A2, F, B, D, E, C, Z]

        // remove elements from the linked list
        ll.remove("F");
        ll.remove(2);
        LOGGER.debug("Contents of ll after deletion: " + ll); //Contents of ll after deletion: [A, A2, D, E, C, Z]

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        LOGGER.debug("ll after deleting first and last: " + ll); //ll after deleting first and last: [A2, D, E, C]

        // get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + " Changed");
        LOGGER.debug("ll after change: " + ll);  //ll after change: [A2, D, E Changed, C]
    }
    /*
    10-14-2016 17:39:38.006 DEBUG p.mark.test.domain.MyLinkedListTests - setUp()
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - testJavaLinkedList()
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - Original contents of ll: [A, A2, F, B, D, E, C, Z]
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - Contents of ll after deletion: [A, A2, D, E, C, Z]
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - ll after deleting first and last: [A2, D, E, C]
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - ll after change: [A2, D, E Changed, C]
    10-14-2016 17:39:38.011 DEBUG p.mark.test.domain.MyLinkedListTests - tearDown()
     */


}
