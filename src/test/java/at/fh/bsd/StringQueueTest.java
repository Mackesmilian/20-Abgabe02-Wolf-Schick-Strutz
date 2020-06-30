package at.fh.bsd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringQueueTest {
    static StringQueue queue;
    static StringQueue offerTest;

    @BeforeEach
    public void setup(){
        queue = new StringQueue(0);
        offerTest = new StringQueue(2);
    }
    @Test
    public void testConstructor(){
        assertFalse(queue.offer("1st"));
    }
    @Test
    public void testOffer(){
        assertTrue(offerTest.offer("1st,2nd"));
    }

}