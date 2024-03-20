

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 1644
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] map = new int[n + 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) { // 소수찾기
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				map[i] = 1;
			}
		}

		int start = 0;
		int end = 0;
		int total = 0;
		int min = Integer.MAX_VALUE;
		while (start <= n && end <= n) {
			if (total == k && min > end - start) {
				min = end - start;
			}
			if (total < k) {
				total += map[end++];
			} else {
				total -= map[start++];
			}
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

}