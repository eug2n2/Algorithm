import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		Deque<int[]> q = new ArrayDeque<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!q.isEmpty() && q.peekLast()[0] > num) q.pollLast();
			
			q.add(new int[] { num, i });

			if (q.peek()[1] < i - l + 1) {
				q.poll();
			}
			bw.write(q.peek()[0]+" ");

		}
		bw.flush();
		bw.close();
	}
}
