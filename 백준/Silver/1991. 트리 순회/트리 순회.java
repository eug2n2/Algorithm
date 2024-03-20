
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char val;
	Node left;
	Node right;
	
	public Node (char val) {
		this.val=val;
		this.left =null;
		this.right = null;
	}
}
public class Main{
	static Node[] tree;
	static StringBuilder sb;
	public static void preorder(Node node) {
		if(node==null) return;
		sb.append(node.val);
		preorder(node.left);
		preorder(node.right);
	
	}
	public static void inorder(Node node) {
		if(node==null) return;
		inorder(node.left);
		sb.append(node.val);
		inorder(node.right);	
	
	}
	public static void postorder(Node node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);	
		sb.append(node.val);
	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		sb = new StringBuilder();
        tree = new Node[n + 1]; // 노드 배열 생성
		for (int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			char parentValue = st.nextToken().charAt(0); // nextToken() 메서드로 토큰을 하나씩 꺼내오면 StringTokenizer객체에는 해당 토큰이 사라진다
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);
            
            //이걸하지않는다면 (밑)  d~g까지는 노드가 생성이되지않았기때문에 노드생성이안됨 
            if (tree[parentValue - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parentValue - 'A'] = new Node(parentValue); // 부모 노드를 생성
            }
			if(leftValue !='.') {
				 tree[leftValue - 'A'] = new Node(leftValue);
				tree[parentValue-'A'].left= tree[leftValue-'A'];
			} 
			if(rightValue !='.') {
				tree[rightValue-'A'] = new Node(rightValue);
				tree[parentValue-'A'].right= tree[rightValue-'A'];
			}
			
		}
		
		preorder(tree[0]);
		sb.append("\n");
		inorder(tree[0]);
		sb.append("\n");
		postorder(tree[0]);
		System.out.println(sb);
		
	}
}