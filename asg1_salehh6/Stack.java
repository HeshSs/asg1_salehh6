package asg1_salehh6;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Question 4
 */
public class Stack implements Iterable<String> {
    private Node first;
    private int size;

	Stack() {
		first = null;
		setSize(0);
	}
	
    private static class Node {
        private String item;
        private Node next;
    }
    
    public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        setSize(getSize() + 1);
    }
    
    public String pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        String item = first.item;
        first = first.next;
        size--;
        return item;
    }
    
    public String peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    
    public Stack copy() {
    	ArrayList<String> list = new ArrayList<>();
    	for (String s : this) {
    		list.add(s);
    	}
    	Collections.reverse(list);
    	Stack stack = new Stack();
    	for (String s : list) {
    		stack.push(s);
    	}
    	return stack;
    }
    
    public Stack inverse() {
    	Stack stack = new Stack();
    	for (String s : this) {
    		stack.push(s);
    	}
    	return stack;
    }
    
    public Iterator<String> iterator() {
        return new ListIterator(first);
    }

    private class ListIterator implements Iterator<String> {
        private Node current;

        public ListIterator(Node first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String item = current.item;
            current = current.next; 
            return item;
        }
                
    }
}
