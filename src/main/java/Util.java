import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Util {
  static String[] a = {
    "int", "long", "byte", "char", "short", "float", "double", "boolean", "void"
  };

  static HashMap<String, String> custom = new HashMap<>();

  private static boolean isBracket(String a) {
    if (a.contains("<")) {
      if (a.endsWith(">")) {
        return true;
      }
    }
    return false;
  }

  public static String getClass(String class_string, String raw) throws ClassNotFoundException {
    if (isBracket(class_string)) {
      class_string = class_string.substring(0, class_string.length() - 1);
      List<String> par = Arrays.asList(class_string.split("<"));
      String a1 = getClass1(par.get(0), raw);
      String a2 = getClass2(par.get(1), raw);
      return a1 + "<" + a2 + ">";
    } else {
      return getClass1(class_string, raw);
    }
  }

  private static String getClass1(String class_string, String raw) throws ClassNotFoundException {
    if (Arrays.stream(a).anyMatch(s -> s.equals(class_string))) return class_string;
    if (custom.containsKey(class_string)) return custom.get(class_string);
    Class<?> cls;
    try {
      cls = Class.forName(class_string, false, ClassLoader.getSystemClassLoader());
    } catch (ClassNotFoundException e) {
      throw new ClassNotFoundException(
          String.format("Không tìm thấy class này: class <%s> trong <%s>", class_string, raw));
    }
    return cls.getCanonicalName();
  }

  public static String getClass2(String class_string, String raw) {
    List<String> rawparams = Arrays.asList(class_string.split(","));
    StringBuilder param_types = new StringBuilder();
    rawparams.forEach(
        s -> {
          String[] temp = s.split(" ");
          String cls = null;
          try {
            cls = Util.getClass(temp[0], s);
          } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
          }
          param_types.append(cls).append(",");
        });
    param_types.deleteCharAt(param_types.length() - 1);
    return param_types.toString();
  }

  public static void add(String class_name, String fqtn) {
    custom.put(class_name, fqtn);
  }

  private static void print(List<String> a) {
    for (String s : a) {
      System.out.println(s);
    }
  }

  public static String getName(String import_){
    int i = import_.length() - 1;
    for(; i >= 0; i --){
      if(import_.charAt(i) == '.') break;
    }
    return import_.substring(i + 1, import_.length()-1);
  }
}
