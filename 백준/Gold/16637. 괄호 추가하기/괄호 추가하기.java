import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int m;
	static int n;
	static int[] nlist;
	static char[] clist;
	static String str;
	static int ans;
	static Stack<Integer> stack; //가장 최근에 괄호 사용한 인덱스 기록 
	static boolean [] visited ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		str = bf.readLine();
		nlist = new int[(n-1)/2+1];
		clist = new char[(n-1)/2];
		nlist[0]= str.charAt(0)-'0';
		for (int i=1;i<n;i+=2) {
			clist[i/2] = str.charAt(i); 
			nlist[(i+1)/2]= str.charAt(i+1)-'0';
		}
		ans =Integer.MIN_VALUE; //정답 
		visited = new boolean[n]; 
		cal();
		for (int i=1;i< (n+3)/4;i++) {
			stack= new Stack<>();
			m=i;
			dfs(0);
		}
		System.out.println(ans);
	
	}
	public static void dfs (int cnt) {
		if(cnt==m) {
			cal();
			return;
		}
		for (int i =1;i<n;i+=2) {
			if(stack.isEmpty()|| i-stack.peek()>2) {
				visited[i]= true ;
				stack.add(i);
				dfs(cnt+1);
				visited[i]= false;
				stack.pop();
			}
		
		}
		
	}
	public static void cal () {
		nlist = new int[(n-1)/2+1];
		clist = new char[(n-1)/2];
		nlist[0]= str.charAt(0)-'0';
		for (int i=1;i<n;i+=2) {
			clist[i/2] = str.charAt(i); 
			nlist[(i+1)/2]= str.charAt(i+1)-'0';
		}
		for (int i =1;i<n;i+=2){ // 괄호먼저 처리 
			if(visited[i]) {
				if(clist[(i-1)/2]=='*') {
					nlist[(i-1)/2] *= nlist[(i-1)/2+1];
					nlist[(i-1)/2+1] =0;
					clist[(i-1)/2]='^';
				}else if(clist[(i-1)/2]=='+') {
					nlist[(i-1)/2] += nlist[(i-1)/2+1];
					nlist[(i-1)/2+1] =0; 
					clist[(i-1)/2]='^';
				}
				else if(clist[(i-1)/2]=='-') {
					nlist[(i-1)/2] -= nlist[(i-1)/2+1];
					nlist[(i-1)/2+1] =0; 
					clist[(i-1)/2]='^';
				}
			}
		}
		int total = nlist[0];
		for (int i=0;i<(n-1)/2;i++) {
			if(clist[i]=='*') {
				total *= nlist[i+1];
			}else if(clist[i]=='+') {
				total += nlist[i+1];
			}
			else if(clist[i]=='-') {
				total -= nlist[i+1];
			}
		}
		ans = Math.max(ans, total);
	}

}
