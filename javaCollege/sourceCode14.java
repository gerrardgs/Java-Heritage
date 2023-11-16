public class Objectx {
    private String data;

    public Objectx(String data){
        this.data = data;
    }

    public void utilizedObjectx(){
        System.out.println("Utilisasi objek menggunakan " + this.data);
    }
}

public class Main {
    public static void main(String[] args) {
        // Creation & Initialization
        Objectx objectx = new Objectx("Data");
        // Utilization
        objectx.utilizedObjectx();
        // Disposal
        objectx = null;

        // Ask JVM to Start the Garbage Collection (Not Recommended)
        //System.gc();
    }
}
// Threads
