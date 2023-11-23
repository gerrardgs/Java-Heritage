public class Student {
    private String name;

    public Student(String name){
        this.name = name;
        System.out.println("Constructor is Executed...");
    }

    public void utilizeObject(){
        System.out.println(this.name + " is utilized...");
        int data = 20;
    }

    protected void finalizer() throws Throwable{
        try {
            System.out.println("Executing Finalize...");
            super.finalize();
        } catch (Throwable e){
            throw e;
        } finally {
            System.out.println("Finalize is Executed...");
        }
    }
}

public class Main {
    public static void main(String[] args){
        int age = 20;
        System.out.println(age);
        Student student = new Student("Ali");
        student.utilizeObject();
        student = null;

        System.gc();
    }
}
