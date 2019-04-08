package uz.developer;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    static long sx, sy, fx, fy, n, k, vmax;
    static int t;
    static long wx[] = new long[10002];
    static long wy[] = new long[10002];
    public static void main(String[] args) {
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(new FileInputStream("joy.in")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("joy.out")))){
            String s = bf.readLine();
            String a[] = s.split(" ");
            sx = Long.parseLong(a[0]);
            sy = Long.parseLong(a[1]);
            fx = Long.parseLong(a[2]);
            fy = Long.parseLong(a[3]);
            long dx = fx - sx;
            long dy = fy - sy;
            long Wx = 0, Wy = 0;
            long vx, vy;
            s = bf.readLine();
            a = s.split(" ");
            n = Long.parseLong(a[0]);
            k = Long.parseLong(a[1]);
            vmax = Long.parseLong(a[2]);
            for (int i = 0; i < n; i ++){
                s = bf.readLine();
                a = s.split(" ");
                t = Integer.parseInt(a[0]);
                wx[t] = Long.parseLong(a[1]);
                wy[t] = Long.parseLong(a[2]);
                Wx += wx[t];
                Wy += wy[t];
            }
            vx = dx - Wx;
            vy = dy - Wy;
            if(vx * vx + vy * vy > vmax * vmax * k * k){
                bw.write("No");
                bw.newLine();
                bw.flush();
                return;
            }

            bw.write("Yes");
            bw.newLine();
            bw.flush();

            BigDecimal s1 = new BigDecimal(sx);
            BigDecimal s2 = new BigDecimal(sy);
            double v1 = 1.0 * vx / k;
            double v2 = 1.0 * vy / k;
            for (int i = 0; i < k; i ++){
                s1 = s1.add(new BigDecimal(v1 + (double)wx[i]));
                s2 = s2.add(new BigDecimal(v2 + (double)wy[i]));
                bw.write(s1 + " " + s2 );
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
