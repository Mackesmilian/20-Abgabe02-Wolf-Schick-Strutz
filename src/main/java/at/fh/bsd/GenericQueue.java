package at.fh.bsd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GenericQueue implements IQueue<Object> {

    private List<Object> elements = new ArrayList<>();
    private int maxSize;


    @Override
    public boolean offer(Object obj) {
        if (elements.size() != maxSize) {
            elements.add(obj);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Object poll() {
        Object element = peek();
        if(elements.size() == 0){
            return null;
        }
        elements.remove(0);
        return element;
    }

    @Override
    public Object remove() {
        if(elements.size() == 0){
            throw new NoSuchElementException("there's no element any more");
        }
        return poll();
    }

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

    @Override
    public Object element() {
        Object element = peek();
        if(element == null){
            throw new NoSuchElementException("there's no element any more");
        }
        return element;
    }
}
