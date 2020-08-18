package baekjoon;

import java.util.Scanner;

public class Main9466 {
	static int n; // 학생 수 
	static int[] students; // 학생 번호 
	static int[] visit; // 체크여부 
	static int[] first_student; // 첫번째 학생 번호 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트 케이스 
		while(t > 0) {
			t--;
			n = sc.nextInt();
			students = new int[n];
			visit = new int[n];
			first_student = new int[n];
			for(int i = 0; i < n; i++) {
				students[i] = sc.nextInt() - 1;
				visit[i] = 0;
				first_student[i] = -1;
			}
			
			int count = 0;
			for(int i = 0; i < n; i++) {
				if(visit[i] == 0) {
					count += dfs(i, i, 1);
				}
			}
			System.out.println(n - count);
		}
		sc.close();
	}
	public static int dfs(int start, int current, int cnt) {
		if(visit[current] > 0) {
			if(first_student[current] != start) {
				return 0;
			}
			return cnt - visit[current];
		}
		
		first_student[current] = start; 
		visit[current] = cnt;
		return dfs(start, students[current], cnt+1);
	}
}
// 참고 : https://lmcoa15.tistory.com/51
