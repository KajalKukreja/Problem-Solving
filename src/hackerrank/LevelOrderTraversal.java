/*
Problem Statement -
https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
*/

package hackerrank;

import java.util.Scanner;

public class LevelOrderTraversal {

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
	
	/* 
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
		for (int i = 0; i <= getHeight(root); i++) {
			printLevel(root, i);
		}
    }

	private static int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	private static void printLevel(Node root, int level) {
		if (root == null) {
			return;
		}
		if (level == 0) {
			System.out.print(root.data + " ");
		}
		else {
			printLevel(root.left, level-1);
			printLevel(root.right, level-1);
		}
	}
	
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
