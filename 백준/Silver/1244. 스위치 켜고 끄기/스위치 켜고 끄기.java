import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n;i++){ //배열에 숫자 입력 
            arr[i]=sc.nextInt();
            }
        int m= sc.nextInt();
        for (int k=0; k<m;k++){
            int gender= sc.nextInt();
            if (gender==1){
                int bae = sc.nextInt();
                arr=boy(bae,n,arr);
            }
            else{
                int bae = sc.nextInt();
                arr=girl(bae,n,arr);
            }
        }
        for (int i=0; i<n;i++){ //리스트 출력 
            if (i%20==19){
                System.out.print(arr[i]+"\n");
            }
            else{System.out.print(arr[i]+" ");}
                
                
            }
        }
        public static int[] boy (int bae,int n,int[] arr){
            for(int j=1;bae * j - 1 >= 0 && bae*j-1<n;j++){
                    if (arr[bae*j-1]==0){
                        arr[bae*j-1]=1;
                        }
                    else if (arr[bae*j-1]==1){
                        arr[bae*j-1]=0;
                        }
                    }   
            return arr;
        }
    
        public static int[] girl (int bae,int n, int[] arr){
            if (arr[bae-1]==0){
                arr[bae-1]=1;
                }
            else if (arr[bae-1]==1){
                    arr[bae-1]=0;
                }   
            int num=1;
            while (bae-num-1>=0 && bae+num-1<n ){
                if (arr[bae-1-num]==0&& arr[bae-1+num]==0){
                    arr[bae-num-1]=1;
                    arr[bae+num-1]=1;
                    num++;
                    }
                else if (arr[bae-1-num]==1&&arr[bae-1+num]==1){
                        arr[bae+num-1]=0;
                        arr[bae-num-1]=0;
                        num++;
                    }
                else{
                    break;
                    }
                }   
            return arr;
            }
        }
    