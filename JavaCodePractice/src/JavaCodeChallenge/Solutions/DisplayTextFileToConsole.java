/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * This class is a simple demo of how to display a text file to console
 *
 * @author tangz
 */
public class DisplayTextFileToConsole {

    public Dog rename(Dog dog, String newName) {
        dog.setName(newName);
        return dog;
    }

    public void rename(Dog dog) {
        dog.setName("cccc");
    }

    public String display(String filePath) throws FileNotFoundException, IOException {
        InputStream input = new FileInputStream(filePath);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader bufferReader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = bufferReader.readLine()) != null) {
            sb.append(str);
            //Because readLine() of bufferReader won't read the new line separator
            //That is why we have to append one here
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        DisplayTextFileToConsole dt = new DisplayTextFileToConsole();
        try {
            System.out.println(dt.display("D:\\Sample.txt"));
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        Dog myDog = new Dog("foo");
        System.out.println("My dog\'s name is : " + myDog.getName());
        dt.rename(myDog, "aaa");
        System.out.println("My dog\'s after rename is : " + myDog.getName());
        dt.rename(myDog);
        System.out.println("My dog\'s after rename is : " + myDog.getName());

        int [][] a = new int [3][3];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 2;
        a[2][0] = 2;
        a[2][1] = 2;
        
        int [][] b = a.clone();
        System.out.println(Arrays.toString(b[0]));
        System.out.println(Arrays.toString(b[1]));
        System.out.println(Arrays.toString(b[2]));
        
        int [] c = new int[4];
        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;
        System.out.println(Arrays.toString(c));
        
        int [] d = new int[4];
        System.out.println(Arrays.toString(d));
        d = c.clone();
        System.out.println(Arrays.toString(d));
        
        String[] strArr = new String[3];
        strArr[0] = "Monday";
        strArr[2] = "Wednesday";
        strArr[1] = "Tuesday";
        System.out.println(Arrays.toString(strArr));
    }
}
