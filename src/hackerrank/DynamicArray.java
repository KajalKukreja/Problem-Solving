/*
Problem Statement -
https://www.hackerrank.com/challenges/dynamic-array/problem
*/

package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		List<List<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}

		int lastAnswer = 0;
		List<Integer> result = new ArrayList<>();

		for (List<Integer> query : queries) {
			int o = query.get(0);
			int x = query.get(1);
			int y = query.get(2);

			if (o == 1) {
				int index = ((x ^ lastAnswer) % n);
				List<Integer> list = arr.get(index);
				if (list != null) {
					list.add(y);
				}
			} else if (o == 2) {
				int index = ((x ^ lastAnswer) % n);
				List<Integer> list = arr.get(index);
				if (list != null) {
					int elem = y % list.size();
					lastAnswer = list.get(elem);
					result.add(lastAnswer);
				}
			}
		}
		return result;
	}
}

public class DynamicArray {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int q = scanner.nextInt();

		List<List<Integer>> queries = new ArrayList<>();
		while (q-- > 0) {
			List<Integer> list = new ArrayList<>();
			list.add(scanner.nextInt());
			list.add(scanner.nextInt());
			list.add(scanner.nextInt());
			queries.add(list);
		}

		List<Integer> result = Result.dynamicArray(n, queries);
		for (int i : result) {
			System.out.println(i);
		}
		scanner.close();
	}
}
