/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.nab;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This is the class of a stack machine which can be operated in any {@link Object}
 * It contains an operator stack
 * It contains an command stack
 * It defines abstract methods that all sub-classes must override
 * 
 * @author tangz
 */
public class StackMachine {
    public Stack<BigDecimal> elements;
    public Stack<Command> history;
    
    /**
     * Default constructor
     */
    public StackMachine() {
        elements = new Stack<>();
        history = new Stack<>();
    }
    
    /**
     * Pushes the element to the top of the stack
     * @param element to be pushed into stack
     */
    public void push(BigDecimal element) {
        elements.push(element);
        Command cmd = new Command (element, null, "push");
        history.push(cmd);
    }
    
    /**
     * Removes the top element from the stack
     * @return BigDecimal element which just get pop from the top of the stack
     *         null if stack is empty
     * @throws EmptyStackException if elements stack is empty
     */
    public BigDecimal pop() throws EmptyStackException {
        BigDecimal a = elements.pop();
        Command cmd = new Command (a, null, "pop");
        history.push(cmd);
        return a;
    }
    
    /**
     * Removes all elements from the elements stack
     * Removes all elements from the history stack
     */
    public void clear() {
        elements.clear();
    }
    
    /**
     * Adds the top 2 elements on the stack and pushes the result back to the stack
     * @throws IllegalArgumentException when only 1 or none elements in the stack
     */
    public abstract void add() throws IllegalArgumentException;
    
    /**
     * Multiplies the top 2 elements on the stack and pushes the result back to the stack
     * @throws IllegalArgumentException when only 1 or none elements in the stack
     */
    public abstract void multiply() throws IllegalArgumentException;
    
    /**
     * Negates the top element on the stack and pushes the result back to the stack
     */
    public abstract void negate();
    
    /**
     * Inverts the top element on the stack and pushes the result back to the stack
     */
    public abstract void invert();
    
    /**
     * The last instruction is undone leaving the stack in the same state as before that instruction
     * This instruction will pop out the top element from history stack and do following steps
     * 1. It will pop the top element from the element stack (previous calculation result is abandoned)
     * 2. It will push the left hand side first back into elements stack
     * 3. It will then push the right hand side element back into element stack
     */
    public abstract void undo();
    
    /**
     * Prints all elements that are currently on the stack
     * How to print and where to print is up to the actual implementation of this method
     */
    public abstract void print();
    
    /**
     * Inner class to describe an instruction
     * Left hand side element cannot be null
     * Right hand side element can be null if operator is a 
     */
    private class Command {
        protected BigDecimal lhs;
        protected BigDecimal rhs;
        protected String operator;
        /**
         * Constructor
         * @param lhs left hand side object of calculation
         * @param rhs right hand side object of calculation
         * @param operator {@link String} representation of operator
         */
        public Command(BigDecimal lhs, BigDecimal rhs, String operator){
            this.lhs = lhs;
            this.rhs = rhs;
            this.operator = operator;
        }
        /**
         * Get left hand side element
         * @return {@link BigDecimal} left hand side element
         */
        public BigDecimal getLhs(){
            return this.lhs;
        }
        /**
         * Get right hand side element
         * @return {@link BigDecimal} right hand side element
         */
        public BigDecimal getRhs(){
            return this.rhs;
        }
    };
}
