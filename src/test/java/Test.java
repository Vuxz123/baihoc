import old.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @org.junit.Test
    public void test3(){
        expectedException.expect(ArithmeticException.class);
        Expression a = new Division(new Numeral(10), new Numeral(0));
        System.out.println(a.evaluate());
    }

    @Rule
    public ExpectedException expectedException2 = ExpectedException.none();
    @org.junit.Test
    public void test4() throws IOException {
        expectedException.expect(IOException.class);
        new Week8Task2().ioEx();
    }

    @org.junit.Test
    public void test5(){
        List<Person> arr = new ArrayList<>();
        arr.add(new Person("Nguyen A", 22, "1"));
        arr.add(new Person("Nguyen A", 20, "2"));
        arr.add(new Person("Le B", 20, "3"));

        arr = Week11.sortGeneric(arr);

        System.out.println(arr);
    }

    @org.junit.Test
    public void test6(){
    Week10.getAllFunction(
        "package net.bqc.utils;\n"
            + "import java.util.List;\n"
            + "class Message {}\n"
            + "public static int printMessages(int messages) {}");
    }
}

