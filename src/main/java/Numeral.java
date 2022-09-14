public class Numeral extends Expression {
  private double value;

  /** abc. */
  public Numeral(double value) {
    this.value = value;
  }

  @Override
  public double evaluate() {
    return value;
  }

  @Override
  public String toString() {
    boolean bl = (value - (int) value) > 0;
    if (bl) {
      return "" + value;
    }
    return "" + (int) value;
  }
}
