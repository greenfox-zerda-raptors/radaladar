/**
 * Created by BB on 2016-11-15.
 */
public class Mentor extends Person {
    public String seniority;
    public String subject;

    public Mentor(String name, int age, String seniority, String subject) {
        super(name, age);
        this.seniority = seniority;
        this.subject = subject;

    }
    public String toString(){
        return super.toString() + " is a(n) " + this.subject + " " + this.seniority;
    }
}
