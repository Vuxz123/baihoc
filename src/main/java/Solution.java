import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

  /**
   * Is Prime.
   *
   * @param n n.
   * @return abc.
   */
  public boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0) {
      return false;
    }
    int lim = (int) Math.sqrt(n);
    for (int i = 3; i < lim; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  static class Result {

    /*
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
      // Write your code here
      for (int i = 1; i < n; i++) {
        Integer last = arr.get(i);
        int j = i - 1;
        while (j >= 0 && arr.get(j) > last) {
          arr.set(j + 1, arr.get(j));
          j--;
          for (Integer integer : arr) {
            System.out.print("" + integer + " ");
          }
          System.out.print("\n");
        }
        arr.set(j + 1, last);
      }
      for (Integer integer : arr) {
        System.out.print("" + integer + " ");
      }
    }

    public static void insertionSort2(int n, List<Integer> arr) {
      // Write your code here
      for (int i = 0; i < n - 1; i++) {
        Integer first = arr.get(i);
        int j = i + 1;
        while (j < n && arr.get(j) < first) {
          arr.set(j - 1, arr.get(j));
          j++;
          for (Integer integer : arr) {
            System.out.print("" + integer + " ");
          }
          System.out.print("\n");
        }
        arr.set(j - 1, first);
      }
      for (Integer integer : arr) {
        System.out.print("" + integer + " ");
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr =
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

    Result.insertionSort2(n, arr);

    System.out.println(arr);

    bufferedReader.close();
  }
}
