package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// dfs, bfs
public class Main1260 {
	static int n,m,v;
	static int[][] node;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점 개수
		m = sc.nextInt(); // 간선 개수
		v = sc.nextInt(); // 탐색을 시작할 정점의 번호
		int x, y;
		node = new int[n+1][n+1];
		for(int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			node[x][y] = 1;
			node[y][x] = 1;
		}
		
		// dfs
		boolean[] visit = new boolean[n+1];
		dfs(v, visit);
		System.out.println();
		
		// bfs
		bfs(v);
		System.out.println();
		
		sc.close();
	}
	public static void dfs(int index, boolean[] visit) {
		if(visit[index]) return;
		visit[index] = true;
		System.out.print(index + " ");
		for(int i = 1; i <= n; i++) {
			if(!visit[i] && node[index][i] == 1) {
				dfs(i, visit);
			}
		}
	}
	public static void bfs(int start) {
		boolean[] visit = new boolean[n+1];
		visit[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			System.out.print(a + " ");
			
			for(int i = 1; i <= n; i++) {
				if(!visit[i] && node[a][i] == 1) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
