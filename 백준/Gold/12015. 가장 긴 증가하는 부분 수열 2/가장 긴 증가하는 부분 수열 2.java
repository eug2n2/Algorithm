
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.Stack;
class Main {
    public static  ArrayList<Integer> nlist = new ArrayList<>();
    public static void main(String args[]) throws IOException {
    	
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
     // 입력 받은 숫자
        int n =Integer.parseInt(st.nextToken()); //크기 
       
       
        st = new StringTokenizer(bf.readLine());
        nlist.add(Integer.parseInt(st.nextToken()));
        for (int i=1;i<n;i++) {
        	int tmp =Integer.parseInt(st.nextToken());
        	int lastindex = nlist.size()-1;
        	if(tmp>nlist.get(lastindex)) {
        		nlist.add(tmp);
        	}
        	else {
        		int end = lowerBound(tmp);
        		nlist.set(end,tmp);
        	}
        }
        
        System.out.println(nlist.size());
        }
    
    public static int lowerBound(int tmp) {
    	int start =0;
    	int end = nlist.size()-1;
    	while(start<end) {
    		int mid =(start+end)/2;
    		if (nlist.get(mid)>=tmp) {
    			end= mid;
    		} 
    		else {
    			start =mid+1;
    		}
    	}
    	return end;
    }
    
        	
    }

