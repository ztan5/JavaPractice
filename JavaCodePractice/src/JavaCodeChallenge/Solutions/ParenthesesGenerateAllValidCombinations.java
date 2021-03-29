/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * given n pair of () generate all valid combinations e.g. ((())) output:
 * ()()(), ()(()), (())(), (()()), ((()))
 *
 * @author tangz
 */
public class ParenthesesGenerateAllValidCombinations {

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            System.out.println(Arrays.toString(current));
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            System.out.println(Arrays.toString(current));
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        ParenthesesGenerateAllValidCombinations ps = new ParenthesesGenerateAllValidCombinations();

        List<String> ls = ps.generateParenthesis(4);
        System.out.println(Arrays.toString(ls.toArray(args)));
    }
}
