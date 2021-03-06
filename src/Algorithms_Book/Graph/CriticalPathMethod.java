package Algorithms_Book.Graph;

import java.util.Scanner;

/**
 * Critical path method for parallel precedence-constrained job scheduling
 * Created by user on 10/1/18.
 */

public class CriticalPathMethod {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = sc.nextInt();
        sc.nextLine();
        EdgeWeightedDigraph G;
        G = new EdgeWeightedDigraph(2 * N + 2);
        int s = 2 * N, t = 2 * N + 1;
        for (int i = 0; i < N; i++) {
            String[] a = sc.nextLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new DirectedEdge(i, i + N, duration));
            G.addEdge(new DirectedEdge(s, i, 0.0));
            G.addEdge(new DirectedEdge(i + N, t, 0.0));
            for (int j = 1; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new DirectedEdge(i + N, successor, 0.0));
            }
        }

        AcyclicLP lp = new AcyclicLP(G, s);
        System.out.println("Start times:");
        for (int i = 0; i < N; i++)
            System.out.printf("%4d: %5.1f\n", i, lp.distTo(i));
        System.out.printf("Finish time: %5.1f\n", lp.distTo(t));
    }
}
