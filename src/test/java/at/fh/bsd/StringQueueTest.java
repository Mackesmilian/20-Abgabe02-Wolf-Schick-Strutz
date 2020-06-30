package at.fh.bsd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringQueueTest {
    static StringQueue queue;

    @BeforeEach
    public void setup(){
        queue = new StringQueue(0);
    }
    @Test
    public void testConstructor(){
        assertFalse(queue.offer("1st"));
    }

}