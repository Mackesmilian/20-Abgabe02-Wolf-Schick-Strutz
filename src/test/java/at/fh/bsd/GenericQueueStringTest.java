package at.fh.bsd;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class GenericQueueStringTest {
    static GenericQueue emptyQ;
    static GenericQueue queue;
    @BeforeEach
    public void setup(){
        emptyQ = new GenericQueue(0);
        queue = new GenericQueue(3);
        queue.offer("1st");
        queue.offer("2nd");
    }

    @Test
    public void testOffer(){
        assertTrue(queue.offer("3rd"));
        assertFalse(queue.offer("4th"));
    }

    @Test
    public void testPoll(){
        assertEquals("1st", queue.poll());
        assertEquals("2nd", queue.poll());
        assertNull(queue.poll());
    }
    @Test
    public void testRemove(){
        assertEquals("1st", queue.remove());
        assertEquals("2nd", queue.remove());
        assertThrows(NoSuchElementException.class,()->{
           queue.remove();
        });
    }
    @Test
    public void testPeek(){
        assertEquals("1st", queue.peek());
        assertEquals("1st", queue.peek());
        assertNull(emptyQ.peek());
    }
    @Test
    public void testElement(){
        assertEquals("1st", queue.element());
        assertThrows(NoSuchElementException.class,()->{
           emptyQ.element();
        });
    }
}
