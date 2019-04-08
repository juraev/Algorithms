package uz.developer.I;

/**
 * Created by user on 8/24/18.
 */
public class Sisters {
    public static void main(String[] args) {

        int a[] = new int[64];

        for (int i = 0; i < 64; i++) {
            a[i] = 0;
        }

        System.out.println(second(first(a, 35)));

    }


    static public int second(int[] a) {

        long sum = 0;
        for (int i = 0; i < 64; i++) {
            sum += (1 << i) * a[i];
        }
        if (sum > ((1 << 63) - 1))
            sum = (1 << 64) - 1 - sum;

        return (int) sum % 64;
    }

    static public int[] first(int[] a, int c) {
        long sum = 0;
        for (int i = 0; i < 64; i++) {
            if (a[i] == 1) {
                sum += (1 << i);
            }
        }
        long temp;
        for (int i = 0; i < 64; i++) {
            temp = sum;
            if (a[i] == 1) {
                temp -= 1 << i;
            } else {
                temp += 1 << i;
            }
            if (a[63] == 1)
                temp = (1 << 64) - 1 - temp;
            System.out.println(temp % 64);
            if (temp % 64 == c) {
                a[i] = 1 - a[i];
                return a;
            }
        }
        return a;
    }
}
