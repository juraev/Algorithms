package Algorithms_Book;

import sun.tools.jconsole.Plotter;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by user on 9/10/18.
 */
public class PerformanceDriver {
    public static void main(String[] args) {
        int n = 100;
        MaxPQ<Integer> pq = new MaxPQ<>(n);

        Random rd = new Random();
        IntStream is;
        IntStream is2;

        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            is = rd.ints(n, 0, n);
            is2 = rd.ints(n / 2, 0, n / 2);
            Long s;
//            synchronized (PerformanceDriver.class) {
                s = System.currentTimeMillis();
                is.forEach(pq::insert);
                for (int j = 0; j * 2 < n; j++)
                    pq.delMax();
                is2.forEach(pq::insert);
                while (!pq.isEmpty())
                    pq.delMax();
                list.add(System.currentTimeMillis() - s);

//            }

        }
        try {
            File file = new File("/Users/user/Desktop/train/a.csv");
            FileWriter fw = new FileWriter(file);
            list.forEach((v) -> {
                try {
                    fw.write(v + " ");
                    fw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Process ps = Runtime.getRuntime().exec("python /Users/user/Desktop/train/temp.py /Users/user/Desktop/train/a.csv");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            String s;
            while((s=stdInput.readLine())!=null){
                System.out.println(s);
            }

            BufferedReader stdError = new BufferedReader(new InputStreamReader(ps.getErrorStream()));

            while ((s = stdError.readLine()) != null){
                System.out.println(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
