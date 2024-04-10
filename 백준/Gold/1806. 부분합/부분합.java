import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine());
		int[] map = new int[n+1];
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int total = 0;
		while (start <= n && end <= n) {
			if (total >= c && min > end -start) {
				min = end - start;
			}
			if (total < c) {
				total += map[end++];
			} else {
				total -= map[start++];
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}

	}

}