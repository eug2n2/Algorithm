import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Main {
	static Node[] tree;
	static StringBuilder sb;
	public static void postorder(Node node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);	
		sb.append(node.val).append("\n");
	
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
//		List<Integer> numbers = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		Deque<Integer> iqueue = new ArrayDeque<>();

		String line;
		int size = 0;
		while ((line = bf.readLine()) != null && !line.isEmpty()) {
			queue.add(Integer.parseInt(line));
			size++;
		}
		int root =queue.peek();
		iqueue.add(root);
		tree = new Node[1000000]; // 노드 배열 생성

		tree[root]= new Node(root);
		while (!queue.isEmpty()) {
			int p = queue.poll();
//			System.out.println("p"+p);
			if(p!=root) {
				int tmp =iqueue.pollLast();
//				System.out.println(tmp);
				while(!iqueue.isEmpty()&&( p>=iqueue.getLast()||tmp>p)) {
					tmp =iqueue.pollLast();
//					System.out.println(tmp+ " tmp ");
					 
				}
				tree[p] = new Node(p);
				tree[tmp].right = tree[p];
//				System.out.println(tmp + "오른쪽에 " + p + "있따.");
				iqueue.add(p);
				
			}
			int son=0;
			boolean check=false;
			while (!queue.isEmpty() && queue.peek() < p) {
				son = queue.poll();
//				System.out.println("응애" +son);
				tree[son] = new Node(son);
				tree[p].left = tree[son];
				p=son;
				iqueue.add(p);
//				System.out.println("iqueue 쏙" +p);
				check=true;
			}
		
		}
		postorder(tree[root]);
		System.out.println(sb);
	}
}
