/*
Q1. Implement a stack and a queue.
*/

import java.util.Scanner;
class Node
{
	int data;
	Node next;
	
	Node(int data)
	{
		this.data = data;
	}
}
class Stack
{
	private Node top;
	
	void push(int data)
	{
		Node temp = new Node(data);
		if(isEmpty())
			top = temp;
		else
		{
			temp.next = top;
			top = temp;
		}
	}
	int pop()
	{
		int data = peek();
		top = top.next;
		return data;
	}
	boolean isEmpty()
	{
		if(top == null)
			return true;
		else
			return false;
	}
	int peek()
	{
		if(isEmpty())
		{
			System.out.println("top = null");
			return -1;
		}
		return top.data;
	}
	void display()
	{
		System.out.print("STACK : ");
		if(isEmpty())
			System.out.println("empty");
		Node ptr = top;
		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}
class Queue
{
	private Node front, rear;
	
	void enqueue(int data)
	{
		Node temp = new Node(data);
		if(isEmpty())
		{
			front = rear = temp;
		}
		else
		{
			Node ptr = front;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = temp;
			rear = temp;
		}
	}
	int dequeue()
	{
		int data = peek();
		front = front.next;
		return data;
	}
	boolean isEmpty()
	{
		if(front == null)
			return true;
		else
			return false;
	}
	int peek()
	{
		if(isEmpty())
		{
			System.out.println("front = null");
			return -1;
		}
		return front.data;
	}
	void display()
	{
		System.out.print("QUEUE : ");
		if(isEmpty())
			System.out.println("empty");
		Node ptr = front;
		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
}
public class q1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------");
		System.out.println("Implementing a Stack..");
		System.out.println("----------------------");
		Stack s = new Stack();
		System.out.print("> Enter size : ");
		int n1 = sc.nextInt();
		System.out.print("> Enter elements : ");
		for(int i=0;i<n1;i++)
			s.push(sc.nextInt());
		s.display();
		System.out.println("Now we'll pop() an element..." + s.pop() + " popped out.\n");
		s.display();
		System.out.println("\ns.isEmpty() = " + s.isEmpty());
		System.out.println("s.peek() = " + s.peek());
		System.out.println("----------------------");
		
		System.out.println();
		
		System.out.println("----------------------");
		System.out.println("Implementing a Queue..");
		System.out.println("----------------------");
		Queue q = new Queue();
		System.out.print("> Enter size : ");
		int n2 = sc.nextInt();
		System.out.print("> Enter elements : ");
		for(int i=0;i<n2;i++)
			q.enqueue(sc.nextInt());
		q.display();
		System.out.println("Now we'll dequeue() an element..." + q.dequeue() + " was removed.\n");
		q.display();
		System.out.println("\nq.isEmpty() = " + q.isEmpty());
		System.out.println("q.peek() = " + q.peek());
		System.out.println("----------------------");
	}
}