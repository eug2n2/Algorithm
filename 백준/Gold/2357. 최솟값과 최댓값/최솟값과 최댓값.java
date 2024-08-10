import java.io.*;
import java.util.*;

public class Main {
    static int[] minTree;
    static int[] maxTree;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 최소, 최대를 구하기 위해 2개의 세그먼트 트리를 만든다.
        // 트리의 크기는  2^(h+1)-1
        int h = (int) Math.ceil(Math.log(n) / Math.log(2));
        int treeSize = (int)Math.pow(2, h + 1);
        minTree = new int[treeSize]; //2 * (2^h) - 1 < 4 *n 이므로 편의상 4*n이라고도 함
        maxTree = new int[treeSize];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(bf.readLine());
        makeTree(0, n - 1, 1, arr, true); // 최소트리
        makeTree(0, n - 1, 1, arr, false); //최대트리

        for (int i= 0;i< m;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findMin(0, n - 1, 1, a - 1, b - 1)).append(" ")
                    .append(findMax(0, n - 1, 1, a - 1, b - 1)).append("\n");
        }

        System.out.println(sb);
    }

    static int makeTree(int start, int end, int index, int[] arr, boolean ismin) {
        if (start == end) { // 리프 노드 rmfjau
            if (ismin) minTree[index] = arr[start];
            else maxTree[index] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (ismin) minTree[index] = Math.min(makeTree(start, mid, index * 2, arr, ismin), makeTree(mid + 1, end, index * 2 + 1, arr, ismin));
        else maxTree[index] = Math.max(makeTree(start, mid, index * 2, arr, ismin), makeTree(mid + 1, end, index * 2 + 1, arr, ismin));
        return ismin ? minTree[index] : maxTree[index];
    }

    //구간을 이분탐색으로 나누어, 그 구간의 최솟/최댓값을 구함
    static int findMin(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return 1000000001;
        if (left <= start && right >= end) return minTree[index];
        int mid = (start + end) / 2;
        return Math.min(findMin(start, mid, index * 2, left, right), findMin(mid + 1, end, index * 2 + 1, left, right));
    }

    static int findMax(int start, int end, int index, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && right >= end) return maxTree[index];
        int mid = (start + end) / 2;
        return Math.max(findMax(start, mid, index * 2, left, right), findMax(mid + 1, end, index * 2 + 1, left, right));
    }
}