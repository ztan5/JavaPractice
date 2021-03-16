/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.nab;

import java.util.Stack;

/**
 * This is the abstract class of a stack machine which can be operated in any {@link Object}
 * It contains an operator stack
 * It contains an command stack
 * It defines abstract methods that all sub-classes must override
 * @param <T> Parameterized Type
 * @author tangz
 */
public abstract class StackMachine<T> {
    public Stack<T> elements;
    public Stack<Command> history;
    
    /**
     * Default constructor
     */
    public StackMachine() {
        elements = new Stack<>();
        history = new Stack<>();
    }
    
    
    
    private class Command {
        protected T lhs;
        protected T rhs;
        protected String operator;
        /**
         * Constructor
         * @param lhs left hand side object of calculation
         * @param rhs right hand side object of calculation
         * @param operator {@link String} representation of operator
         */
        public Command(T lhs, T rhs, String operator){
            this.lhs = lhs;
            this.rhs = rhs;
            this.operator = operator;
        }
        public T getLhs(){
            return this.lhs;
        }
    };
}
