import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] arr = new long[1024];

        for(int i=0;i<n;i++){
            String str = bf.readLine();
            int tmp =0;
            for(int j=0;j<str.length();j++){
                int num =str.charAt(j)-'0';
                tmp |= 1<<num;
            }
            arr[tmp]++;
        }
        long ans = 0;
        for(int i=1;i<1024;i++){
            ans+= arr[i]*(arr[i]-1)/2;
            for(int j=i+1;j<1024;j++){
                if((i&j)>=1) ans+=(arr[i]*arr[j]);
            }
        }
        System.out.println(ans);

    }

}