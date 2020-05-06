package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 문자열로 입력 받음.
		int len = str.length(); // 문자열 길이 
		
		String num = "";
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0; i < len; i++) {
			String sub = str.substring(i, i+1);
			if(sub.equals("+")) {
				queue.add(num);
				num = "";
			}else if(sub.equals("-")) {
				queue.add(num);
				queue.add(")");
				num = "";
			}else {
				num += sub;
			}
		}
		queue.add(num);
		queue.add(")");
		
		int result = 0;
		int temp = 0;
		boolean isFirstInt = true;
		while(!queue.isEmpty()) {
			String s = queue.poll();
			if(s.equals(")")) {
				if(isFirstInt) {
					result = temp;
					isFirstInt = false;
				}else {
					result -= temp;
				}
				temp = 0;
			}else {
				temp += Integer.valueOf(s);
			}
		}
		System.out.println(result);
		sc.close();
	}
}
