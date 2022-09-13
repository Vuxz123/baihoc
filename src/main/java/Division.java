public class Division extends BinaryExpression{
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    @Override
    public double evaluate() {
        double division = 0;
        try{
            division = left.evaluate() / right.evaluate();
        }catch (ArithmeticException e){
            new ArithmeticException("Lỗi chia cho 0");
        }
        return division;
    }
}
