import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(bf.readLine());
	
			String str =bf.readLine();
			int max =0;
			long ans =0;
			 // 공백을 기준으로 문자열 분리
	        String[] strArray = str.split(" ");
			for (int i = n-1; i >= 0; i--) {
				int num = Integer.parseInt(strArray[i]);
				if(max <num) {
					max=num;
				} else {
					ans+= max-num;
				}
			}
			System.out.println(ans);
			
		}
	}
}
