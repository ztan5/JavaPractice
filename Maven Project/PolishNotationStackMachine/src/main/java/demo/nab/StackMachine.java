/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.nab;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This is the class of a stack machine which can be operated in any
 * {@link Object} It contains an operator stack It contains an command stack It
 * defines abstract methods that all sub-classes must override
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
     * Peek the top element of elements stack
     *
     * @return BigDecimal top element
     * @throws EmptyStackException if elements stack is empty
     */
    public BigDecimal peek() throws EmptyStackException {
        return elements.peek();
    }

    /**
     * Pushes the element to the top of the stack
     *
     * @param element to be pushed into stack
     */
    public void push(BigDecimal element) {
        elements.push(element);
        Command cmd = new Command(element, null, "push");
        history.push(cmd);
    }

    /**
     * Removes the top element from the stack
     *
     * @return BigDecimal element which just get pop from the top of the stack
     * null if stack is empty
     * @throws EmptyStackException if elements stack is empty
     */
    public BigDecimal pop() throws EmptyStackException {
        BigDecimal element = elements.pop();
        Command cmd = new Command(element, null, "pop");
        history.push(cmd);
        return element;
    }

    /**
     * Removes all elements from the elements stack Removes all elements from
     * the history stack
     */
    public void clear() {
        elements.clear();
        history.clear();
    }

    /**
     * Adds the top 2 elements on the stack and pushes the result back to the
     * stack
     *
     * @throws IllegalArgumentException when elements stack contains less than 2
     * elements
     */
    public void add() throws IllegalArgumentException {
        if (elements.size() < 2) {
            throw new IllegalArgumentException("Invalid instruction: ADD command requires 2 numbers");
        }

        BigDecimal lhs = elements.peek();
        elements.pop();
        BigDecimal rhs = elements.peek();
        elements.pop();
        BigDecimal result = lhs.add(rhs);
        elements.push(result);
        Command cmd = new Command(lhs, rhs, "add");
        history.push(cmd);
    }

    /**
     * Multiplies the top 2 elements on the stack and pushes the result back to
     * the stack
     *
     * @throws IllegalArgumentException when elements stack contains less than 2
     * elements
     */
    public void multiply() throws IllegalArgumentException {
        if (elements.size() < 2) {
            throw new IllegalArgumentException("Invalid instruction: MUL command requires 2 numbers");
        }
        BigDecimal lhs = elements.peek();
        elements.pop();
        BigDecimal rhs = elements.peek();
        elements.pop();
        BigDecimal result = lhs.multiply(rhs);
        elements.push(result);
        Command cmd = new Command(lhs, rhs, "mul");
        history.push(cmd);
    }

    /**
     * Negates the top element on the stack and pushes the result back to the
     * stack
     *
     * @throws EmptyStackException when elements stack is empty
     */
    public void negate() throws EmptyStackException {
        BigDecimal lhs = elements.peek();
        BigDecimal result = lhs.multiply(new BigDecimal(-1));
        elements.pop();
        elements.push(result);
        Command cmd = new Command(lhs, null, "neg");
        history.push(cmd);
    }

    /**
     * Inverts the top element on the stack and pushes the result back to the
     * stack
     *
     * @throws EmptyStackException when elements stack is empty
     * @throws IllegalArgumentException when element is value 0 (0 has no
     * inverse value)
     */
    public void invert() throws EmptyStackException, IllegalArgumentException {
        BigDecimal lhs = elements.peek();
        if (lhs.compareTo(new BigDecimal(0)) == 0) {
            throw new IllegalArgumentException("Invalid instruction: Cannot invert value 0");
        }
        BigDecimal invertor = new BigDecimal(1);
        BigDecimal result = invertor.divide(lhs, MathContext.DECIMAL32);
        elements.pop();
        elements.push(result);
        Command cmd = new Command(lhs, null, "inv");
        history.push(cmd);
    }

    /**
     * The last instruction is undone leaving the stack in the same state as
     * before that instruction This instruction will pop out the top element
     * from history stack and do following steps 1. It will pop the top element
     * from the element stack (previous calculation result is abandoned) 2. It
     * will push the left hand side first back into elements stack 3. It will
     * then push the right hand side element back into element stack
     *
     * @throws EmptyStackException when history stack is empty
     * @throws IllegalArgumentException when command contains invalid arguments
     */
    public void undo() throws EmptyStackException, IllegalArgumentException {
        Command cmd = history.peek();
        String cmdStr = cmd.getCommand();
        BigDecimal lhs = cmd.getLhs();
        BigDecimal rhs = cmd.getRhs();

        //This should not happen but it is good to place this check here
        if (lhs == null) {
            throw new IllegalArgumentException("Invalid arguments: Null value found in left hand side value.");
        }

        if (cmdStr.equalsIgnoreCase("push")) {
            elements.pop();
        } else if (cmdStr.equalsIgnoreCase("pop")) {
            elements.push(lhs);
        } else if (cmdStr.equalsIgnoreCase("add")) {
            if (rhs == null) {
                throw new IllegalArgumentException("Invalid arguments: Null value found in right hand side value.");
            }
            elements.pop();
            elements.push(rhs);
            elements.push(lhs);
        } else if (cmdStr.equalsIgnoreCase("mul")) {
            if (rhs == null) {
                throw new IllegalArgumentException("Invalid arguments: Null value found in right hand side value.");
            }
            elements.pop();
            elements.push(rhs);
            elements.push(lhs);
        } else if (cmdStr.equalsIgnoreCase("neg")) {
            elements.pop();
            elements.push(lhs);
        } else if (cmdStr.equalsIgnoreCase("inv")) {
            BigDecimal invertor = new BigDecimal(1);
            if (lhs.compareTo(new BigDecimal(0)) == 0) {
                throw new IllegalArgumentException("Invalid arguments: divide by 0 error found.");
            }
            //BigDecimal orgValue = invertor.divide(lhs, MathContext.DECIMAL32);
            elements.pop();
            elements.push(lhs);
        }

        //process is finished, remove this history from stack
        history.pop();
    }

    /**
     * Prints all elements that are currently on the stack How to print and
     * where to print is up to the actual implementation of this method
     */
    public String print() {
        if (elements.isEmpty()) {
            return "";
        }
        StringBuilder s1 = new StringBuilder();
        Object[] arr = elements.toArray();
        for (int i = 0; i < arr.length; i++) {
            BigDecimal element = (BigDecimal) arr[i];
            s1.append(element);
            //new line separated string for display
            //Use System.lineSeparator() to let it work in all OS.
            s1.append(System.lineSeparator());
        }
        return s1.toString();
    }

    /**
     * Print all stack contents of history stack
     *
     * @return String all elements separated by new line
     */
    public String printCommand() {
        if (history.isEmpty()) {
            return "";
        }
        StringBuilder s1 = new StringBuilder();
        Object[] arr = history.toArray();
        for (int i = 0; i < arr.length; i++) {
            Command cmd = (Command) arr[i];
            s1.append(cmd.getLhs());
            s1.append(", ");
            s1.append(cmd.getRhs() == null ? " " : cmd.getRhs());
            s1.append(", ");
            s1.append(cmd.getCommand().toUpperCase());
            //new line separated string for display
            //Use System.lineSeparator() to let it work in all OS.
            s1.append(System.lineSeparator());
        }
        return s1.toString();
    }

    /**
     * Inner class to describe an instruction Left hand side element cannot be
     * null Right hand side element can be null if operator is a
     */
    private class Command {

        protected BigDecimal lhs;
        protected BigDecimal rhs;
        protected String operator;

        /**
         * Constructor
         *
         * @param lhs left hand side object of calculation
         * @param rhs right hand side object of calculation
         * @param operator {@link String} representation of operator
         */
        public Command(BigDecimal lhs, BigDecimal rhs, String operator) {
            this.lhs = lhs;
            this.rhs = rhs;
            this.operator = operator;
        }

        /**
         * Get left hand side element
         *
         * @return {@link BigDecimal} left hand side element
         */
        public BigDecimal getLhs() {
            return this.lhs;
        }

        /**
         * Get right hand side element
         *
         * @return {@link BigDecimal} right hand side element
         */
        public BigDecimal getRhs() {
            return this.rhs;
        }

        /**
         * Get this command's operator string
         *
         * @return {@link String} operator
         */
        public String getCommand() {
            return this.operator;
        }
    };
}
