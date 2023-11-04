public class Human{
    public String name;
    public int age;
    public String email;
    public String gender;

    public Human(){
        this.name = "unnamed";
        this.age = 0;
        this.email = "example@gmail.com";
        this.gender = "Male/Female";
    }

    public Human(String name, int age){
        this.name = name;
        this.age = age;
        this.email = "empty";
        this.gender = "empty";
    }

    public Human(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = "empty";
    }

    public Human(String name, int age, String email, String gender){
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public void walk(){
        System.out.println(this.name + " " + "Sedang Berjalan");
    }

    public void walk(int hourDuration){
        System.out.println(this.name + " " + "Sedang Berjalan Selama" + " " + hourDuration + " " + "Jam.");
    }

    public String sendEmail(String receiver){
        return "Email Terkirim Dari " + this.email + " Ke " + receiver;
    }

    public void sendEmail(String receiver, String subject){
        System.out.println("Email Terkirim Dari " + this.email + " Ke " + receiver);
        System.out.println("Subject : " + subject);
    }

    @Override
    public String toString(){
        return "Name\t: " + this.name + "\n" + "Age\t\t: " + this.age + "\n" + "Email\t: " + this.email + "\n" + "Gender\t: " + gender + "\n";
    }
}

public class Main {
    public static void main(String[] args){
        Human unnamed = new Human();
        System.out.println(unnamed.toString());

        System.out.println("");

        Human Gerrard = new Human("Gerrard Sebastian", 18, "gs@gmail.com", "Male");
        System.out.println(Gerrard.toString());
        Gerrard.walk();
        Gerrard.walk(3);

        System.out.println("");

        Human Ali = new Human("Ali Rafli Putra Hakiki", 20, "alirph@gmail.com", "Male");
        System.out.println(Ali.toString());
        String AliEmailSent = Ali.sendEmail("alirafli20@gmail.com");
        System.out.println(AliEmailSent);
        Ali.sendEmail("gerrardsebastiangege2005@gmail.com", "Sending Simple Email");
    }
}
