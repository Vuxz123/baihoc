public class Numeral extends Expression{
    private double value;

    public Numeral(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
