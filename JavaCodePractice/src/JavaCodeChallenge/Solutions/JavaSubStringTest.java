/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 *public String substring(int beginIndex, int endIndex)
 * Returns a string that is a substring of this string. 
 * The substring begins at the specified beginIndex and extends to the character at index endIndex - 1. 
 * Thus the length of the substring is endIndex-beginIndex. 
Examples: 

 "hamburger".substring(4, 8) returns "urge"
 "smiles".substring(1, 5) returns "mile"
 Parameters: 
beginIndex - the beginning index, inclusive. 
endIndex - the ending index, exclusive. 
Returns: 
the specified substring. 
Throws: 
IndexOutOfBoundsException - if the beginIndex is negative, or endIndex is larger than the length of this String object, or beginIndex is larger than endIndex. 
 * @author tangz
 */
public class JavaSubStringTest {
    public static void main(String[] args){
        String message = "Hello world!";
        String newMessage = message.substring(6, 12); //+ message.substring(12, 6);
        System.out.println(newMessage);
    }
}
