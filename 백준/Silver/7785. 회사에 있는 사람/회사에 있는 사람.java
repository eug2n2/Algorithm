import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String people = st.nextToken();
			String state = st.nextToken();
			if(state.equals("enter")) {
				set.add(people);
			}else {
				set.remove(people);
			}
		}
		Iterator<String> it= set.iterator();
		StringBuilder sb= new StringBuilder();
		String[] answer = new String[set.size()];
		int idx=0;
		while(it.hasNext()) {
			answer[idx++] = it.next();
		}
		Arrays.sort(answer);
		for(int i=set.size()-1;i>=0;i--) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}
