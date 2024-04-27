import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] tree;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int size =(int)(Math.pow(2, n))-1;
		array = new int[size];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0;i<size ;i++) {
			array[i]=Integer.parseInt(st.nextToken());
		}
		tree= new ArrayList[n];
		for(int i=0;i<n;i++) {
			tree[i]= new ArrayList<>();
		}
		dfs(0,size-1,0);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<tree[i].size();j++) {
				sb.append(tree[i].get(j)+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int start, int end,int layer) {
		if(start==end) {
			tree[layer].add(array[end]);
			return;
		}
		int mid = (end+start)/2;
//		System.out.println(start+" mid "+mid +" end "+ end);
		tree[layer].add(array[mid]);
		
		dfs(start,mid-1, layer+1);
		dfs(mid+1,end,layer+1);
	}
}
