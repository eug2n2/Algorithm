import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>(new TwoElementComparator());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new int[] { a, b });
		}
		int[] p = pq.poll();
		int min = p[0];
		int max = p[1];
		int cnt = max - min;
		while (!pq.isEmpty()) {
			p = pq.poll();
			if (p[0] > max) {
				min = p[0];
				max = p[1];
				cnt += max - min;
			} else if (max < p[1]) {
				cnt += p[1] - max;
				max = p[1];
				if (p[0] < min) {
					cnt += p[0] - min;
					min = p[0];
				}
			}
		}

		System.out.println(cnt);
	}
}

class TwoElementComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		if (o1[0] != o2[0]) {
			return Integer.compare(o1[0], o2[0]);
		} else {
			return Integer.compare(o1[1], o2[1]);
		}
	}
}