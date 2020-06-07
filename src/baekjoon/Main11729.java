package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11729 {
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
		int n = Integer.parseInt(bf.readLine()); // 원판 개수
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
		int cnt = (int)Math.pow(2d, n) - 1;
		bw.write(cnt + "\n");
		hanoi(n, 1, 3, 2);
		bw.flush();
		bw.close();
	}
	public static void hanoi(int n, int start, int to, int via) throws IOException {
		if(n == 1) {
			bw.write(start + " " + to + "\n");
		}else {
			hanoi(n-1, start, via, to);
			bw.write(start + " " + to + "\n");
			hanoi(n-1, via, to, start);
		}
	}
}
