/*
Problem Statement -
https://www.hackerrank.com/challenges/is-binary-search-tree/problem
*/

package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class IsThisABST {

	//Adding it inside main class due to conflicts with other solutions using same class name Node
	static class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
	
	/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

	The Node class is defined as follows:
	    class Node {
	    int data;
	    Node left;
	    Node right;
	     }
	*/
	private static List<Integer> list = new ArrayList<>();
    
    boolean checkBST(Node root) {
        inOrder(root);
        return isSorted(list);
    }
    
    private static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.data);
            inOrder(root.right);
        }
    }
    
    private static boolean isSorted(List<Integer> list) {
    	for (int i = 0; i < list.size()-1; i++) {
            if (i+1 < list.size() && list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}
