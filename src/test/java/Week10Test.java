import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class Week10Test {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.out.println(outContent);
    }

    public static String readStream(InputStream is) {
        StringBuilder sb = new StringBuilder(512);
        try {
            Reader r = new InputStreamReader(is, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    @Test
    public void test1() throws FileNotFoundException {
        String a = readStream(new FileInputStream("D:/OasisTest/Java-Utils-master/src/main/java/com/nordstrom/common/base/ExceptionUnwrapper.java"));

        System.out.println(Week10.getAllFunction(a));
        Assert.assertEquals(outContent.toString(), "[unwrap(java.lang.Throwable), unwrap(java.lang.Throwable,java.lang.StringBuilder)]\n");
    }

    @Test
    public void test2() throws FileNotFoundException {
        String a = readStream(new FileInputStream("D:/OasisTest/utils-master/src/main/java/com/github/rkumsher/collection/ArrayUtils.java"));

        System.out.println(Week10.getAllFunction(a));
        Assert.assertEquals(outContent.toString(), "[unwrap(java.lang.Throwable), unwrap(java.lang.Throwable,java.lang.StringBuilder)]\n");
    }
}
