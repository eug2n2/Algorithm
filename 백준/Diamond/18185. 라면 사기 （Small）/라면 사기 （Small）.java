import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine()); // item 개수
		int[] arr = new int[n+2];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i=0;i<n;i++) {
			if (arr[i] > 0) {
				// 5원으로 살수 있는 최대 라면개수는 최대한 많이 ! 
				// 무조건 많이 사는게 이득이아닌 부분
				// i+1번째 공장에서 사야될 라면(아까 tmp 뺀거 제외하고)과 i+2에서 사야할 라면이 차이가 난다면  
				//- > 그렇다면 둘의 차이만큼 빼자 
				// 2 3 2 0 같이 마지막에 라면 없으면 남은라면은 어차피 따로사면됨 
				 if(arr[i+1]>arr[i+2]){
					 // 차는 무조건 남겨둘거니까 
			            int a=Math.min(arr[i], arr[i+1]-arr[i+2]);
			            ans+=5*a;
			            arr[i]-=a; 
			            arr[i+1]-=a;
			            
			            int b=Math.min(arr[i], Math.min(arr[i+1], arr[i+2]));
			            ans+=7*b;
			            arr[i]-=b; 
			            arr[i+1]-=b; 
			            arr[i+2]-=b;
			        }  else{ // 최대한 많이제거 
			            int b=Math.min(arr[i],arr[i+1]);
			            ans+=7*b;
			            arr[i]-=b; 
			            arr[i+1]-=b; 
			            arr[i+2]-=b;

			            int a=Math.min(arr[i], arr[i+1]);
			            ans+=5*a;
			            arr[i]-=a; 
			            arr[i+1]-=a;
			        }
			        ans+=3*arr[i];
			}
		}
		System.out.println(ans);
	}
}
