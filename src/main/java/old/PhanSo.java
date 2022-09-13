package old;

import java.util.Objects;
public class PhanSo {
  private int numerator;
  private int denominator;

  public int getNumerator() {
    return numerator;
  }

  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  /**
   * Set denominator. Note: denominator cannot be zero;
   *
   * @param denominator new denominator.
   */
  public void setDenominator(int denominator) {
    if (denominator == 0) {
      return;
    }
    this.denominator = denominator;
  }

  /** The PhanSo. */
  public PhanSo(int numerator, int denominator) {
    if (denominator == 0) {
      denominator = 1;
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public PhanSo() {
    this.numerator = 0;
    this.denominator = 1;
  }

  /** abc. */
  public PhanSo reduce() {
    int gcd = gcd();
    numerator /= gcd;
    denominator /= gcd;
    return this;
  }

  /** abc. */
  public PhanSo add(PhanSo solution) {
    if (solution.denominator == this.denominator) {
      this.numerator += solution.numerator;
    } else {
      this.numerator =
          this.numerator * solution.denominator + solution.numerator * this.denominator;
      this.denominator *= solution.denominator;
    }
    reduce();
    return this;
  }

  /** abc. */
  public PhanSo subtract(PhanSo solution) {
    if (solution.denominator == this.denominator) {
      this.numerator -= solution.numerator;
    } else {
      this.numerator =
          this.numerator * solution.denominator - solution.numerator * this.denominator;
      this.denominator *= solution.denominator;
    }
    reduce();
    return this;
  }

  /** abc. */
  public PhanSo multiply(PhanSo solution) {
    this.numerator *= solution.numerator;
    this.denominator *= solution.denominator;
    reduce();
    return this;
  }

  /** abc. */
  public PhanSo divide(PhanSo solution) {
    this.numerator *= solution.denominator;
    this.denominator *= solution.numerator;
    reduce();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhanSo solution = (PhanSo) o;
    reduce();
    solution.reduce();
    return numerator == solution.numerator && denominator == solution.denominator;
  }

  @Override
  public int hashCode() {
    return Objects.hash(numerator, denominator);
  }

  private int gcd() {
    int i = Math.max(Math.abs(numerator), Math.abs(denominator));
    for (; i > 0; i--) {
      if (numerator % i == 0 && denominator % i == 0) {
        break;
      }
    }
    return i;
  }

  @Override
  public String toString() {
    return "PhanSo{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
  }

  public static void main(String[] args) {
    //
    PhanSo a = new PhanSo(1, 2);
    PhanSo b = new PhanSo(1, 1);
    PhanSo c;

    System.out.println(a);

    c = a.add(b);

    System.out.println(a);
    System.out.println(c);
  }
}
