import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> bigpq = new PriorityQueue<>();
		PriorityQueue<Integer> smallpq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(bf.readLine());
		smallpq.add(a);
		sb.append(a + "\n");
		for (int i = 1; i < n; i++) {
			a = Integer.parseInt(bf.readLine());
			if (smallpq.peek() <= a && smallpq.size() > bigpq.size()) {
				bigpq.add(a);
			} else if (smallpq.size() == bigpq.size() && bigpq.peek() >= a) {
				smallpq.add(a);
			} else if (smallpq.size() == bigpq.size() && bigpq.peek() < a) {
				bigpq.add(a);
				smallpq.add(bigpq.poll());
			} else if (smallpq.peek() > a && smallpq.size() > bigpq.size()) {
				bigpq.add(smallpq.poll());
				smallpq.add(a);
			}
			sb.append(smallpq.peek() + "\n");

		}
		System.out.println(sb);
	}

}
