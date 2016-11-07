/**
 * Created by BB on 2016-11-07.
 */
public class Workshop18{
    public static void main(String... args){
        // I would like to replace "long" with "short" in this example, but it has a problem. Please fix it! Don't forget that String is immutable
        // Expected ouput: A short example string
        StringBuilder example = new StringBuilder("A long example string");
        int start = example.indexOf("long");
        example.replace(start, start+"long".length(), "short");
        System.out.println(example);
    }
}

