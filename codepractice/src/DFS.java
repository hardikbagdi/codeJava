

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
		StdOut.print("Original DFS:");
		doDFS(graph,0,visited);
		List<Integer>[] reversedgraph=reversegraph(graph);
		StdOut.print("Reveresed graph DFS:");
		doDFS(reversedgraph,0,new boolean[reversedgraph.length]);
	}
	
	private static List<Integer>[] reversegraph(List<Integer>[] graph) {
		// TODO Auto-generated method stub
		int u,v;
		List<Integer>[] reversedgraph = new List[graph.length];
		for (int i = 0; i < graph.length; i++) {
			reversedgraph[i]=new ArrayList<>();
		}
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				reversedgraph[graph[i].get(j)].add(i);
			}
		}
		//doDFS(reversedgraph,0,new boolean[reversedgraph.length]);
		return reversedgraph;
	}

	public static void doDFS(List<Integer>[] graph,int v, boolean[] visited) {
		// TODO Auto-generated method stub
		//boolean[] visited = new boolean[graph.length];
			StdOut.print("DFS entered for node:"+ v);
			for ( v = 0; v < visited.length; v++) {
				
			}
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
