package at.fh.bsd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringQueueTest {
    static StringQueue queue;

    @BeforeEach
    public void setup(){
        queue = new StringQueue(2);
    }
    @Test
    public void testConstructor(){
        assertTrue(queue.offer("1st"));
        assertTrue(queue.offer("1st"));
        assertFalse(queue.offer("1st"));
    }

}