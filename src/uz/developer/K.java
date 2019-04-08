package uz.developer;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Hiro on 23/09/2017.
 */
public class K {
    public static long n, k, m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextLong();
        k = scan.nextLong();
        m = scan.nextLong();

        Matrix D = new Matrix(0, k - 1, 1, k - 1);
        Matrix E = Matrix.binpow(D, n - 2);
        BigInteger ans = BigInteger.valueOf((
                        ((k - 1) % m * D.b) % m +
                                (((k % m) * ((k - 1) % m)) % m * D.d) % m
                ) % m

        );
        System.out.println(ans);
    }


    static class Matrix {
        long a, b, c, d;

        Matrix(long a1, long b1, long c1, long d1) {
            a = a1;
            b = b1;
            c = c1;
            d = d1;
        }

        public static Matrix mult(Matrix A, Matrix B) {
            Matrix C = new Matrix(0, 0, 0, 0);
            C.a = ((A.a * B.a) % m + (A.c * B.b) % m) % m;
            C.b = ((A.b * B.a) % m + (A.d * B.b) % m) % m;
            C.c = ((A.a * B.c) % m + (A.c * B.d) % m) % m;
            C.d = ((A.b * B.c) % m + (A.d * B.d) % m) % m;
            return C;
        }

        static Matrix binpow(Matrix A, long h) {
            Matrix C = new Matrix(0, k - 1, 1, k - 1);
            if (n == 1) return C;
            if (n % 2 == 1) {
                C.a = 0;
                C.b = k - 1;
                C.c = 1;
                C.d = k - 1;
                return mult(C, binpow(A, n - 1));
            }
            C = binpow(A, n / 2);
            return mult(C, C);
        }

    }

}

