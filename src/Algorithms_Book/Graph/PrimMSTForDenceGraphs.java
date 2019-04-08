package Algorithms_Book.Graph;

import Algorithms_Book.Bag;
import Algorithms_Book.IndexMinPQ;

/**
 * Created by user on 9/25/18.
 */
public class PrimMSTForDenceGraphs {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    int comparisons = 0;
    int V;

    public PrimMSTForDenceGraphs(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        V = G.V();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[0] = 0.0;

        for (int i = 0; i < G.V(); i ++){
            int y = min();
            for (Edge x : G.adj(y)){
                int w = x.other(y);
                if(!marked[w] && distTo[w] > x.weight()) {
                    distTo[w] = x.weight();
                    edgeTo[w] = x;
                }
            }
            distTo[y] = Double.POSITIVE_INFINITY;
        }
    }

    int min(){
        int in = 0;
        for (int i = 0; i < V; i ++){
            if(distTo[i] < distTo[in]) {
                in = i;
            }
        }
        return in;
    }

    public Iterable<Edge> edges()
    {
        Bag<Edge> mst = new Bag<Edge>();
        for (int v = 1; v < edgeTo.length; v++)
            mst.add(edgeTo[v]);
        return mst;
    }
}
