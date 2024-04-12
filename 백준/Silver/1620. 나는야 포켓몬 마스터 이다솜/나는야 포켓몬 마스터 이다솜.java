import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> map = new HashMap<>();
		HashMap<String,String> intmap = new HashMap<>();
		for(int i=1;i<=n;i++) {
			String poketmon=  bf.readLine();
			map.put(poketmon, i);
			intmap.put(Integer.toString(i), poketmon);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			String quiz=  bf.readLine();
			if(map.containsKey(quiz)) {
				sb.append(map.get(quiz)).append("\n");
			}else {
				sb.append(intmap.get(quiz)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
