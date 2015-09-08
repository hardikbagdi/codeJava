import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class scc {
public static void main(String[] args) {
	StdOut.print("Enter no of nodes:");
	int v= StdIn.readInt();
	//ArrayList<Integer> graph= new ArrayList<>();
	List<Integer>[] graph = new List[v];
	//ArrayList<Integer>[] graph = new ArrayList<Integer>[];
	
	for (int i = 0; i <graph.length; i++) {
		graph[i]=new ArrayList<Integer>();
	}
	StdOut.print("Enter edges number:");
	int edgen= StdIn.readInt();
	for (int i = 0; i < edgen; i++) {
		int a=StdIn.readInt();
		int b=StdIn.readInt();
		graph[a].add(b);
	}
	java.util.Stack<Integer> stack = new java.util.Stack<>();
	boolean[] visited = new boolean[v];
	for (int i = 0; i < graph.length; i++) {
			
				doDFS(graph,i,visited,stack);
			}

List<ArrayList<Integer>> components = new ArrayList<>();
visited=new boolean[v];
for (int i = 0; i < stack.size(); i++) {
	v=stack.pop();
	Stack<Integer> stack2 = new Stack<>();
	if(!visited[v]){
	
	doDFS(graph, v, visited, stack2);
	components.add(new ArrayList<>(stack2));
	}
	
}
	StdOut.print(components);

}

public static void doDFS(List<Integer>[] graph,int v, boolean[] visited,Stack<Integer> stack) {
	// TODO Auto-generated method stub
	//boolean[] visited = new boolean[graph.length];
	visited[v]=true;
		StdOut.print("DFS entered for node:"+ v);
	
			
			StdOut.print("\n Visited :"+v+"\n \n ");
			
			for (int j = 0; j < graph[v].size(); j++) {
				if(!visited[graph[v].get(j)])
				doDFS(graph,graph[v].get(j),visited,stack);
			
			
		}
			
	
		StdOut.print("\n DFS exit for node:"+ v+"\n");
		stack.push(v);
}

}

