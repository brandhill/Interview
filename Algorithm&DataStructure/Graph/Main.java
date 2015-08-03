import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		/*************** Graph ****************/
		System.out.println("@@@@@@@@@@ Create a Graph @@@@@@@@@@\n");
		Graph G = new Graph("bin/tinyG.txt");
		G.printAdjList();
		G.search(12);
		
		// DFS:
		System.out.println("********** DFSPath Test **********\n");
		DFSPath DFSgetPath = new DFSPath(G);
		DFSgetPath.HasPathDFS(0, 3);
		DFSgetPath.HasPathDFS(0, 5);
		DFSgetPath.HasPathDFS(0, 12);
		
		// BFS:
		System.out.println("********** BFSPath Test **********\n");
		BFSPath BFSgetPath = new BFSPath(G);
		BFSgetPath.HasPathBFS(0, 3);
		BFSgetPath.HasPathBFS(0, 5);
		BFSgetPath.HasPathBFS(0, 12);
		
		// Connected Component:
		System.out.println("********** CC Test **********\n");
		CC cc = new CC(G);
		cc.count();
		cc.id(0);	cc.id(3);	cc.id(4);	cc.id(6);
		cc.id(7);	cc.id(8);
		cc.id(10);	cc.id(12);
		System.out.println();
		/* should be connected */
		cc.isConnected(0, 5);
		cc.isConnected(7, 8);
		cc.isConnected(9, 11);
		/* should be not connected */
		cc.isConnected(0, 7);
		cc.isConnected(7, 10);
		cc.isConnected(9, 3);
		
		// Cycle Detection:
		System.out.println("********** Cycle Test **********\n");
		Cycle cycle = new Cycle(G);
		cycle.hasCycle();
		
		// isBipartite:
		System.out.println("\n********** Bipartite Test **********\n");
		Bipartite bipartite = new Bipartite(G);
		bipartite.isBipartite();

		System.out.println("\nCreate new Graph");
		Graph G2 = new Graph("bin/Bipartite.txt");
		G2.printAdjList();
		Bipartite bipartite2 = new Bipartite(G2);
		bipartite2.isBipartite();
		
		/*************** SymbolGraph ****************/
		System.out.println("\n@@@@@@@@@@ Create a SymbolGraph based on Graph @@@@@@@@@@\n");
		SymbolGraph symbolgraph = new SymbolGraph("bin/routes.txt", " ");
		symbolgraph.printAdjList();
		symbolgraph.printList();
		
		/*************** Digraph ****************/
		System.out.println("\n@@@@@@@@@@ Create a Digraph @@@@@@@@@@\n");
		Digraph digraph = new Digraph("bin/tinyDG.txt");
		digraph.printAdjList();

		// DigraphDFS:
		System.out.println("********** DigraphDFS Test **********\n");
		DigraphDFS digraphDFS = new DigraphDFS(digraph);
		digraphDFS.search(12);
		digraphDFS.search(0);
		digraphDFS.search(6);
		
		// DigraphCycle:
		System.out.println("********** DigraphCycle Test **********\n");
		DigraphCycle digraphcycle = new DigraphCycle(digraph);
		digraphcycle.cycle();
		
		/*************** DAG ****************/
		System.out.println("\n@@@@@@@@@@ Create a DAG @@@@@@@@@@\n");

		// DepthFirstOrder:
		System.out.println("********** DepthFirstOrder Test **********\n");
		Digraph DAG = new Digraph("bin/tinyDAG.txt");
		DAG.printAdjList();
		DepthFirstOrder depthfirstorder = new DepthFirstOrder(DAG);
		depthfirstorder.pre();
		depthfirstorder.post();
		depthfirstorder.reversePost();
		
		// Topological:
		System.out.println("********** Topological Test **********\n");
		Topological topo = new Topological(DAG);
		topo.order();
		
		// Connected Component:
		System.out.println("********** KosarajuSCC Test **********\n");
		digraph.printAdjList();
		KosarajuSCC scc = new KosarajuSCC(digraph);
		scc.count();
		scc.id(0);	scc.id(1);
		scc.id(3);	scc.id(4);	scc.id(6);
		scc.id(7);	scc.id(8);
		scc.id(10);	scc.id(12);
		/* should be strongly connected */
		scc.isStronglyConnected(0, 5);
		scc.isStronglyConnected(9, 11);
		/* should be not strongly connected */
		scc.isStronglyConnected(7, 8);
		scc.isStronglyConnected(0, 7);
		scc.isStronglyConnected(7, 10);
		scc.isStronglyConnected(9, 3);

		System.out.println("\nend");
	}
}