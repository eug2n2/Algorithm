import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			pq.add(a);

		}
		int m = pq.poll(); // 처음 껀 제거
		if (m > 1)
			System.out.println(1);
		else {
			int ans = 2;
			while (!pq.isEmpty()) {
				m = pq.poll();
				if (ans<m) {
					break;
				} 
				ans+=m;
			}
			System.out.println(ans);
		}

	}
}
