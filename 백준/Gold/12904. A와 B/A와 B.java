import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int ans = 1;
		String a = bf.readLine();
		String b =bf.readLine();
		int acnt = a.length(); // a길이
		int bcnt = b.length();
		while (acnt!=bcnt) {
			if (b.charAt(bcnt-1)=='B') {
				StringBuffer sb= new StringBuffer();
				for (int i=bcnt-2;i>=0;i--) {
					sb.append(b.charAt(i));
				}
				b= sb.toString();
				bcnt--;
			}else if (b.charAt(bcnt-1)=='A') {
				 b = b.substring(0, bcnt - 1);
				bcnt--;
			}
		}
		if (!a.equals(b)) {
			ans=0;
		}
		System.out.println(ans);
	}
}
