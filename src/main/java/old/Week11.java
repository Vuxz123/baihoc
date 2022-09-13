package old;

import java.util.List;
import java.util.stream.Collectors;

public class Week11 {

  /** abc. */
  public static <T extends Comparable> List<T> sortGeneric(List<T> arr) {
    return arr.stream().sorted().collect(Collectors.toList());
  }
}
