package baekjoon;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main1966 {
	static class Pair {
		int index;
		int priority;
		public Pair(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트케이스
		int[] result = new int[t]; // 결과값 저장 
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();	// n개
			int m = sc.nextInt();	// 위치
			int count = 0;
			
			Queue<Pair> queue = new ArrayDeque<Pair>();
			PriorityQueue<Integer> priority = new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int j = 0; j < n; j++) {
				int num = sc.nextInt();
				queue.add(new Pair(j, num));
				priority.add(num);
			}
		
			while(!queue.isEmpty()) {
				Pair current = queue.poll();
				int max = priority.peek();
				
				if(current.priority == max) {
					priority.poll();
					count++;
					
					if(current.index == m) {
						result[i] = count;
						break;
					}
				} else {
					queue.add(current);
				}
			}
		}
		for(int r : result) {
			System.out.println(r);
		}
		sc.close();
	}
}
