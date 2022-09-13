package old;

public class Division extends BinaryExpression{
    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    @Override
    public double evaluate() throws ArithmeticException{
        double division = 0;
        if(right.evaluate() == 0){
            throw new ArithmeticException("Lỗi chia cho 0");
        }
        division = left.evaluate() / right.evaluate();
        return division;
    }
}
