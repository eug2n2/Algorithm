import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				int num= Integer.parseInt(st.nextToken());
				matrix[i][j] = num%1000;
			}
		}
		int[][] answer = divide(matrix,b);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(answer[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	public static int[][] divide(int[][] array, long degree) {
		if(degree==1L) {
			return array;
		}
		int[][] copyarray = divide(array, degree/2);
		copyarray= multiply(copyarray, copyarray);
		if(degree%2==1L) {
			copyarray= multiply(copyarray, array);
		}
		return copyarray;
	}
	
	public static int[][] multiply(int[][] a, int[][] b){
		int[][] result = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int tmp=0;
				for (int k = 0; k < n; k++) {
				tmp += a[i][k]*b[k][j]; 
				tmp%=1000;
				}
			
				result[i][j]=tmp;
			}
		}
		return result;
	}
}
