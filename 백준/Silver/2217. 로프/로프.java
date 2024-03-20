import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 숫자
		int n = Integer.parseInt(bf.readLine()); // 크기
		PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			result.add(Integer.parseInt(bf.readLine()));
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			int p = result.poll();
			answer = Math.max(answer, p * (i + 1));
		}
		System.out.println(answer);
	}
}