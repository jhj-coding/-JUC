package com.jhj.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class One {

    private static Unsafe reflectGetUnsafe() throws NoSuchFieldException, IllegalAccessException {
       Field field=Unsafe.class.getDeclaredField("theUnsafe");
       field.setAccessible(true);
       return (Unsafe) field.get(null);
    }
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int[] a = new int[6];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
//        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
