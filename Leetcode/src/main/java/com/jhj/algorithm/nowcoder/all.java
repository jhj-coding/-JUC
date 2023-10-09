package com.jhj.algorithm.nowcoder;

public class all {

    //NC1 大数加法
    public class Solution1 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * <p>
         * 计算两个数之和
         *
         * @param s string字符串 表示第一个整数
         * @param t string字符串 表示第二个整数
         * @return string字符串
         */
        public String solve(String s, String t) {
            // write code here
            int res = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int slen = s.length();//短的
            int tlen = t.length();
            if (slen > tlen) {
                String ss = t;
                t = s;
                s = ss;
                slen = s.length();
                tlen = t.length();
            }
            for (int i = slen - 1; i >= 0; i--) {
                int j = tlen - (slen - i);
                int i1 = s.charAt(i) - '0';
                int i2 = t.charAt(j) - '0';
                int i3 = i1 + i2 + res;
                res = i3 / 10;
                stringBuilder.insert(0, i3 % 10);
            }
            for (int i = tlen - slen - 1; i >= 0; i--) {
                int i2 = t.charAt(i) - '0';
                int i3 = i2 + res;
                res = i3 / 10;
                stringBuilder.insert(0, i3 % 10);
            }
            if (res != 0) {
                stringBuilder.insert(0, res);
            }
            return stringBuilder.toString();
        }
    }
}
