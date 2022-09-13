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
        if(value - Math.round(value) > 0) return "" + value;
        return "" + (int) value;
    }
}
