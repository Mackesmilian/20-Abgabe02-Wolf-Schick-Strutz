package at.fh.bsd;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueIntTest {
    static GenericQueue emptyQ;
    static GenericQueue queue;

    /**
     * Creates two queue from the type GenericQueue for testing
     */
    @BeforeEach
    public void setup(){
        emptyQ = new GenericQueue(0);
        queue = new GenericQueue(3);
        queue.offer(1);
        queue.offer(2);
    }

    /**
     * Tests for the offer function
     *
     * assertTrue: fails when returning false
     * tests is successful when the offer function adds the given integer to the queue
     *
     * assertFalse: fails when returning true
     * tests is successful when the offer function does not add the given integer to the queue
     * because ???
     */
    @Test
    public void testOffer(){
        assertTrue(queue.offer(2));
        assertFalse(queue.offer(2));
    }

    /**
     * Tests for the poll function
     *
     * assertEquals: fails if expected integer is not included
     * tests is successful when the given integer will be removed
     *
     * assertNull: fails if the given queue is not null
     * tests is successful when the queue is empty/null
     */
    @Test
    public void testPoll(){
        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertNull(queue.poll());
    }

    /**
     * Tests for the remove function
     *
     * assertEquals: fails if expected integer will not be removed
     * tests is successful when the the expected integer is removed
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * queue now has no integer remaining in the queue therefore the test is successful when the Exception is thrown
     */
    @Test
    public void testRemove(){
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertThrows(NoSuchElementException.class,()->{
            queue.remove();
        });
    }

    /**
     * Tests for the peek function
     *
     * assertEquals: fails if expected integer is not included
     * tests is successful when the expected integer is in the queue
     *
     * assertNotEquals: fails if unexpected String is included
     * tests is successful when the unexpected String is not in the queue
     *
     * assertNull: fails if the NoSuchElementException will not be thrown
     * emptyQ has no element therefore tests is successful when the Exception is thrown
     */
    @Test
    public void testPeek(){
        assertEquals(1, queue.peek());
        assertNotEquals("1", queue.peek()); //just to be sure there is no string hiding somewhere
        assertEquals(1, queue.peek());
        assertNull(emptyQ.peek());
    }

    /**
     * Tests for the element function
     *
     * assertEquals: fails if expected integer is not included
     * tests is successful when the expected integer is in the queue
     *
     * assertThrows: fails if the NoSuchElementException will not be thrown
     * emptyQ has no element therefore tests is successful when the Exception is thrown
     */
    @Test
    public void testElement(){
        assertEquals(1, queue.element());
        assertThrows(NoSuchElementException.class,()->{
            emptyQ.element();
        });
    }
}
