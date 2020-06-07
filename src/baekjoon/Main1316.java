package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class Main1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 단어 개수
		String[] word = new String[n];
		for(int i = 0; i < n; i++) {
			word[i] = sc.next();
		}

		int result = 0;
		boolean isGroup = false;
		char temp;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			isGroup = true;
			temp = word[i].charAt(0);
			for(char c : word[i].toCharArray()) {
				if(temp != c && map.containsKey(c)) {
					isGroup = false;
					break;
				}else {
					map.put(c, 1);
				}
				temp = c;
			}
			if(isGroup) {
				result++;
			}
			map.clear();
		}
		System.out.println(result);
		sc.close();
	}

}
