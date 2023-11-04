public abstract class Canine {
    public abstract void roam();
    public abstract void eat();
}

public interface Animal{
    public abstract void breathing();
}

public interface Pet{
    public abstract void beFriendly();
    public abstract void play();
}

public class Dog extends Canine implements Pet, Animal{
    private String name;

    @Override
    public void breathing(){
        System.out.println(name + " Sedang Bernafas.");
    }

    @Override
    public void eat(){
        System.out.println(name + " Sedang Makan Daging.");
    }

    @Override
    public void roam(){
        System.out.println(name + " Sedang Berkelana.");
    }

    @Override
    public void beFriendly(){
        System.out.println(name + " Sangat Ramah Michellin Star");
    }

    @Override
    public void play(){
        System.out.println(name + " Sedang Bermain.");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

public class Cat implements Pet, Animal{
    private String name;

    @Override
    public void breathing(){
        System.out.println(name + " Sedang Bernafas.");
    }

    @Override
    public void play(){
        System.out.println(name + " Sedang Adu Jotos.");
    }

    @Override
    public void beFriendly(){
        System.out.println(name + " Sedang Mendengkur.");
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Main{
    public static void main(String[] args){
        Dog anjing = new Dog();
        anjing.setName("Yupi");
        anjing.eat();
        anjing.roam();
        anjing.beFriendly();
        anjing.play();
        anjing.breathing();

        System.out.println();

        Cat kucing = new Cat();
        kucing.setName("Persia");
        kucing.breathing();
        kucing.beFriendly();
        kucing.play();
    }
}
