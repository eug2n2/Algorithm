
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {
   
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     // 입력 받은 숫자
        int num =Integer.parseInt(bf.readLine());
     // 숫자의 자릿수 계산
        int n = (num == 0) ? 1 : (int)(Math.log10(num)+1);//n자릿수
     // 빈 자릿수 여부를 나타내는 플래그
        boolean empty = false; 
        // 숫자의 각 자릿수를 저장하는 배열
        int[] nlist = new int [n];
        // 배열에 자릿수 역순으로 저장
        int index =n-1;
        int num1=num;
        while(index >= 0) {
        	nlist[index]=(num1 % 10);
            num1 /= 10;
            index--;
        }
     // 초기 정답은 100에서 입력 숫자의 차이
        int answer =  Math.abs(100-num);

        // 초기화할 변수들
        int maxc =0;
        int minc =0;
        int m = Integer.parseInt(bf.readLine()); // 고장난버튼
        int upc=0;
        int downc=0;

        // 고장난 버튼을 저장하는 리스트
        List<Integer> fixList = new ArrayList<>();

        // 고장난 버튼이 하나 이상인 경우
        if(m>0){ StringTokenizer st = new StringTokenizer(bf.readLine());
        
        for(int i=0;m>0&&i<m;i++){
            fixList.add(Integer.parseInt(st.nextToken()));
                }
            }
        // 각 자릿수에 대한 처리
        for (int i=0;m<10&& i<nlist.length;i++) {
            // 현재 자릿수가 비어 있지 않고 나누어진 버튼에 해당하지 않으면
        	if(!empty&&!fixList.contains(nlist[i])){ // 그 자리수가 딱 있음 
        		maxc+= nlist[i]*Math.pow(10, n-i-1);// 큰값으로 접근
        		minc+= nlist[i]*Math.pow(10, n-i-1); // 작은값으로 접근 
        		upc+= nlist[i]*Math.pow(10, n-i-1); // 자릿수 하나 올림해서 찾기  		
        		downc+=  nlist[i]*Math.pow(10, n-i-1);//(자릿수) 내림해서 찾기 
        	}
        	  // 현재 자릿수가 비어 있지 않고 나누어진 버튼에 해당하면
        	else if(!empty&&fixList.contains(nlist[i])) { //지금까진 좋았는데... 이제는 자릿수가 고장남 
        		empty=true;
        		int a =nlist[i];
                // 나보다 작은 값이 fixList에 있는 동안 계속 감소
        		while(a!=-1&&fixList.contains(a)){
        			--a;}
        		if(a>0) {
        			minc+=a*Math.pow(10, n-i-1);}
        		else if(i==0&&n>1) {
        			a=0;
        		}
        		 // 첫 자릿수 처리
        		if (i==0) {
        			int find=1;
        			while (fixList.contains(find)) {
            			find++;
            		}
        			int bfind=0;
        			while (fixList.contains(bfind)) {
            			bfind++;}
            		int sfind =nlist[i]-1;	
            		while (sfind>=0&&fixList.contains(sfind)) {
                    		sfind--;
                    	}
            		
                	downc+= sfind*Math.pow(10, n-i-1);//(자릿수) 내림해서 찾기 
            		
        			upc+=find*Math.pow(10, n-i)+bfind*Math.pow(10, n-i-1);
        			find =nlist[i]-1;
        			}
        		  // 나머지 자릿수의 처리
        		if(i!=0) {
        			upc-=nlist[i-1]*Math.pow(10, n-i);
        			downc-=nlist[i-1]*Math.pow(10, n-i);
        			int find=nlist[i-1]+1;
        			while (fixList.contains(find)) {
            			find++;
            		}
        			int bfind=0;
        			while (fixList.contains(bfind)) {
            			bfind++;
            		}
        			int maxfind=9;
        			while (fixList.contains(maxfind)) { 
            			maxfind--;
            		}
        			int ssfind =nlist[i-1]-1;	
            		while (ssfind>=0&&fixList.contains(ssfind)) {
                    		ssfind--;
                    	}
            		if(ssfind<0&&i==1) {
            			ssfind=0;
            		}
            		if(ssfind>=0) {
            			downc +=ssfind*Math.pow(10, n-i)+maxfind*Math.pow(10, n-i-1);
            		}
            		else {
            			downc=500001+num;
            		}
        			upc+=find*Math.pow(10, n-i)+bfind*Math.pow(10, n-i-1);
        		}
        		int b =nlist[i];
        		// 나보다 큰 값이 fixList에 있는 동안 계속 증가
        		while(b!=10&&fixList.contains(b)){
        			++b;}
        		if(b<10) {
        			maxc+=b*Math.pow(10, n-i-1);}
        		
        		else if(a>=0) {
        			maxc+=a*Math.pow(10, n-i-1);
        		}
        		else {maxc=500001+num; }//최댓값없음
        		if(a<0&&b<10) {
        			minc+=b*Math.pow(10, n-i-1);
        		} else if(a<0&&b>=10) {
        			minc=500001+num; //최솟값없음
        		}
	        		}
        
        	else {
        		int find =0;
        		while (fixList.contains(find)) {
        			find++;
        		}
        		maxc+=find*Math.pow(10, n-i-1);
        		upc+=find*Math.pow(10, n-i-1);
        		
        		int maxfind =9;
        		if(minc!=500001+num) {
        		while (fixList.contains(maxfind)) { 
        			maxfind--;
        		}
        		minc+=maxfind*Math.pow(10, n-i-1);
        		downc+=maxfind*Math.pow(10, n-i-1);
	        	}
        	}
        }
        		  // 버튼 누른 횟수 더해주기 
        int upb= (upc == 0) ? 1 : (int)(Math.log10(upc)+1);
        int maxb= (maxc == 0) ? 1 : (int)(Math.log10(maxc)+1);
        int downb= (downc == 0) ? 1 : (int)(Math.log10(downc)+1);
        int minb = (minc == 0) ? 1 : (int)(Math.log10(minc)+1);
        maxc= Math.abs(maxc-num)+maxb;
        minc= Math.abs(minc-num)+minb;
        upc= Math.abs(upc-num)+upb;
        downc= Math.abs(downc-num)+downb;
        if(m==10) {
        	System.out.println(answer);
        } else if(!empty) {
        	answer = Math.min(answer,Math.min(maxc, minc));
        	System.out.println(answer);
        }else if(n==1) {
        	answer = Math.min(answer,Math.min(maxc,Math.min(minc,upc)));
        	System.out.println(answer);
        } else {
        	answer = Math.min(answer,Math.min(maxc,Math.min(minc, Math.min(upc,downc)) ));
        	System.out.println(answer);
        }
        	
    }
}
