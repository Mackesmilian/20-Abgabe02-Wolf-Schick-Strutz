package at.fh.bsd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StringQueueTest {
    static StringQueue queue;
    static StringQueue offerTest;

    @BeforeEach
    public void setup(){
        queue = new StringQueue(0);
        offerTest = new StringQueue(1);
    }

    @Test
    public void testOffer(){
        assertFalse(queue.offer("1st"));
        assertTrue(offerTest.offer("1st"));
    }
    @Test
    public void testPoll(){
        offerTest.offer("1st"); //the element in the test before gets deleted, therefore you need a new one
        assertEquals("1st", offerTest.poll());
        assertNull(queue.poll());
    }
    @Test
    public void testRemove(){
        offerTest.offer("1st");
        assertEquals("1st", offerTest.remove());
        assertThrows(NoSuchElementException.class,()->{
            offerTest.remove();
        });
    }
    @Test
    public void testElement(){
        offerTest.offer("1st");
        assertEquals("1st", offerTest.element());
        assertThrows(NoSuchElementException.class,()->{
            queue.element();
        });
    }

}