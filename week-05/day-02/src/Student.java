import java.util.ArrayList;
/**
 * Created by BB on 2016-11-15.
 */
public class Student extends Person{

    public ArrayList<Integer> grades = new ArrayList<>();
    public Student(String name, int age) {
        super(name, age);
    }
    public void addGrade(int grade) {
        this.grades.add(this.grades.size(), grade);
    }

    public double getAverage() {
        Integer gradeSum = 0;
        Integer gradeCount = 0;
        for (Integer grade : this.grades) {
            gradeSum += grade;
            gradeCount++;
        }
        return ((double)gradeSum/(double)gradeCount);
    }
    public String toString(){
        return super.toString() + " average " + this.getAverage();
    }
}
