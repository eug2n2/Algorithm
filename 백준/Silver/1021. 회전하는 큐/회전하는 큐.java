

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 입력 받은 숫자
		int n = Integer.parseInt(st.nextToken()); // 크기
		int m = Integer.parseInt(st.nextToken()); // 뽑아야할 수 개수
		// 내림차순 우선순위큐
		int answer = 0;
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			deque.add(i); // deque 숫자 입력
		}
		st = new StringTokenizer(bf.readLine());
		int[] nlist = new int[m];
		for (int i = 0; i < m; i++) {
			nlist[i] = Integer.parseInt(st.nextToken()); // deque 숫자 입력
		}
		int i = 0;
		// 123 일때 2를 뽑는다 뒤로 뽑으면 312, 213 후 제거 (2번)
		// 123 일대 앞으로 뽑으면 213 제거 (1번)
		while (i < m && deque.size() > 1) {
			while (deque.peekFirst() != nlist[i]) {
				if (deque.indexOf(nlist[i]) <= (deque.size() - 1) / 2) {
					deque.addLast(deque.pollFirst());
					answer++;
				} else {
					deque.addFirst(deque.pollLast());
					answer++;
				}
			}
			deque.poll();
			i++;
		}

		System.out.println(answer);
	}
}