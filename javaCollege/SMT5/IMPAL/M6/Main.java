public class Main {
    public static void main(String[] args) {
        AutoCarRPL myCar = new AutoCarRPL("Bensin", 120);
        myCar.start();
        myCar.drive();

        // Mio example
        Mio myMio = new Mio("Bensin", 80);
        myMio.start();
        myMio.drive();
    }
}
