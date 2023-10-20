package com.jhj.algorithm.nowcoder;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(ins);
        in.nextToken();
        int t = (int)in.nval;
        for(int i=0;i<t;i++) {
            in.nextToken();
            int y = (int) in.nval;
            in.nextToken();
            int z = (int) in.nval;
            in.nextToken();
            int b = (int) in.nval;
            double v = Math.pow(y, Math.E) / (z * 1.0);
            BigDecimal bigDecimal = new BigDecimal(v);
            System.out.println(bigDecimal.setScale(b, BigDecimal.ROUND_HALF_EVEN));
        }



    }

}
