
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 1644
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] map = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) { // 소수찾기
			map[i] = Integer.parseInt(st.nextToken());		
		}
		int start = 0;
		int end = n-1;
		int min = Integer.MAX_VALUE;
		int answers =0;
		int answere= 0;
		while (start <end ) {
			int sum =map[end] + map[start];
			int tmp = Math.abs(sum);
			if (min >tmp) {
				min =tmp;
				answers = map[start];
				answere =map[end];
			} 
			if(sum >0) {
				end--;
			} else {
				start++;
			}
		}
		
		System.out.println(answers +" " +answere);
		

	}

}