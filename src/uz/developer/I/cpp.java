package uz.developer.I;

import java.util.Scanner;

/**
 * Created by Hiro on 25/10/2017.
 */
public class cpp {
    static public long binpow(int a){
        if(a == 0)
            return 1;
        if(a%2 == 1)
            return 2*binpow(a-1);
        long res = binpow(a/2);
        return res * res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int l = n.length();
        System.out.print(l + " ");
        long x = 0, y = 0;
        for (int i = 0; i < l; i ++){
            boolean h = n.charAt(i) - '0' % 2 == 0;
            x += h ? 0 : binpow(l - i - 1);
            y += n.charAt(i) - '0' > 1 ? binpow(l-i-1) : 0;
            System.out.println(x + " " + y);
        }
        System.out.print(x + " " + y);
    }
}
