package at.fh.bsd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericQueue implements IQueue<Object> {

    private List<Object> elements = new ArrayList<>();
    private int maxSize;

    /**
     * Constructor for GenericQueue.
     * Makes a new GenericQueue object with initialisation of an integer.
     *
     * @param maxSize determines the maximum size for the queue
     */
    public GenericQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * If you call this function it returns a boolean if the size of the list is not equal the maxSize.
     *
     * @param obj the object given the method
     * @return returns a boolean; true if the object was successfully added, false if not
     */
    @Override
    public boolean offer(Object obj) {
        if (elements.size() != maxSize) {
            elements.add(obj);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Gets the first object in the list then deletes it and returns the value, if not null.
     * If the list is of size 0 this method returns 0 and deletes nothing.
     *
     * @return the object that stands first in the list which got deleted or null
     */
    @Override
    public Object poll() {
        Object element = peek();
        if(elements.size() == 0){
            return null;
        }
        elements.remove(0);
        return element;
    }

    /**
     * Removes the first object by calling poll() if the list is not of size 0.
     * If the list size is 0 there will be thrown an exception.
     *
     * @return calls the poll() method to delete and returns the object that got deleted
     */
    @Override
    public Object remove() {
        if(elements.size() == 0){
            throw new NoSuchElementException("there's no element any more");
        }
        return poll();
    }

    /**
     * If the list is bigger then 0 the method returns the first object, otherwise returns null.
     *
     * @return the first element in the list or null
     */
    @Override
    public Object peek() {
        Object element;
        if(elements.size() > 0){
            element = elements.get(0);
        }else{
            element = null;
        }
        return element;
    }

    /**
     * Gets the first element in the list if the element is not null.
     * If the element is null there will be thrown an exception.
     *
     * @return the first element in the list
     */
    @Override
    public Object element() {
        Object element = peek();
        if(element == null){
            throw new NoSuchElementException("there's no element any more");
        }
        return element;
    }

}
