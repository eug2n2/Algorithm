import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int n;
	static StringBuilder sb;
	static int hanoi;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine()); // 숫자 정수

		sb = new StringBuilder();
		
	
		if (n > 20) {
			System.out.println( BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));
		} else {
			sb.append((int)Math.pow(2, n)-1+"\n");
			move(n,1,3,2);
			System.out.println(sb);
		}
	}


	 public static void move(int num,int start, int end, int via) {
		 if(num==1) {
			 sb.append(start+" "+ end+"\n");
		 }else {
			 move(num-1,start,via,end);
			 sb.append(start+" "+end+"\n");
			 move(num-1,via, end, start);
		 }
			
	 }
}