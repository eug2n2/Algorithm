import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	PriorityQueue<Integer> minq = new PriorityQueue<>();
	PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
	StringTokenizer st = new StringTokenizer(bf.readLine());
	for (int i=0;i<n;i++) { //A 
		int a  =Integer.parseInt(st.nextToken());
		minq.add(a);
	}
	st = new StringTokenizer(bf.readLine());
	for (int i=0;i<n;i++) { //B 
		int a  =Integer.parseInt(st.nextToken());
		maxq.add(a);
	}
	int ans =0;
	while(!maxq.isEmpty()) {
		int num = maxq.poll();
		int tmp = minq.poll();
		ans+= num*tmp;
	}
	System.out.println(ans);
}
}
