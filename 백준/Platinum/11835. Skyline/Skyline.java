import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
