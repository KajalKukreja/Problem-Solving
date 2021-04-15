/*
Problem Statement -
https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
*/

package hackerrank;

import java.util.Scanner;

public class InsertionInBST {
   
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
	
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }
	
	 /* Node is defined as :
	 class Node 
	    int data;
	    Node left;
	    Node right;
	*/
	public static Node insert(Node root,int data) {
		if (root == null) {
			return new Node(data);
		}
		if (data < root.data) {
			root.left = insert(root.left, data);
		}
		else {
			root.right = insert(root.right, data);
		}
		return root;
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
      	preOrder(root);
    }	
}