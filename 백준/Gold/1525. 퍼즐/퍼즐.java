import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String correct = "123456780";
		Map<String, Integer> map = new HashMap<>();
		String str = "";
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 3; j++) {
				str += st.nextToken();

			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		map.put(str,0);
		Queue<String> queue = new ArrayDeque<>();
		queue.add(str);
		while (!queue.isEmpty()) {
			String p = queue.poll();
			int cnt = map.get(p);// 무조건 map에 있음 걱정 ㄴ
			if (p.equals(correct)) {
				ans =cnt;
				break;
			}
			int zd = p.indexOf("0");
			int x = zd / 3;
			int y = zd % 3;
//			System.out.println("0의 위치  "+ x+" "+y+" cnt:"+cnt +" z"+zd);
			for (int di = 0; di < 4; di++) {
				int nx = x + dx[di];
				int ny = y + dy[di];
				if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3)	continue;
//				System.out.println(nx+" ny "+ ny+ " zero"+ zd);
				String newstr = swap(p, zd, nx * 3 + ny);
//				System.out.println(newstr+" "+ (cnt+1));
				if (!map.containsKey(newstr)) {
					map.put(newstr, cnt + 1);
					queue.add(newstr);
				}

			}
		}
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}

	public static String swap(String str, int a, int b) {
		char[] charArray = str.toCharArray();
		char tmp = charArray[a];
		charArray[a] = charArray[b];
		charArray[b] = tmp;
		str = new String(charArray);
		return str;
	}

}
