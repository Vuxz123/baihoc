package old;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Week8Task2 {

  /** abc. */
  public void nullPointerEx() throws NullPointerException {
    String a = null;
    try {
      a.length();
    } catch (NullPointerException e) {
      throw new NullPointerException("Lỗi Null Pointer");
    }
  }

  /** abc. */
  public String nullPointerExTest() {
    String res = null;
    try {
      nullPointerEx();
    } catch (NullPointerException e) {
      res = e.getMessage();
    }
    return res;
  }

  /** abc. */
  public void arrayIndexOutOfBoundEx() throws IndexOutOfBoundsException {
    int[] a = new int[0];
    try {
      a[0] = 1;
    } catch (IndexOutOfBoundsException e) {
      throw new IndexOutOfBoundsException("Lỗi Array Index Out of Bounds");
    }
  }

  /** abc. */
  public String arrayIndexOutOfBoundsExTest() {
    String res = null;
    try {
      arrayIndexOutOfBoundEx();
    } catch (IndexOutOfBoundsException e) {
      res = e.getMessage();
    }
    return res;
  }

  /** abc. */
  public void arithmeticEx() {
    try {
      int a = 1 / 0;
    } catch (ArithmeticException e) {
      throw new ArithmeticException("Lỗi Arithmetic");
    }
  }

  /** abc. */
  public String arithmeticExTest() {
    String res = null;
    try {
      arithmeticEx();
    } catch (ArithmeticException e) {
      res = e.getMessage();
    }
    return res;
  }

  /** abc. */
  public void fileNotFoundEx() throws FileNotFoundException {
    try {
      FileReader a = new FileReader(new File("src/adudu"));
    } catch (FileNotFoundException e) {
      throw new FileNotFoundException("Lỗi File Not Found");
    }
  }

  /** abc. */
  public String fileNotFoundExTest() {
    String res = null;
    try {
      fileNotFoundEx();
    } catch (FileNotFoundException e) {
      res = e.getMessage();
    }
    return res;
  }

  /** abc. */
  public void func() throws IOException {
    throw new IOException("Lỗi IO");
  }

  /** abc. */
  public void ioEx() throws IOException {
    func();
  }

  /** abc. */
  public String ioExTest() {
    String res = null;
    try {
      func();
    } catch (IOException e) {
      res = e.getMessage();
    }
    return res;
  }
}
