package at.fh.bsd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StringQueueTest {
    static StringQueue queue;
    static StringQueue offerTest;

    /**
     * Creates two queues for testing
     */
    @BeforeEach
    public void setup(){
        queue = new StringQueue(0);
        offerTest = new StringQueue(1);
    }

    /**
     * Tests for the offer function
     *
     * assertFalse: fails when returning true
     * tests is successful when the outcome with queue, which maxSize is 0, returns false
     *
     * assertTrue: fails when returning false
     * tests is successful when the outcome with queue, which maxSize is 1, returns true
     */
    @Test
    public void testOffer(){
        assertFalse(queue.offer("1st"));
        assertTrue(offerTest.offer("1st"));
    }

    /**
     * Tests for the poll function
     *
     * assertEquals: fails if expected String is not included
     * tests is successful when the outcome with offerTest returns true
     *
     * assertNull: fails if the given queue is not null
     * tests is successful when the outcome with queue returns true
     */
    @Test
    public void testPoll(){
        offerTest.offer("1st"); //the element in the test before gets deleted, therefore you need a new one
        assertEquals("1st", offerTest.poll());
        assertNull(queue.poll());
    }

    /**
     * Tests for the remove function
     *
     * assertEquals: fails if expected String will not be removed
     * tests is successful when the expected String is removed
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * offerTest now has no element remaining in the queue therefore the test is successful when the Exception is thrown
     */
    @Test
    public void testRemove(){
        offerTest.offer("1st");
        assertEquals("1st", offerTest.remove());
        assertThrows(NoSuchElementException.class,()->{
            offerTest.remove();
        });
    }

    /**
     * Tests for the element function
     *
     * assertEquals: fails if expected String is not included
     * tests is successful when the outcome with offerTest returns true
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * queue has no element in the queue therefore tests is successful when the Exception is thrown
     */
    @Test
    public void testElement(){
        offerTest.offer("1st");
        assertEquals("1st", offerTest.element());
        assertThrows(NoSuchElementException.class,()->{
            queue.element();
        });
    }

}