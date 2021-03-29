/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * () (()), ()() ((())), (())(), ()(()), (()()), ()()()
 * Not yet come up with any solution
 * @author tangz
 */
public class ParenthesisGenerateAllMyOwnSolution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public static void main(String[] args) {
        ParenthesisGenerateAllMyOwnSolution ps = new ParenthesisGenerateAllMyOwnSolution();
        System.out.println(ps.generateParenthesis(3));
    }
}
