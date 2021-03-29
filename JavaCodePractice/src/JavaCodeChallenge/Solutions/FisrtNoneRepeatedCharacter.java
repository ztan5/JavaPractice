/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author tangz
 */
public class FisrtNoneRepeatedCharacter {

    private Map<Character, Integer> map = new HashMap<>();
    private Map<Integer, Character> indexMap = new TreeMap<>();
//  Original one
    public Character getFristRepeatedCharacter(String input) {
        map.clear();
        indexMap.clear();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            Integer counter = map.get(ch);
            if (counter != null) {
                map.put(ch, ++counter);
                removeFromIndexMap(ch);
            } else {
                map.put(ch, 1);
                indexMap.put(i, ch);
            }
        }

        return getChar();
    }

    public Character getChar() {
        Iterator<Integer> it = indexMap.keySet().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            return indexMap.get(i);
        }
        return null;
    }

    //Remove item from a map by its value
    //Can be improved here, has to iterate the 
    public void removeFromIndexMap(Character ch) {
        Iterator<Integer> it = indexMap.keySet().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            Character c = indexMap.get(i);
            if (c.compareTo(ch) == 0) {
                indexMap.remove(i);
                return;
            }
        }
    }

    public static void main(String[] args) {
        FisrtNoneRepeatedCharacter solution = new FisrtNoneRepeatedCharacter();
        String s1 = "aabacce";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aabacceb";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aafcbe";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "ebbaaccddehtiqbbdkdlag";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aaaaab";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));
    }
}
