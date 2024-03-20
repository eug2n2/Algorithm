import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.Stack;
class Main {
   
    public static void main(String args[]) throws IOException {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
     // 입력 받은 숫자
        int h =Integer.parseInt(st.nextToken()); //높이
        int w =Integer.parseInt(st.nextToken()); //가로
        int[] height= new int[w];
        st = new StringTokenizer(bf.readLine());
        for (int i=0;i<w;i++) {
        	height[i]=Integer.parseInt(st.nextToken()); 
        }
        
        int result=0;
        for (int i=1;i<w-1;i++) {
        	int left=0;
            int right=0;
        	for(int j=0;j<i;j++) {
        		left= Math.max(left, height[j]);
        	}
        	for(int j=i+1;j<w;j++) {
        		right= Math.max(right, height[j]);
        	}
        	int value = Math.min(left,right);
        	if(value>height[i]) {
        		result+=value-height[i];
        	}
        }
        System.out.println(result);
        }
        	
    }

