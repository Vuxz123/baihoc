public class Multiplication extends BinaryExpression {

  /** abc. */
  public Multiplication(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public double evaluate() {
    return left.evaluate() * right.evaluate();
  }

  @Override
  public String toString() {
    return "(" + left.toString() + " * " + right.toString() + ")";
  }
}
