package Algorithms_Book;

/**
 * Created by user on 9/8/18.
 */
class FastMinPQ<Key extends Comparable> {
    private Key[] pq;             // heap-ordered complete binary tree
    private int N = 0;            //    in pq[1..N] with pq[0] unused

    public FastMinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        int left = 0;
        int right = 31;
        while ((N & (1 << right)) == 0) {
            right--;
        }
        int mid;
        do {
            mid = (left + right) >> 1;
            if (greater(N, N >> mid)) {
                right = mid;
            } else left = mid;
        }while (mid != left);

        for (int i = 0; i < mid; i ++)
            exch(N >> i, N >> (i + 1));
    }

    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }


    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    static int ff = 0;
    public static void main(String[] args) {
        FastMinPQ<Integer> pq = new FastMinPQ<>(12);
        for (int i = 0; i < 10; i ++)
            pq.insert((i * 7) % 10);

        for (int i = 0; i < 10; i ++)
            System.out.println(pq.delMin());
    }
}
