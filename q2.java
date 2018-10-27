/*
Q2. Implement a queue using 2 stacks.
*/

import java.util.Scanner;
class Stack
{
	private int arr[];
	private int size, top;
	
	Stack(int size)
	{
		this.size = size;
		arr = new int[this.size];
		top = -1;
	}
	void push(int data)
	{
		if(top == size-1)
		{
			System.out.println("// OVERFLOW");
		}
		else
			arr[++top] = data;
	}
	boolean isEmpty()
	{
		if(top == -1)
			return true;
		else
			return false;
	}
	int pop()
	{
		if(top == -1)
		{
			System.out.println("// UNDERFLOW");
			return -1;
		}
		return arr[top--];
	}
	int peek()
	{
		if(isEmpty())
			return -1;
		else
			return arr[top];
	}
	void display()
	{
		if(isEmpty())
			System.out.println("Empty.");
		else
		{
			for(int i=top;i>=0;i--)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
	void revdisplay()
	{
		if(isEmpty())
			System.out.println("Empty.");
		else
		{
			for(int i=0;i<=top;i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}
class Queue
{
	private Stack s1, s2;
	
	Queue(int size)
	{
		s1 = new Stack(size);
		s2 = new Stack(size);
	}
	void enqueue(int data)
	{
		s1.push(data);
	}
	int dequeue()
	{
		if(!s2.isEmpty())				// emptying s2 if its filled
			while(!s2.isEmpty())
				s2.pop();
		
		while(!s1.isEmpty())			// copying s1 into s2 in reverse
		{
			s2.push(s1.pop());
		}
		int data = s2.pop();			// popping from s2
		while(!s2.isEmpty())			// copying back s2 into s1 in reverse
		{
			s1.push(s2.pop());
		}
		return data;
	}
	void display()
	{
		if(s1.isEmpty())
		{
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
			s1.display();
		}
		else
			s1.revdisplay();
	}
}
public class q2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of queue : ");
		int n = sc.nextInt();
		Queue q = new Queue(n);
		
		System.out.println("\n---------------------");
		System.out.println("Enter 1 to enqueue().");
		System.out.println("Enter 2 to dequeue().");
		System.out.println("Enter 3 to display().");
		System.out.println("Enter -1 to exit.");
		System.out.println("\n---------------------");
		System.out.print("Enter choice : ");
		int choice = sc.nextInt();
		while(choice != -1)
		{
			switch(choice)
			{
				case 1:
						System.out.print("Enter number to enqueue : ");
						q.enqueue(sc.nextInt());
						System.out.println("> Done");
						break;
				
				case 2:
						System.out.println("Removed : " + q.dequeue() + " from the queue.");
						System.out.println("> Done");
						break;
				
				case 3:
						System.out.println("Queue :-");
						q.display();
						break;
				
				default:
						System.out.println("> Invalid choice.");
			}
			System.out.println("\n---------------------");
			System.out.print("Enter choice : ");
			choice = sc.nextInt();
		}
		
		System.out.println();
	}
}