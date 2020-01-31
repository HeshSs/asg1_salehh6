package asg1_salehh6;
/**
 * Question 8
 */
public class DoubleNode {
	Node first;
	
    class Node {
        double data; 
        Node prev; 
        Node next; 
        
        Node(double d) {
        	this.data = d;
        }
    }
    
    public void insertFront(double data) {
    	Node newNode = new Node(data);
    	
    	newNode.next = first;
    	newNode.prev = null;
    	
    	if (first != null) {
    		first.prev = newNode;
    	}
    	
    	first = newNode;
    }
    
    public void insertBack(double data) {
    	if (first == null) {
    		insertFront(data);
    		return;
    	}
    	
    	Node newNode = new Node(data);
    	Node current = first;
    	
    	newNode.next = null;
    	
    	while (current.next != null) {
    		current = current.next;
    	}
    	
    	current.next = newNode;
    	newNode.prev = current;
    	
    }
    
    public void insertBefore(Node node, double data) {
    	if (node == null) {
    		return;
    	}
    	
    	Node newNode = new Node(data);
    	newNode.prev = node.prev;
    	node.prev.next = newNode;
    	newNode.next = node;
    	node.prev = newNode;
    	
    }
    
    public void insertAfter(Node node, double data) {
    	if (node == null) {
    		return;
    	}
    	
    	Node newNode = new Node(data);
    	newNode.next = node.next;
    	node.next = newNode;
    	newNode.prev = node;
    	
    	if (newNode.next != null) {
    		newNode.next.prev = newNode;
    	}
    }
    
    public void removeFront() {
    	first.next.prev = null;
    	first = first.next;
    }
    
    public void removeBack() {
    	Node current = first;
    	
    	while (current.next != null) {
    		current = current.next;
    	}
    	
    	current.prev.next = null;
    	current = null;
    	
    }
    
    public void remove(Node node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
}
