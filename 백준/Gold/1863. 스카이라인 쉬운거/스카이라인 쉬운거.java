import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String ars[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		stack.add(0);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek() > y) { // 높이를 맞추자.
				answer++;
				stack.pop();
			}
			// 높이가 같으면 큐에 넣어줄 필요가 없다.
			if (!stack.isEmpty() && stack.peek() == y) {
				continue; 
			}
			stack.add(y);
		}

		while (!stack.isEmpty()) {
			int p = stack.pop();
			if (p > 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
