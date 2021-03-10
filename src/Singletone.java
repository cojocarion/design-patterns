import java.nio.charset.Charset;
import java.util.Random;

class SingletoneExample
{
    private static SingletoneExample instance;

    public String s;
    private SingletoneExample()
    {
        byte[] array = new byte[250];
        new Random().nextBytes(array);
        s = new String(array, Charset.forName("UTF-8"));
    }

    public static SingletoneExample getInstance()
    {
        if (instance == null)
            instance = new SingletoneExample();

        return instance;
    }
}
public class Singletone {
    public static void main(String[] args) {
        SingletoneExample x = SingletoneExample.getInstance();
        SingletoneExample y = SingletoneExample.getInstance();

        System.out.println("String token x is " + x.s);
        System.out.println("String token x is " + y.s);
    }

}
