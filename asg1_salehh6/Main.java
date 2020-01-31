package asg1_salehh6;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Hishmat Salehi
 * All the tests for the classes, methods and functions for 2C03 Assignment 1 are run here.
 */
public class Main {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			timer(i);
		}
		
	}
	
	// Question 5
	private class Node {
		Double item;
		Node next;
	}
	
	public void insertAfter(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return;
		} 
		
		Node firstNext = node1.next;
		node1.next = node2;
		node2.next = firstNext;
	}
	
	// Question 6
	public double max(Node first) {
		double max = 0;
		if (first == null) {
			return max;
		}
		
		Node currentNode = first;
		while (currentNode.next != null) {
			if (currentNode.item > max) {
				max = currentNode.item;
			}
			currentNode = currentNode.next;
		}
		
		return max;
	}
	
	// Question 7
	public double max(CircularBuffer buffer) {
		double max = 0;
		
		for (int i = 0; i < buffer.getSize(); i++) {
			double element = buffer.getElement(i);
		
			if (element > 0) {
				if (element > max) {
					max = element;
				}
			}
		}
		
		return max;
	}
	
	// Question 13
	public static double efficientProgram(double n, int i) {
		if (n == 0) return 0;
		if (i == 0) return n;
		return Math.pow(n, efficientProgram(n, i-1));
	}
	
	public static void timer(double n) {
	    long start2 = System.nanoTime();
	    System.out.println(efficientProgram(n, 3));
	    long finish2 = System.nanoTime();
		long timeElapsed = (finish2 - start2); 

		System.out.println("The time elapsed for efficientProgram2 is: " + timeElapsed);

	}
}
