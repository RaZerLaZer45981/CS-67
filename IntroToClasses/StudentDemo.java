public class StudentDemo 
{
    public static void main(String[] args)
    {
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Ron", 19);
        Student student3 = new Student("Charlie", 21);
        Student student4 = new Student("Ken",19);

        student1.introduce();
        student2.introduce();
        student3.introduce();
        student4.introduce();
    }
}