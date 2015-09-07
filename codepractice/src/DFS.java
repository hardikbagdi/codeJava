
import java.util.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
public class DFS {
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
		boolean[] visited = new boolean[graph.length];
		doDFS(graph,0,visited);
		
	}

	private static void doDFS(List<Integer>[] graph,int v, boolean[] visited) {
		// TODO Auto-generated method stub
		//boolean[] visited = new boolean[graph.length];
			StdOut.print("DFS entered for node:"+ v);
			while (!visited[v]) {
				visited[v]=true;
				StdOut.print("\n Visited :"+v+"\n \n ");
				for (int j = 0; j < graph[v].size(); j++) {
					doDFS(graph,graph[v].get(j),visited);
				
				
			}
				
		}
			StdOut.print("\n DFS exit for node:"+ v+"\n");
	}
}
