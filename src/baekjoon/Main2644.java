import java.util.Scanner;

public class Main2644 {
	static int n;
	static boolean[] visit;
	static int[][] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 사람수
		int a = sc.nextInt() - 1; // 촌수 계산해야 하는 사람1
		int b = sc.nextInt() - 1; // 촌수 계산해야 하는 사람2
		int m = sc.nextInt(); // 부모자식 관계 수
		array = new int[n][n];
		int x, y;
		for(int i = 0; i < m; i++) {
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			array[x][y] = 1;
			array[y][x] = 1;
		}
		
		visit = new boolean[n];
		int result = countChon(a, b, 0);
		System.out.println(result);
		
		sc.close();
	}
	
	public static int countChon(int current, int goal, int cnt) {
		visit[current] = true;
		
		if(current == goal) {
			return cnt;
		}
		
		int result = -1;
		
		for(int i = 0; i < n; i++) {
			if(!visit[i] && array[current][i] == 1) {
				result = countChon(i, goal, cnt+1);
				
				if(result != -1) {
					break;
				}
			}
		}
		return result;
	}
	
}




/*
9
7 3
7
1 2
1 4
2 7
2 8
2 9
4 5
4 6

0 1 1 0 0 0 0 0 0 
1 0 0 0 0 0 1 1 1 
1 0 0 0 0 0 0 0 0 
0 0 0 0 1 1 0 0 0 
0 0 0 1 0 0 0 0 0 
0 0 0 1 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 

7->3

시작7
7 -> 2
	2 -> 1,8,9
		1 -> 3 (!!3)
		8 -> 
		9 -> 
*/
