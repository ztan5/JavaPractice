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
