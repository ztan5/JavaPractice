/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 * Return the max profit if we buy and sell
 * @author tangz
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

//    public int maxProfit(int[] prices) {
//        int n = prices.length;
//        if (n == 0 || n == 1) {
//            return 0;
//        }
//
//        Set<Integer> profitRank = new TreeSet<>(Collections.reverseOrder());
//
//        int[][] m = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i >= j) {
//                    m[i][j] = 0;
//                } else {
//                    m[i][j] = (prices[j] - prices[i]) > 0 ? (prices[j] - prices[i]) : 0;
//                }
//            }
//        }
//        printMatrix(m);
//        //All Depth
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                if (m[row][col] > 0) {
//                    int depth = col + 1;
//                    int profit = m[row][col];
//                    while (depth < n) {
//                        boolean bAllZeroRow = true;
//                        for (int i = 0; i < n; i++) {
//                            if (m[depth][i] > 0) {
//                                profit += m[depth][i];
//                                depth = i + 1;
//                                bAllZeroRow = false;
//                                break;
//                            }
//                        }
//                        if (bAllZeroRow) {
//                            depth++;
//                        }
//                    }
//                    profitRank.add(profit);
//                }
//            }
//        }
//        //All Width
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                if (m[row][col] > 0) {
//                    int depth = col + 1;
//                    int profit = m[row][col];
//                    while (depth < n) {
//                        int max = 0;
//                        for (int i = 0; i < n; i++) {
//                            if (m[depth][i] > max) {
//                                max = m[depth][i];
//                            }
//                        }
//                        profit += max;
//                        profitRank.add(profit);
//                        profit = m[row][col];
//                        depth++;
//                    }
//                }
//            }
//        }
//
//        if (profitRank.isEmpty()) {
//            return 0;
//        } else {
//            return profitRank.iterator().next();
//        }
//    }
//
//    public void printMatrix(int[][] n) {
//        int rows = n[0].length;
//        for (int i = 0; i < rows; i++) {
//            System.out.println(Arrays.toString(n[i]));
//        }
//    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        int[] n1 = {7, 1, 5, 3, 6}; //7
        System.out.println("Max Profit: " + solution.maxProfit(n1));
        int[] n2 = {1, 2, 3, 4, 5}; //4
        System.out.println("Max Profit: " + solution.maxProfit(n2));
        int[] n3 = {7, 6, 4, 3, 1}; //0
        System.out.println("Max Profit: " + solution.maxProfit(n3));

        int[] n4 = {1, 2, 3};//2
        System.out.println("Max Profit: " + solution.maxProfit(n4));

        int[] n5 = {9, 8, 7, 1, 10}; //9
        System.out.println("Max Profit: " + solution.maxProfit(n5));

        int[] n6 = {2, 1, 9, 7};//8
        System.out.println("Max Profit: " + solution.maxProfit(n6));

        int[] n7 = {6, 1, 3, 2, 4, 7};//7
        System.out.println("Max Profit: " + solution.maxProfit(n7));

        int[] n8 = {3,2,6,5,0,3};//7
        System.out.println("Max Profit: " + solution.maxProfit(n8));
          
        int[] n9 = {2,1,2,1,0,1,2}; //3
        System.out.println("Max Profit: " + solution.maxProfit(n9));

        int[] n10 = {3, 3, 5, 0, 0, 3, 1, 4};//8
        System.out.println("Max Profit: " + solution.maxProfit(n10));

        int[] n11 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0}; //15
        System.out.println("Max Profit: " + solution.maxProfit(n11));
    }
}
