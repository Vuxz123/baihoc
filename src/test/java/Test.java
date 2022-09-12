import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test(){
        Expression a = new Addition(new Numeral(20), new Square(new Numeral(20)));
        System.out.println(a.toString());
        Assert.assertEquals(a.evaluate(), 420, 0.0001f);
    }

    @org.junit.Test
    public void test2(){
        Expression a = new Square(new Addition(new Addition(new Square(new Numeral(10)), new Numeral(-3)),new Square(new Numeral(4))));
        System.out.println(a.toString());
        Assert.assertEquals(a.evaluate(), 12769, 0.0001f);
    }
}
