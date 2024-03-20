

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int p;
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			String str = br.readLine();
			if (str.contains("push")) {
				String intstr = str.replaceAll("[^0-9]", "");
				deque.add(Integer.parseInt(intstr));
			} else if (str.equals("front")) {
				if (!deque.isEmpty()) {
					p = deque.getFirst();
					sb.append(p).append("\n");
				} else {
					sb.append("-1").append("\n");
				}
			} else if (str.equals("pop")) {
				if (!deque.isEmpty()) {
					p = deque.poll();
					sb.append(p).append("\n");
				} else {
					sb.append("-1").append("\n");
				}
			} else if (str.equals("back")) {
				if (!deque.isEmpty()) {
					p = deque.getLast();
					sb.append(p).append("\n");
				} else {
					sb.append("-1").append("\n");
				}
			} else if (str.equals("empty")) {
				if (!deque.isEmpty()) {
					sb.append("0").append("\n");
				} else {
					sb.append("1").append("\n");
				}
			} else if (str.equals("size")) {
				p = deque.size();
				sb.append(p).append("\n");
			}
		}

		System.out.print(sb.toString());
	}
}
