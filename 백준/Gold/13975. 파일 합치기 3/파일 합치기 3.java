import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(bf.readLine()); // tc의수 
		for (int tc=0;tc<t;tc++) {
			PriorityQueue <Long> pq = new PriorityQueue<>();
			Long k=Long.parseLong (bf.readLine()); // 소설의 장수 
			Long answer=0L;
			StringTokenizer st =new StringTokenizer(bf.readLine());
			for(long i=0;i<k;i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			while (pq.size()>1) {
				Long a= pq.poll();
				Long b =pq.poll();
				pq.add(a+b);
				answer +=a+b;
			}
			System.out.println(answer);
		}
		}
	}