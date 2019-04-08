package Algorithms_Book.Graph;

import java.util.Stack;

/**
 * Created by user on 10/1/18.
 */
public class Topological {
    private Stack<Integer> top;
    private boolean marked[];

    public Topological(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        top = new Stack<>();
        for (int i = 0; i < G.V(); i ++)
            if(!marked[i]) dfs(G, i);
    }

    private void dfs(EdgeWeightedDigraph G, int v){
        marked[v] = true;
        for (DirectedEdge e : G.adj(v))
            if(!marked[e.to()])
                dfs(G, e.to());
        top.push(v);
    }

    public Iterable<Integer> order(){
        return top;
    }
}
