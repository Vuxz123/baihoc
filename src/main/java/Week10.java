import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Week10 {

  protected static HashMap<String, String> imports = new HashMap<>();

  protected static class MethodFormat {
    private String rawinput = null;
    private String name;
    private List<String> params;

    public MethodFormat(){
      reset();
    }

    public MethodFormat(String name, List<String> params) {
      this.name = name;
      this.params = params;
    }

    public MethodFormat(String rawinput) {
      analyze(rawinput);
    }

    public void reset(){
      rawinput = null;
      name = null;
      params = null;
    }

    public void analyse(String rawinput) {
      analyze(rawinput);
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public List<String> getParams() {
      return params;
    }

    public void setParams(List<String> params) {
      this.params = params;
    }

    private void analyze(String rawinput) {
      String input = normalize(rawinput);
      String[] a = input.split("\\(", 2);
      this.name = a[0];
      StringBuilder b = new StringBuilder(a[1]);
      b.deleteCharAt(b.length() - 1);
      a[1] = b.toString();

      analyzeParam(a[1]);
    }

    private void analyzeParam(String rawparam) {
      List<String> rawparams = Arrays.asList(rawparam.split(","));
      List<String> param_types = new ArrayList<>(rawparams.size());
      rawparams.forEach(
          s -> {
            if(s.startsWith(" ")) {
              s = s.substring(1,s.length()-1);
            }
            String[] temp = s.split(" ");
            String cls = temp[0];
            try {
              cls = Util.getClass(temp[0], s);
            } catch (ClassNotFoundException e) {
              throw new RuntimeException(e);
            }
            param_types.add(cls);
          });
      params = param_types;
    }

    private String normalize(String rawinput) {
      String a = rawinput;
      InputStream input = new ByteArrayInputStream(rawinput.getBytes());
      Scanner scanner = new Scanner(input);
      String temp = null;
      StringBuilder res = new StringBuilder();
      boolean stage = false;
      int i = 0;
      while (scanner.hasNext()) {
        temp = scanner.next();
        if (stage) {
          if (temp.endsWith(")")) {
            res.append(temp);
            return res.toString();
          }
          res.append(temp).append(" ");
          continue;
        }
        switch (temp) {
          case "public":
            break;
          case "static":
            break;
          case "void":
            break;
          case "private":
            break;
          case "protected":
            break;
          default:
            if (i == 0) {
              i++;
              continue;
            }
            stage = true;
            res.append(temp).append(" ");
            break;
        }
      }
      return res.toString();
    }

    @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append(this.name).append("(");
      params.forEach(s -> builder.append(s).append(","));
      builder.setCharAt(builder.length()-1, ')');
      return builder.toString();
    }
  }

  private static List<String> lineSeperate(String input) {
    List<String> output = Arrays.asList(input.split("\n"));
    return output;
  }

  private static List<String> methodCollect(List<String> input) {
    return input.stream()
        .filter(
            s -> {
              if (s.contains("static") && !s.contains("/") && !s.contains("*") && s.contains("(") && !s.contains("new") && !s.contains("=")) return true;
              return false;
            })
        .collect(Collectors.toList());
  }

  private static void analyseClass(List<String> lines){
    lines.get(0).contains("package");
    String package_ = lines.get(0);
    package_ = package_.substring(0 + 8, package_.length()-1);
    lines = lines.stream().filter(s -> s.contains(" class ") && !s.contains("\"")).collect(Collectors.toList());
    String finalPackage_ = package_;
    lines.forEach(s -> {
      int bi = s.indexOf("class");
      int ei = s.indexOf("{");
      String temp = s.substring(bi + 6, ei - 1);
      temp.trim();
      Util.add(temp, finalPackage_ + "." + temp);
    });
  }

  private static void analyseImport(List<String> lines) {
    lines = lines.stream().filter(s -> {
      return s.startsWith("import");
    }).collect(Collectors.toList());
    lines.forEach(s -> {
      Util.add(Util.getName(s), s.substring(0 + 7, s.length() - 1));
    });
  }

  public static List<String> getAllFunction(String fileContent) {
    List<String> lines = lineSeperate(fileContent);
    List<String> methods = methodCollect(lines);
    List<String> res = new ArrayList<>();
    analyseImport(lines);
    analyseClass(lines);
    if (methods.isEmpty()) throw new RuntimeException("Không tìm thấy methods nào");
    MethodFormat format = new MethodFormat();
    for (String s: methods){
      format.reset();
      format.analyse(s);
      res.add(format.toString());
    }
    return res;
  }
}
