import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] map;
	static int answermo=0;
	static int answerz=0;
	static int answerone=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n =  Integer.parseInt(st.nextToken());
        map = new int  [n][n];
        for (int i =0;i<n;i++) {
        	st = new StringTokenizer(bf.readLine());
        	for (int j=0;j<n;j++) {
             map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        StringBuilder sb = new StringBuilder();
        cut(0, n,0, n,n*n);
        sb.append(answermo).append("\n");
        sb.append(answerz).append("\n");
        sb.append(answerone);
        System.out.println(sb);
       
    }

    public static void cut(int xstart, int xend, int ystart, int yend, int size) {
    	
    	int countmo =0;
    	int countz=0;
    	int countone =0;
        for (int i= xstart; i<xend ;i++) {
        	for (int j= ystart; j<yend ;j++) {
        		if(map[i][j]==-1) {
        			countmo++;
        		} else if(map[i][j]==1) {
        			countone++;
        		} else {
        			countz++;
        		}
        	}
        }
        if( countmo==size ) {
        	answermo++;
        } else if (countz==size ) {
        	answerz++;
        } else if (countone ==size) {
        	answerone++;
        } else {
        	for (int i= xstart;i<xend;i+= (xend-xstart) /3) {
        		for (int j = ystart ; j<yend;j+=(yend-ystart)/3) {
        			cut(i,i+ (xend-xstart)/3,j,j+(yend-ystart)/3,size/9);
        		}
        	}
        }
        
    }
}
