import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  public Greeter(String language, String country, String name) {
    locale = new Locale(language, country);
    this.name = name;
  }

  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + name;
  }

  public static void main(String[] args) {
    if (args.length >= 3) {
      String language = args[0];
      String country = args[1];
      StringBuilder nameBuilder = new StringBuilder();

      for (int i = 2; i < args.length; i++) {
        nameBuilder.append(args[i]);
        if (i < args.length - 1) {
          nameBuilder.append(" ");
        }
      }
      String name = nameBuilder.toString();

      Greeter greeter = new Greeter(language, country, name);
      System.out.println(greeter.sayHello());
    } else {
      System.out.println("Invalid number of command line arguments.");
    }
  }
}
