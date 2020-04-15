package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main1068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 노드 개수 
		int[] node = new int[n];
		for(int i = 0; i < n; i++) {
			node[i] = sc.nextInt();	// 노드 입력 
		}
		int deleteNode = sc.nextInt();	// 지울 노드 번호
		
		// 노드 지우기 
		node[deleteNode] = -99;
		
		// 리프 노드개수 카운트 
		int leafCount = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		// 루트 노드 찾아서 스택에 넣기
		for(int i = 0; i < n; i++) {
			if(node[i] == -1) {
				stack.add(i);
				break;
			}
		}
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				if(node[i] == index) {
					stack.add(i);
					cnt++;
				}
			}
			// 
			if(cnt == 0) {
				leafCount++;
			}
			
		}
		
		System.out.println(leafCount);
		sc.close();
	}
}
