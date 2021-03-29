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
public class FirstNoneRepeatedCharacter2 {

    public class PlaceHolder implements Comparable<PlaceHolder> {

        Integer index;
        Integer counter;

        @Override
        public int compareTo(PlaceHolder o) {
            if (counter.compareTo(o.counter) == 0) {
                return index.compareTo(o.index);
            } else {
                return counter.compareTo(o.counter);
            }
        }

    }

    private final Map<Character, PlaceHolder> map = new HashMap<Character, PlaceHolder>();

    public Character getFristRepeatedCharacter(String input) {
        map.clear();
        if (input == null || input.isEmpty()) {
            return '#';
        }

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (map.get(c) == null) {
                PlaceHolder p = new PlaceHolder();
                p.counter = 1;
                p.index = i;
                map.put(c, p);
            } else {
                PlaceHolder q = (PlaceHolder) map.get(c);
                q.counter = q.counter + 1;
                q.index = i;
            }
        }

        Map sortedMap = new TreeMap<PlaceHolder, Character>();
        Iterator<Character> it = map.keySet().iterator();
        while (it.hasNext()) {
            Character c = it.next();
            PlaceHolder p = (PlaceHolder) map.get(c);
            if (p.counter == 1) {
                sortedMap.put(p, c);
            }
        }

        Iterator<PlaceHolder> itp = sortedMap.keySet().iterator();
        while (itp.hasNext()) {
            PlaceHolder p = itp.next();
            Character c = (Character) sortedMap.get(p);
            return c;
        }

        return '#';
    }

    public static void main(String[] args) {
        FirstNoneRepeatedCharacter2 solution = new FirstNoneRepeatedCharacter2();
        String s1 = "aabacce";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aabacceb";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aafcbe";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "ebbaaccddehtiqbbdkdlag";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "xhmnidfffasssigppdxhlmllidhdiahkdljpoiwat;lidijfaslkdjfa;lsjdfaoieaoidj";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "aaaaab";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = null;
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));

        s1 = "vvvvv";
        System.out.println("First Non-repeated Character in " + s1 + " is: " + solution.getFristRepeatedCharacter(s1));
    }
}
