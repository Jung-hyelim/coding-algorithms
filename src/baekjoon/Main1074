package baekjoon;
import java.util.Scanner;

public class Main1074 {
	public static int r;
	public static int c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 배열 크기 = 2^n * 2^n
		r = sc.nextInt(); // 결과 row
		c = sc.nextInt(); // 결과 col
		
		int size = (int)Math.pow(2, n);
		int result = recursion(0, 0, size, 0);
		System.out.println(result);
		sc.close();
	}
	public static int recursion(int row, int col, int size, int num) {
		if(size == 1) {
			return num;
		}else {
			size /= 2;
			
			if((row + size) <= r) {
				row += size;
				num += (size * size * 2);
			}
			if((col + size) <= c) {
				col += size;
				num += (size * size);
			}
			
			return recursion(row, col, size, num);
		}
	}
}
