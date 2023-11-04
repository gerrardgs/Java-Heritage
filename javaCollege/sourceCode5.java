public class ProgrammingLanguage {
    public boolean isCompiled;
    public String paradigm;

    // default construc
    public ProgrammingLanguage(){
        this.isCompiled = false;
        this.paradigm = null;
    }

    // overloading construc
    public ProgrammingLanguage(boolean isCompiled, String paradigm){
        this.isCompiled = isCompiled;
        this.paradigm = paradigm;
    }

    // default and overloading construc
    public void display(){
        if (isCompiled == false && paradigm == null){
            System.out.println("It's A Programming Language");
        } else{
            String type = isCompiled ? "compiled" : "interpreted";
        }
    }
}

public class C extends ProgrammingLanguage{
    public boolean hasPointer = true;

    public C(){
        super(true, "Imperative");
    }

    public void display(){
        System.out.println("It's A C Programming");
        super.display();
    }
}

public class Java extends ProgrammingLanguage{
    public boolean hasJVM = true;

    public Java(){
        super(true, "Object-Oriented");
    }

    public void display(){
        System.out.println("It's A Java Programming");
        super.display();
    }
}

public class Python extends ProgrammingLanguage{
    public boolean isLooselyTyped = true;

    public Python(){
        super(false, "OOP");
    }

    public void display(){
        System.out.println("It's A Python Programming");
        super.display();
    }
}

public class Main {
    public static void main(String[] args){

        // default Output
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.display();

        System.out.println("");

        ProgrammingLanguage CLanguage = new C();
        CLanguage.display();

        System.out.println("");

        ProgrammingLanguage JavaLanguage = new Java();
        JavaLanguage.display();

        System.out.println("");

        ProgrammingLanguage PythonLanguage = new Python();
        PythonLanguage.display();

        System.out.println("");

        // Array Output
        int arrLenght = 4;
        ProgrammingLanguage [] programmingLanguages = new ProgrammingLanguage[arrLenght];
        programmingLanguages[0] = new ProgrammingLanguage();
        programmingLanguages[1] = new C();
        programmingLanguages[2] = new Java();
        programmingLanguages[3] = new Python();

        for (int i = 0; i < arrLenght; i++){
            programmingLanguages[i].display();
            System.out.println("");
        }
    }
}
