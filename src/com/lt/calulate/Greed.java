package com.lt.calulate;

public class Greed {


    public static void main(String[] args) {

        Integer[] prices = new Integer[]{1, 5, 4, 7, 1, 8};
        greedPrices(prices);
        greedPricesWithAnother(prices);
        greedPricesWithJava(prices);

    }

    private static void greedPricesWithJava(Integer[] prices) {

        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        System.out.println(total);
    }

    private static void greedPricesWithAnother(Integer[] prices) {

        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (prices[i + 1] - prices[i] > 0) {
                total += prices[i + 1] - prices[i];
            }
        }

        System.out.println(total);
    }

    private static void greedPrices(Integer[] prices) {

        int index = 0;
        int total = 0;
        while (index < prices.length) {
            // 如果第一个大于第二个 那么继续找
            if (index < prices.length - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            int min = prices[index];
            // 找到上涨到的最大值
            while (index < prices.length - 1 && prices[index] <= prices[index + 1]) {
                index++;
            }

            total += prices[index++] - min;

        }

        System.out.println(total);

    }
}
