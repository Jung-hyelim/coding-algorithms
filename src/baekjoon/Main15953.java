package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main15953 {
	static int[][] A = {{1, 500},{2, 300},{3, 200},{4, 50},{5, 30},{6, 10}};
	static int[][] B = {{1, 512},{2, 256},{4, 128},{8, 64},{16, 32}};
	static Map<Integer, Integer> AReward = new HashMap<Integer, Integer>();
	static Map<Integer, Integer> BReward = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		init();
		
		int t = sc.nextInt(); // 테스트 케이스
		int[] result = new int[t];
		int a, b;
		for(int i = 0; i < t; i++) {
			a = sc.nextInt(); // 제1회 대회 등수 
			b = sc.nextInt(); // 제2회 대회 등수
			result[i] = (AReward.containsKey(a) ? AReward.get(a) : 0) + (BReward.containsKey(b) ? BReward.get(b) : 0);
		}
		for(int i : result) {
			System.out.println(i * 10000);
		}
		sc.close();
	}
	public static void init() {
		int rank = 1;
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[i][0]; j++) {
				AReward.put(rank++, A[i][1]);
			}
		}
		rank = 1;
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[i][0]; j++) {
				BReward.put(rank++, B[i][1]);
			}
		}
	}
}
