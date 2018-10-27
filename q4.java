/*
**Q4.Implement a class MinStack using the stack class we have already built. It should support O(1) push, O(1) pop and O(1) getMinimum() functions where getMinimum() returns the minimum element present in the stack. (Hint: You would need two stacks for doing this)
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
}
class MinStack
{
	Stack s1, min;
	MinStack(int size)
	{
		s1 = new Stack(size);
		min = new Stack(size);
	}
	void push(int data)
	{
		s1.push(data);
		
		if(min.isEmpty() || min.peek() > data)		// pushing element into min stack only if it's smaller than the previous min.top element
			min.push(data);
	}
	int pop()
	{
		if(s1.isEmpty())
		{
			System.out.println("// UNDERFLOW");
			return -1;
		}
		int data;
		if(s1.peek() == min.peek())
		{
			data = s1.pop();
			min.pop();
		}
		else
			data = s1.pop();
		return data;
	}
	void display()
	{
		s1.display();
		System.out.println("\nMin element : " + getMinimum());
	}
	int getMinimum()
	{
		if(min.isEmpty())
		{
			System.out.println("// MinStack is empty.");
			return -1;
		}
		else
			return min.peek();
	}
}
public class q4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of stack : ");
		int n = sc.nextInt();
		MinStack s = new MinStack(n);
		
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