package at.fh.bsd;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueStringTest {
    static GenericQueue emptyQ;
    static GenericQueue queue;

    /**
     * Creates two queue from the type GenericQueue for testing
     */
    @BeforeEach
    public void setup(){
        emptyQ = new GenericQueue(0);
        queue = new GenericQueue(3);
        queue.offer("1st");
        queue.offer("2nd");
    }

    /**
     * Tests for the offer function
     *
     * assertTrue: fails when returning false
     * tests is successful when the offer function adds the given String to the queue
     *
     * assertFalse: fails when returning true
     * tests is successful when the offer function does not addsthe given String to the queue
     * because maxSize was already reached
     */
    @Test
    public void testOffer(){
        assertTrue(queue.offer("3rd"));
        assertFalse(queue.offer("4th"));
    }

    /**
     * Tests for the poll function
     *
     * assertEquals: fails if expected String is not included
     * tests is successful when the given String will be deleted
     *
     * assertNull: fails if the given queue is not null
     * tests is successful when the queue is empty/null
     */
    @Test
    public void testPoll(){
        assertEquals("1st", queue.poll());
        assertEquals("2nd", queue.poll());
        assertNull(queue.poll());
    }

    /**
     * Tests for the remove function
     *
     * assertEquals: fails if expected String will not be removed
     * tests is successful when the the expected String is removed
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * queue now has no element remaining in the queue therefore the test is successful when the Exception is thrown
     */
    @Test
    public void testRemove(){
        assertEquals("1st", queue.remove());
        assertEquals("2nd", queue.remove());
        assertThrows(NoSuchElementException.class,()->{
           queue.remove();
        });
    }

    /**
     * Tests for the peek function
     *
     * assertEquals: fails if expected String is not included
     * tests is successful when the expected String is in the queue
     *
     * assertNull: fails if the NoSuchElementException will not be thrown
     * emptyQ has no element therefore tests is successful when the Exception is thrown
     */
    @Test
    public void testPeek(){
        assertEquals("1st", queue.peek());
        assertEquals("1st", queue.peek());
        assertNull(emptyQ.peek());
    }
    /**
     * Tests for the element function
     *
     * assertEquals: fails if expected String is not included
     * tests is successful when the expected element is in the queue
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * emptyQ has no element therefore tests is successful when the Exception is thrown
     */
    @Test
    public void testElement(){
        assertEquals("1st", queue.element());
        assertThrows(NoSuchElementException.class,()->{
           emptyQ.element();
        });
    }
}
