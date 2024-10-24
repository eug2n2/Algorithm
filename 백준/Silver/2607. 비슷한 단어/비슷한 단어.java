import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bf.readLine());
        String str  =  bf.readLine();
        int[] voca = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            voca[ch - 'A']++;
        }
        int answer =0;
        for(int i = 1; i < x; i++) {
            String tmp  =  bf.readLine();
            int[] vtmp = new int[26];
            answer++;
            for (int j = 0; j < tmp.length(); j++) {
                char ch = tmp.charAt(j);
                vtmp[ch - 'A']++;
            }
            boolean mchance =false;
            boolean pchance =false;
            for(int k = 0; k < 26; k++) {
                if(Math.abs(vtmp[k] - voca[k])>=2) {
                    answer--;
                    break;
                }
                else if(vtmp[k] - voca[k]==1) {
                    if(!mchance) mchance =true;
                    else {
                        answer--;
                        break;
                    }
                }
                else if(vtmp[k] - voca[k]==-1) {
                    if(!pchance) pchance =true;
                    else {
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);

    }

}