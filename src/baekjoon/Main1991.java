package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1991 {
	public static class Tree {
		Node root;
		public void add(char data, char leftData, char rightData) {
			if(root == null) { // 루트가 비어있으면 루트생성, 루트의 left, right 넣어준다.
				if(data != '.') {
					root = new Node(data);
				}
				if(leftData != '.') {
					root.left = new Node(leftData);
				}
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			}else { // 루트가 비어있지 않으면, data 찾아서 left, right 넣어준다.
				search(root, data, leftData, rightData);
			}
		}
		private void search(Node root, char data, char leftData, char rightData) {
			if(root == null) return;
			if(root.data == data) { // data 위치를 찾았으면 left, right 넣어준다.
				if(leftData != '.') {
					root.left = new Node(leftData);
				}
				if(rightData != '.') {
					root.right = new Node(rightData);
				}
			}else { // data 위치를 못찾았으면, 다시 밑으로 내려가서 찾는다.
				search(root.left, data, leftData, rightData);
				search(root.right, data, leftData, rightData);
			}
		}
	}
	public static class Node {
		char data;
		Node left, right;
		public Node(char data) {
			this.data = data;
		}
	}
	// 전위순회 : 루트, 좌, 우
	public static void preorder(Node root) {
		System.out.print(root.data);
		if(root.left != null) preorder(root.left);
		if(root.right != null) preorder(root.right);
	}
	// 중위순회 : 좌, 루트, 우
	public static void inorder(Node root) {
		if(root.left != null) inorder(root.left);
		System.out.print(root.data);
		if(root.right != null) inorder(root.right);
	}
	// 후위순회 : 좌, 우, 루트
	public static void postorder(Node root) {
		if(root.left != null) postorder(root.left);
		if(root.right != null) postorder(root.right);
		System.out.print(root.data);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		char[] data = new char[3];
		Tree tree = new Tree();
		for(int i = 0; i < n; i++) {
			data = in.readLine().replaceAll(" ", "").toCharArray();
			tree.add(data[0], data[1], data[2]);
		}
		preorder(tree.root);
		System.out.println();
		inorder(tree.root);
		System.out.println();
		postorder(tree.root);
		System.out.println();
		in.close();
	}

}
// 참고 : https://m.blog.naver.com/occidere/220899936160
