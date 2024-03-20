

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//dfs풀이 
public class Main {
	static int n;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph ;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(bf.readLine());
		graph = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n+1]; 
		visited[1]=true;
		 answer = new int[n+1]; 
		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			graph.get(r).add(g);
			graph.get(g).add(r);
		}
			dfs(1);
			for (int i = 2; i <= n; i++) {
				System.out.println(answer[i]);
			}
		}
	public static void dfs (int p){
		for (int var:graph.get(p)) {
			if(!visited[var]) {
				answer[var]= p;
				visited[var]=true;
				dfs(var);
			}
		}
	}
}