import java.util.*;
import java.io.*;

class Main
{
	public static void main(String args[]) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
		int n= Integer.parseInt(bf.readLine());
		long[] answer = new long[n];
		int[] nlist = new int[n];
		Stack<int[]> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i =0;i<n;i++) {
			nlist[i]=Integer.parseInt(st.nextToken());
			
		}
		stack.push(new int[] {nlist[0],1});
		for(int i=1;i<n;i++) {
			int height=nlist[i];
			while(!stack.isEmpty()) {
				if( height >=stack.peek()[0]) {
					stack.pop();
				} else {
					answer[i]=stack.peek()[1];
					break;
				}
			}
			stack.push(new int[] {height,i+1});
		}
		StringBuilder sb = new StringBuilder();
		for (int i =0;i<n;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb);
	}
}