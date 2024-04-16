import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long a0 = 0;
	static long a1 = 0;
	static long p, q;
	static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		long n = Long.parseLong(st.nextToken());
		p = Long.parseLong(st.nextToken());
		q = Long.parseLong(st.nextToken());
		System.out.println(dfs(n));
	}

	public static long dfs(long n) {
		if (n == 0)	return 1;
		else if (n ==1)	return 2;
		else if (map.containsKey(n)) return map.get(n);
		long tmp = n / p;
		long tmp1 = n / q;
		map.put(n, dfs(tmp) + dfs(tmp1)); 
		return map.get(n);
	}
}
