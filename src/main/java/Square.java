public class Square extends Expression{
    private Expression expression;

    public Square(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        double pow = expression.evaluate();
        return pow * pow;
    }

    @Override
    public String toString() {
        return "(" + expression.toString() + ")" + " ^ 2";
    }
}
