package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1707 {
	static List<List<Integer>> graph;
	static int[] colors;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 테스트 케이스 
		boolean[] result = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			int v = sc.nextInt();	// 정점 개수 
			int e = sc.nextInt();	// 간선 개수 
			// 그래프 초기화 
			graph = new ArrayList<List<Integer>>();
			for(int j = 0; j <v; j++) {
				graph.add(new ArrayList<Integer>());
			}
			// 그래프 설정 
			for(int j = 0; j < e; j++) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			result[i] = true;
			colors = new int[v];
			// dfs로 이분그래프 판별 
			for(int j = 0; j < v; j++) {
				if(colors[j] == 0) {
					colors[j] = 1;
					boolean temp = dfs(j);
					if(!temp) {
						result[i] = false;
						break;
					}
				}
			}
		}
		for(boolean s : result) {
			System.out.println((s ? "YES" : "NO"));
		}
		sc.close();
	}
	public static boolean dfs(int i) {
		int currentColor = colors[i];
		int otherColor = currentColor == 1 ? 2 : 1;
		
		boolean result = true;
		
		for(Integer num : graph.get(i)) {
			if(colors[num] == 0) {
				colors[num] = otherColor;
				result &= dfs(num);
			}else {
				if(colors[num] == currentColor) {
					return false;	// 이진그래프 아님 
				}else {
					continue;
				}
			}
		}
		return result;
	}
}
