package fixes;

import java.util.Stack;

public class ExpressionEvaluator {
  /**
   * Evaluates a prefix expression.
   * @param prefixExpression An array of Strings, where is string represents either an operator or an operand.
   * @return The evaluation of this prefix expression.
   */
  public static int evaluatePrefix(String[] prefixExpression) {
    Stack<Integer> operandStack = new Stack<Integer>();
    Stack<Integer> operatorStack = new Stack<Integer>();

    // TODO: Implement me!

    return 0;
  }

  /**
   * Evaluates a postfix expression.
   * @param postfixExpression An array of Strings, where is string represents either an operator or an operand.
   * @return The evaluation of this postfix expression.
   */
  public static int evaluatePostfix(String[] postfixExpression) {
    Stack<Integer> operandStack = new Stack<Integer>();

    // TODO: Implement me!

    return 0;
  }

  /**
   * Determines if a given string is an operator or not.
   * @param s The string to test.
   * @return true if s is an operator, false otherwise.
   */
  private static boolean isOperator(String s) {
    return "+-*/".contains(s);
  }

  /**
   * Evaluates an expression given an operator and two operands.
   * @param operator The operator.
   * @param operandA The left operand.
   * @param operandB The right operand.
   * @return The evaluation of these two operands with the operator.
   */
  private static int evaluateWithOperator(String operator, int operandA, int operandB) {
    switch(operator) {
      case "+":
        return operandA + operandB;
      case "-":
        return operandA - operandB;
      case "*":
        return operandA * operandB;
      case "/":
        return operandA / operandB;
      default:
        return -1;
    }
  }

  public static void main(String[] args) {
    String[] prefixExpression = {"/", "-", "*", "+", "1", "3", "2", "2", "2"};
    String[] postfixExpression = {"2", "2", "*", "8", "4", "/", "+"};

    System.out.println(ExpressionEvaluator.evaluatePrefix(prefixExpression));
    System.out.println(ExpressionEvaluator.evaluatePostfix(postfixExpression));

  }

}
