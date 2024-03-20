import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받은 숫자
		int n = Integer.parseInt(bf.readLine()); // 크기
		// 내림차순 우선순위큐
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; n > 1 && i <= n - 1; i++) {
			queue.remove();
		}
		int answer = queue.poll();
		System.out.println(answer);
	}
}