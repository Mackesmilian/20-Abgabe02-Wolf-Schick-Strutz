# 20-Abgabe02-Wolf-Schick-Strutz 

## Overview

This is the documentation for our site for the project based upon the
provided IQueue interface and StringQueue implementation of said interface.
We corrected some errors in the StringQueue implementation, added a generic 
implementation of IQueue and created tests for all classes to reach 100% test coverage.

## What is a Queue?

A queue is a simple collection which is based upon the first in, first out principle,
much like a queue you would encounter in real life. You enqueue at the end of the 
queue, wait for all people in front of you to dequeue until you can dequeue yourself.
This is useful as we can use the queue to store entities which need to be processed 
later which makes the queue useful as a buffer.

## How do you Test a Queue?

Our approach was to simply add and remove objects to the queue and monitor the 
behaviour of the corresponding method that's being tested. This means for example 
that `offer()` (as seen below) can behave in two different ways: If you add an object 
and the queue is not full (or smaller than the maximum size previously specified)
the object will be added and `offer()` will return `true`. If the queue is full, 
it will return `false`. 
```Java
@Override
    public boolean offer(String obj) {
        if (elements.size() != maxSize)
            elements.add(obj);
        else
            return false;

        return true;
    }
```
Same goes for all other methods. We considered their behaviour and return values 
based on the implementation and tested these aspects. For example the methods
`poll()` and `remove()` have the same desired effect (they remove and return the 
next element) but they differ in their behaviour when the queue is empty: `poll()`
returns `null` and `remove` throws an exception. The test methods for both methods
can be seen here:

```Java
@Test
    public void testPoll(){
        offerTest.offer("1st"); 
        assertEquals("1st", offerTest.poll());
        assertNull(queue.poll());
    }
```
```Java
@Test
    public void testRemove(){
        offerTest.offer("1st");
        assertEquals("1st", offerTest.remove());
        assertThrows(NoSuchElementException.class,()->{
            offerTest.remove();
        });
    }
```