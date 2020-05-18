package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main6549 {
	public static class Pair {
		int index;
		int height;
		public Pair(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isEnd = false;
		while(!isEnd) {
			int n = sc.nextInt(); // 테스트 케이스
			if(n == 0) {
				isEnd = true;
				break;
			}
			
			long ans = 0L;
			Stack<Pair> stack = new Stack<>();
			for(int i = 0; i <= n; i++) {
				int i_height;
				if(i == n) i_height = -1;
				else i_height = sc.nextInt();
				int left = i;
				while(!stack.empty() && stack.peek().height > i_height) {
					ans = Math.max(ans, ((long)i - (long)stack.peek().index) * (long)stack.peek().height);
					left = stack.peek().index;
					stack.pop();
				}
				stack.push(new Pair(left, i_height));
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
//참고 : https://greeksharifa.github.io/ps/2018/07/07/PS-06549/
