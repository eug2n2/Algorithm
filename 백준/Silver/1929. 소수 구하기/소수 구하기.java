import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st =new StringTokenizer(bf.readLine());
	StringBuilder sb = new StringBuilder();
	int m =Integer.parseInt(st.nextToken());
	int n=Integer.parseInt(st.nextToken());	
	for (int i=m; i<=n;i++) {
		if(sosu(i)) {
			sb.append(i+"\n");
		}
	}
	System.out.println(sb);	
		}
	
	public static boolean sosu(int x) {
		if( x==1) {
			return false;
		}
		else{for (int i =2; i<=Math.sqrt(x);i++) {
			if( x%i==0) {
				return false;
				}
			}
		}
		return true;
	}
	
}