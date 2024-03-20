import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int r;
	static int c;
	static int answer=0;
	static int value = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		int n = (int) Math.pow(2, num);
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		z(0, 0, n);
		System.out.println(answer);
		
	}

	public static void z(int xstart,int ystart, int size) {
		if (size == 1) {
			if(xstart==r&&ystart==c) {
				answer= ++value;
				return;
				}
				
		} else {
			int length =size/ 2;
			if ( r<xstart+length && c<ystart+length) {
			z(xstart, ystart, size / 2);}
			
			else if ( r<xstart+length && c>=ystart+length) {
				value+=size*size/4;
				z(xstart, ystart+length,  size / 2);}
			
			else if (xstart+length<= r && c<ystart+length) {
				value+=size*size/2;
				z(xstart+length,ystart,  size / 2);
			}else {
				value+=size*size/4*3;
			z(xstart+length, ystart+length, size / 2);
			}
			
		}
	}}
