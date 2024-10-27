package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        int len = array.length;
        boolean[] isLocalMaxima = new boolean[len];
        int countLocalMaxima = 0;

        for (int i = 0; i < len; i++) {
            if ((i == 0 && array[i] > array[i + 1]) ||
                    (i == len - 1 && array[i] > array[i - 1]) ||
                    (i > 0 && i < len - 1 && array[i] > array[i - 1] && array[i] > array[i + 1])) {
                isLocalMaxima[i] = true;
                countLocalMaxima++;
            }
        }

        int[] result = new int[len - countLocalMaxima];
        int resultPos = 0;
        for (int i = 0; i < len; i++) {
            if (!isLocalMaxima[i]) {
                result[resultPos++] = array[i];
            }
        }

        return result;
    }
}
