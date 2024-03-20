

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st= new StringTokenizer(bf.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int c =Integer.parseInt(st.nextToken());
    	int [] map = new int [n];
    	for (int i =0;i<n;i++) {
    		map[i]=Integer.parseInt(bf.readLine());
    	}
    	Arrays.sort(map);
    	int start =1;
    	int end = map[n-1]-map[0]+1;
    	
    	while (start<end) {
    		int count =1;
    		int mid = (start + end )/2;
    		int idx=0;
    		for (int i=1;i<n;i++) {
    			if(map[i]-map[idx]>=mid) {
    					count++;
    					idx=i;
    				}
    			}
    		if(count>=c) {
    			start=mid+1;
    		} else{
    			end = mid;
    		}
    	}
    	System.out.println(start-1);
    	
    }

}