
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 입력 받은 숫자
		int n = Integer.parseInt(bf.readLine()); // 크기
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		for (int i = 0; queue.size() != 1; i++) {
			if (i % 2 == 0) {
				queue.remove();
			} else {
				int a = queue.remove();
				queue.add(a);
			}
		}
		int answer = queue.poll();
		System.out.println(answer);
	}
}