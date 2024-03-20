

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<int[]> house = new ArrayList<int[]>();
	static ArrayList<int[]> chicken = new ArrayList<int[]>();
	static int answer =Integer.MAX_VALUE;
	static int m ;
	static boolean[] chickenvisited ;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int [][] map = new int [n][n];
		
		for (int i =0; i<n;i++) { //map 입력받기 
			st = new StringTokenizer(bf.readLine());
			for (int j =0;j<n;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					house.add(new int[] {i,j});
				}
				else if(map[i][j]==2) {
					chicken.add(new int[] {i,j});
				}
			}
		}
		chickenvisited  = new boolean[chicken.size()];
		backtracking(0,0);
		System.out.println(answer);
	}
	public static void backtracking(int cnt, int idx){
		
		if(cnt==m) {
			int total=0;
			for (int i =0; i<house.size();i++) {
				int sum = Integer.MAX_VALUE;
			
				for (int j =0; j<chicken.size();j++) {
					if(chickenvisited[j]) { //치킨집 방문가능 
						int hc= Math.abs(house.get(i)[0]-chicken.get(j)[0]) +  Math.abs(house.get(i)[1]-chicken.get(j)[1]);
					
						sum =Math.min(sum, hc);
					}
				}
				total+=sum;
			}
			answer = Math.min(answer, total);
			return;
		}
		for(int i= idx;i<chicken.size();i++ ) { //다음 치킨집을 위한 도약 
			if(!chickenvisited[i]) { //폐업 
				chickenvisited[i]=true; //폐업아님 
				backtracking(cnt+1,i+1);
				chickenvisited[i]= false;
			}
			
		}
			
		
	}
}