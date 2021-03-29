/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 * Use recursive function to calculate fibonacci numbers 0,1,1,2,3,5,8,13,21,34
 * Actually some situations, a question can be converted to getting finonacci
 * number calculations A frog can either jump onto 1 stair or 2 stairs. Ask to
 * jump to n(th) stairs, there are how many ways ?
 *
 * @author tangz
 */
public class FibnacciRecursiveWay {

    //To jump to stair n
    //The frog can either jump from n-1 stair or n-2 stairs
    //Because a frog can either jump onto 1 stair or 2 stairs
    //So the ways how a frog can jump to n stairs can be put in recursive way
    public static int frogJump(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        // 1, 1  (jump 1 and jump 1)
        // 2     (jump 2 all in once)
        if (n == 2) {
            return 2;
        }

        //Use add principle instead of multiply principle
        //To get destination c,  we can go from A - > C  and B - > C
        //From A to C we have X ways,
        //From B to C we have Y ways.
        //Ask how many different ways we can go to C
        //  the answer should be 
        //  n = X + Y;
        return frogJump(n - 1) + frogJump(n - 2);
    }

    public static int frogJumpIterative(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int prev = 1;
        int next = 2;
        for (int i = 3; i <= n; i++) {
            result = prev + next;
            prev = next;
            next = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 2;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 3;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 4;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 5;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 6;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 7;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 8;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 9;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 10;
        System.out.printf("f(%d): %d%n", n, frogJump(n));
        n = 11;
        System.out.printf("f(%d): %d%n", n, frogJump(n));

        n = 1;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 2;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 3;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 4;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 5;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 6;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 7;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 8;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 9;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 10;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
        n = 11;
        System.out.printf("frogJumpIterative(%d): %d%n", n, frogJumpIterative(n));
    }

}
