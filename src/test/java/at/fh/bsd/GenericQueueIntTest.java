package at.fh.bsd;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueIntTest {
    static GenericQueue emptyQ;
    static GenericQueue queue;

    @BeforeEach
    public void setup(){
        emptyQ = new GenericQueue(0);
        queue = new GenericQueue(3);
        queue.offer(1);
        queue.offer(2);
    }

    @Test
    public void testOffer(){
        assertTrue(queue.offer(2));
        assertFalse(queue.offer(2));
    }

    @Test
    public void testPoll(){
        assertEquals(1, queue.poll());
        assertEquals(2, queue.poll());
        assertNull(queue.poll());
    }
    @Test
    public void testRemove(){
        assertEquals(1, queue.remove());
        assertEquals(2, queue.remove());
        assertThrows(NoSuchElementException.class,()->{
            queue.remove();
        });
    }
    @Test
    public void testPeek(){
        assertEquals(1, queue.peek());
        assertNotEquals("1", queue.peek()); //just to be sure there is no string hiding somewhere
        assertEquals(1, queue.peek());
        assertNull(emptyQ.peek());
    }
    @Test
    public void testElement(){
        assertEquals(1, queue.element());
        assertThrows(NoSuchElementException.class,()->{
            emptyQ.element();
        });
    }
}
