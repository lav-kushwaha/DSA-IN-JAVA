package Recursion.Questions;
import java.util.*;
import java.lang.*;

// Java program to create Special triangle.
//https://www.geeksforgeeks.org/sum-triangle-from-array/

public class ConstructTriangle
{
	// Function to generate Special Triangle.
	public static void printTriangle(int[] A)
	{
		// Base case
		if(A.length<1){
			return;
		}
		int [] temp = new int[A.length-1];
		for (int i=0; i<A.length-1;i++){
			int x = A[i]+A[i+1];
			temp[i]=x;
		}
		printTriangle(temp);
		System.out.println(Arrays.toString(A));
	}

	// Driver function.
	public static void main(String[] args)
	{
		int[] A = { 1, 2, 3, 4, 5 };
		printTriangle(A);
	}
}
