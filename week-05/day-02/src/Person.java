/**
 * Created by BB on 2016-11-15.
 */
public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return this.name + " (" + this.age + ")";
    }

}
