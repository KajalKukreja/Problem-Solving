/*
Problem Statement -
https://www.hackerrank.com/challenges/arrays-ds/problem
*/

package hackerrank;

import java.util.Scanner;

public class ArraysDS {

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
		int[] result = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			result[a.length - 1 - i] = a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrCount = Integer.parseInt(scanner.nextLine());
		int[] arr = new int[arrCount];
		for (int i = 0; i < arrCount; i++) {
			arr[i] = scanner.nextInt();
		}

		int[] res = reverseArray(arr);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

		scanner.close();
	}
}

