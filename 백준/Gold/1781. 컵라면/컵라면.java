

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Ramen {
	int deadLine;
	int countRamen;

	public Ramen(int deadLine, int countRamen) {
		this.deadLine = deadLine;
		this.countRamen = countRamen;
	}
}

// 클래스 객체의 우선순위를 위한 클래스
class RamenComparator implements Comparator<Ramen> {
	@Override
	public int compare(Ramen o1, Ramen o2) {
		if (o1.deadLine == o2.deadLine) {
			return o2.countRamen - o1.countRamen;
		} else {
			return o1.deadLine - o2.deadLine;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Ramen> pq = new PriorityQueue<>(1, new RamenComparator());
		PriorityQueue<Integer> result = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) { // 큐에 입력받음
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new Ramen(a, b));

		}
		int size = 0;
		int answer = 0;
		while (!pq.isEmpty()) {
			Ramen r = pq.poll();
			if (r.deadLine > size) {
				result.add(r.countRamen);
				size++;
				answer += r.countRamen;

			} else if (result.peek() < r.countRamen) {
				answer -= result.poll();
				answer += r.countRamen;
				result.add(r.countRamen);

			}
		}

		System.out.println(answer);
	}
}
