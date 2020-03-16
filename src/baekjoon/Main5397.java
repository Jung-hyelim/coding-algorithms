import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());	// 테스트케이스 
		for(int i = 0; i < n; i++) {
			String input = bf.readLine();
			for(Character c : getPassword(input)) {
				bw.write(c);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static List<Character> getPassword(String input) {
		int cursor = 0;	// 커서 위치
		List<Character> list = new LinkedList<Character>();
		// ArrayList 의 remove 시간복잡도는 O(n) - 중간에 삭제한 후 앞에꺼를 다 땡겨와야 함.
		// LinkedList 의 remove 시간복잡도는 O(n) , 맨앞과 맨뒤는 O(1)
		
		for(char current : input.toCharArray()) {
			if(current == '<') {
				cursor--;
				if(cursor < 0) cursor = 0;
			}else if(current == '>') {
				cursor++;
				if(cursor > list.size()) cursor = list.size();
			}else if(current == '-') {
				cursor--;
				if(cursor >= 0 && cursor < list.size()) list.remove(cursor);
				if(cursor < 0) cursor = 0;
			}else {
				list.add(cursor, current);
				cursor++;
				if(cursor > list.size()) cursor = list.size();
			}
		}
		return list;
	}
}
