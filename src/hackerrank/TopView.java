/*
Problem Statement -
https://www.hackerrank.com/challenges/tree-top-view/problem
*/

package hackerrank;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class TopView {
	
	static class Pair<U, V> {
		U first;
		V second;
		
		Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}
	}

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
	public static void topView(Node root) {
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair<Node, Integer>> queue = new LinkedList<>();		
		if (root == null) {
			return;
		}
		
		//add root in map and queue
		map.put(0, root.data);
		queue.add(new Pair<Node, Integer>(root, 0));
		
		while (!queue.isEmpty()) {
			
			//remove head and explore its children
			Pair<Node, Integer> currElem = queue.poll();
			
			if (currElem.first != null && currElem.first.left != null) {
				int verticalHeight = currElem.second - 1;
				if (map.get(verticalHeight) == null) {
					map.put(verticalHeight, currElem.first.left.data);
				}
				queue.add(new Pair<Node, Integer>(currElem.first.left, verticalHeight));
			}
			if (currElem.first != null && currElem.first.right != null) {
				int verticalHeight = currElem.second + 1;
				if (map.get(verticalHeight) == null) {
					map.put(verticalHeight, currElem.first.right.data);
				}
				queue.add(new Pair<Node, Integer>(currElem.first.right, verticalHeight));
			}
		}
		
		for (Integer i : map.values()) {
			System.out.print(i + " ");
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
        topView(root);
    }	
}
