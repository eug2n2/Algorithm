import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st =new StringTokenizer(bf.readLine());
	int n =Integer.parseInt(st.nextToken());
	int m=Integer.parseInt(st.nextToken());	
	char[][] newmap = new char [n][m];
	for (int i=0;i<n;i++) { // 입력받기 
		String str = bf.readLine();
		for (int j=0;j<m;j++) {
			newmap[i][j]= str.charAt(j);
		}
	}
	int answer=n*m+1;
	
	for (int i=0;i<n-7;i++) { 
		for (int j=0;j<m-7;j++) {
			int result1=0;
			int result2=0;
			for (int a=i;a<=i+7;a+=2) {
				for (int b=j;b<=j+7;b+=2) {
					if (newmap[a][b]=='B') {//첫글자 W로 시작하는 경우 
						result1++;
					}else { //첫글자 B로 시작하는 경우 
						result2++;
					}
					if (newmap[a][b+1]=='B') {//첫글자 B로 시작하는 경우 
						result2++;
					}else { //첫글자 W로 시작하는 경우 
						result1++;
					}
					if (newmap[a+1][b]=='B') {//첫글자 B로 시작하는 경우 
						result2++;
					}else { //첫글자 W로 시작하는 경우 
						result1++;
					}
					if (newmap[a+1][b+1]=='B') {//첫글자 W로 시작하는 경우 
						result1++;
					}else { //첫글자 B로 시작하는 경우 
						result2++;
					}
				}
			}
			
			answer=Math.min(answer, Math.min(result1, result2));
		}
	}
	System.out.println(answer);
	}
}