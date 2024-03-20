import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // 1644
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		ArrayList<Integer> map = new ArrayList<>();
		for (int i = 2; i <= n; i++) { // 소수찾기
			boolean sosu =true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j==0) {
					sosu=false;
					break;
				}
				
			}
			if(sosu) {
				map.add(i);
			}
		}
		map.add(0); 
		int start = 0;
		int end = 0;
		int total = 0;
		int cnt =0;
		
		while (start <= map.size()-1 && end <= map.size()-1) {
			if (total == n) {
				cnt++;
			}
			if (total <n) {
				total += map.get(end++);
			} else {
				total -= map.get(start++);
			}
		}
		
		System.out.println(cnt);
		

	}

}