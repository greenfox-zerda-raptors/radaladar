/**
 * Created by BB on 2016-11-07.
 */
public class Workshop19{
    public static void main(String... args){
        // Please change "Heljo" to "Hello" and add name ("World") to the end of the string builder
        String name = "World";
        StringBuilder builder = new StringBuilder("Heljo");
        int start = builder.indexOf("j");
        builder.setCharAt(start, 'l');
        builder.append(", " + name + "!");

        System.out.println(builder);
    }
}