/*
Q3. Implement a stack using 2 queues.
*/

import java.util.Scanner;
class Queue
{
	private int arr[];
	private int size, front, rear;
	
	Queue(int size)
	{
		this.size = size;
		arr = new int[this.size];
		front = rear = -1;
	}
	int count()
	{
		if(front == -1)
			return 0;
		else
			return rear-front+1;
	}
	boolean isEmpty()
	{
		if(front == -1)
			return true;
		else
			return false;
	}
	void enqueue(int data)
	{
		if(rear == size-1)
			System.out.println("// OVERFLOW");
		else
		{
			arr[++rear] = data;
			if(front == -1)
				front++;
		}
	}
	int dequeue()
	{
		if(front == -1)
		{
			System.out.println("// UNDERFLOW");
			return -1;
		}
		else
		{
			int data = arr[front];
			if(front == rear)
				front = rear = -1;
			else
				front++;
			return data;
		}
	}
	int peek()
	{
		if(isEmpty())
			return -1;
		else
			return arr[front];
	}
	void revdisplay()
	{
		if(isEmpty())
			System.out.println("Empty.");
		else
		{
			for(int i=rear;i>=front;i--)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
	// Not needed
	// void display()
	// {
		// if(isEmpty())
			// System.out.println("Empty.");
		// else
		// {
			// for(int i=front;i<=rear;i++)
				// System.out.print(arr[i] + " ");
			// System.out.println();
		// }
	// }
}
class Stack
{
	private Queue q1, q2;
	Stack(int size)
	{
		q1 = new Queue(size);
		q2 = new Queue(size);
	}
	void push(int data)
	{
		q1.enqueue(data);
	}
	int pop()
	{
		while(q1.count() > 1)
		{
			q2.enqueue(q1.dequeue());
		}
		int data = q1.dequeue();
		
		Queue temp = q1;
		q1 = q2;
		q2 = temp;
		return data;
	}
	void display()
	{
		q1.revdisplay();
	}
}
public class q3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of stack : ");
		int n = sc.nextInt();
		Stack s = new Stack(n);
		
		System.out.println("\n---------------------");
		System.out.println("Enter 1 to push().");
		System.out.println("Enter 2 to pop().");
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
						System.out.print("Enter number to push : ");
						s.push(sc.nextInt());
						System.out.println("> Done");
						break;
				
				case 2:
						System.out.println("Popped out : " + s.pop() + " from the stack.");
						System.out.println("> Done");
						break;
				
				case 3:
						System.out.println("Stack :-");
						s.display();
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